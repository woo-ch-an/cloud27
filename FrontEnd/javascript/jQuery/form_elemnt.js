// var runMode = "vanilla";
var runMode = "jQuery";

$(function () {
    if (runMode === "jQuery") {
        var boxs = $("input[type='checkbox'][name='favorate-genre']");
        $("#checked-all").on("change", function () {
            boxs.prop("checked", $(this).prop("checked"));
        });
        boxs.on("change", function () {
            var checkBox = boxs.length;
            var checkedCount = boxs.filter(":checked").length;
            $("#checked-all").prop("checked", checkBox === checkedCount);
        });

        // email 값 바꾸기

        console.log($("#email").val());
        $("#email").val("other@gmail.com");

        console.log($("#jobs").val());
        $("#jobs").val(3);

        $("#jobs").on("change", function () {
            console.log($(this).val());
            var text = $(this).children("option:selected").text();
        })
        $("input[type='radio'][name='age']").on("click", function () {
            console.log("change " + $(this).val());
        });
    }
});

window.onload = function () {
    if (runMode === "vanilla") {
        var email = this.document.querySelector("#email").value;
        console.log(email);

        this.document.querySelector("#email").value = "other@gmail.com";

        var jobs = this.document.querySelector("#jobs").value;
        console.log(jobs);

        this.document.querySelector("#jobs").value = 3; // professor

        this.document.querySelector("#jobs").addEventListener("change", function () {
            console.log(this.value);
            console.log(this.querySelector("option[value='" + this.value + "']").innerText);
        });

        //radio event area
        // click (click)
        var radios = this.document.querySelectorAll("input[type='radio'][name='age']");

        for (var i = 0; i < radios.length; i++) {
            radios[i].addEventListener("click", function () {
                console.log(this.checked, this.value);
            });
        }

        // change (select) 
        for (var i = 0; i < radios.length; i++) {
            radios[i].addEventListener("change", function () {
                console.log("changed " + this.checked, this.value);
            });
        }

        var checkboxs = this.document.querySelectorAll("input[type='checkbox'][name='favorate-genre']");

        var seletedAll = this.document.querySelector("#checked-all");
        seletedAll.addEventListener("change", function () {
            for (var i = 0; i < checkboxs.length; i++) {
                checkboxs[i].checked = this.checked;
            }
        });

        for (var i in checkboxs) {
            if (!isNaN(i)) {
                checkboxs[i].addEventListener("change", function () {
                    var checkedCount = 0;
                    for (var j in checkboxs) {
                        if (!isNaN(j)) {
                            if (checkboxs[j].checked) {
                                checkedCount++;
                            }
                        }
                    }
                    seletedAll.checked = checkedCount === checkboxs.length;
                });
            }
        }

    }
};