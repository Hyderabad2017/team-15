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
  </head>

  <body>
<?php
define('DB_NAME','halloffame');
define('DB_USER','root');
define('DB_PASSWORD','');
define('DB_HOST','localhost');

$link=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD);
echo 'entered';
session_start();
if(!$link)
{
	die('could not connect:'.mysql_error());
}
$db_selected=mysql_select_db(DB_NAME,$link);
if(!$db_selected)
{
	die('can\'t use'.DB_NAME.':'.mysql_error());
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	$An=$_POST['A-'];
	$Ap=$_POST['A+'];
	$Bn=$_POST['B-'];
	$Bp=$_POST['B+'];
	$ABn=$_POST['AB-'];
	$ABp=$_POST['AB+'];
	$On=$_POST['O-'];
	$Op=$_POST['O+'];
	

echo $An;

$result=mysql_query("update recepients set A-='$An',B-='$Bn',AB-='$ABn',A+='$Ap',B+='$Bp',AB+='$ABp',O-='$On',O+='$Op' where username='bloodbank1'",$link);
echo $result;
}
?>
<!DOCTYPE html>
<html>
<head>
<style>
body {
    background-color: white;
}

h1 {
    color: red;
    text-align: center;
}

p {
    font-family: verdana;
    font-size: 2vw;
}
table, th, td {
    border-collapse: collapse;
	font-size:1.4vw;
}
th, td {
    padding: 5px;
    text-align: left;    
}
button{
	padding:10px;
	width:20%;
	margin-top:3%;
	margin-left:40%;
	display:block;
	color:white;
	background-color:blue;
	
}
button:hover{
color:black;
background-color:green;
}
h2{
	font-weight:bold;
	font-size:1.3vw;
	color:green;
	float:right;
}
h3{
	font-weight:bold;
	font-size:1.3vw;
	color:#bf6c31;
	float:left;
}
.but{
	width:100%;
	height:3%;background-color:#31bf8f;
}
</style>
</head>
<body>
<h3>Search for Bloodgroup</h4>
<form name="search" method="POST" action="result.php">
<table>
<tr>
<td>
 <select name="BB">
  <option value="A+" >A+</option>
  <option value="A-" >A-</option>
  <option value="B+" >B+</option>
  <option value="B-" >B-</option>
  <option value="AB+">AB+</option>
  <option value="AB-">AB-</option>
  <option value="O-">O-</option>
  <option value="O+" >O+</option>
 </select>
</td>
<td><input type="submit" class="but" name="search"> </td>
</form>
<h1>INVENTORY</h1>
<h2><a href="notif.php">Donor Requests</a></h2>


<form action="recuserhome.php" method="POST">
<table style="width:100%;margin-left:29%;margin-top:-3%;">
  <tr>
    <th>Blood group</th>
    <th>Availability</th>
  </tr>
  <tr>
    <td>O+</td>
    <td><input type="text" name="O+"></td>
  </tr>
    <tr>
    <td>O-</td>
    <td><input type="text" name="O-"></td>
  </tr>
    <tr>
    <td>A-</td>
    <td><input type="text" name="A-"></td>
   </tr>
    <tr>
    <td>A+</td>
    <td><input type="text" name="A+"></td>
   </tr>
    <tr>
    <td>B-</td>
    <td><input type="text" name="B-"></td>
    </tr>  
	<tr>
    <td>B+</td>
    <td><input type="text" name="B+"></td>
    </tr> 
	<tr>
    <td>AB-</td>
    <td><input type="text" name="AB-"></td>
    </tr>  
	<tr>
    <td>AB+</td>
    <td><input type="text" name="AB+"></td>
    </tr>  
	<tr>
    <td>O+</td>
    <td><input type="text" name="O+"></td>
    </tr>  
	<tr>
    <td>O-</td>
    <td><input type="text" name="O-"></td>
    </tr>  
</table> 
<button type="submit">SUBMIT</button>
</form>

</body> 
</html>
