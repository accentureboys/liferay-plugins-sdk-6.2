package com.accentureboys.sample.individual;

import java.io.IOException;
import java.util.Date;

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
		User defaultUser = UserLocalServiceUtil.getDefaultUser(company.getCompanyId());
		//add user's address information
		long addressId = CounterLocalServiceUtil.increment(Address.class.getName());
		Address address = AddressLocalServiceUtil.createAddress(addressId);
		address.setUserId(defaultUser.getUserId());
		address.setUserName(defaultUser.getScreenName());
		address.setCompanyId(company.getCompanyId());
		address.setCountryId(countryId);
		address.setRegionId(regionId);
		address.setCreateDate(new Date());
		address.setCity(RegionServiceUtil.getRegion(regionId).getName());
		AddressLocalServiceUtil.updateAddress(address);
		//add user's account information
		long accountId = CounterLocalServiceUtil.increment(Account.class.getName());
		Account account = AccountLocalServiceUtil.createAccount(accountId);
		account.setCompanyId(company.getCompanyId());
		account.setUserId(defaultUser.getUserId());
		account.setUserName(defaultUser.getScreenName());
		account.setName(idType);
		account.setLegalName(idType);
		account.setLegalId(idNumber);
		account.setCreateDate(new Date());
		AccountLocalServiceUtil.updateAccount(account);
		//update user's contact information, add accountId to contact object
		Contact contact = defaultUser.getContact();
		contact.setAccountId(accountId);
		ContactLocalServiceUtil.updateContact(contact);
		
		response.sendRedirect("/html/individual/success.jsp");
	}
}
