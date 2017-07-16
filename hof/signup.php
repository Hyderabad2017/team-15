<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Theme Template for Bootstrap</title>
      <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../../dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="theme.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	<style>
	body{
		background-color:#4c50c4;
	}
	</style>
  </head>
 <?php
define('DB_NAME','halloffame');
define('DB_USER','root');
define('DB_PASSWORD','');
define('DB_HOST','localhost');

$link=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD);

if(!$link)
{
	die('could not connect:'.mysql_error());
}
$db_selected=mysql_select_db(DB_NAME,$link);
if(!$db_selected)
{
	die('can\'t use'.DB_NAME.':'.mysql_error());
}
if(isset($_POST["signin"]))
{
$fname=$_POST['firstname'];
$lname=$_POST['lastname'];
$E_mail=$_POST['email'];
$gender=$_POST['gender'];
$password=$_POST['password'];
$phno=$_POST['phno'];
$bgroup=$_POST['bgroup'];
$sql2="insert into user(fname,lname,phn,uname,gender,pwd,bgroup) values('$fname','$lname','$phno','$E_mail','$gender','$password','$bgroup')";

$sql=mysql_query("select * from user where uname='".$E_mail."'");
$norows=mysql_num_rows($sql);
if($norows==0)
{
	//$result1=mysql_query("insert into login(username,password) values('$E_mail','$password')");
	$result2=mysql_query("insert into user(fname,lname,phn,uname,gender,pwd,bgroup) values('$fname','$lname','$phno','$E_mail','$gender','$password','$bgroup')");

	echo 'account created successfully';
	header("Location:userhome.php");
	
}
else if($norows==1)
{
	echo 'account already exists';
	header("Location:login.php");
}

if(!mysql_query($result2))
{
	die('error:'.mysql_error());
}
}
mysql_close();

?>

  <body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="index.php">Home</a></li>
            <li><a href="login.php">Login</a></li>
			<li class="active"><a href="signup.php">Sign In </a></li>
           
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	
  <div class="container"style="margin-top:7%;"> 
<div id="signupbox" style="display margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" method="post" action ="signup.php" class="form-horizontal" role="form">
                                
                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>
                                    
                                
                                  
                               
                                    
                                <div class="form-group">
                                    <label for="firstname" class="col-md-3 control-label">First Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="firstname" value="" placeholder="First Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="lastname" value="" placeholder="Last Name">
                                    </div>
                                </div>
								<div class="form-group">
                                    <label for="BloodGroup" class="col-md-3 control-label">Blood Group</label>
								
                                    <div class="col-md-9">
                                        <select class="form-control" name="bgroup" >
									<option value="A+">A+</option>
									<option value="A-">A-</option>
									<option value="B+">B+</option>
									<option value="B-">B-</option>
									<option value="AB+">AB+</option>
									<option value="AB-+">AB-</option>
									<option value="O+">O+</option>
									<option value="O-">O-</option>
									
									</select>
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="email" value="" placeholder="Email Address">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="password" placeholder="Password">
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label for="phno" class="col-md-3 control-label">Phone Number</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="phno" placeholder="Phone Number">
                                    </div>
                                </div>
                                <div class="form-group">
                                <label for="gender" class="col-md-3 control-label">Gender</label>
                                    <div class="col-md-9">
                                    <div class="radio">
                                        <input id="female" name="gender" type="radio" value="female" >
                                        <label for="female" class="radio-label">Female</label>
                                      </div>

                                    <div class="radio">
                                        <input id="male" name="gender" type="radio" value="male" checked>
                                        <label  for="male" class="radio-label">Male</label>
                                      </div>
                                </div>
                                </div>
                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <input id="btn-signup" type="submit" name="signin" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</input>
                                         
                                    </div>
                                </div>
                                
                                
                                
                                
                            </form>
                         </div>
                    </div>
			</div> 
			</div>
			
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>