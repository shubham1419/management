<%@ include file="./shared/header.jsp"%>
<c:if test="${userClickIndex!= true}" >
<%@ include file="./shared/sidebar.jsp"%>
<%@ include file="./shared/topHeader.jsp"%>
</c:if>
<body> 

	<c:if test="${userClickIndex == true}">
		<%@include file="login.jsp"%>
	</c:if>

	<c:if test="${userCLickDashboard == true}">
		<%@include file="dashboard.jsp"%>
	</c:if>
	
	<c:if test="${userClickManageDeveloper == true}">
		<%@include file="developer.jsp" %>
	</c:if>
	
	<!--  **for testing purpose**-->
	<c:if test="${userCLickTesting == true}">
		<%@include file="testing.jsp"%>
	</c:if>
	
</body>
<%@ include file="./shared/footer.jsp"%>
</html>