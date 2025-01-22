// API URL 설정
const BOARD_API_URL = '/day05/board';

// 페이지 로드 시 실행
document.addEventListener('DOMContentLoaded', () => {
    loadBoardList();  // 게시물 목록 로드
    document.getElementById('writeForm').addEventListener('submit', handleWrite);
});

// 게시물 목록 로드
async function loadBoardList() {
    try {
        const response = await fetch(BOARD_API_URL);
        const boards = await response.json();
        
        const boardList = document.getElementById('boardList');
        boardList.innerHTML = '';
        
        boards.forEach(board => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${board.bno}</td>
                <td onclick="viewBoard(${board.bno})" style="cursor:pointer">${board.btitle}</td>
                <td>${board.bwriter}</td>
                <td>${new Date(board.bdate).toLocaleString()}</td>
                <td>${board.bview}</td>
            `;
            boardList.appendChild(tr);
        });
    } catch (error) {
        console.error('Error:', error);
        alert('게시물 목록 로드 실패');
    }
}

// 게시물 등록
async function handleWrite(event) {
    event.preventDefault();
    
    const formData = new FormData(event.target);
    const data = {
        btitle: formData.get('btitle'),
        bcontent: formData.get('bcontent'),
        bwriter: formData.get('bwriter'),
        bpwd: formData.get('bpwd')
    };
    
    try {
        const response = await fetch(BOARD_API_URL, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });
        const result = await response.json();
        
        if(result.success) {
            alert('게시물 등록 성공');
            event.target.reset();
            loadBoardList();
        } else {
            alert('게시물 등록 실패');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('게시물 등록 실패');
    }
}

// 게시물 조회
async function viewBoard(bno) {
    try {
        const response = await fetch(`${BOARD_API_URL}/${bno}`);
        const board = await response.json();
        
        const detail = `
            제목: ${board.btitle}
            작성자: ${board.bwriter}
            작성일: ${new Date(board.bdate).toLocaleString()}
            조회수: ${board.bview}
            내용: ${board.bcontent}
            
            수정하시려면 '수정', 삭제하시려면 '삭제'를 입력하세요.
        `;
        
        const action = prompt(detail, '');
        if(action === '수정') handleEdit(board.bno);
        else if(action === '삭제') handleDelete(board.bno);
        
    } catch (error) {
        console.error('Error:', error);
        alert('게시물 조회 실패');
    }
}

// 게시물 수정
async function handleEdit(bno) {
    const pwd = prompt('비밀번호를 입력하세요:');
    if(!pwd) return;
    
    const title = prompt('새로운 제목을 입력하세요:');
    const content = prompt('새로운 내용을 입력하세요:');
    if(!title || !content) return;
    
    try {
        const response = await fetch(`${BOARD_API_URL}/${bno}`, {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({
                btitle: title,
                bcontent: content,
                bpwd: pwd
            })
        });
        const result = await response.json();
        
        if(result.success) {
            alert('게시물 수정 성공');
            loadBoardList();
        } else {
            alert('게시물 수정 실패');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('게시물 수정 실패');
    }
}

// 게시물 삭제
async function handleDelete(bno) {
    const pwd = prompt('비밀번호를 입력하세요:');
    if(!pwd) return;
    
    try {
        const response = await fetch(`${BOARD_API_URL}/${bno}`, {
            method: 'DELETE',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({bpwd: pwd})
        });
        const result = await response.json();
        
        if(result.success) {
            alert('게시물 삭제 성공');
            loadBoardList();
        } else {
            alert('게시물 삭제 실패');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('게시물 삭제 실패');
    }
}