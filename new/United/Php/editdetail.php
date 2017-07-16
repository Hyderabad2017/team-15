<?php
require 'DB_Connect.php';
$age=$_POST["Age"];
$mobile=$_POST["Phone"];
$mail=$_POST["Email"];
$rquery="UPDATE donor set Age='$age',Mobile='$mobile'where Email='$mail'";
$result2=mysqli_query($conn,$rquery) or die("Error" .mysqli_error($conn));

?>