/**
 * object2.js
 */

document.addEventListener('DOMContentLoaded', function() {//이벤트이름, 이벤트가 발생하면 실행되는 함수
	// document.getElementById('show').innerHTML = '<p>Hello, World</p>';
	//콘텐츠를 다 읽고 난 다음에 실행. 
	let data = `[{"id":1,"first_name":"Alaine","last_name":"Bruhn","email":"abruhn0@bloglines.com","gender":"Female","salary":5674},
{"id":2,"first_name":"Romy","last_name":"Ludl","email":"rludl1@reddit.com","gender":"Female","salary":6532},
{"id":3,"first_name":"Wilbur","last_name":"Windridge","email":"wwindridge2@oakley.com","gender":"Male","salary":6212},
{"id":4,"first_name":"Leonidas","last_name":"Dutchburn","email":"ldutchburn3@twitter.com","gender":"Male","salary":8560},
{"id":5,"first_name":"Tobye","last_name":"Bontein","email":"tbontein4@webmd.com","gender":"Polygender","salary":6273},
{"id":6,"first_name":"Horton","last_name":"Dorton","email":"hdorton5@godaddy.com","gender":"Genderfluid","salary":5195},
{"id":7,"first_name":"Nap","last_name":"Archanbault","email":"narchanbault6@accuweather.com","gender":"Male","salary":6514},
{"id":8,"first_name":"Goddart","last_name":"Pollendine","email":"gpollendine7@bbb.org","gender":"Male","salary":5809},
{"id":9,"first_name":"Lester","last_name":"Calverley","email":"lcalverley8@ihg.com","gender":"Male","salary":3977},
{"id":10,"first_name":"Norris","last_name":"Rey","email":"nrey9@reddit.com","gender":"Male","salary":5130}]`;

// json 타입 => javaScript에서 쓰는 object 타입으로 변환
let result = JSON.parse(data); //data를 js의 object로 변환.
console.log(result);

// for(String str : personList) 처럼 썼던거를 이제 밑에처럼 써주는것.. 갯수만큼 반복
// <ul><li>obj</li></ul>
// <div id="show"></div>

const fields = ['id', 'first_name', 'email', 'salary']; //항목을 정해주고
let tableTag = document.createElement('table');

for (row of result){
	tableTag.appendChild(makeTr(row));
}

document.getElementById('show').appendChild(tableTag);

for (row of result){ //새로만든..
	trTag.appendChild(makeTd(row));
}

document.getElementById('show').appendChild(trTag);

function makeTr(obj){
	let trTag = document.createElement('tr');
	return trTag;
}

function makeTd(obj){
	let tdTag = document.createElement('td');
	let str = '';
	for (field of fields){
		str += `${field}: ${obj[field]} `;
	}
	let txt = document.createTextNode(str);
	return tdTag;
	
}


function makeList(obj){
	let liTag = document.createElement('li');
	let str = '';
	for (field of fields){ //배열에 선언되어져있는 갯수만큼 받아오기
		str += `${field}: ${obj[field]} `; //id: id속성을 읽어옵니다, first_name: firstname을 읽어옵니다
	}
	let txt = document.createTextNode(str);
	liTag.appendChild(txt);
	
	return liTag;
}



}); 
