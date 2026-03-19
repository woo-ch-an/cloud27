String.prototype.replaceAll = function (findtext, replaceText) {
  console.log('aa');
  return this;
}


// String 객체의 Contains 기능 추가 
String.prototype.contains = function (findtext) {
  console.log(findtext);
  console.log(this);

  return this.indexOf(findtext) >= 0;
};

// print 기능 추가
Object.prototype.print = function () {
  console.log("돌려돌려돌림판이젠 나의 보너스 타임");
};
var tempObj = {};
tempObj.print();
console.dir(tempObj);

window.onload = function () {
  var text = "abhfgasdhfba jaksefbajeksbg";

  console.log(String);
  console.dir(String);
  text = text.replaceAll("a", "A");

  console.log(text);

  text = text.toUpperCase();

  console.log(text + " mmmmmmmm");

  console.log(text.contains("j a"));


  var list = document.querySelector(".list");
  var listItems = [{
    tagName: "li", text: "first", class: "list-item"
  }, { tagName: "li", text: "second", class: "list-item" }, { tagName: "li", text: "third", class: "list-item" }, { tagName: "li", text: "fouth", class: "list-item" }
  ];

  for (var i = 0; i < listItems.length; i++) {
    var item = listItems[i];

    var eachItem = document.createElement(item.tagName);
    eachItem.className = item.class;
    eachItem.innerText = item.text;
    list.appendChild(eachItem);

  }


  var lizard = document.querySelector(".Lizzard");

  lizard.addEventListener("click", function () {
    console.log("Lizzard 🦎");
  });
  function getObject() {
    return {
      price: 123456,
      namea: "asda",
      model: "affg",
      anjdidlrj: "fan",
      chainsaw: ["gs", "asd", "aaa"],
      address: {
        ciaff: "asd",
        gdsg: "hjr",
      },
    };
  }

  var obj = getObject();
  console.log(obj.chainsaw);

  var newObject = {
    namae: "demetrian",
    "ti-tle": "titus",
    power: false,
    powerOn: function () { console.log(this.namae + "키기"); this.power = true; },
    powerOff: function () { console.log(this.namae + "끄기"); this.power = false; },
  };
  console.log(newObject, typeof newObject);

  newObject.powerOn();

  console.log(newObject.power)
  newObject.powerOff();

  console.log(newObject.power)
  newObject.powerOn();

  console.log(newObject.power)
  newObject.powerOn();

  console.log(newObject.power)

  console.log(newObject.namae);
  console.log(newObject["namae"]);
  console.log(newObject["ti-tle"]);

  console.log(newObject.power)

}