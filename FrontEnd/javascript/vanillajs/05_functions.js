window.onload = function () {

  (function (number) {
    console.log('나를실행해봐', number);
  })(5);
  var list = document.querySelector(".list");
  console.log(list);
  console.dir(list);

  console.log(list.dataset.count)
  var dataCount = parseInt(list.dataset.count);

  for (var i = 0; i < dataCount; i++) {
    (function (number) {
      var eachItem = document.createElement("li");
      eachItem.innerText = number;
      eachItem.addEventListener("click", function () {
        alert(number);
      });

      list.appendChild(eachItem);
    })(i + 1);

    // list.innerHTML += "<li>" + (i + 1) + "</li>";
  }

  var lizard = document.querySelector(".Lizzard");

  lizard.addEventListener("click", function () {
    console.log("Lizzard 🦎");
  });


  var printMessage = function (message) {
    console.log(message);
  }

  printMessage("asd");

  function printSumResult(from, to, endfunction) {
    setTimeout(function () {
      var sum = 0;
      for (var i = from; i <= to; i++) {
        sum += i;
      }
      console.log(sum);

      endfunction(sum);
    }, 0);

  }

  // printSumResult(1, 100000000, function (sum) {
  //   if (confirm("asd!!" + sum)) {
  //     alert('!!asd');
  //   }
  // });


  // getPlusResult(100, 200);

  function printCalcResult(num1, num2, operator) {
    if (operator === "+") {
      console.log(getPlusResult(num1, num2));
    } else if (operator === "-") {
      console.log(getSubtractResult(num1, num2));
    } else if (operator === "*") {
      console.log(getMultplyResult(num1, num2));
    } else if (operator === "/") {
      console.log(getDivideResult(num1, num2));
    }

    function getPlusResult(num1, num2) {
      return num1 + num2;
    }
    function getSubtractResult(num1, num2) {
      return num1 - num2;
    }
    function getMultplyResult(num1, num2) {
      return num1 * num2;
    }
    function getDivideResult(num1, num2) {
      return num1 / num2;
    }
  }
  function addAll() {
    var sum = 0;
    for (var i = 0; i < arguments.length; i++) {
      sum + arguments[i];
    }
    return sum;
  }
  function calc(num1, num2) {
    console.log(arguments);

    return num1 + num2;
  }

  var re;
  var val = calc(40, 30);
  console.log(val);

  val = calc(40, 70, 100);
  console.log(val);

  val = calc(-2);
  console.log(val);
  val = calc(re, -10);
  console.log(val);

  printCalcResult(1, 3, "+");
  printCalcResult(19, 3, "-");
  printCalcResult(10, 3, "*");
  printCalcResult(9, 3, "/");
};
