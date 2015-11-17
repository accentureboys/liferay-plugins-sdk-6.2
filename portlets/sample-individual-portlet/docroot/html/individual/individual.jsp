<%@include file="/html/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>

<% 
	List<com.liferay.sample.model.Degree> allDegrees = DegreeLocalServiceUtil.getAllDegrees();
%>

<script>  
$(document).ready(function() {  
//input box 1  
var MaxInputs1       = 8; //maximum input boxes allowed  
var InputsWrapper1   = $("#InputsWrapper1"); //Input boxes wrapper ID  
var AddButton1       = $("#AddMoreFileBox1"); //Add button ID  
  
var x = InputsWrapper1.length; //initlal text box count  
var FieldCount1=1; //to keep track of text box added  
  
$(AddButton1).click(function (e)  //on add input button click  
{  
        if(x <= MaxInputs1) //max input box allowed  
        {  
            FieldCount1++; //text box added increment  
            //add input box  
            $(InputsWrapper1).append('<div><input type="text" name="<portlet:namespace/>honouryName' + FieldCount1 +'" id="<portlet:namespace/>honouryName'+ FieldCount1 +'"/><a href="#" class="removeclass1">×</a></div>');  
            x++; //text box increment  
        }  
return false;  
});  
  
$("body").on("click",".removeclass1", function(e){ //user click on remove text  
        if( x > 1 ) {  
                $(this).parent('div').remove(); //remove text box  
                x--; //decrement textbox  
                FieldCount1--; //decrement count
        }  
return false;  
})   

//input box 2 
var MaxInputs2       = 8; //maximum input boxes allowed  
var InputsWrapper2   = $("#InputsWrapper2"); //Input boxes wrapper ID  
var AddButton2       = $("#AddMoreFileBox2"); //Add button ID  
  
var x = InputsWrapper2.length; //initlal text box count  
var FieldCount2=1; //to keep track of text box added  
  
$(AddButton2).click(function (e)  //on add input button click  
{  
        if(x <= MaxInputs2) //max input box allowed  
        {  
        	FieldCount2++; //text box added increment  
            //add input box  
            $(InputsWrapper2).append('<div><input type="text" name="<portlet:namespace/>thesisName' + FieldCount2 +'" id="<portlet:namespace/>thesisName'+ FieldCount2 +'"/><a href="#" class="removeclass2">×</a></div>');  
            x++; //text box increment  
        }  
return false;  
});  
  
$("body").on("click",".removeclass2", function(e){ //user click on remove text  
        if( x > 1 ) {  
                $(this).parent('div').remove(); //remove text box  
                x--; //decrement textbox  
                FieldCount2--; //decrement count
        }  
return false;  
})   

//input box 3
var MaxInputs3       = 8; //maximum input boxes allowed  
var InputsWrapper3   = $("#InputsWrapper3"); //Input boxes wrapper ID  
var AddButton3       = $("#AddMoreFileBox3"); //Add button ID  
  
var x = InputsWrapper3.length; //initlal text box count  
var FieldCount3=1; //to keep track of text box added  
  
$(AddButton3).click(function (e)  //on add input button click  
{  
        if(x <= MaxInputs3) //max input box allowed  
        {  
        	FieldCount3++; //text box added increment  
            //add input box  
            $(InputsWrapper3).append('<div><input type="text" name="<portlet:namespace/>propertyName' + FieldCount3 +'" id="<portlet:namespace/>propertyName'+ FieldCount3 +'"/><a href="#" class="removeclass3">×</a></div>');  
            x++; //text box increment  
        }  
return false;  
});  
  
$("body").on("click",".removeclass3", function(e){ //user click on remove text  
        if( x > 1 ) {  
                $(this).parent('div').remove(); //remove text box  
                x--; //decrement textbox  
                FieldCount3--; //decrement count
        }  
return false;  
})   
  
});  
</script>

<portlet:actionURL var="updateUserBackground" windowState="normal"/>

<aui:form  action="${updateUserBackground}" method="POST">      

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
<div>
    <a href="#" id="AddMoreFileBox1" class="btn btn-info">添加更多的荣誉输入框</a></span></p>  
    <div id="InputsWrapper1">  
    	<div>
    		<label class="" for="">荣誉称号</label>
    		<input type="text" name="<portlet:namespace/>honouryName1" id="<portlet:namespace/>honouryName1"/><a href="#" class="removeclass1">×</a>
    	</div>  
    </div>  
</div>

<div>    
    <a href="#" id="AddMoreFileBox2" class="btn btn-info">添加更多的论文输入框</a></span></p>  
    <div id="InputsWrapper2">  
    	<div>
    		<label class="" for="">论文专著</label>
    		<input type="text" name="<portlet:namespace/>thesisName1" id="<portlet:namespace/>thesisName1"/><a href="#" class="removeclass2">×</a>
    	</div>  
    </div>
</div>  

<div>    
    <a href="#" id="AddMoreFileBox3" class="btn btn-info">添加更多的产权输入框</a></span></p>  
    <div id="InputsWrapper3">  
    	<div>
    		<label class="" for="">知识产权</label>
    		<input type="text" name="<portlet:namespace/>propertyName1" id="<portlet:namespace/>propertyName1"/><a href="#" class="removeclass3">×</a>
    	</div>  
    </div>
</div>

<aui:input name="recommender" type="text" label="推荐人"></aui:input>
<label class="" for="">更多介绍</label>
<textarea name="<portlet:namespace/>introduction" rows="4" cols="20" wrap="hard"></textarea>
</aui:fieldset>

<aui:button-row>
		<aui:button class="btn btn-primary" type="submit"/>
		<aui:button  type="reset" />
</aui:button-row>

</aui:form>