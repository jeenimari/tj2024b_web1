const waitingWrite=()=>{
	let phoneInput = document.querySelector('.phoneInput');
	let pnoInput = document.querySelector('.pnoInput');
	
	//객체화시키기
	
	let data = {
		phone : phoneInput.value,
		pno: parseInt(pnoInput.value)
	};
	
	// 패치통신
	fetch(`/tj2024b_wep1/day03/waiting2`,{
		method : 'POST',
		headers: {'Content-Type' : 'application/json'},
		body : JSON.stringify(data)
	})
	.then(r=>r.json())
	.then(result =>{
		if(result){
			alert('대기등록 성공')
			phoneInput.value =' ';
			pnoInput.value= ' ';
			waitingFindAll();
			
		}
		else{alert('대기등록실패');}
	})
}// fend

// 2. 대기 명단 전체 조회 함수
function waitingFindAll(){
    fetch(`/tj2024b_wep1/day03/waiting2`)
    .then(r => r.json())
    .then(list => {
        // 1. HTML 구성
        let html = '';
        list.forEach(waiting => {
            html += `
                <tr>
                    <td>${waiting.wno}</td>
                    <td>${waiting.phone}</td>
                    <td>${waiting.pno}</td>
                    <td>
                        <button onclick="updatePno(${waiting.wno},'${waiting.phone}')">인원수 수정</button>
                        <button onclick="waitingDelete(${waiting.wno})">삭제</button>
                    </td>
                </tr>`;
        });
        // 2. HTML 출력
        document.querySelector('tbody').innerHTML = html;
    });
}

// 3. 대기 명단 수정 함수
function updatePno(wno,cphone){
    // 1. 수정할 인원수 입력받기
    let newPno = prompt('수정할 인원수를 입력하세요');
    if(!newPno){ return; } // 취소 눌렀을 때
    
    // 2. 수정할 정보 객체화
    let data = {
      
		wno: wno,
        pno: parseInt(newPno),
		phone : cphone
		
    };
    
    // 3. 통신
    fetch(`/tj2024b_wep1/day03/waiting2`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    .then(r => r.json())
    .then(result => {
        if(result){
            alert('수정 성공');
            waitingFindAll();
        }
        else{ alert('수정 실패'); }
    });
}

// 4. 대기 명단 삭제 함수
function waitingDelete(wno){
    fetch(`/tj2024b_wep1/day03/waiting2?wno=${wno}`, { method: 'DELETE' })
    .then(r => r.json())
    .then(result => {
        if(result){
            alert('삭제 성공');
            waitingFindAll();
        }
        else{ alert('삭제 실패'); }
    });
}

// 페이지 로드시 대기 명단 출력
waitingFindAll();