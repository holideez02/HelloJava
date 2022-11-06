//bookList.js

document.addEventListener('DOMContentLoaded', domLoadedFunc);

function domLoadedFunc() {

    fetch('./BookListServlet')
        .then(result => result.json())
        .then(showList)
        .catch(error => console.error(error));

    //head
    function showList(result) {
        //타이틀 생성
        makeHead();
        //리스트 출력
        makeList(result);
    };

    function makeHead() { //타이틀 만들기
        let thead = document.getElementById('title');
        let tr = document.createElement('tr');
        let thTag = document.createElement('th');
        let checkbox = document.createElement('input');
        checkbox.setAttribute('type', 'checkbox');
        thTag.append(checkbox);
        tr.appendChild(thTag);
        thead.appendChild(tr);

        checkbox.addEventListener('change', function () {
            document.querySelectorAll('#list input[type="checkbox"]').forEach(function (check) {
                check.checked = checkbox.checked;
            });
        });
        let titles = ['도서코드', '도서명', '저자', '출판사', '가격', '삭제'];
        for (let title of titles) {
            let thTag = document.createElement('th');
            let idTxt = document.createTextNode(title);
            thTag.appendChild(idTxt);
            tr.appendChild(thTag);
        }

    }

    function makeList(ary = []) { //목록 출력

        let tbody = document.getElementById('list');
        let fields = ['bookCode', 'bookName', 'author', 'press', 'price'];
        for (let obj of ary) {
            let tr = makeTr(obj);
            tbody.appendChild(tr);
        }

        function makeTr(row = {}) { //tr생성
            let tr = document.createElement('tr');
            tr.setAttribute('id', row.bookCode);
            //체크박스 먼저 생성
            let td = document.createElement('td');
            td.style.textAlign = 'center';
            let check = document.createElement('input');
            check.addEventListener('change', function () {
                console.log(this.checked);
            })
            check.setAttribute('type', 'checkbox');
            td.append(check);
            tr.append(td);

            //db의 데이터들 생성
            for (let field of fields) {
                let td = document.createElement('td');
                let txt = document.createTextNode(row[field]);
                td.append(txt);
                tr.append(td);
                tbody.append(tr);
            }
            //삭제버튼
            let btn = document.createElement('button');
            btn.addEventListener('click', delFunc);
            td = document.createElement('td')
            let txt = document.createTextNode('삭제');
            btn.setAttribute('id', 'delete');
            btn.appendChild(txt);
            td.appendChild(btn);
            tr.appendChild(td);

            return tr;
        }
        //////////////////////////추가//////////////////////////
        document.querySelector('button[type=button]').addEventListener('click', addFunc);

        function addFunc() { //데이터 추가
            let bc = document.getElementById('bookCode').value;
            let bn = document.getElementById('bookName').value;
            let au = document.getElementById('author').value;
            let pr = document.getElementById('press').value;
            let price = document.getElementById('price').value;
            let check = bc && bn && au && pr && price;
            if (!check) {
                alert('필수항목입니다.')
                return false;
            }

            let data = 'bookCode=' + bc + '&bookName=' + bn + '&author=' + au + '&press=' + pr + '&price=' + price;

            fetch('./BookAddServlet', {
                    method: 'post',
                    headers: {
                        'Content-type': 'application/x-www-form-urlencoded'
                    },
                    body: data
                })
                .then(result => result.json())
                .then(addCallback)
                .catch(error => console.error(error));

            return false;
        }

        function addCallback(result) {
            document.querySelector('#list').append(makeTr(result));

            //화면 입력 초기화
            document.getElementById('bookCode').value = '';
            document.getElementById('bookName').value = '';
            document.getElementById('author').value = '';
            document.getElementById('press').value = '';
            document.getElementById('price').value = '';
        }

        //////////////////////////삭제//////////////////////////
        document.getElementById('delete').addEventListener('click', delFunc);

        function delFunc() {
            console.log('삭제실행');
            let bookid = this.parentElement.parentElement.getAttribute('id');
            console.log(bookid);

            let delAjax = new XMLHttpRequest();
            delAjax.open('post', './BookDelServlet');
            delAjax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            delAjax.send('bookCode=' + bookid);
            delAjax.onload = function () {
                let result = delAjax.responseText;
                if (result == 'success') {
                    document.getElementById(bookid).remove();
                } else if (result == 'fail') {
                    alert('실패!');
                }
            }

        }

        ////////////////////////선택삭제//////////////////////////////
        document.getElementById('checkDel').addEventListener('click', deleteCheckedFunc);

        function deleteCheckedFunc() {
            let trs = document.querySelectorAll('#list>tr');

            for (let i = 0; i < trs.length; i++) {
                if (trs[i].children[0].firstElementChild.checked) {
               let bookId = trs[i].getAttribute('id');
                    let delAjax = new XMLHttpRequest();
                    delAjax.open('post', './BookDelServlet');
                    delAjax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                    delAjax.send('bookCode=' + bookId);
                    delAjax.onload = function () {
                        let result = delAjax.responseText;
                        if (result == 'success') {
                            alert('삭제 완료')
                            trs[i].remove();
                        } else if (result == 'fail') {
                            alert('실패');
                        }
                    }

                }
            }
        }
    }
} //end of domLoadedFunc