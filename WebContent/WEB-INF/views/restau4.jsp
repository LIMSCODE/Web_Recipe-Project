
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<div id="map" style="width: 100%; height: 350px;"></div>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5547f6be229990d33003b21ff84d57d4&libraries=services"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 7 // 지도의 확대 레벨
    };
    
// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 

var addr = new Array();

var positions = ${list2};

       //지오코더객체 생성
      var geocoder = new kakao.maps.services.Geocoder();

      // 주소로 좌표를 검색합니다
      //geocoder.addressSearch('서울시 사당로 23길 112', function(result, status) {

         
         
         for(var i =0 ; i<positions.length; i++) {
            geocoder.addressSearch(positions[i].address, function(result, status, data){
               if (status === daum.maps.services.Status.OK) {
                  var coords = new kakao.maps.LatLng(result[0].y, result[0].x); 
                  
                  
                  var marker= new kakao.maps.Marker({ map:map, position:coords }); 
                  
                  // 마커를 지도에 표시합니다. 
                  marker.setMap(map);
                   // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                    map.setCenter(coords);                
               }   
               }); //geocorder.adressSearch
         
          }



</script>



