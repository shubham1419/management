<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">

        <!-- Header--
        <header id="header" class="header">

            <div class="header-menu">

  
            </div>

        </header><!-- /header -->
        <!-- Header-->

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Dashboard</h1>
                    </div>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="page-header float-right">
                    <div class="page-title">
                     <security:authorize access="isAuthenticated()">
                        <ol class="breadcrumb text-right">
                            <li class="active">User Menu</li>
                            <a href="${contextRoot}/perform-logout">Logout</a>
                        </ol>
                        </security:authorize>
                    </div>
                </div>
            </div>
        </div>