$().ready(function () {
    // creat new <p> tag. content is after.
    // new <p> tag's location is under the out downside of the wrapper
    var newP1 = $("<p>");
    newP1.text("after");
    $(".wrapper").after(newP1);

    // 비포, 바깥 위쪽
    var newP2 = $("<p>");
    newP2.text("before");
    $(".wrapper").before(newP2);
    // 프리펜드 안쪽위
    var newP3 = $("<p>");
    newP3.text("prepend");
    $(".wrapper").prepend(newP3);
    // 어팬드 안쪽아래
    var newP4 = $("<p>");
    newP4.text("append");
    $(".wrapper").append(newP4);

    // create new div, content is newDiv1
    // new div tag is und
    var div1 = $("<div>");
    div1.text("newDiv-----");
    $(".a").after(div1);

    var div2 = $("<div>");
    div2.text("newDiv2mmmmㅡㅡㅡㅡㅡㅡ");
    $(".c").before(div2);

    var span1 = $("<span>");
    span1.text(" newSpan ~ ");
    $(".b").append(span1);


    var span2 = $("<span>");
    span2.text(" newSpan2 ~ ");
    $(".b").prepend(span2);

});