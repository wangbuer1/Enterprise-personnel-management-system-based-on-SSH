<%@include file="../header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工资管理平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="index-div">
    <div class="header-left">
         <span>
            <span>欢迎来到工资管理平台</span>
        </span>
    </div>
    <div class="header-right">
        <span>
               <c:if test="${sessionScope.user.role == '管理员'}">
                   <a href="${pageContext.request.contextPath}/end/department/list">部门管理</a>
               </c:if>
            <c:if test="${sessionScope.user.role == '管理员'}">
                <a href="${pageContext.request.contextPath}/end/employee/list">员工管理</a>
            </c:if>
            <c:if test="${sessionScope.user.role == '管理员'}">
                <a href="${pageContext.request.contextPath}/end/salary/list">工资管理</a>
            </c:if>
            <a href="/" id="logout">退出</a>
        </span>
    </div>
</div>
<div class="employee-form-div">
    <c:if test="${!empty employee.id}">
        <h1 style="font-size: 22px">编辑员工工资信息</h1>
    </c:if>
    <c:if test="${empty employee.id}">
        <h1 style="font-size: 22px">添加员工工资信息</h1>
    </c:if>
    <c:if test="${empty employee.id}">
         <form class="employee-form" method="post" action="${pageContext.request.contextPath}/end/salary/add">
    </c:if>
        <c:if test="${!empty employee.id}">
        <form class="employee-form" method="post" action="${pageContext.request.contextPath}/end/salary/update?id=${employee.id}">
            </c:if>
                <c:if test="${!empty employee.id}">
                    <input name="salary.id" value="${employee.salary.id}" hidden>
                    </c:if>
                <div class="input-div">
                    <label for="employeeCode">员工编号</label>
                <c:if test="${!empty employee.id}">
                    <input id="employeeCode" type="text" placeholder="请输入员工编号" name="employeeCode" value="${employee.employeeCode}" disabled="disabled">
                </c:if>
                <c:if test="${empty employee.id}">
                    <select id="employeeCode" name="id" style="width: 200px">
                        <option value="">请选择员工编号</option>
                        <c:forEach items="${employeeList}" var="employee">
                                <option value="${employee.id}">${employee.employeeCode}</option>
                        </c:forEach>
                    </select>
                </c:if>
                </div>
                <div class="input-div" style="width: 340px">
                    <label for="basis">基本工资</label>
                        <span>
                            <input id="basis" type="text" placeholder="请输入员工年龄" name="salary.basis" value="${employee.salary.basis}" onkeyup="this.value=this.value.replace(/\D/g,'')">
                        元
                        </span>
                </div>
                <div class="input-div" style="width: 340px">
                    <label for="bonus">奖金</label>
                    <span>
                            <input id="bonus" type="text" placeholder="请输入员工年龄" name="salary.bonus" value="${employee.salary.bonus}" onkeyup="this.value=this.value.replace(/\D/g,'')">
                        元
                        </span>
                </div>
                <div class="input-div" style="width: 340px">
                    <label for="allowance">津贴</label>
                    <span>
                            <input id="allowance" type="text" placeholder="请输入员工年龄" name="salary.allowance" value="${employee.salary.allowance}" onkeyup="this.value=this.value.replace(/\D/g,'')">
                        元
                        </span>
                </div>
                <div class="input-div" style="width: 340px">
                    <label for="subsidy">补贴</label>
                    <span>
                            <input id="subsidy" type="text" placeholder="请输入员工年龄" name="salary.subsidy" value="${employee.salary.subsidy}" onkeyup="this.value=this.value.replace(/\D/g,'')">
                        元
                        </span>
                </div>
        <div class="input-div" style="display: flex;justify-content: flex-start;">
            <c:if test="${empty employee.id}">
                <button type="submit" class="login-button">添加</button>
                </c:if>
                <c:if test="${!empty employee.id}">
                    <button type="submit" class="login-button">修改</button>
                    </c:if>
        </div>
        <div class="input-div">
            <span class="error-info" style="color: red">${info}</span>
        </div>
    </form>
</div>
</body>
</html>
