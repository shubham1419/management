<%@include file="./shared/header.jsp"%>
<body>

	<div class="container">
		<div class="row">
			<div class="col">
				<div class="jumbotron">
					<center> 
						<h2>${title}</h2>
					</center>
				</div>
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
</body>
<%@include file="./shared/footer.jsp"%>
</html>