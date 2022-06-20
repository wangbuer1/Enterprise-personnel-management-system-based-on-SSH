<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工资管理平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div class="login-div">
    <form class="login-form" method="post" action="login">
        <h2>工资管理平台登录</h2>
        <div class="input-div">
            <label for="name">用户名</label>
            <input id="name" type="text" placeholder="请输入用户名" name="username">
        </div>
        <div class="input-div">
            <label for="password">密  码</label>
            <input id="password" type="password" placeholder="请输入密码" name="password">
        </div>
        <div class="button-div">
            <button type="submit" class="login-button">登陆</button>
            <button class="register-button">
                <a href="${pageContext.request.contextPath}/toRegister">注册</a>
            </button>
        </div>
        <div class="input-div">
            <span class="error-info" style="color: red">${info}</span>
        </div>
    </form>
</div>
</body>
</html>
