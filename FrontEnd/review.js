window.onload = function () {
  var lizard = document.querySelector(".Lizzard");

  lizard.addEventListener("click", function () {
    console.log("Lizzard 🦎");

    var v = document.querySelector("input[type=text]");

    var list = document.querySelector(".list");

    var listItems = {
      tagName: "li",
      text: v.value,
      classname: "list_child"
    }

    var elementlist = document.createElement("li");
    list.appendChild(elementlist);


  });




};
