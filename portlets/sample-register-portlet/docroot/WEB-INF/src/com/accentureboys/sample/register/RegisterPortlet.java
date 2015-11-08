package com.accentureboys.sample.register;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class RegisterPortlet
 */
public class RegisterPortlet extends MVCPortlet {
	/**
	 * Register user on register tab
	 * 
	 * @param request ActionRequest
	 * @param response ActionResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IOException
	 */
	public void registerUser(ActionRequest request, ActionResponse response) throws SystemException, PortalException, IOException{
		//get values from the page
		String userName = ParamUtil.getString(request, "userName");
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		long gender =  ParamUtil.getLong(request, "gender");
		String password1 = ParamUtil.getString(request, "pwd");
		String password2 = ParamUtil.getString(request, "repeat_pwd");
		String emailAddress = ParamUtil.getString(request, "emailAddress");
		String telphone = ParamUtil.getString(request, "telphone");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		
		//validate all the required fields
		if(userName.equals("")||firstName.equals("")||lastName.equals("")||password1.equals("")||password2.equals("")||emailAddress.equals("")||telphone.equals("")){
			SessionErrors.add(request, "all-required");
			_log.error("all-required");
			return;
		}
		//validate password are matched with each other
		if(!password1.equals(password2)){
			SessionErrors.add(request, "password-not-match");
			_log.error("password-not-match");
			return;
		}
		//validate email format
		if(emailFormat(emailAddress)){
			SessionErrors.add(request, "email-format-not-correct");
			_log.error("email-format-not-correct");
			return;
		}
		User defaultUser = UserLocalServiceUtil.getDefaultUser(company.getCompanyId());
		//add contact information
		long contactId = CounterLocalServiceUtil.increment(Contact.class.getName());
		Contact contact = ContactLocalServiceUtil.createContact(contactId);
		contact.setUserId(defaultUser.getUserId());
		contact.setUserName(userName);
		contact.setMale(gender == 1L ? true : false);
		contact.setCreateDate(new Date());
		ContactLocalServiceUtil.updateContact(contact);				
		
		//add phone information
		long phoneId = CounterLocalServiceUtil.increment(Phone.class.getName());
		Phone phone = PhoneLocalServiceUtil.createPhone(phoneId);
		phone.setUserId(defaultUser.getUserId());
		phone.setNumber(telphone);
		phone.setCreateDate(new Date());
		PhoneLocalServiceUtil.updatePhone(phone);
		
		//create user
		boolean autoPassword = false;
		boolean autoScreenName = false;
		long facebookId = ParamUtil.getLong(request, "facebookId");
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = "";
		long[] groupIds = null;
		long[] organizationIds = null;
		UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(company.getCompanyId(), "Personal");
		Role role = RoleLocalServiceUtil.getRole(company.getCompanyId(), "User");
		long[] roleIds = {role.getRoleId()};
		long[] userGroupIds = {userGroup.getUserGroupId()};
		boolean sendEmail = true;
		int prefixId = ParamUtil.getInteger(request, "prefixId");
		int suffixId = ParamUtil.getInteger(request, "suffixId");
		boolean male = transLongToBoolean(gender);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), request);
		
		User user = UserLocalServiceUtil.addUserWithWorkflow(defaultUser.getUserId(), company.getCompanyId(), autoPassword, password1, password2, autoScreenName, userName, emailAddress, facebookId, "", LocaleUtil.fromLanguageId("zh_CN"), firstName, "", lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		
		String redirect =
				PortalUtil.getPathMain() + "/portal/login?login=" + user.getEmailAddress() +
					"&password=" + password1 + "&rememberMe=1";		
		response.sendRedirect(redirect);
	}
	
	private static boolean emailFormat(String email) {
		boolean tag = true;
		final String pattern1 = "^([a-z0-9A-Z]+[-|//.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?//.)+[a-zA-Z]{2,}$";
		final Pattern pattern = Pattern.compile(pattern1);
		final Matcher mat = pattern.matcher(email);
		if (!mat.find()) {
			tag = false;
		}
		return tag;
	}
	
	private boolean transLongToBoolean(long k) {
		if (k == 1L)
			return true;
		else
			return false;
	}
	
	private static Log _log = LogFactoryUtil.getLog(RegisterPortlet.class);
}
