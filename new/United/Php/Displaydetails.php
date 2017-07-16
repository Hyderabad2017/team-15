<?php
require 'DB_Connect.php';
$name=$_POST["Name"];
$phone=$_POST["Mobile"];
$gender=$_POST["Gender"];
$rquery="SELECT Age,Email from donor where Name='$name'and Mobile='$phone'and Gender='$gender'";
$rows=array();
$result2=mysqli_query($conn, $rquery) or die("Error" .mysqli_error($conn));
 if(mysqli_num_rows($result2)>0)
 {
while($row=$result2->fetch_assoc())
{

 $rows[]= $row;

}
$roows["Details"]=$rows;
$roows["error"]=FALSE;
}
else
{

	$roows["error"]=TRUE;
}
echo json_encode($roows);

?>