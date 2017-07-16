<?php
 require_once 'DB_Connect.php';
 session_start();
 // $name=$_POST['name'];
 // $password=$_POST['password'];
 $result=mysqli_query($conn,'SELECT * FROM test where name="ranjith" and password="ranjith"');
 	if($result)
 	{

 	if(mysqli_num_rows($result)==1)
 		 {
           $_SESSION['name']="ranjith";
           header('Location:welcome.php');
}
}
else
	echo "ïnvalid credentials";
?>