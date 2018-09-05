<body id="LoginForm">
<div class="container">
<div class="login-form">
<div class="main-div">
    <div class="panel">
   <p>Please enter your email and password</p>
   </div>
    <form action="${contextRoot}/login" method="POST"
						class="form-horizontal" id="loginForm">

        <div class="form-group">
			<input type="email" name="username" class="form-control" placeholder="Email Address">
        </div>

        <div class="form-group">  
			<input type="password" name="password" class="form-control" placeholder="Password">
        </div>
        <div class="forgot">
        <a href="reset.html">Forgot password?</a>
</div>
       <input type="submit" name="Login"
							class="btn btn-primary" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

    </form>
    
					
    </div>

</div></div></div>








<%-- <div class="content">


						<div class="form-group">
							<label>Email address</label> <input type="email" name="username"
								class="form-control" placeholder="Email">
						</div>
						<div class="form-group">
							<label>Password</label> <input type="password" name="password"
								class="form-control" placeholder="Password">
						</div>
						<div class="checkbox">
							<label> <input type="checkbox"> Remember Me
							</label> <label class="pull-right"> <a href="#">Forgotten
									Password?</a>
							</label>

						</div>
						<input type="submit" name="Login"
							class="btn btn-success btn-flat m-b-30 m-t-30" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>


</div>

 --%>




