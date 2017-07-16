<?php
require 'DB_Connect.php';
$email=$_POST["email"];
$pwd=$_POST["pwd"];
$x="Yes";

$query="UPDATE  temprec SET Status='$x' ,Active='$x' ,pwd='$pwd' WHERE email='$email' ";
$result=mysqli_query($conn, $query) or die("Error" .mysqli_error($conn));
?>