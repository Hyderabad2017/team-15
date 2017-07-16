<!DOCTYPE html>
<html>
<head>
<style>
body {
    background-color: white;
}

h1 {
    color: red;
    text-align: center;
}

p {
    font-family: verdana;
    font-size: 2vw;
}
table, th, td {
    border-collapse: collapse;
	font-size:1.4vw;
}
th, td {
    padding: 5px;
    text-align: left;    
}
button{
	padding:10px;
	width:20%;
	margin-top:3%;
	margin-left:40%;
	display:block;
	color:white;
	background-color:blue;
	
}
button:hover{
color:black;
background-color:green;
}
</style>
</head>
<body>

<h1>INVENTORY</h1>

<form action="recuserhome.php" method="POST">
<table style="width:100%;margin-left:10%;">
  <tr>
    <th>Blood group</th>
    <th>Availability</th>
  </tr>
  <tr>
    <td>O+</td>
    <td><input type="text" name="O+"></td>
  </tr>
    <tr>
    <td>O-</td>
    <td><input type="text" name="O-"></td>
  </tr>
    <tr>
    <td>A-</td>
    <td><input type="text" name="A-"></td>
   </tr>
    <tr>
    <td>A+</td>
    <td><input type="text" name="A+"></td>
   </tr>
    <tr>
    <td>B-</td>
    <td><input type="text" name="B-"></td>
    </tr>  
	<tr>
    <td>B+</td>
    <td><input type="text" name="B+"></td>
    </tr> 
	<tr>
    <td>AB-</td>
    <td><input type="text" name="AB-"></td>
    </tr>  
	<tr>
    <td>AB+</td>
    <td><input type="text" name="AB+"></td>
    </tr>  
	<tr>
    <td>O+</td>
    <td><input type="text" name="O+"></td>
    </tr>  
	<tr>
    <td>O-</td>
    <td><input type="text" name="O-"></td>
    </tr>  
</table> 
<button type="submit">SUBMIT</button>
</form>
</body> 
</html>