<?php
require 'DB_Connect.php';
$name=$_POST["name"];
$email=$_POST["email"];
$reg=$_POST["reg"];
$active=$_POST["Active"];
$status=$_POST["Status"];
$pwd=$_POST["pwd"];

$query="INSERT INTO temprec(name,email,reg,Active,Status,pwd)VALUES('$name','$email','$reg','$active','$status','$pwd')";
$result=mysqli_query($conn, $query) or die("Error" .mysqli_error($conn));
?>