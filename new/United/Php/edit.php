<?php
require 'DB_Connect.php';
$State=$_POST["state"];
$mail=$_POST["Email"];
$rquery="UPDATE donor set state='$State' where Email='$mail'";
$result2=mysqli_query($conn,$rquery) or die("Error" .mysqli_error($conn));
 ?>