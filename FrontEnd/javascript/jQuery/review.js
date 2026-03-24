$(function () {

  $(".add-item").on("click", function () {
    // 아이템 추가
    var list = $("<li>");
    // 리스트 만들어서 안쪽 마지막 append로 추가
    var listcount = $(".item-list").children().length;
    if (listcount <= 9) {
      list.text("아이템 목록" + (listcount + 1));
      list.addClass("item-lists");
      $(".item-list").append(list);

      $(".text-content").text("총 " + (listcount + 1) + " 개의 아이템이 등록되었습니다.");
    } else {
      alert("더이상 추가할 수 없습니다");
    }
  })

  $(".remove-item").on("click", function () {
    // 아이템 전체 제거
    // select ul children -> remove
    $(".item-list").children().remove();
    $(".text-content").text("등록된 아이템이 없습니다");
  })
})

// window.onload = function () {
//   var inputBtn = document.querySelector(".add-item");
//   var list = document.querySelector(".item-list");
//   var listItem = { tagName: "li", text: "아이템 목록", class: "item-lists" }
//   var deletBtn = document.querySelector(".remove-item");
//   var textContent = document.querySelector(".text-content");
//   // 1. 아이템 추가 
//   inputBtn.addEventListener("click", function () {

//     var listCount = document.querySelectorAll("li");

//     if (listCount.length < 10) {

//       var insertionitem = document.createElement(listItem.tagName);

//       insertionitem.className = listItem.class;
//       insertionitem.innerText = listItem.text + (listCount.length + 1);

//       list.appendChild(insertionitem);
//       textContent.innerText = "총 " + (listCount.length + 1) + " 개의 아이템이 등록되었습니다.";
//     } else {
//       alert("더이상 추가할 수 없습니다 !");
//     }
//   })

//   // 2. 아이템 삭제

//   deletBtn.addEventListener("click", function () {
//     var deleteItems = document.querySelectorAll("li");
//     //remove child ㅎ 라는게있음 
//     for (var i = 0; i < deleteItems.length; i++) {
//       deleteItems[i].remove();
//     }

//     textContent.innerText = "등록된 아이템이 없습니다. ";
//   })
// };
