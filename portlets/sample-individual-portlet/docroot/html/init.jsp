<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
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
<%@ page import="com.liferay.portal.model.Region"%>
<%@ page import="com.liferay.portal.service.RegionServiceUtil"%>
<%@ page import="com.liferay.sample.model.Degree"%>
<%@ page import="com.liferay.sample.service.DegreeLocalServiceUtil"%>
<%@ page import="com.liferay.sample.model.Education"%>
<%@ page import="com.liferay.sample.service.EducationLocalServiceUtil"%>
<%@ page import="com.liferay.sample.model.Property"%>
<%@ page import="com.liferay.sample.service.PropertyLocalServiceUtil"%>
<%@ page import="com.liferay.sample.model.Honour"%>
<%@ page import="com.liferay.sample.service.HonourLocalServiceUtil"%>
<%@ page import="com.liferay.sample.model.Thesis"%>
<%@ page import="com.liferay.sample.service.ThesisLocalServiceUtil"%>

<%@ page import="javax.portlet.WindowState" %>
<link href="${pageContext.request.contextPath}/css/amazeui.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>

<portlet:defineObjects />

<liferay-theme:defineObjects />