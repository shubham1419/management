<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../shared/header.jsp"%>
<%@ include file="../../shared/sidebar.jsp"%>
<%@ include file="../../shared/topHeader.jsp"%>

<%-- <a href="${flowExecutionUrl}&_eventId_home">Home</a> --%>

<div class="content mt-3">
	<div class="col-sm-12">
		<!-- form for adding developer -->
		<sf:form modelAttribute="employeeMeta" method="POST">
			<div class="form-group row">
				<label class="col-2 col-form-label">First Name:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="fisrtName" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Last Name:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="lastName" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-2 col-form-label">Address:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="address" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-2 col-form-label">Phone:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="phone" />
				</div>
			</div>
			<sf:input type="hidden" path="id" />
			<sf:input type="hidden" path="status" />
			<sf:input type="hidden" path="profileImage" />
			<button type="submit" name="_eventId_professional"
				class="btn btn-primary">
				<span class="fa fa-left"></span> Back - Professional
			</button>
			<button type="submit" name="_eventId_confirm" class="btn btn-primary">
				Next - Confirm<span class="fa fa-right"></span>
			</button>
		</sf:form>
	</div>
</div>
</div>

<%@ include file="../../shared/footer.jsp"%>
</html>