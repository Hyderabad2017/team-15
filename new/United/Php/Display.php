<?php
require 'DB_Connect.php';
$city=$_POST["City"];
$bgroup=$_POST["Bgroup"];
$area=$_POST["Area"];
$rquery="SELECT Name,Mobile,Gender,state from donor where City='$city' and Bgroup='$bgroup' and Area='$area'";
$rows=array();
$result2=mysqli_query($conn,$rquery) or die("Error" .mysqli_error($conn));
 if(mysqli_num_rows($result2)>0) 
 {
while($row=$result2->fetch_assoc())
{

 $rows[]= $row;

}
$roows["Display"]=$rows;
$roows["error"]=FALSE;
}
else
{

    $roows["error"]=TRUE;
}
echo json_encode($roows);

?>