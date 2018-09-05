<%@include file="./shared/header.jsp"%>
<%@ include file="./shared/sidebar.jsp"%>
<%@ include file="./shared/topHeader.jsp"%>
<body>

	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col">

					<center>
						<h2>${title}</h2>
					</center>

				</div>
			</div>
			<div class="row">
				<div class="col">
					<center>
						<%-- <p>${errorTitle}</p> --%>
						<h3>${errorDescription}</h3>
					</center>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="./shared/footer.jsp"%>
</html>