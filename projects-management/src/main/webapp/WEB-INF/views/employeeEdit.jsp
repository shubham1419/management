<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content mt-3">
	<c:if test="${not empty message}">
		<div class="col-sm-12">
			<div class="alert alert-${msgclass} alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				${message}
			</div> 
		</div>
	</c:if>
	<div class="col-sm-12">
		<!-- form for adding developer -->
		<sf:form modelAttribute="employee" method="POST" action="${contextRoot}/manage/employee/update">
			
						<div class="form-group row">
				<label class="col-2 col-form-label">E-mail:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="email" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Password:</label>
				<div class="col-10">
					<sf:input class="form-control" type="password" path="password" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Confirm Password:</label>
				<div class="col-10">
					<sf:input class="form-control" type="password"
						path="confirmPassword" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Role</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="role" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Designation:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="designation" />
				</div>
			</div>
			
			
			<div class="form-group row">
				<label class="col-2 col-form-label">First Name:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="employeeMeta.fisrtName" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Last Name:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="employeeMeta.lastName" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-2 col-form-label">Address:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="employeeMeta.address" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-2 col-form-label">Phone:</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="employeeMeta.phone" />
				</div>
			</div>
			
						
			<sf:input type="hidden" path="employeeMeta.id" />
			<sf:input type="hidden" path="employeeMeta.status" />
			<sf:input type="hidden" path="employeeMeta.profileImage" />
			
			<sf:input type="hidden" path="id" />
			<sf:input type="hidden" path="status" />
			<sf:input type="hidden" path="assigned" />
			
			<input class="btn btn-primary" type="submit" value="Submit">
		</sf:form>
	</div>
</div>
</div>