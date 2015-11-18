package com.accentureboys.sample.individual;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Account;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AccountLocalServiceUtil;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class IndividualPortlet
 */
public class IndividualPortlet extends MVCPortlet {
	/**
	 * Update user's information
	 * 
	 * @param request ActionRequest	
	 * @param response ActionResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IOException 
	 */
	public void  updateUser(ActionRequest request,ActionResponse response) throws SystemException, PortalException, IOException {
		//get values from the page
		long countryId = ParamUtil.getLong(request, "countryId");
		long regionId = ParamUtil.getLong(request, "regionId");
		String idType = ParamUtil.getString(request, "idType");
		String idNumber = ParamUtil.getString(request, "idNumber");
		String city = ParamUtil.getString(request, "city");
		String zip = ParamUtil.getString(request, "zipcode");
		String street = ParamUtil.getString(request, "street");
		//get current login user
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		User user = PortalUtil.getUser(request);
		//update user's contact information, add accountId to contact object
		Contact contact = user.getContact();
		if(contact.getAccountId() == 0L){
			long accountId = CounterLocalServiceUtil.increment(Account.class.getName());
			Account account = AccountLocalServiceUtil.createAccount(accountId);
			this.setAccount(account, company.getCompanyId(), user.getUserId(), user.getScreenName(), 
					idType, idType, idNumber, new Date());
			contact.setAccountId(accountId);
		}else{
			Account account = AccountLocalServiceUtil.fetchAccount(contact.getAccountId());
			this.setAccount(account, company.getCompanyId(), user.getUserId(), user.getScreenName(), 
					idType, idType, idNumber, new Date());
		}
		ContactLocalServiceUtil.updateContact(contact);
		
		//add user's address information
		List<Address> addressList = user.getAddresses();
		if(addressList.size()==0){
			AddressLocalServiceUtil.addAddress(user.getUserId(), Contact.class.getName(), user.getContactId(), street, "", "", city, zip, regionId, countryId, 11002, true, true);
		}else{
			Address address = addressList.get(0);
			AddressLocalServiceUtil.updateAddress(address.getAddressId(), street, "", "", city, zip, regionId, countryId, 11002, true, true);
		}
		UserLocalServiceUtil.updateUser(user);

		response.setRenderParameter("mvcPath", "/html/individual/individual.jsp");
	}
	
	/**
	 * Set account object
	 * 
	 * @param account account object
	 * @param companyId company id
	 * @param userId user id
	 * @param userName user name
	 * @param name id type
	 * @param legalName id type
	 * @param legalId id number
	 * @param date current system date
	 * @return new account object with information
	 * @throws SystemException 
	 */
	private Account setAccount(Account account, long companyId, long userId, String userName, 
			String name, String legalName, String legalId, Date date ) throws SystemException{
		account.setCompanyId(companyId);
		account.setUserId(userId);
		account.setUserName(userName);
		account.setName(name);
		account.setLegalName(legalName);
		account.setLegalId(legalId);
		account.setCreateDate(new Date());
		AccountLocalServiceUtil.updateAccount(account);
		return account;
	}
}
