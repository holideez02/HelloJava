//covid.js

window.onload = function () { //html에 있던것들 밑에 다 로딩되고 실행

    //request url.
    let url =
        'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=A2Q3Qa6jsRDId6bk6WoIyUY8ZLmM6QmcpgwPOkNnPgyxzbXJVnBVUtonQp5Fdr7DdXuT2J62GXyiQxy8twDfiA%3D%3D';

    fetch(url)
        .then(result => result.json()) //json->object 
        .then(showList)
        .catch(error => console.log(error));
    document.querySelector('#findBtn').addEventListener('click', findCenterList);
}
let titles = {
    id: '센터아이디',
    centerName: '이름',
    phoneNumber: '연락처',
    lat:'위도',
    lng:'경도',
    facilityName: '장소'
};
let data;

function showList(result) {
    //타이틀 생성
    makeHead();

    //body(데이터) 영역 생성.
    console.log(result);
    data = result.data;

    //option 태그 생성.
    makeOption(data); //data의 값을 넘겨줌

    let selectedCity = data.filter(center => center.sido == '서울특별시');
    makeList(selectedCity); //서울 특별시에 대한 데이터만 쭉뜬다. 

}

//옵션태그 생성
function makeOption(ary = []) {
    //select 태그 생성.
    let sidoAry = []; // ['서울특별시', '대전광역시', ].. 단, 중복된 값이 있으면 안된다.
    ary.forEach(center => { //배열의 건수만큼 돌겠습니다..
        //data에 있는 센터 정보와 sidoAry에 있는 센터 정보를 비교.
        //sidoAry에 값이 있으면 건너띄고, sidoAry에 값이 없으면 추가. 
        if (sidoAry.indexOf(center.sido) == -1) { //없으면
            sidoAry.push(center.sido);
        }
    });
    let cityList = document.getElementById('city');
    sidoAry.forEach(sido => { //옵션, 태그, value. city에 append하기.
        let option = document.createElement('option');
        option.value = sido;
        option.textContent = sido;
        cityList.append(option)
    });
}

function findCenterList() {
    let searchKey = document.querySelector('#city').value;
    let searchAry = data.filter(center => center.sido == searchKey);
    makeList(searchAry);
}

//리스트 출력 함수
function makeList(ary = []) { //배열타입의 매개값이 들어와야함.
    //값이 있으면()=화면에 tr이 있으면) tr 삭제.리스트 밑에 tr들을 다 가지고와서 한건(tr)씩 다 삭제!! 
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove())
    let list = document.getElementById('list');
    ary.forEach(center => {
        list.append(makeTr(center));
    }); //데이터 건수만큼 반복.

    //화면에서 순번 출력
    document.querySelectorAll('#list>tr').forEach((tr,idx) => {
        let td = document.createElement('td');
        td.textContent = idx + 1;
        tr.prepend(td); // append(): 마지막 위치에 추가. prepend() : 처음 위치에 추가
    })
}

//데이터 영역 생성 함수.
function makeTr(row = {}) { //값이 하나 넘어오면 실행. row ={}
    let tr = document.createElement('tr');
    tr.setAttribute('lng',row.lng );
    tr.setAttribute('lat', row.lat);
    tr.setAttribute('facilityName', row.facilityName);
    tr.addEventListener('click', openInfoWindow);
    //td생성.
    for (let field in titles) {
        let td = document.createElement('td');
        let txt = document.createTextNode(row[field]); //row가 가지고 있는 값과 field가 가지고 있는 값의 조합
        td.appendChild(txt);
        tr.appendChild(td);

    }
    return tr;
}

function openInfoWindow(e){
    console.log(e.target.parentElement) //이벤트를 받는 속성. tr lng, lat
    let lng = e.target.parentElement.getAttribute('lng');
    let lat = e.target.parentElement.getAttribute('lat');
    let facilityName = e.target.parentElement.getAttribute('facilityName');

    window.location.href = 'infoWindow.html?x=' + lng + '&y=' + lat + '&facilityName=' + facilityName; //내가 원하는 url로 이동
}

// 타이틀 생성 함수.
function makeHead() {
    //titles라는 오브젝트를 활용해서 출력해보기
    let tr = document.createElement('tr'); //타이틀 다음 붙일거
    let th = document.createElement('th');
    th.textContent = '순번';
    tr.appendChild(th);
    for (let title in titles) {
        let th = document.createElement('th');
        let txt = document.createTextNode(titles[title]); // titles를 돌면서 속성하나씩 붙임.
        th.appendChild(txt);
        tr.appendChild(th);
    }
    document.getElementById('title').append(tr);
}