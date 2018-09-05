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
		<sf:form modelAttribute="project"
			action="${contextRoot}/manage/add/project" method="POST" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-2 col-form-label">Project Name</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="projectName" />
				</div>
			</div>

			<input class="bnt btn-primary" type="submit" value="Submit">
			<sf:input type="hidden" path="id" />
			<sf:input type="hidden" path="status" />
		</sf:form>
	</div>
</div>
</div>