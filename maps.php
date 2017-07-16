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