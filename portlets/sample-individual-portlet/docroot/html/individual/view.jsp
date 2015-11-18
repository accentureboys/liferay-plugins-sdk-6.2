<%@include file="/html/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	User selUser = PortalUtil.getSelectedUser(request);
	selUser = PortalUtil.getUser(request);
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
		<aui:select name="countryId" label="国家" cssClass="countrySelect" id="countrySelector" onchange="changeRegions(this.value);">
			<aui:option label="请选择" value="0" />
			<c:forEach var="country" items='<%=allCountries%>'>
				<aui:option label="${country.name}"
					value="${country.countryId}" />
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
					<aui:option label="请选择" value="0" />
				</c:otherwise>
			</c:choose>
		</aui:select>
		<aui:input name="city" type="text" label="城市"></aui:input>
		<aui:input name="zipcode" type="text" label="邮政编码"></aui:input>
		<aui:input name="street" type="text" label="具体地址"></aui:input>
	</aui:fieldset>
	
	<aui:fieldset>
		<aui:select name="idType" label="证件类型">
			<aui:option label="请选择" value="0"></aui:option>
			<aui:option label="身份证" value="id"></aui:option>
			<aui:option label="护照" value="passport"></aui:option>
		</aui:select>
		<aui:input name="idNumber" type="text" label="证件号"></aui:input>
	</aui:fieldset>
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