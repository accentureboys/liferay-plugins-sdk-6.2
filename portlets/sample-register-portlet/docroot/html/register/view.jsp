<%@include file="/html/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:actionURL name="registerUser" var="registerUserURL" windowState="normal" />

<liferay-ui:error key="all-required" message="所有选项均为必填项！" />
<liferay-ui:error key="password-not-match" message="两次密码不一致！" />
<liferay-ui:error key="email-format-not-correct" message="邮箱格式不正确！" />

<aui:form action="<%= registerUserURL %>" method="POST" name="fm">
	基本资料：
	<aui:fieldset>
		<aui:input type="text" name="userName" label="用户名："></aui:input>
		<aui:input type="text"  name="firstName" label="名："></aui:input>
		<aui:input type="text"  name="lastName" label="姓：" ></aui:input>
        <aui:select name="gender" label="性别：" id="gender">
		<aui:option label="男" value="1" /><div style="display: inline; float: left; width: 50%;">
		<aui:option label="女" value="0" />
		</aui:select>
        <aui:input type="password"  name="pwd" label="密  码："></aui:input>
        <aui:input type="password"  name="repeat_pwd" label="确认密码："></aui:input>
    </aui:fieldset>
       联系方式：
    <aui:fieldset>
    	 <aui:input type="text"  name="emailAddress" label="邮箱地址："></aui:input>
    	 <aui:input type="text"  name="telphone" label="电话号码："></aui:input>
    </aui:fieldset>
    
    <aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" />
	</aui:button-row>
</aui:form>