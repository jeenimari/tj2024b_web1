<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>카카오맵 테스트</title>
    <style>
        #map {
            width: 500px;
            height: 500px;
            margin: 20px;
            border: 1px solid #ccc;
        }
    </style>
</head>
<body>
    <h1>카카오맵 테스트</h1>
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7be15cee355c36d1e316e018bafe0fc6"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.55805, 126.92619), // 지도의 중심좌표
        level: 2, // 지도의 확대 레벨
        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
    }; 

// 지도를 생성한다 
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 지도 중심 좌표 변화 이벤트를 등록한다
kakao.maps.event.addListener(map, 'center_changed', function () {
	console.log('지도의 중심 좌표는 ' + map.getCenter().toString() +' 입니다.');
});

// 지도 클릭 이벤트를 등록한다 (좌클릭 : click, 우클릭 : rightclick, 더블클릭 : dblclick)
kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
	console.log('지도에서 클릭한 위치의 좌표는 ' + mouseEvent.latLng.toString() + ' 입니다.');
});	
		
	</script>
</body>
</html>