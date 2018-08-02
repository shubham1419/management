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
		<sf:form modelAttribute="developer"
			action="${contextRoot}/manage/developer" method="POST" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-2 col-form-label">Full Name</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="name" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Password</label>
				<div class="col-10">
					<sf:input class="form-control" type="password" path="password" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Confirm-Password</label>
				<div class="col-10">
					<sf:input class="form-control" type="password"
						path="confirmPassword" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Email</label>
				<div class="col-10">
					<sf:input class="form-control" type="email" path="email" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-2 col-form-label">Phone</label>
				<div class="col-10">
					<sf:input class="form-control" type="tel" path="phone" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-2 col-form-label">Designation</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="designation" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Role</label>
				<div class="col-10">
					<sf:select path="role">
						<sf:option value="NONE" label="Select Role" />
						<sf:options items="${developerRole}" />
					</sf:select>

				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Address</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="address" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">Upload Image:</label>
				<div class="col-10">
					<sf:input class="form-control" type="file" path="file" />
				</div>
			</div>
			<input class="bnt btn-primary" type="submit" value="Submit">
			<sf:input type="hidden" path="id" />
			<sf:input type="hidden" path="status" />
			<sf:input type="hidden" path="imgCode" />
		</sf:form>
	</div>
</div>
</div>