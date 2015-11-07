<%@include file="/html/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:actionURL name="registerUser" var="registerUserURL" windowState="normal" />

<liferay-ui:error key="all-required" message="所有选项均为必填项！" />
<liferay-ui:error key="password-not-match" message="两次密码不一致！" />
<liferay-ui:error key="email-format-not-correct" message="邮箱格式不正确！" />

<%-- <aui:form action="<%= registerUserURL %>" method="POST" name="fm">
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
</aui:form> --%>

<!--main content start-->
  <main>
      <div class="am-g-fixed am-u-md-10 am-u-sm-centered">
          <form action="<%= registerUserURL %>" method="POST" class="am-form" id="register-form" data-am-validator>

              <div class="form-up" >
                  <h3>基本资料</h3>

                      <div class="form-item">
                          <label class="register-label" class="register-label" for="">用户名</label>
                          <input class="register-input" type="text" name="<portlet:namespace/>userName" required/>
                      </div>
                  <div class="form-item-block">
                      <div class="form-item">
                          <label  class="register-label" for="">姓</label>
                          <input class="register-input"  type="text" name="<portlet:namespace/>lastName" required/>
                      </div>
                      <div class="form-item">
                          <label class="register-label" for="">名</label>
                          <input class="register-input" type="text" name="<portlet:namespace/>firstName" required/>
                      </div>
                  </div>
                      <div class="form-item">
                      <label class="register-label" for="">性别</label>
                      <div class="register-radios">
                              <div class="am-radio">
                                  <label>
                                      <input type="radio" name="<portlet:namespace/>gender" value="1" checked>
                                      男
                                  </label>
                              </div>
                              <div class="am-radio">
                                  <label>
                                      <input type="radio" name="<portlet:namespace/>gender" value="0">
                                      女
                                  </label>
                              </div>
                      </div>
                      </div>
                  <div class="form-item-block">
                      <div class="form-item">
                          <label class="register-label" for="">密码</label>
                          <input class="register-input" minlength="6" id="reg-vld-pwd-1" name="<portlet:namespace/>pwd" type="password" placeholder="请输入至少6位密码" required/>
                      </div>

                      <div class="form-item">
                          <label class="register-label" for="">密码确认</label>
                          <input class="register-input" id="reg-vld-pwd-2" name="<portlet:namespace/>repeat_pwd" type="password"  placeholder="请与上面输入的值一致" data-equal-to="#reg-vld-pwd-1" required/>
                      </div>
                  </div>

              </div>
              <hr/>
              <div class="form-down">
                  <h3>联系方式</h3>
                  <div class="form-down-container">
                          <div class="form-item">
                              <label class="register-label" class="register-label" for="">邮箱地址</label>
                              <input class="register-input"  type="text" name="<portlet:namespace/>emailAddress" required/>
                          </div>
                          <div class="form-item">
                              <label  class="register-label" for="">手机号码</label>
                              <input class="register-input"  type="text"  name="<portlet:namespace/>telphone" required/>
                          </div>

                          <div class="form-item">
                              <label class="register-label" for="">其他方式</label>
                              <input class="register-input" type="text"/>
                          </div>


                  </div>
              </div>
         <!--button group -->
              <div class="register-btn am-cf">
                  <input type="submit" class="am-btn am-btn-primary am-btn-sm register-btn-item" value="提交"/>
                  <button class="am-btn am-btn-default am-btn-sm register-btn-item">重置</button>
              </div>

          </form>
      </div>
  </main>

