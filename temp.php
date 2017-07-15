<?php
require 'DB_Connect.php';
$name=$_POST["name"];
$email=$_POST["email"];
$reg=$_POST["reg"];
$query="INSERT INTO temprec (name,email,reg)VALUES('$name','$email','$reg')";
$result=mysqli_query($conn, $query) or die("Error" .mysqli_error($conn));
?>