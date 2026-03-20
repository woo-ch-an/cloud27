$(function () {
    var h1 = $("h1");
    console.log(h1.text());
    h1.text("What do you want to do");

    alert($("p").text());
    $("p").text("다음여행을 계획해 보 세요");
});
