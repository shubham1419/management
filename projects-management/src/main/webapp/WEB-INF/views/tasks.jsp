<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


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
		<sf:form modelAttribute="projectMeta"
			action="${contextRoot}/manage/add/project/tasks" method="POST">
			<div class="form-group row">
				<label class="col-2 col-form-label">Task Name</label>
				<div class="col-10">
					<sf:input class="form-control" type="text" path="taskName" />
				</div>
			</div>
			<input class="bnt btn-primary" type="submit" value="Submit">
			<sf:input type="hidden" path="id" />
			<sf:input type="hidden" path="status" />
		</sf:form>
		
		
	
	<div class="row">
		<input type="hidden" name="count" value="1" />
        <div class="control-group" id="fields">
            <label class="control-label" for="field1">Nice Multiple Form Fields</label>
            <div class="controls" id="profs"> 
                <form class="input-append">
                    <div id="field"><input autocomplete="off" class="input" id="field1" name="prof1" type="text" placeholder="Type something" data-items="8"/><button id="b1" class="btn add-more" type="button">+</button></div>
                </form>
            <br>
            <small>Press + to add another form field :)</small>
            </div>
        </div>
	</div>
		
	</div>
</div>
</div>