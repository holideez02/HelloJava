/**
 * dom3.js
 */

document.addEventListener('DOMContentLoaded', function() {
	
	document.querySelector('button').addEventListener('click', function(){
		
		//아이디 조회해서 화면에서 삭제.
		let trs = document.querySelectorAll('table>tbody>tr');
		let id = document.getElementById('id').value;
		for(let i =0; i<trs.length; i++){
			if(trs[i].children[0].textContent==id){
				trs[i].remove();
			}
		}
	});
	let tableObject = { //오브젝트.
		id: 'hong', //속성 값을 읽는것은 this
		titles: ["아이디", "이름", "이메일"],
		data: [{ id: 'user1', name: '홍길동', email: 'hong@email' },
		{ id: 'user2', name: '김민서', email: 'kim@email' },
		{ id: 'user3', name: '박항서', email: 'park@email' }],
		addData: function(row){
			this.data.push(row)
		},
		makeTable: function() { //테이블만드는 메소드
			let table = document.createElement('table');
			let thead = this.makeHead();
			let tbody = this.makeBody();
			table.append(thead, tbody); //appendChild는 매개값을 하나만 받지만, append는 여러개
			return table;
		},
		makeHead: function() {
			let thead = document.createElement('thead');
			let tr = document.createElement('tr');
			this.titles.forEach(function(title) { //변수이름이 title. 여기는 값이다
				let td = document.createElement('th');
				let txt = document.createTextNode(title);
				td.append(txt);
				tr.append(td);
			})
			thead.append(tr);
			return thead;
		},
		makeBody: function() {
			let tbody = document.createElement('tbody');
			this.data.forEach(val => { //val, idx, ary순서. 필요한것만 써도됨. this의 data가 가지고 있는 갯수만큼 반복할게요
				let tr = document.createElement('tr');
				tbody.append(tr);
				for (let field in val) { //오브젝트의 갯수만큼 필드(속성)을 가지고 옴. foreach랑 다르니 기억하기.
					let td = document.createElement('td');
					let txt = document.createTextNode(val[field]); //field의 값을 가져옴.
					td.append(txt);
					tr.append(td);
				}
				//삭제버튼. 클릭하면 한 건 삭제.
				let btn = document.createElement('button');
				btn.addEventListener('click', function(){
					this.parentElement.parentElement.remove();
				})
				let txt = document.createTextNode('삭제');
				btn.append(txt);
				let td = document.createElement('td');
				td.append(btn);
				tr.append(td);
			});

			return tbody;
		},
		init: function() { //메소드 만들고싶을때 function으로 정의. 
			//			let id = 'kim'; //변수
			//			console.log('init call.' + id);
			document.getElementsByTagName('body')[0].append(this.makeTable()); //태그값으로 요소를 선택해올때는 bytagname. body라는 태그를 찾음. body가 하나더라도 인덱스는 0을 꼭 써주기..
		}
	}
	
	// 데이터 추가.
	tableObject.addData({id: 'user4', name:'황선홍', email:'hwang@email'});
	tableObject.init(); //화면에 그려주는 메소드 호출
}) //end of DOMContentLoaded
