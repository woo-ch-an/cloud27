$(function () {
    // 첨에 존재했던 DOM(button-area)를 통해 
    // 새롭게 생성된 p.whitecolor에게 ㅔClick이벤트 주기
    $(".package-button-area").on("click", "p.white-color", function () {
        alert($(this).text())

    });

    $(".contact").on("click", function () {
        // console.log($(this).prev().find(".package-deal-comment").text());
        $(this)
            .prev()
            .find(".package-deal-comment")
            .each(function () {
                console.log($(this).text());
            })
    })

    $(".package-green-button").on("click", function () {
        var priceData = $(this).closest(".package").data("price");

        var newp = $("<p>");

        // // inline style 부여하기
        // newp.css({ color: "white" });

        newp.addClass("white-color");

        newp.text("From $" + priceData);
        // newp.on("click", function () {
        //     alert($(this).text());
        // })
        $(this).after(newp);
        $(this).remove();
    });
})