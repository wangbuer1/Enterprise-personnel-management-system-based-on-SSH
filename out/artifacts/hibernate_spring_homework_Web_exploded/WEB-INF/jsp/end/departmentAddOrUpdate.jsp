<%@include file="../header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="department-form-div">
    <c:if test="${!empty department.id}">
        <h1 style="font-size: 22px">编辑岗位信息</h1>
    </c:if>
    <c:if test="${empty department.id}">
        <h1 style="font-size: 22px">添加岗位信息</h1>
    </c:if>
    <c:if test="${empty department.id}">
         <form class="department-form" method="post" action="${pageContext.request.contextPath}/end/department/add">
    </c:if>
        <c:if test="${!empty department.id}">
        <form class="department-form" method="post" action="${pageContext.request.contextPath}/end/department/update?id=${department.id}">
            </c:if>
                <c:if test="${!empty department.id}">
                    <input name="oldDepartmentName" value="${department.departmentName}" hidden>
                    <input name="id" value="${department.id}" hidden>
                </c:if>
        <div class="input-div">
            <label for="departmentName">分类名称</label>
            <input id="departmentName" type="text" placeholder="请输入分类名称" name="departmentName" value="${department.departmentName}">
        </div>
        <div class="input-div" style="display: flex;justify-content: flex-start;">
            <c:if test="${empty department.id}">
                <button type="submit" class="login-button">添加</button>
                </c:if>
                <c:if test="${!empty department.id}">
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
