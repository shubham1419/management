<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content">
    <div class="container-fluid">
      <div class="row">
       <c:if test="${not empty message}">
		<div class="col-md-8">
			<div class="alert alert-${msgclass} alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				${message}
			</div> 
		</div> 
	</c:if> 
       <div class="col-md-8">
         <div class="card">
	
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
		
		</div>
	</div>
</div>
</div>





<html lang="en">
<head>
  <title>Add Remove input fields dynamically using jQuery bootstrap</title>
  
  
</head>
<body>
 

       <sf:form modelAttribute="projectMeta"
			action="${contextRoot}/manage/add/project/tasks" method="POST">
 
      	<div class="input-group control-group after-add-more">
			
			
			   <input type="text" name="addmore[]" path="taskName" class="form-control" placeholder="Enter Task">
					  <div class="input-group-btn"> 
						<button class="btn btn-success add-more" type="button"><i class="glyphicon glyphicon-plus"></i> Add</button>
					  </div>
			  </div>
 
        		<input class="bnt btn-primary" type="submit" value="Submit">
			<sf:input type="hidden" path="id" />
			<sf:input type="hidden" path="status" />
		</sf:form>
		
 
        <!-- Copy Fields-These are the fields which we get through jquery and then add after the above input,-->
        <div class="copy-fields hide">
          <div class="control-group input-group" style="margin-top:10px">
            <input type="text" name="addmore[]" path="taskName"  class="form-control" placeholder="Enter Task">
            <div class="input-group-btn"> 
              <button class="btn btn-danger remove" type="button"><i class="glyphicon glyphicon-remove"></i> Remove</button>
            </div>
          </div>
        </div>
	</div>
  </div>
</div>
 
<script type="text/javascript">
 
    $(document).ready(function() {
 
	//here first get the contents of the div with name class copy-fields and add it to after "after-add-more" div class.
      $(".add-more").click(function(){ 
          var html = $(".copy-fields").html();
          $(".after-add-more").after(html);
      });
//here it will remove the current value of the remove button which has been pressed
      $("body").on("click",".remove",function(){ 
          $(this).parents(".control-group").remove();
      });
 
    });
 
</script>
 
</body>
</html>

