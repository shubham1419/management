<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
        
 <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top " id="navigation-example">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="javascript:void(0)">Dashboard</a>
          </div>
        <security:authorize access="isAuthenticated()">
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item dropdown">
                <a class="nav-link" href="javscript:void(0)" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="material-icons">person</i>
                  <!-- <span class="notification">5</span> -->
                  <p class="d-lg-none d-md-block">
                    User Menu
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="javascript:void(0)">Mike John responded to your email</a>
                  <a class="dropdown-item" href="javascript:void(0)">You have 5 new tasks</a>
                  <a class="dropdown-item" href="javascript:void(0)">You're now friend with Andrew</a>
                  <a class="dropdown-item" href="javascript:void(0)">Another Notification</a>
                  <a class="dropdown-item" href="${contextRoot}/perform-logout">Logout</a>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="javascript:void(0)">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
              </li>
            </ul>
          </div>
          </security:authorize>
        </div>
      </nav>
      <!-- End Navbar -->        
        
    <div class="content">    
