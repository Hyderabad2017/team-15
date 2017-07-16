<?php
//header("Location:userhome.php");
define('DB_NAME','united');
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
$Name=$_POST['user'];
$password=$_POST['pass'];
echo $Name;
echo $password;
$result=mysql_query("insert into recepients(user,password) values ($Name,$password)",$link);
$norows=mysql_num_rows($result);

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
	/*if($dbname==$&&$dbpassword==$password)
	{
		session_start();
		echo 'logged in';
		$_SESSION['sess_user']=$Name;
		header("Location:userhome.php");
	}*/
	
}
else 
{
	echo 'couldnot use function';
}
}
mysql_close();
?>