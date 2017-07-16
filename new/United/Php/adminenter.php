<?php
require 'DB_Connect.php';
$name=$_POST["name"];
$rquery="SELECT email,reg from  temprec where name= '$name'";
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