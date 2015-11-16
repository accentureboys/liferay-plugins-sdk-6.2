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
			long addressId = CounterLocalServiceUtil.increment(Address.class.getName());
			Address address = AddressLocalServiceUtil.createAddress(addressId);
			this.setAddress(address, user.getUserId(), user.getScreenName(), company.getCompanyId(), 
					countryId, regionId, new Date(), RegionServiceUtil.getRegion(regionId).getName());
		}else{
			Address address = addressList.get(0);
			this.setAddress(address, user.getUserId(), user.getScreenName(), company.getCompanyId(), 
					countryId, regionId, new Date(), RegionServiceUtil.getRegion(regionId).getName());
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
	
	/**
	 * Set address object
	 * 
	 * @param address address object
	 * @param userId user id
	 * @param userName user name
	 * @param companyId company id
	 * @param countryId country id
	 * @param regionId region id
	 * @param date current system date
	 * @param city region name
	 * @return	new address object with informaton
	 * @throws SystemException
	 */
	private Address setAddress(Address address, long userId, String userName, long companyId, 
			long countryId, long regionId, Date date, String city) throws SystemException {
		address.setUserId(userId);
		address.setUserName(userName);
		address.setCompanyId(companyId);
		address.setCountryId(countryId);
		address.setRegionId(regionId);
		address.setCreateDate(date);
		address.setCity(city);
		AddressLocalServiceUtil.updateAddress(address);
		return address;
	}
}
