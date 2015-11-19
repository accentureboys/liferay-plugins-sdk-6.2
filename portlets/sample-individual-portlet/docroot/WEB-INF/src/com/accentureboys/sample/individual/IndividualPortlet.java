package com.accentureboys.sample.individual;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
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
		//get current login user
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		User user = PortalUtil.getUser(request);
		//add custom field 'id' and 'password' for store user's id and passport information
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				User.class.getName(), request);
		String city = (String) serviceContext.getAttribute("city");
		String street = (String) serviceContext.getAttribute("street1");
		String zip = (String) serviceContext.getAttribute("zip");
		user.setExpandoBridgeAttributes(serviceContext);
		UserLocalServiceUtil.updateUser(user);
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
}
