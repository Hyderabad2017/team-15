<?php
//header("Location:userhome.php");
session_start();
define('DB_NAME','halloffame');
define('DB_USER','root');
define('DB_PASSWORD','');
define('DB_HOST','localhost');

$link=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD);
echo 'entered';

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
//$Name=$_POST['user'];
$Name=$_SESSION['sess_user'];
$BB=$_POST['BB'];
$dt=$_POST['dt'];
echo $Name;
echo $BB;
echo $dt;
$result=mysql_query("insert into donarreq(username,date,recepient) values('$Name','$dt','$BB')",$link);
echo 'request submitted successfully';
/*$norows=mysql_num_rows($result);

if($norows==0)
{
	header("Location:signup.php");
	
}
else if($norows==1)
{
	if($row=mysql_fetch_assoc($result))
	{
		$dbname=$row['uname'];
		$dbpassword=$row['pwd'];
	}
	if($dbname==$Name&&$dbpassword==$password)
	{
		session_start();
		echo 'logged in';
		$_SESSION['sess_user']=$Name;
		header("Location:userhome.php");
	}
	
}
else 
{
	echo 'couldnot use function';
}*/
}
mysql_close();
?>
<html>
<head>
<title>home</title>
</head>
<body>
<h1>donation details </h1>
<fieldset style="width:30%"><legend>Donation Form</legend>
<form method="POST" action="userhome.php">
<table border="0">

<tr>
<td>DATE</td><td> <input type="date" name="dt" id="dt" onchange="mydate1();"></td>
</tr>
<tr>
<td>BLOOD BANKS</td><td>  <select name="BB">
  <option value="bloodbank1" >bloodbank1</option>
  <option value="BLOODBANK2" >BLOODBANK2</option>
</select>
</td>
</tr>
<tr>
<td>
<input type="submit" name="submit" value="submit"></td></tr>
</table>
</form>
</body>
</html>