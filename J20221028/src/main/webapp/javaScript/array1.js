//array1.js
fetch('data/MOCK_DATA.json')
    .then(result => result.json())
    .then(composeFnc) // showMain에 result를 넘겨줌.
    .catch(error => console.error(error));

function composeFnc(result = []) { //result가 배열이라고 선언해줌.
    //급여 5000넘는 사람들만 filter후에 새로운 모임을 만듬.
    result.filter(row => row.salary > 5000)
        .map(row => {
            let team = {
                t_id: row.id,
                t_name: row.first_name + '/' + row.last_name
            };
            team.t_mail = row.email;
            team['t_dept'] = 'Account';
            return team;
        })
        .forEach(team => console.log(team));
}

// Array.map() => A -> A' 데이터 A를 하나 받아서 새로운 데이터 형태의 A를 만듬.
function mappingFnc(result = []) {
    let newAry = result.map(row => {
        let newObj = {}; //오브젝트 선언할때 {}로 선언할 수 있다. new Object(); 랑 같음
        newObj.user_id = row.id;
        newObj.user_name = row.first_name + '-' + row.last_name;
        newObj.info = row.email;

        return newObj;

    });

    newAry.forEach(obj => console.log(obj));
}


//매개변수를 선언했는데 값이 안들어오면 아무데이터가 없는 배열을 선언하겠다. 새로운 배열을 만들어주는 메소드.
// Array.filter() => 매개함수의 반환값이 true인 요소들만 모아서 새로운 배열 생성.
function filterFnc(result = []) {
    // 인덱스 번호가 짝수인사람만 출력
    // let oddAry = result.filter((row, idx) => {
    //     return idx % 2 ==0;
    // }); //filter는 조건을 만족하는 새로운 배열을 선언해줌

    // oddAry.forEach(row => console.log(row));

    //급여가 5000보다 큰사람만 출력. 간단하게 쓸 수 있음.
    result.filter(row => row.salary > 5000)
        .forEach(row => console.log(row));

    //salary.forEach(row => console.log(row));
}

//Array.forEach() => 반환값은 없고, 최종 처리하는 기능 구현.
function showMain(result) {
    // console.log(result);
    result.forEach((row, idx) => { // 값, 인덱스, 배열자체. forEach는 리턴값이 없음.
        console.log(row);
        // if(row.gender == 'Female'){ // row가 가진 속성 중 여자인것만
        if (idx % 2 == 0) { //인덱스가 짝수인것들만 출력. 1,3,5,7,9
            console.log(row.id, row.first_name, row.last_name);
        }
    });
}

function sum(a = 0, b = 0) { //a와 b의 값을 애초에 0으로 지정해주면(초기값) 값이 하나만 있을때 nan이 안뜸. 
    return a + b;
}
console.log(sum(10));