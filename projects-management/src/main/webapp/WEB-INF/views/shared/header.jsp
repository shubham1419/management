<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="springTag" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<springTag:url var="css" value="/resources/css" />
<springTag:url var="scss" value="/resources/scss" />
<springTag:url var="js" value="/resources/js" />
<springTag:url var="img" value="/resources/images" />
<springTag:url var="images" value="/resources/empImages" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	  <meta charset="utf-8" />
	  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
	  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	  <title>Project Management - ${title}  </title>
	  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
	  <!--     Fonts and icons     -->
	  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	  <!-- CSS Files -->
	  <link href="${css}/material-dashboard.css?v=2.1.0" rel="stylesheet" />
	  <!-- my custom css -->
	  <link rel="stylesheet" href="${css}/my-style.css">
	</head>




