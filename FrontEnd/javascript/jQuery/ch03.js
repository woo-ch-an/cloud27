$(function () {
    var listItems = $("#destinations").children("li")
    console.log(listItems);

    listItems.on("click", function () {
        var a = $(this);
        console.log("태그내용", $(this).text());
        console.log("태그 내용 : ", $(this).prev().text());
        console.log("다음거 : ", a.next().text());
        console.log("부모 : ", a.parent().text());
    });
})

// window.onload = function () {
//     var listItems = document.querySelectorAll("#destinations > li");
//     console.log(listItems);

//     for (var i = 0; i < listItems.length; i++) {
//         listItems[i].addEventListener("click", function (event) {
//             console.dir(event.target);
//             console.log(event.target.innerText);
//             console.log(event.target.previousElementSibling.innerText);
//             console.log(event.target.parentElement.innerText);

//         });
//     };
// };