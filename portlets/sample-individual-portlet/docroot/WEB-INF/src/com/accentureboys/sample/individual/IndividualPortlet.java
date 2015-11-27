package com.accentureboys.sample.individual;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
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
import com.liferay.sample.model.Education;
import com.liferay.sample.model.Honour;
import com.liferay.sample.model.Property;
import com.liferay.sample.model.Thesis;
import com.liferay.sample.service.EducationLocalServiceUtil;
import com.liferay.sample.service.HonourLocalServiceUtil;
import com.liferay.sample.service.HonourServiceUtil;
import com.liferay.sample.service.PropertyLocalServiceUtil;
import com.liferay.sample.service.ThesisLocalServiceUtil;
import com.liferay.sample.service.persistence.HonourPersistence;
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
	
	/**
	 * Save Education, Honor, Property and Thesis information
	 * 
	 * @param actionRequest
	 * @param response
	 * @throws Exception
	 */
	public void getAutoFieldsData(ActionRequest actionRequest, ActionResponse response) throws Exception {
		//get current login user
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		User user = PortalUtil.getUser(actionRequest);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				User.class.getName(), actionRequest);
		String schoolName = (String) serviceContext.getAttribute("schoolName");
		String recommender = (String) serviceContext.getAttribute("recommender");
		String introduction = (String) serviceContext.getAttribute("introduction");
		String graduateYear = ParamUtil.getString(actionRequest, "graduateYear");
		long degreeId = ParamUtil.getLong(actionRequest, "degree");
		//get education object by userId if empty create a new education object
		Education education = null;
		education = EducationLocalServiceUtil.getEducationByUserId(user.getUserId());
		if (education == null) {
			long educationId = CounterLocalServiceUtil.increment(Education.class.getName());
			education = EducationLocalServiceUtil.createEducation(educationId);
			this.setEducation(education, user.getUserId(), schoolName, degreeId, graduateYear, recommender, introduction);
		}else{
			this.setEducation(education, user.getUserId(), schoolName, degreeId, graduateYear, recommender, introduction);
		}
		
		// get honor values from database
		List<Honour> honourList = new ArrayList<Honour>();
		honourList = HonourLocalServiceUtil.getHonourListByUserId(user.getUserId());
		if (honourList.size() != 0) {
			HonourLocalServiceUtil.removeHonourListByUserId(user.getUserId());
		}
		// get honour auto fields data
		String honourIndexesString = actionRequest.getParameter("honourIndexes");
		int[] honourIndexes = StringUtil.split(honourIndexesString, 0);
		for (int honourIndex : honourIndexes) {
			String honoraryName = ParamUtil.getString(actionRequest, "honoraryName" + honourIndex);
			if (!honoraryName.equals("")) {
				long honourId = CounterLocalServiceUtil.increment(Honour.class.getName());
				Honour honour = HonourLocalServiceUtil.createHonour(honourId);
				honour = this.updateHonor(honour, honoraryName, user.getUserId());
				HonourLocalServiceUtil.addHonour(honour);
			}
		}
		
		// get property values from database
		List<Property> propertyList = new ArrayList<Property>();
		propertyList = PropertyLocalServiceUtil.getPropertyListByUserId(user.getUserId());
		if (propertyList.size() != 0) {
			PropertyLocalServiceUtil.removePropertyListByUserId(user.getUserId());
		}
		// get property values from page
		String propertyIndexesString = actionRequest.getParameter("propertyIndexes");
		int[] propertyIndexes = StringUtil.split(propertyIndexesString, 0);
		for (int propertyIndex : propertyIndexes) {
			String propertyName = ParamUtil.getString(actionRequest, "propertyName" + propertyIndex);
			if (!propertyName.equals("")) {
				long propertyId = CounterLocalServiceUtil.increment(Property.class.getName());
				Property property = PropertyLocalServiceUtil.createProperty(propertyId);
				property = this.updateProperty(property, propertyName, user.getUserId());
				PropertyLocalServiceUtil.addProperty(property);
			}	
		}
		
		// get thesis values from database
		List<Thesis> thesisList = new ArrayList<Thesis>();
		thesisList = ThesisLocalServiceUtil.getThesisListByUserId(user.getUserId());
		if (thesisList.size() != 0) {
			ThesisLocalServiceUtil.removeThesisListByUserId(user.getUserId());
		}
		// get thesis values from page
		String thesisIndexesString = actionRequest.getParameter("thesisIndexes");
		int[] thesisIndexes = StringUtil.split(thesisIndexesString, 0);
		for (int thesisIndex : thesisIndexes) {
			String thesisName = ParamUtil.getString(actionRequest, "thesisName" + thesisIndex);
			if (!thesisName.equals("")) {
				long thesisId = CounterLocalServiceUtil.increment(Thesis.class.getName());
				Thesis thesis = ThesisLocalServiceUtil.createThesis(thesisId);
				thesis = this.updateThesis(thesis, thesisName, user.getUserId());
				ThesisLocalServiceUtil.addThesis(thesis);
			}
		}
	}
	
	/**
	 * Set attributes to Education object
	 * 
	 * @param education Education object
	 * @param userId long userId
	 * @param schoolName String schoolName
	 * @param degreeId long userId
	 * @param graduateYear String graudateYear
	 * @param recommender String recommender
	 * @param introduction String introduction
	 * @return Education object
	 */
	private Education setEducation(Education education, long userId, String schoolName, long degreeId, String graduateYear, 
			 String recommender, String introduction){
		education.setUserId(userId);
		education.setDegreeId(degreeId);
		education.setSchoolName(schoolName);
		education.setGraduateYear(graduateYear);
		education.setIntroduction(introduction);
		education.setRecommender(recommender);
		return education;
	}
	
	/**
	 * Update Honour object
	 * 
	 * @param honour Honour object
	 * @param honoraryName String honoraryName
	 * @param userId long userId
	 * @return Honour object
	 */
	private Honour updateHonor(Honour honour, String honoraryName, long userId) {
		honour.setUserId(userId);
		honour.setHonoraryName(honoraryName);
		return honour;
	}
	
	/**
	 * Update Property object
	 * 
	 * @param property
	 * @param propertyName
	 * @param userId
	 * @return Property object
	 */
	private Property updateProperty(Property property, String propertyName, long userId) {
		property.setUserId(userId);
		property.setPropertyName(propertyName);
		return property;
	}
	
	/**
	 * Update Thesis object
	 * 
	 * @param thesis Thesis object
	 * @param thesisName String thesisName
	 * @param userId long userId
	 * @return Thesis object
	 */
	private Thesis updateThesis(Thesis thesis, String thesisName, long userId) {
		thesis.setUserId(userId);
		thesis.setThesisName(thesisName);
		return thesis;
	}
	
}
