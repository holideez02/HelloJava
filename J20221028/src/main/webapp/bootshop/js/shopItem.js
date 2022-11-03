//shopItem.js

fetch('../ShopItemListServlet')
    .then(result => result.json())
    .then(itemListShow)
    .catch(err => console.log(err));

//카트에 담을때 숫자 바꿔주는 함수
function addCartFunc() {
    console.log('담기');
    let zero = document.querySelector('span.badge').textContent; // span.badge에 대한 내용
    console.log(zero);
    document.querySelector('span.badge').textContent = parseInt(zero)+1;
}

function itemListShow(result) { //result의 데이터를 루핑 돌면서
    console.log(result);

    result.forEach(item => { //result의 데이터 건수만큼 출력.
        makeItemDiv(item);
    })

}

function makeItemDiv(item = {}) { //상품 매개값으로 주기.. item(상품)은 object
    let template = document.querySelector('#template>div');
    let good = template.cloneNode(true); //good은 탬플릿을 clone해서 가지고 온것. 그 안에 값을 바꿔주기.

    good.querySelector('h5').textContent = item.itemName;
    good.querySelector('img.card-img-top').src = '../images/' + item.image;
    good.querySelector('span.text-muted').textContent = item.originPrice;
    good.querySelector('span.text-muted').nextSibling.textContent = ' ' + item.salePrice; //nextSibling은 다음의 동생요소를 찾는다는 뜻. 형님은 previousSibling. (형제)
    
    //아이템 담기
    good.querySelector('a.btn').addEventListener('click', addCartFunc)

    //평점(review)
    let review = item.likeIt; //평점. 4.5
    let a = Math.floor(review); //review가 가지고 있는 점수를 내림. 온쪽
    let b = review - a; //.5가 있는지 없는지 유무. 반쪽
    for (let i = 0; i < a; i++) {
        let div = document.createElement('div');
        div.className = 'bi-star-fill'; //<div class="bi-star-fill">
        // div.setAttribute('class', 'bi-star-fill');
        good.querySelector('div.d-flex').append(div);
    }
    if (b) {
        let div = document.createElement('div');
        div.className = 'bi-star-half'; //<div class="bi-star-fill">
        good.querySelector('div.d-flex').append(div);
    }


    //상품목록
    let parent = document.querySelector('section.py-5>div>div');
    parent.append(good);
    console.log(good);
}