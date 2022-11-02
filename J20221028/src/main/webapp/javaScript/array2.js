fetch('./MemberListServlet' ) //기본이 get방식. post면 따로 method{} post로 써주기.
    .then(result => result.json())
    .then(listShow)
    .catch(error => console.error(error));

function listShow(data = []){
    //admin인 사람들만 출력
    // data.forEach(member => {
    //     if(member.responsibility == 'admin')
    //         console.log(member);    
    // })

    //권한이 user인 사람들만 userGroup이라고 새롭게 배열 생성.
    // data.filter(member => member.responsibility == 'user')
    //     .map(member => {
    //         let userGroup ={
    //             user_id : member.id,
    //             user_name: member.name,
    //             user_email: member.email
    //         }
    //         return userGroup;
    //     })
    //     .forEach(userGroup => console.log(userGroup));

    //교수님 방법.
    // //1. forEach를 사용하면..
    // let userGroup = [];
    // data.forEach(member => {
    //     if(member.responsibility == 'user')
    //         userGroup.push(member);
    // })
    //2. filter를 사용하면
    userGroup = data.filter(member => member.responsibility = 'user');
    console.log(userGroup);
}

