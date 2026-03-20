// take all "li" tages and replace them to seoul
$(function () {
    $("li").text("Seoul");
    // change the text which class name is promo to "busan"
    $(".promo").text("Busan");
    // change the text which id is destination's second child to gyoung ju
    $("#destinations > li:nth-child(2)").text("Gyoung ju");
    // $("li").eq(1).text("gyoung ju"); 
})


// window.onload = function () {
//     var listItems = document.querySelectorAll("li"); 
//     for (var i = 0; i < listItems.length; i++) {
//         listItems[i].innerText = "Seoul";
//     }
// };