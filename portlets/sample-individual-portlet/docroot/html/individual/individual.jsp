<%@include file="/html/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>

<% 
	List<com.liferay.sample.model.Degree> allDegrees = DegreeLocalServiceUtil.getAllDegrees();
%>

<%-- <portlet:actionURL name="updateUserBackground" var="updateUserBackground" windowState="normal"/>
<aui:form  action="${updateUserBackground}" method="POST"> --%>      

<aui:fieldset label="学历资料">
	<aui:input name="schoolName" type="text" label="毕业大学"></aui:input>
	<aui:select name="degree" label="学历">
		<aui:option label="请选择" value="0" />
		<c:forEach var="degree" items='<%=allDegrees%>'>
			<aui:option label="${degree.degreeName}" value="${degree.degreeId}" />
		</c:forEach>
	</aui:select>
	<aui:select name="graduateYear" cssClass="graduateSelect" label="毕业年份" >
		<%
			Calendar c = Calendar.getInstance();
					int now = c.get(Calendar.YEAR);
					now -= 40;
					for (int i = 0; i < 42; i++) {
						out.println("<option value=" + now + ">" + now
								+ "</option>");
						now++;
					}
		%>
	</aui:select>
</aui:fieldset>

<aui:fieldset label="获得荣誉">

</aui:fieldset>
<%-- </aui:form> --%>