<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@include file="/html/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>

<% 
	List<com.liferay.sample.model.Degree> allDegrees = DegreeLocalServiceUtil.getAllDegrees();
	User selUser = PortalUtil.getSelectedUser(request);
	selUser = PortalUtil.getUser(request);
	Education education = null;
	education = EducationLocalServiceUtil.getEducationByUserId(selUser.getUserId());
	List<Honour> honourList = new ArrayList<Honour>();
	List<Property> propertyList = new ArrayList<Property>();
	List<Thesis> thesisList = new ArrayList<Thesis>();
	honourList = HonourLocalServiceUtil.getHonourListByUserId(selUser.getUserId());
	propertyList = PropertyLocalServiceUtil.getPropertyListByUserId(selUser.getUserId());
	thesisList = ThesisLocalServiceUtil.getThesisListByUserId(selUser.getUserId());
	int year = 0;
	long degreeId = 0l;
	if(education!=null){
		year = Integer.parseInt(education.getGraduateYear());
		degreeId = education.getDegreeId();
	}
%>

<portlet:actionURL name="getAutoFieldsData" var="getAutoFieldsData" windowState="normal"/>

<aui:form action="${getAutoFieldsData }" method="post">

<aui:fieldset label="学历资料">
	毕业大学:
	<liferay-ui:input-field model="<%= Education.class %>" bean="<%= education %>" field="schoolName" />
	<aui:select name="degree" label="学历">
		<aui:option label="请选择" value="0" />
		<c:set var="dId" value="<%=degreeId %>"/>
		<c:forEach var="degree" items='<%=allDegrees%>'>
			<option value="${degree.degreeId}" ${degree.degreeId == dId ? 'selected="selected"' : ''}>${degree.degreeName}
			</option>
		</c:forEach>
	</aui:select>
	<aui:select name="graduateYear" cssClass="graduateSelect" label="毕业年份" >
		<%
			Calendar c = Calendar.getInstance();
					int now = c.get(Calendar.YEAR);
					now -= 40;
					for (int i = 0; i < 42; i++) {
						out.println("<option value='" + now +"' "+ (year==now?"selected='selected'":"") + ">" + now
								+ "</option>");
						now++;
					}
		%>
	</aui:select>
</aui:fieldset>

<aui:fieldset label="获得荣誉">
<!-- show honor inputs -->
<%
	if(honourList.size() != 0){
%>
<div id="honour-fields">
	<%
		for(int i=0; i<honourList.size(); i++){
	%>
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">
		<%
			String honor = "honoraryName" + String.valueOf(i);
		%>
			<aui:input fieldParam="<%=honor %>" id="<%=honor %>" name="<%=honor %>" value="<%=honourList.get(i).getHonoraryName() %>" label="荣誉称号"/>
		</div>
	</div>
	<%
		}
	%>
</div>
<%
	}else{
%>
<div id="honour-fields">
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">
			<aui:input fieldParam='honoraryName0' id='honoraryName0' name="honoraryName0" label="荣誉称号"/>
		</div>
	</div>
</div>
<%
	}
%>

<!-- show property inputs -->
<%
	if(propertyList.size() != 0){
%>
<div id="property-fields">
	<%
		for(int i=0; i<propertyList.size(); i++){
	%>
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">
			<%
				String property = "propertyName" + String.valueOf(i);
			%>
			<aui:input fieldParam="<%=property %>" id="<%=property %>" name="<%=property %>" value="<%=propertyList.get(i).getPropertyName() %>" label="知识产权"/>
		</div>
	</div>
	<%
		}
	%>
</div>
<%
	}else{
%>
<div id="property-fields">
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">
			<aui:input fieldParam='propertyName0' id='propertyName0' name="propertyName0" label="知识产权"/>
		</div>
	</div>
</div>
<%
	}
%>


<!-- show thesis inputs -->
<%
	if(thesisList.size() != 0){
%>
<div id="thesis-fields">
	<%
		for(int i=0; i<thesisList.size(); i++){
	%>
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">
			<%
				String thesis = "thesisName" + String.valueOf(i);
			%>
			<aui:input fieldParam="<%=thesis %>" id="<%=thesis %>" name="<%=thesis %>" value="<%=thesisList.get(i).getThesisName() %>" label="论文专著"/>
		</div>
	</div>
	<%
		}
	%>
</div>
<%
	}else{
%>
<div id="thesis-fields">
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">
			<aui:input fieldParam='thesisName0' id='thesisName0' name="thesisName0" label="论文专著"/>
		</div>
	</div>
</div>
<%
	}
%>

推荐人:
<liferay-ui:input-field model="<%= Education.class %>" bean="<%= education %>" field="recommender" />
更多介绍:
<liferay-ui:input-field model="<%= Education.class %>" bean="<%= education %>" field="introduction" />
</aui:fieldset>

<aui:button-row>
		<aui:button class="btn btn-primary" type="submit"/>
		<aui:button  type="reset" />
</aui:button-row>

<aui:script use="liferay-auto-fields">
    new Liferay.AutoFields(
    {
    contentBox: '#honour-fields',
    fieldIndexes: '<portlet:namespace />honourIndexes'
    }
    ).render();
    
    new Liferay.AutoFields(
    {
    contentBox: '#property-fields',
    fieldIndexes: '<portlet:namespace />propertyIndexes'
    }
    ).render();
    
    new Liferay.AutoFields(
    {
    contentBox: '#thesis-fields',
    fieldIndexes: '<portlet:namespace />thesisIndexes'
    }
    ).render();
 </aui:script>

</aui:form>