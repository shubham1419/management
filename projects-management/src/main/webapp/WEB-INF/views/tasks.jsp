<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>

    <title>Edit</title>
    <style type="text/css">.hidden {display: none;}</style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script type="text/javascript">
    $(function() {

        // Start indexing at the size of the current list
        var index = ${fn:length(employer.employees)};

        // Add a new Employee
        $("#add").off("click").on("click", function() {
            $(this).before(function() {
                var html = '<div id="projectMetaId' + index + '.wrapper" class="hidden">';                    
                html += '<input type="text" id="projectMetaId' + index + '.projectName" name="projectMetaId[' + index + '].projectName" />';
                html += '<input type="hidden" id="projectMetaId' + index + '.remove" name="projectMetaId[' + index + '].remove" value="0" />';
                html += '<a href="#" class="projectMetaId.remove" data-index="' + index + '">remove</a>';                    
                html += "</div>";
                return html;
            });
            $("#projectMetaId" + index + "\\.wrapper").show();
            index++;
            return false;
        });

        // Remove an Employee
        $("a.projectMetaId\\.remove").off("click").on("click", function() {
            var index2remove = $(this).data("index");
            $("#projectMetaId" + index2remove + "\\.wrapper").hide();
            $("#projectMetaId" + index2remove + "\\.remove").val("1");
            return false;
        });

    });
    </script>

</head>
<body>

    <c:choose>
        <c:when test="${type eq 'create'}"><c:set var="actionUrl" value="create" /></c:when>
        <c:otherwise><c:set var="actionUrl" value="employer/update/${employer.id}" /></c:otherwise>
    </c:choose>

    <form:form action="${actionUrl}" modelAttribute="projects" method="POST" name="employer">
        <form:hidden path="id" />
        <table>
            <tr>
                <td><form:label path="projectName">Project Name</form:label></td>
               
            </tr>
            <tr>
                <td>Employees</td>
                <td>
                    <c:forEach items="${projects.projectMetaId}" varStatus="loop">
                        <!-- Add a wrapping div -->
                        <c:choose>
                            <c:when test="${projects.projectMetaId[loop.index].remove eq 1}">
                                <div id=projectMetaId${loop.index}.wrapper" class="hidden">
                            </c:when>
                            <c:otherwise>
                                <div id="projectMetaId${loop.index}.wrapper">
                            </c:otherwise>
                        </c:choose>
                            <!-- Generate the fields -->
                            <form:input path="projectMetaId[${loop.index}].taskName" />
                            <!-- Add the remove flag -->
                            <c:choose>
                                <c:when test="${projectMetaId[loop.index].remove eq 1}"><c:set var="hiddenValue" value="1" /></c:when>
                                <c:otherwise><c:set var="hiddenValue" value="0" /></c:otherwise>
                            </c:choose>
                            <form:hidden path="projectMetaId[${loop.index}].remove" value="${hiddenValue}" />
                            <!-- Add a link to remove the Employee -->
                            <a href="#" class="projectMetaId.remove" data-index="${loop.index}">remove</a>
                        </div>
                    </c:forEach>
                    <button id="add" type="button">add</button>
                </td>
            </tr>
        </table>
        <button type="submit">OK</button>
    </form:form>

</body>
</html>



























<%-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
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
 --%>
