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
        <h1 style="font-size: 22px">编辑员工信息</h1>
    </c:if>
    <c:if test="${empty employee.id}">
        <h1 style="font-size: 22px">添加员工信息</h1>
    </c:if>
    <c:if test="${empty employee.id}">
         <form class="employee-form" method="post" action="${pageContext.request.contextPath}/end/employee/add">
    </c:if>
        <c:if test="${!empty employee.id}">
        <form class="employee-form" method="post" action="${pageContext.request.contextPath}/end/employee/update?id=${employee.id}">
            </c:if>
                <c:if test="${!empty employee.id}">
                    <input name="oldEmployeeName" value="${employee.employeeName}" hidden>
                    <input name="id" value="${employee.id}" hidden>
                    </c:if>
                <div class="input-div">
                    <label for="employeeCode">员工编号</label>
                    <input id="employeeCode" type="text" placeholder="请输入员工编号" name="employeeCode" value="${employee.employeeCode}">
                </div>
                <div class="input-div">
                    <label for="employeeName">员工名称</label>
                    <input id="employeeName" type="text" placeholder="请输入员工名称" name="employeeName" value="${employee.employeeName}">
                </div>
                <div class="input-div" style="width: 340px">
                    <label for="age">员工年龄</label>
                        <span>
                            <input id="age" type="text" placeholder="请输入员工年龄" name="age" value="${employee.age}" onkeyup="this.value=this.value.replace(/\D/g,'')">
                        岁
                        </span>
                </div>
                <div class="input-div" style="width: 340px">
                    <label for="department">岗位类型</label>
                    <div>
                        <select id="department" name="department.id" style="width: 200px">
                            <option value="">请选择岗位</option>
                            <c:forEach items="${departmentList}" var="department">
                                <c:if test="${employee.department.id == department.id}">
                                    <option value="${department.id}" selected="selected">${department.departmentName}</option>
                                </c:if>
                                <c:if test="${employee.department.id != department.id}">
                                    <option value="${department.id}">${department.departmentName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
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
