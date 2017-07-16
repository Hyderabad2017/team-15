<?php
require 'DB_Connect.php';
$city=$_POST["City"];
$bgroup=$_POST["Bgroup"];
$rquery="SELECT DISTINCT Area from donor where City='$city' and Bgroup='$bgroup'";
$rows=array();
$result2=mysqli_query($conn,$rquery) or die("Error" .mysqli_error($conn));
 if(mysqli_num_rows($result2)>0)
 {
while($row=$result2->fetch_assoc())
{

 $rows[]= $row;

}
$roows["Area"]=$rows;
$roows["error"]=FALSE;
}
else
{

    $roows["error"]=TRUE;
}
echo json_encode($roows);

?>