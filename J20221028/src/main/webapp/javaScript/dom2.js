// dom2.js

document.addEventListener('DOMContentLoaded', domLoadedFunc); //document에 이벤트 등록. domLoadedFunc 함수 실행 index.html의 document

function domLoadedFunc() {
	let data = `[{"id":1,"first_name":"Alaine","last_name":"Bruhn","email":"abruhn0@bloglines.com","gender":"Female","salary":5674},
				 {"id":2,"first_name":"Romy","last_name":"Ludl","email":"rludl1@reddit.com","gender":"Female","salary":6532},
				 {"id":3,"first_name":"Wilbur","last_name":"Windridge","email":"wwindridge2@oakley.com","gender":"Male","salary":6212},
				 {"id":4,"first_name":"Leonidas","last_name":"Dutchburn","email":"ldutchburn3@twitter.com","gender":"Male","salary":8560}
			]`;
	let obj = {}  //자바스크립트의 obj형태로 만들거야
	let result = JSON.parse(data); //json형태의 데이터를 자바스크립트의 object로 변경. 문자열이지만 parsing작업으로 가능하게 됨
	console.log(result); //데이터를 주고 받기가 정말 편함.

	console.log(result[0].first_name);//첫번째 데이터의 first_name 찾기
	console.log(result[1].email); //두번째 데이터의 email
	for (let i = 0; i < result.length; i++) {
		console.log(`firstName: ${result[i].first_name}, lastName: ${result[i]['last_name']}`);
	}
	//확장 for문. 
	for (let obj of result) { //배열의 갯수만큼 반복하겠습니다
		console.log(`id: ${obj.id}, email: ${obj['email']}`) //obj가 객체니까.
	}

	console.clear(); //위에 것 다 지우기 

	//배열일 경우에는 배열객체 Array.forEach()메소드 이용.. 잘 쓰는편이니 기억해두기.
	//result는 배열. 함수의 매개값을 받는 메소드 forEach. 어떤 기능을 배열에 들어있는 갯수만큼 반복
	result.forEach(function(value, index) {
		//if(value.salary > 5000) //salary가 5000넘는사람!
		if (index < 2) //index가 2보다 작은사람! 이렇게 조건으로도 줄 수 있다.. 신기하지?
			console.log(value, index);
	});

	//확장 for.
	//table
	let table = document.createElement('table');
	//	table.setAttribute('border', '1');
	let show = document.getElementById('show')
	show.appendChild(table);
	//thead
	let thead = document.createElement('thead');
	let tr = document.createElement('tr');
	let titles = ['아이디', '이름', '이메일', '성별', '급여', '삭제'];
	for (let title of titles) {
		let idTag = document.createElement('th');
		let idTxt = document.createTextNode(title); //
		idTag.appendChild(idTxt);
		tr.appendChild(idTag);
	}
	let idTag = document.createElement('th');
	let checkbox = document.createElement('input')
	checkbox.setAttribute('type', 'checkbox');
	checkbox.addEventListener('change', function() {
		// >는 자식, 공백은 하위.. #show>table>tbody>tr>td>input도 되지만 ~ 귀찮으니.. 여기 경로 타고가서 type이 checkbox인 애들 가져올게요
		document.querySelectorAll('#show input[type="checkbox"]').forEach(function(check) { //cks에 담겨져있는 모든 요소에 대해서 함수를 실행해요. function(값, 인덱스, 배열자체) 순서 완전중요. 
			check.checked = checkbox.checked; //cks는 부하들. checkbox는 대장님. 대장이 체크하면 부하들도 체크해
		});
	});
	idTag.appendChild(checkbox);
	tr.appendChild(idTag);
	thead.appendChild(tr);

	table.appendChild(thead);

	//tbody
	let tbody = document.createElement('tbody');
	table.appendChild(tbody);
	let fields = ['id', 'first_name', 'email', 'gender', 'salary'];
	for (let obj of result) {
		let tr = makeTr(obj);
		tbody.appendChild(tr);
	} //end of for(let obj of result) 데이터 건수만큼 반복..

	//////////////////////////////event//////////////////////////////////
	//추가버튼에 이벤트 등록. button의 선택자를 불러와야함
	document.querySelector('button[type=button]').addEventListener('click', addFunc);

	//수정 버튼에 이벤트 등록. (인덱스 1번째!) . 버튼에 id부여 해도 되지만 이렇게도 된다. 선택자를 통해서 갖고오기!
	document.querySelectorAll('button[type=button]')[1].addEventListener('click', updateFunc);

	//선택 삭제 버튼에 이벤트 등록.
	document.querySelectorAll('button[type=button]')[2].addEventListener('click', deleteCheckedFunc);
	///////////////////////////function/////////////////////////////////
	function addFunc() {
		let id = document.getElementById('id').value;
		let fn = document.getElementById('fname').value;
		let em = document.getElementById('email').value;
		let sa = document.getElementById('salary').value;
		let gn = document.getElementById('gender').value;
		// 입력사항 빠진거 없는지 체크.
		let check = id && fn && em && sa && gn;
		if (!check) {
			alert('입력항목 확인');
			return;
		}

		let newRow = {
			id: id,
			first_name: fn,
			email: em,
			salary: sa,
			gender: gn
		}
		document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));
	} //end of addFunc()

	function updateFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr'); //이 경로의 모든 tr가져옴
		let id = document.getElementById('id').value;
		console.log(id, trs[0].children[0].textContent) // 밑에 if문 쓰기전에 값 맞는지 확인해보고..
		for (let i = 0; i < trs.length; i++) {
			//	console.log(trs[i].children[0].textContent) //id값만 쏙 다 가져옴!
			if (trs[i].children[0].textContent == id) { //이 조건에 맞는 값이면
				trs[i].children[4].textContent = document.getElementById('salary').value; //데이터에 있는 값(화면) = 새로입력한 값으로 salary의 값이 바귐
				trs[i].children[3].textContent = document.getElementById('gender').value;
				trs[i].children[2].textContent = document.getElementById('email').value;
				trs[i].children[1].textContent = document.getElementById('fname').value;
			}
		}
	} //end of updateFunc()

	function deleteCheckedFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		for (let i = 0; i < trs.length; i++) {
			if (trs[i].children[6].firstElementChild.checked) {
				trs[i].remove();
			}
		}
	} //end of deleteCheckedFunc()

	function showDetailFunc() {//마우스 갖다대면 값이 입력창으로 들어가게 된다
		//		console.log(this.firstElementChild); //(this)tr을 기준으로 첫번째자식인 td를 호출
		//		console.log(this.lastElementChild); //(this)tr을 기준으로 마지막자식인 button를 호출
		//		console.log(this.children[1]); //대신 second, third같은게 없지만 인덱스값으로도 접근가능. 
		//		console.log(this.children[1].textContent); //값을 가지고 오는 것. 
		document.getElementById('id').value = this.children[0].textContent;
		document.getElementById('fname').value = this.children[1].textContent;
		document.getElementById('email').value = this.children[2].textContent;
		document.getElementById('gender').value = this.children[3].textContent;
		document.getElementById('salary').value = this.children[4].textContent;
	} //end of showDetailFunc()

	function makeTr(row) { //값을 받으면 
		// 데이터 건수만큼 반복.
		let tr = document.createElement('tr');
		tr.addEventListener('mouseover', function() {
			this.style.backgroundColor = '#CAF2FA';
		}); //마우스 올리면 색깔 바뀜
		tr.addEventListener('click', showDetailFunc); //클릭하면 정보가 입력창에 뜸
		tr.addEventListener('mouseout', function() {//마우스 내리면 색깔돌아옴
			this.style.backgroundColor = null;
		})

		for (let field of fields) {
			// 보여지는 항목만큼 반복.
			let td = document.createElement('td');
			let txt = document.createTextNode(row[field]); //obj의 field는 각각의 요소들을 가지고 옴
			td.appendChild(txt);
			tr.appendChild(td);
		}
		//삭제버튼. <td><button>삭제</button></td>
		let td = document.createElement('td')
		let btn = document.createElement('button');
		btn.addEventListener('click', function() { //클릭하면 삭제되는 기능
			this.parentElement.parentElement.remove(); //버튼의 부모요소를 찾아와서 삭제. btn->td->tr까지 같이!
		});
		let txt = document.createTextNode('삭제');
		td.appendChild(btn);
		btn.appendChild(txt);
		tr.appendChild(td);

		//체크박스.
		td = document.createElement('td');
		td.style.textAlign = 'center';
		let check = document.createElement('input');
		check.addEventListener('change', function() {
			console.log(this.checked); //체크가 되었는지 안되었는지. true/false 반환
		})
		check.setAttribute('type', 'checkbox');
		td.appendChild(check);
		tr.appendChild(td);

		return tr; //반환해서 함수 부른곳에서 쓸 수 있게끔!
	} // end of makeTr()

} //end of domLoadedFunc()