<?php
require 'DB_Connect.php';
$name=$_POST["Name"];
$pass=md5($_POST["Password"]);
$query="INSERT INTO entry(User,Password)VALUES('$name','$pass')";
$result=mysqli_query($conn, $query) or die("Error" .mysqli_error($conn));
//echo json_encode($name);
$rows=array();
 $rquery="SELECT * from entry";
 $result2=mysqli_query($conn, $rquery) or die("Error" .mysqli_error($conn));
 //$roows[]=array();
 if(mysqli_num_rows($result2)>0)
 {
while($row=$result2->fetch_assoc())
{
 // $name=$row[0];
 // $pass=$row[1];
 // $response["User"] = $name;
 // $response["Password"] = $pass;
 // $response["errorr"]=FALSE;
//echo $response; 

//$rows[]= array('data' => $row);
$rows[]= $row;//adodiley

//$rows["error"]=TRUE;//ehe error aha problem
//$list[]=$rows;

}
$roows["Details"]=$rows;

//echo json_encode($rows["error"]);
}
else
{

	$roows["error"]=TRUE;
}
$roows["error"]=FALSE;
//ila chesthe annitiki false ehe ga
echo json_encode($roows);
?>