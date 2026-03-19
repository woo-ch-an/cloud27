window.onload = function () {
  var button = document.querySelector(".clickable-button");
  console.log(button);
  // clickable-button 클릭하면 버튼클릭인걸출력

  button.addEventListener("click", function () {
    console.log("click button");
    alert("clcickckcickc");
  });

  var box = document.querySelector(".clickable-box");
  console.log(box);

  box.addEventListener("click", function () {
    console.log("click button");
    confirm("clcslc");
  });
};
