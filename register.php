
<?php
if(!@mysql_connect('localhost','root',''))
{echo 'could not connect';
die();}

if(!@mysql_select_db(bb))
{echo 'error';}
$error1=false;
$error2=false;
$error3=false;
$error4=false;
$error5=false;
if(isset($_POST['signin']))
{
	$username=$_POST['username'];
	$email=$_POST['useremail'];
	$gender=$_POST['gender'];
	$mon=$_POST['mon'];
	$date=$_POST['dd'];
	$year=$_POST['yyyy'];
	$password=$_POST['password1'];
	$confpassword=$_POST['password2'];
	if($password==$confpass)
	{
		if(strlen($password)>=8)
		{
			
			
				if(filter_var($email,FILTER_VALIDATE_EMAIL))
				{
					$query=mysql_query("select email from recreg where email='$email'");
					if((mysql_num_rows($query))==1)
					{
						$error1=true;
						$emsg="email exists,try with diff email";
					}else
					{
						mysql_query("insert into recreg values('".mysql_real_escape_string($username)."','".mysql_real_escape_string($email)."','".mysql_real_escape_string($gender)."','".mysql_real_escape_string($mon)."','".mysql_real_escape_string($date)."','".mysql_real_escape_string($year)."','".mysql_real_escape_string($password)."','".mysql_real_escape_string($confpassword)."')");
						
					}
					
				}
				else{
						$error2=true;
						$emailms="enter valid email";
				}
			
		}else{
			$error4=true;
			$passms="password must be 8 chars";
		}
	
	}
else{
	$error5=true;
	$passnot="passwords not matched";
}
}
<html>
<form action="register.php" method="POST" >
<h1>
Sign up
</h1>
<table>
<tr>
	<td>Name:</td>
	<td><input type="text" name="username" id="username"  /></td><br />
</tr>

<tr>
	<td>email:</td>
	<td><input type="text" name="useremail" id="useremail"  /><br /></td></tr>

<tr>
		<td>Gender:</td>
		<td>Male<input type="radio" name="gender" id="gender"  />
			Female<input type="radio" name="gender" id="gender"  /><br /></td></tr>

<tr>
		<td>Birthday:</td>
		<td><select name="mon" id="mon">

			<option value="january">january</option>
			<option value="february">february</option>
			<option value="march">march</option>
			<option value="april">april</option>
			<option value="may">may</option>
			<option value="june">june</option>
			<option value="july">july</option>
			<option value="august">august</option>
			<option value="september">september</option>
			<option value="october">october</option>
			<option value="november">november</option>
			<option value="december">december</option>

			</select >
<select name="dd" id="dd">

<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>

</select>
<select name="yyyy" id="yyyy">

<option value="1980">1980</option>
<option value="1981">1981</option>
<option value="1982">1982</option>
<option value="1983">1983</option>


</select><br /></td></tr>

<tr>
		<td>Password:</td>
		<td><input type="password" name="password1" id="password1"/><br /></td>

		</tr>

<tr>
		<td>Re-enter Password:</td>
		<td><input type="password" name="password2" id="password2" /><br />
		</td></tr>

<tr><td><input type="submit" value="Register" name="signin" onclick=""/><br /></td></tr>
</table>
</form>
</html>
<?php
define('DB_NAME','userdata');
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
$Name=$_POST['username'];
$E_mail=$_POST['useremail'];
$sex=$_POST['gender'];
$month=$_POST['mon'];
$day=$_POST['dd'];
$year=$_POST['yyyy'];
$birthday=$day.'-'.$month.'-'.$year;
$password=$_POST['password1'];
$sql2="insert into userdetails(name,username,gender,birthday,password) values('$Name','$E_mail','$sex','$birthday','$password')";

$sql=mysql_query("select * from login where username='".$Name."'");
$norows=mysql_num_rows($sql);
if($norows==0)
{
	$result1=mysql_query("insert into login(username,password) values('$E_mail','$password')");
	$result2=mysql_query("insert into userdetails(name,username,gender,birthday,password) values('$Name','$E_mail','$sex','$birthday','$password')");

	echo 'account created successfully';
	
}
else if($norows==1)
{
	echo 'account already exists';
}



if(!mysql_query($result1))
{
	die('error:'.mysql_error());
}
if(!mysql_query($result2))
{
	die('error:'.mysql_error());
}
}
mysql_close();

?>
