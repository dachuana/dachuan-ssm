<%--
  Created by IntelliJ IDEA.
  User: 12517
  Date: 2018/10/19
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>商品信息</title>
</head>
<body>
    <table width="100%" border="1">
        <tr>
            <td>商品名称</td>
            <td>${item.name}</td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td>${item.price}</td>
        </tr>
        <tr>
            <td>生日日期</td>
            <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <td>商品介绍</td>
            <td>${item.datail}</td>
        </tr>
    </table>
</body>
</html>
