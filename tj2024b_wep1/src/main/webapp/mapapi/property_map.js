let map;
let markers = [];
let currentInfoWindow = null;

// 지도 초기화
function initMap() {
    const container = document.getElementById('map');
    const options = {
        center: new kakao.maps.LatLng(37.5665, 126.9780), // 서울 중심 좌표
        level: 3
    };
    
    map = new kakao.maps.Map(container, options);
    
    // 지도 로드 후 매물 데이터 가져오기
    loadProperties();
}

// 매물 데이터 가져오기
function loadProperties() {
    fetch('PropertyServlet')
        .then(response => response.json())
        .then(data => {
            data.forEach(property => {
                addMarker(property);
            });
        })
        .catch(error => {
            console.error('데이터 로드 중 오류 발생:', error);
        });
}

// 마커 추가
function addMarker(property) {
    const position = new kakao.maps.LatLng(property.lat, property.lng);
    
    const marker = new kakao.maps.Marker({
        position: position,
        map: map
    });
    
    markers.push(marker);
    
    // 마커 클릭 이벤트
    kakao.maps.event.addListener(marker, 'click', function() {
        showPropertyInfo(property);
    });
}

// 매물 정보 표시
function showPropertyInfo(property) {
    const propertyInfo = document.getElementById('propertyInfo');
    
    // 정보 업데이트
    document.getElementById('propertyTitle').textContent = property.title;
    document.getElementById('propertyPrice').textContent = 
        property.price.toLocaleString() + '원';
    document.getElementById('propertyAddress').textContent = property.address;
    document.getElementById('propertySize').textContent = 
        property.squareFeet + '㎡';
    document.getElementById('propertyType').textContent = property.propertyType;
    
    // 정보창 표시
    propertyInfo.style.display = 'block';
}

// 정보창 닫기
function closePropertyInfo() {
    document.getElementById('propertyInfo').style.display = 'none';
}

// 지도 검색 범위 내 매물 가져오기
function getPropertiesInBounds() {
    const bounds = map.getBounds();
    const sw = bounds.getSouthWest();
    const ne = bounds.getNorthEast();
    
    const data = {
        minLat: sw.getLat(),
        maxLat: ne.getLat(),
        minLng: sw.getLng(),
        maxLng: ne.getLng()
    };
    
    // POST 요청으로 범위 내 매물 요청
    fetch('PropertyServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(properties => {
        // 기존 마커 제거
        markers.forEach(marker => marker.setMap(null));
        markers = [];
        
        // 새 마커 추가
        properties.forEach(property => {
            addMarker(property);
        });
    })
    .catch(error => {
        console.error('검색 중 오류 발생:', error);
    });
}

// 지도 이동 완료 이벤트
kakao.maps.event.addListener(map, 'idle', function() {
    getPropertiesInBounds();
});

// 페이지 로드 시 지도 초기화
window.onload = initMap;