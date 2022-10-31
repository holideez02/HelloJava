//dom1 
//DOM 활용해서 페이지 만들기. html로 만들어도 되지만 js로 만들게되면 좀 더 동적으로 만들 수 있기 때문에
// 더 선호하는 편!

document.addEventListener('DOMContentLoaded', function(){ //document가 다 실행된 다음 실행.
	let show = document.getElementById('show'); //
	let form = document.createElement('form'); //form 이라고 하는 객체 생성
// id.
	let txt = document.createTextNode('ID: ');
	let input = document.createElement('input');
	input.setAttribute('type', 'text'); //input에 attribute추가. type이나 id같은거
	input.setAttribute('id', 'id'); //앞에는 id라는 attribute, 뒤는 값
	let br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);
	
// name.
	txt = document.createTextNode('Name: ');
	input = document.createElement('input');
	input.setAttribute('type', 'name');
	input.setAttribute('id', 'name');
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);

// Phone.
	txt = document.createTextNode('Phone: ');
	input = document.createElement('input');
	input.setAttribute('type', 'name');
	input.setAttribute('id', 'phone');
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);
// 전송.
	input = document.createElement('input');
	input.setAttribute('type', 'submit');
	input.setAttribute('value', '전송');
	br = document.createElement('br');
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);

})



