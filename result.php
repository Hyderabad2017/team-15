<?php
//session_start();
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
//$Name=$_SESSION['sess_user'];
$BB=$_POST['BB'];
//$dt=$_POST['dt'];
//echo $Name;
echo $BB;
//echo $dt;
$result=mysql_query("select * from user where bgroup='$BB'",$link);
echo 'request submitted successfully';
echo "<table border='1px'>";
echo mysql_num_rows($result);
if (mysql_num_rows($result) > 0) {
    // output data of each row
    while($row = mysql_fetch_assoc($result)) {
        echo "<tr><td>id: " . $row["phn"]. " </td><td>Name: " . $row["uname"]. "</td><td> " . $row["fname"]. "</td></tr><br>";
    }
}else {
    echo "0 results";
}
}
    
echo "</table>";
?>