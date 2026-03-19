window.onload = function () {
  var ary = [];
  var push = document.querySelector(".push");
  console.log(push);
  var pop = document.querySelector(".pop");
  var unshift = document.querySelector(".unshift");
  var shift = document.querySelector(".shift");
  var lizard = document.querySelector(".Lizzard");

  lizard.addEventListener("click", function () {
    console.log("Lizzard 🦎");
  });

  push.addEventListener("click", function () {
    ary.push(ary.length + 1);
    console.log(ary);
  });
  pop.addEventListener("click", function () {
    var val = ary.pop();
    console.log(val, ary);
  });
  unshift.addEventListener("click", function () {
    ary.unshift(ary.length + 1);
    console.log(ary);
  });
  shift.addEventListener("click", function () {
    var val = ary.shift();
    console.log(val, ary);
  });
};
