<?php
require 'DB_Connect.php';
$name=$_POST["UserName"];
$email=$_POST["UserEmail"];
$password=md5($_POST["UserPassword"]);

$query="INSERT INTO rec_reg(UserName,UserEmail,UserPassword)VALUES('$name','$email','$password')";
$result=mysqli_query($conn, $query) or die("Error" .mysqli_error($conn));




?>