<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>index.jsp</title>
    <script src="object.js"></script>
</head>
<body>

    <form action="index.html" onsubmit="submitFunc()"> <!--action, onsubmit 전부 attribute submit을 누르면 함수실행-->
        id: <input type="text" id="uid" value="user1"><br>
        pw: <input type="password" id="upw" value="1234"><br>
        <input type="submit" value="로그인">
    </form>

    <div id="show"></div>

    <script>

        function saveFnc(){
            // document.write('<p>Hello, World </p>');
            // DOM 요소 생성.
            let pTag = document.createElement('p'); // <p></p> 
            let txt = document.createTextNode('Hello, World'); //자식요소 해당하는 부분.
            pTag.appendChild(txt); //p가 자식을 감싸기 때문에 <p>Hello,world</p>가 실행됨
            console.log(pTag);
            
            document.getElementById('show'); //div id가 show인 녀석을 선택해오는 메소드
            show.appendChild(pTag);
            console.log(show);
        }

        function submitFunc() {
            event.preventDefault(); //window가 가지고 있는 내장객체. form이 가진 기본기능 차단(action이 실행되지 않음)
            console.log('submitFunc() call.');

            //엘리먼트(element) 선택하는데 id속성을 통해서 엘리먼트를 선택.
            let id = document.getElementById('uid').value;
            let pw = document.getElementById('upw').value;

            let pTag = document.createElement('p'); //요소 만드는건 createElement
            let txt = document.createTextNode('id는 ' + id + ', 비번은 ' + pw);
            pTag.appendChild(txt);

            pTag.onclick = function(){ //function은 실행한다는 뜻
                console.log(this.remove()); // p태그 자신을 가리키는게 this. 
            }

            document.getElementById('show').appendChild(pTag);
        }
    </script>

</body>
</html>