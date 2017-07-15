<!DOCTYPE html>
<html>
  <head>
    <style>
      #map {
        height: 400px;
        width: 100%;
       }
    </style>
  </head>
  <body>
    <h3>My Google Maps Demo</h3>
    <div id="map"></div>
    <script>
      function initMap() {
	/*	<?php

//header("Location:userhome.php");
define('DB_NAME','halloffame');
define('DB_USER','root');
define('DB_PASSWORD','');
define('DB_HOST','localhost');

$link=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD);
echo 'entered';

if(!$link)
{
	die('could not connect:'.mysql_error());
}
$db_selected=mysql_select_db(DB_NAME,$link);
if(!$db_selected)
{
	die('can\'t use'.DB_NAME.':'.mysql_error());
}

/*if ($_SERVER["REQUEST_METHOD"] == "POST") {
$username=$_POST['user'];
$date=$_POST['dt'];*/
//$BB=$_POST['BB'];
//echo $availability;
//echo $required;
//$result=mysql_query("select location from users where bloodgroup='$BB'",$link);
//$norows=mysql_num_rows($result);
//		?>  */
        var hyd = {lat: 17.3850,lng:78.4867};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: hyd
        });
        var marker = new google.maps.Marker({
          position: hyd,
          map: map
        });
      }
	  
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyATzgMpq4NUq0Y89yytAMKg6xmVQ9fcWF4&callback=initMap">
    </script>
  </body>
</html>