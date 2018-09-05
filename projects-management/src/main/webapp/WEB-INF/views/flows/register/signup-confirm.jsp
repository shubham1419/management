<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../shared/header.jsp"%>
<%@ include file="../../shared/sidebar.jsp"%>
<%@ include file="../../shared/topHeader.jsp"%>



<div class="container">

	<div class="row">

		<div class="col-sm-6">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Professional Details</h4>
				</div>

				<div class="panel-body">
					<div class="text-center">
						<p>
							Role : <strong>	${registerModel.employee.role}</strong>
						</p>
						<p>
							Designation : <strong>${registerModel.employee.designation}</strong>
						</p>
						<p>
							E-mail : <strong>${registerModel.employee.email}</strong>
						</p>
						<p>
							Password : <strong>${registerModel.employee.password}</strong>
						</p>
						<p>
							<a href="${flowExecutionUrl}&_eventId_professional"
								class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>

			</div>


		</div>

		<div class="col-sm-6">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>

				<div class="panel-body">
					<div class="text-center">
						<p>
							First Name : <strong>${registerModel.employeeMeta.fisrtName}</strong>
						</p>
						<p>
							Last Name : <strong>${registerModel.employeeMeta.lastName}</strong>
						</p>
						<p>
							Address : <strong>${registerModel.employeeMeta.address}</strong>
						</p>
						<p>
							Phone : <strong>${registerModel.employeeMeta.phone}</strong>
						</p>
						<p>
							<a href="${flowExecutionUrl}&_eventId_personal"
								class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>

			</div>

		</div>

	</div>

	<div class="row">

		<div class="col-sm-4 col-sm-offset-4">

			<div class="text-center">

				<a href="${flowExecutionUrl}&_eventId_submit"
					class="btn btn-lg btn-primary">Confirm</a>

			</div>

		</div>

	</div>

</div>
<%@ include file="../../shared/footer.jsp"%>
</html>