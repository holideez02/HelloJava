//object.js

let obj = { //오브젝트를 만드는 방법.
    user_id: "hong",
    user_name: "Hongkildong",
    user_age: 20, //필드가 아닌 프로퍼티.
    hobbies: ['독서', '낮잠', '자전거'],
    show_info: function(){
        return 'id: ' + this.user_id + ', name: ' + this.user_name 
        + ', age: ' + this.user_age; //object에 대한 프로퍼티를 가지고 올때는 this.붙이기
    }
}

console.log('id: ' + obj.user_id);
console.log('name: ' + obj["user_name"]);
let field = "user_age"; //변수에 담아서
console.log('age: ' + obj[field]); //갖고와도 된다.
console.log('첫번째 취미: ' + obj.hobbies[0]); //인덱스의 첫번째 값인 독서를 가져옴.

console.log('홍의 정보: ' + obj.show_info());


//객체 생성.
function Person(name, age){ //생성자 함수
    this.name = name;
    this.age = age;

    this.showInfo = function(){
        return '이름은 ' + this.name + ', 나이는 ' + this.age;
    }
}

let p1 = new Person('홍길동', 20); //새로 만든 객체의 주소값을 p1에 저장
let p2 = new Person('김유신', 21); //new로 만들었기 때문에 아까 함수에서 가지고온 this를 의미
let p3 = new Person('박명수', 22);

const persons = [p1, p2, p3]; //배열에다가 담음
for(let i=0; i<persons.length; i++){
    console.log(persons[i].showInfo());
}

function person(name){
    this.name = name; //여기서 this는 window 객체를 의미.
}

person('김민수'); //new 없이 만들어지는 함수는 그냥 함수. 여기서 this는 최상위 window를 불러옴.
console.log(this); //그래서 window객체의 name이 바뀌는것.. 이상해!!

// this: 함수, 전역 영역에서 this를 사용하면 windows라는 최상위 객체를 가리킴.
//       object에서 사용이 되면 this는 객체 그 자신을 가리킴. new 로 써줄때!