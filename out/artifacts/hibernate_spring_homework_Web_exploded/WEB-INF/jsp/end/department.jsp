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
<div class="cart-content">
    <h1 style="font-size: 22px">岗位管理</h1>
    <div style="display: flex;justify-content: space-between">
        <div>
            <form action="${pageContext.request.contextPath}/end/department/getDepartmentByFuzzyName" method="post">
                岗位名称:<input type="text" name="departmentName" value="${department.departmentName}">
                <button>查询</button>
            </form>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/end/department/toAdd">
                <button class="bg-primary">添加</button>
            </a>
        </div>
    </div>
        <table>
        </table><table class="table table-bordered">
        <thead>
        <tr>
            <th width="60">#</th>
            <th>岗位信息</th>
            <th width="200">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${departmentList}" var="department">
            <tr>
                <td style="text-align: center">
                        ${department.id}
                </td>
                <td>${department.departmentName}</td>
                <td><div class="table-button">
                    <a href="${pageContext.request.contextPath}/end/department/toUpdate?departmentId=${department.id}">
                    <button>编辑</button>
                    </a>
                    <a href="${pageContext.request.contextPath}/end/department/delete?departmentId=${department.id}">
                    <button class="bg-danger">删除</button>
                    </a>
                </div></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="color: red">${info}</div>
</div>
</body>
</html>
