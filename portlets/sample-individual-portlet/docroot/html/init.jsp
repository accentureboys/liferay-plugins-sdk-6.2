<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.CookieNotSupportedException" %>
<%@ page import="com.liferay.portal.NoSuchUserException" %>
<%@ page import="com.liferay.portal.PasswordExpiredException" %>
<%@ page import="com.liferay.portal.UserEmailAddressException" %>
<%@ page import="com.liferay.portal.UserLockoutException" %>
<%@ page import="com.liferay.portal.UserPasswordException" %>
<%@ page import="com.liferay.portal.UserScreenNameException" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.util.*" %>
<%@ page import="com.liferay.portal.model.Company" %>
<%@ page import="com.liferay.portal.security.auth.AuthException" %>
<%@ page import="com.liferay.portal.model.UserConstants"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.model.Country"%>
<%@ page import="com.liferay.portal.service.CountryServiceUtil"%>

<%@ page import="javax.portlet.WindowState" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<portlet:defineObjects />

<liferay-theme:defineObjects />