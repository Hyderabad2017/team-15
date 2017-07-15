<?php
require 'DB_Connect.php';
$name=$_POST["Name"];
$email=$_POST["Email"];
$password=md5($_POST["Password"]);
$age=$_POST["Age"];
$bgroup=$_POST["Bgroup"];
$phone=$_POST["Mobile"];
$gender=$_POST["Gender"];
$city=$_POST["City"];
$area=$_POST["Area"];
$Weight=$_POST["Weight"];
$query="INSERT INTO donor(Name,Email,Password,Age,Bgroup,Mobile,Gender,City,Area,Weight)VALUES('$name','$email','$password','$age','$bgroup','$phone','$gender','$city','$area','$Weight')";
$result=mysqli_query($conn, $query) or die("Error" .mysqli_error($conn));




?>