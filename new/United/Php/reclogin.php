<?php
require 'DB_Connect.php';
$email=$_POST["email"];
$password=$_POST["pwd"];
$query="SELECT email,pwd from temprec where email='$email' and pwd='$password'";
$result=mysqli_query($conn, $query) or die("Error" .mysqli_error($conn));
if(mysqli_num_rows($result)==1){
$response["error"]=FALSE;
}
else
{
$response["error"]=$password;

}
echo json_encode($response);
?>