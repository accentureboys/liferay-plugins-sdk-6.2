<%@page import="com.liferay.portal.service.AddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Address"%>
<%@include file="/html/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	User selUser = PortalUtil.getSelectedUser(request);
	selUser = PortalUtil.getUser(request);
	List<Address> addressList = selUser.getAddresses();
	Address address = null;
	long countryId = 0L;
	long regionId = 0L;
	String countryName = "请选择";
	String regionName = "请选择";
	if(addressList.size() != 0){
		address = addressList.get(0);
		if(address != null){
			countryId = address.getCountryId();
			regionId = address.getRegionId();
			countryName = CountryServiceUtil.getCountry(countryId).getName();
			regionName = RegionServiceUtil.getRegion(regionId).getName();
		}
	}	
	String currentURL = PortalUtil.getCurrentURL(request);
	String editPortraitUrl = themeDisplay.getPortalURL()+"/group/control_panel/manage?p_p_id=2&p_p_lifecy‌​cle=0&p_p_state=pop_up&p_p_mode=view&_2_portrait_id=0&_2_p_u_i_d="+themeDisplay.getUserId()+"&_2_struts_action=%2Fmy_account%2Fedit_user_portrait";
	List<com.liferay.portal.model.Country> allCountries = CountryServiceUtil.getCountries();
%>

<portlet:actionURL name="updateUser" var="updateUser" windowState="normal"/>
	身份认证：
	<liferay-ui:logo-selector
			currentLogoURL="<%= user.getPortraitURL(themeDisplay) %>"
			defaultLogoURL="<%= UserConstants.getPortraitURL(themeDisplay.getPathImage(), selUser.isMale(), 0) %>"
			editLogoURL="<%= editPortraitUrl %>"
			imageId="<%= selUser.getPortraitId() %>"
			logoDisplaySelector=".user-logo"
			showBackground="<%= false %>"
		/>
	<aui:form  action="${updateUser}" method="POST">
	<aui:fieldset>
		<aui:select id="countrySelector" name="countryId" label="国家" cssClass="countrySelect" onchange="changeRegions(this.value);">
			<c:set var="cId" value="<%=countryId %>"/>
			<c:forEach var="country" items='<%=allCountries%>'>
				<option value="${country.countryId}" ${country.countryId == cId ? 'selected="selected"' : ''}>${country.name}
				</option>
			</c:forEach>
		</aui:select>

		<aui:select name="regionId" label="地区" cssClass="regionSelect" id="regionSelector">
			<c:choose>
				<c:when test="${!empty regions}">
					<c:forEach var="region" items='${regions}'>
						<aui:option label="${region.name}" value="${region.regionId}" />
					</c:forEach>
				</c:when>
				<c:otherwise>
					<aui:option label="<%= regionName  %>" value="<%= regionId  %>" />
				</c:otherwise>
			</c:choose>
		</aui:select>
		城市:
		<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="city" />
		邮政编码:
		<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="zip" />
		具体地址:
		<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="street1" />
	</aui:fieldset>
	
	身份证：
	<liferay-ui:custom-attribute
        className="<%= User.class.getName() %>"
        classPK="<%= selUser != null ? selUser.getUserId() : 0  %>"
        editable="<%= true %>"
        label="<%= false %>"
        name="id"
    />
    
         护照:
	<liferay-ui:custom-attribute
        className="<%= User.class.getName() %>"
        classPK="<%= selUser != null ? selUser.getUserId() : 0  %>"
        editable="<%= true %>"
        label="<%= false %>"
        name="passport"
    />
    
	<aui:button-row>
		<aui:button class="btn btn-primary" type="submit"/>
		<aui:button  type="reset" />
	</aui:button-row>
	</aui:form>
	
<aui:script>
function _2_changeLogo(newPortraitURL, newPortraitId) {
    <portlet:namespace/>portraitId_var = newPortraitId;
    var A = AUI();
    A.one('.avatar').attr('src', newPortraitURL);

    A.one('.deletePortrait').val(false);

}
</aui:script>	