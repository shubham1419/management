<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../shared/header.jsp"%>
<%@ include file="../../shared/sidebar.jsp"%>
<%@ include file="../../shared/topHeader.jsp"%>

<div class="content mt-3">
	<div class="col-sm-12">
		<!-- form for adding developer -->
		<sf:form modelAttribute="employee" method="POST">

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

			<%-- 			<div class="form-group row">
				<label class="col-2 col-form-label">Role</label>
				<div class="col-10">
					<sf:select path="role">
						<sf:option value="NONE" label="Select Role" />
						<sf:options items="${developerRole}" />
					</sf:select>

				</div>
			</div> --%>

			<sf:input type="hidden" path="id" />
			<sf:input type="hidden" path="status" />
			<sf:input type="hidden" path="assigned" />

			<button type="submit" name="_eventId_personal"
				class="btn btn-primary">
				Next - Personal<span class="fa fa-right"></span>
			</button>
		</sf:form>
	</div>
</div>
</div>
<%@ include file="../../shared/footer.jsp"%>
