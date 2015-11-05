<%@include file="/html/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	User selUser = PortalUtil.getSelectedUser(request);
	selUser = PortalUtil.getUser(request);
	String currentURL = PortalUtil.getCurrentURL(request);
	String editPortraitUrl = themeDisplay.getPortalURL()+"/group/control_panel/manage?p_p_id=2&p_p_lifecy‌​cle=0&p_p_state=pop_up&p_p_mode=view&_2_portrait_id=0&_2_p_u_i_d="+themeDisplay.getUserId()+"&_2_struts_action=%2Fmy_account%2Fedit_user_portrait";
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
			
		</aui:fieldset>
	</aui:form>
	
<aui:script>
function _2_changeLogo(newPortraitURL, newPortraitId) {
    <portlet:namespace/>portraitId_var = newPortraitId;
    var A = AUI();
    A.one('.avatar').attr('src', newPortraitURL);

    A.one('.deletePortrait').val(false);

}
</aui:script>	