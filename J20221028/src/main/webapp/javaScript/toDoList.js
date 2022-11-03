//toDoList.js
document.addEventListener('DOMContentLoaded', function () {
            let ulTag = document.createElement('ul');
            let liTag = document.createElement('li');

            let list = [];

            document.getElementById('add').addEventListener('click', addList); //add버튼을 누르면 실행

            function addList() { //목록 추가
                let item = document.querySelector('#do').value;
                if (item != '') {
                    list.push(item);
                    document.querySelector('#do').value = '';
                    document.querySelector('#do').focus();
                    console.log(list);
                    showList(list);
                }
            }
            function showList(list){ //목록 보여주기
                document.querySelectorAll('#doList>ul>li').forEach(li => {
                    li.remove(); //화면 싹 지워주고
                })
                for(let i of list){
                    let liTag = document.createElement('li');
                    let span = document.createElement('span');
                    span.setAttribute('id', 'close');
                    document.querySelector('#id').textContent='x';
                    liTag.append(i);
                    liTag.append(span);
                    ulTag.append(liTag);
                }
                document.querySelector('#doList').append(ulTag);
            }

            function removeList(){ //화면에서 삭제
                console.log('삭제');
            }
            
        })