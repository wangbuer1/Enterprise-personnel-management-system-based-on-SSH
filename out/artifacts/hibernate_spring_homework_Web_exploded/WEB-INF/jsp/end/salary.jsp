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
    <h1 style="font-size: 22px">工资管理</h1>
    <div style="display: flex;justify-content: space-between">
        <div>
            <form action="${pageContext.request.contextPath}/end/salary/getSalaryByCritiria" method="post">
                员工编号:<input type="text" name="employeeCode" value="${employee.employeeCode}">
                员工姓名:<input type="text" name="employeeName" value="${employee.employeeName}">
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
                <button>查询</button>
            </form>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/end/salary/toAdd">
                <button class="bg-primary">添加</button>
            </a>
        </div>
    </div>
        <table>
        </table><table class="table table-bordered">
        <thead>
        <tr>
            <th width="60">#</th>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>基本工资</th>
            <th>岗位津贴</th>
            <th>奖金</th>
            <th>住房补贴</th>
            <th>总计</th>
            <th>岗位类型</th>
            <th width="200">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td style="text-align: center">
                        ${employee.id}
                </td>
                <td>${employee.employeeCode}</td>
                <td>${employee.employeeName}</td>
                <td>${employee.salary.basis}</td>
                <td>${employee.salary.allowance}</td>
                <td>${employee.salary.bonus}</td>
                <td>${employee.salary.subsidy}</td>
                <td>${employee.salary.total}</td>
                <td>${employee.department.departmentName}</td>
                <td><div class="table-button">
                    <a href="${pageContext.request.contextPath}/end/salary/toUpdate?id=${employee.id}">
                    <button>编辑</button>
                    </a>
                    <a href="${pageContext.request.contextPath}/end/salary/delete?id=${employee.id}">
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
