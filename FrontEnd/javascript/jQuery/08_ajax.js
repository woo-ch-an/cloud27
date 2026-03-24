// https://jsonplaceholder.typicode.com/comments
$(function (){
$(".load-comments").one("click", function(){
    $(".spinner").show();
   // 비동기로 https://jsonplaceholder.typicode.com/comments 호출하기
   // window.fetch(url); ==> Promise 반환. (비동기)
var fechProm=   fetch("https://jsonplaceholder.typicode.com/comments");
// Pending -> 요청 진행중 
// fullfilㅣed -> 님 다됨.  (에러도 포함)
   // ㄴ 정상 반환 Prom then 으로 처리 
   // ㄴ 에러 반환 Prom catch 로 처리

   // 서버로 보낸 http 요청이 서버로부터 처리됐을 경우
   // 서버가 반환시킨값을 Console로 출력해본다면 ?
   fechProm.then(function (jasonResponse /*서버가 패치에게 반환시킨 값*/) { 
    // jasonResponse.json() < 비동기처리 (Promise의 반환 )

    return jasonResponse.json();
   }).then(function(body /*json이 반환시킨값 */){ 
    // body 꼬라지 : [ {PostId, id,name,email,body},{},{}]
    for(var i =0; i < body.length; i++){
        var comments= body[i];
        var bodycom = comments.body;

        var liItem= $("<li>").text(bodycom); 
        $(".comments").append(liItem);
    }
    $(".spinner").hide();

   });



// 일정 주기로 함 수 반복;
// setInterval(function() {} , 1000); 1초주기로 계속반복
// setInterval(function() {
//     console.log(fechProm);
// }, 100); 
});
});



// window.onload = function () {
//     var button = this.document.querySelector(".call-promise");

//     button.addEventListener("click", function () {
//         var delay = parseInt(Math.random() * 10000);

//         var prom = new Promise(function (resolve, reject) {
//             // 비동기화 함수 처리
//             setTimeout(function () {

//                 if (delay % 2 === 0) {
//                     reject(delay);
//                 } else {
//                     resolve(delay);
//                 }
//             }, delay);

//         })
 
//         fucktion(deat)

// });
// };