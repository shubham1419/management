 <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
   
<body class="dark-edition">
  <div class="wrapper ">
  
    <div class="sidebar" data-color="purple" data-background-color="black" data-image="${css}/sidebar-2.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
        <a href="http://www.creative-tim.com" class="simple-text logo-normal">
         Dashboard
        </a>
      </div>
       <security:authorize access="isAuthenticated()">
      <div class="sidebar-wrapper">
        <ul class="nav">
        <security:authorize access="hasAuthority('USER')"> 
          <li class="nav-item active  ">
            <a class="nav-link" href="./dashboard.html">
              <i class="material-icons">dashboard</i>
              <p>Dashboard</p>
            </a>
          </li>
          </security:authorize>
           <security:authorize access="hasAuthority('ADMIN')">
          <li class="nav-item ">
            <a class="nav-link" href="${contextRoot}/manage/all-employees">
              <i class="material-icons">person</i>
              <p>Manage Employee</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="${contextRoot}/manage/all-projects">
              <i class="material-icons">library_books</i>
              <p>Manage Projects</p>
            </a>
          </li>
          
         <%-- 
         for later uses only url
          <li> <a href="${contextRoot}/manage/add/project"> <i class="fa fa-plus" aria-hidden="true"></i>Add Project </a></li>
          <li> <a href="${contextRoot}/manage/add/employee"> <i class="fa fa-plus" aria-hidden="true"></i>Add Employee </a></li>
                --%>        
                  
          </security:authorize>
        </ul>
      </div>
       </security:authorize> 
    </div> 
    
    
    
    
    
    
    
    
