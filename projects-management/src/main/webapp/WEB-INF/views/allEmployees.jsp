<div class="container-fluid">
	<div class="row">
	    <div class="col-md-12">
			    <div class="card">
				    <div class="card-header">
		               <div class="text-primary">
	                       <a href="${contextRoot}/manage/register" class="btn btn-success">Add New Employee</a>
	                   </div>
				   </div>
			   </div>           
        </div>  
		<div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title ">List Of All Employees</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead class=" text-primary">
                        <th>
                          Sr No.
                        </th>
                        <th>
                          Employee Name
                        </th>
                        <th>
                          Designation
                        </th>
                        <th>
                         E-Mail
                        </th>
                        <th>
                          Action
                        </th>
                      </thead>
                      <tbody>
                      <c:forEach items="${employee}" var= "emp" varStatus="counter">  
                        <tr>
                          <td>
                           ${counter.count}
                          </td>
                          <td>
                            ${emp.employeeMeta.fisrtName} ${emp.employeeMeta.lastName}
                          </td>
                          <td>
                           ${emp.designation}
                          </td>
                          <td>
                            ${emp.email}
                          </td>
                          <td class="text-primary">
                           <a href="${contextRoot}/manage/employee/${emp.id}" class="btn btn-success">
                           	<i class="fa fa-pencil" aria-hidden="true"></i>
                           </a>
                           <a href="#" class="btn btn-primary">
                           	<i class="fa fa-eye" aria-hidden="true"></i>
                           </a>
                          </td>
                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
	</div>
</div>