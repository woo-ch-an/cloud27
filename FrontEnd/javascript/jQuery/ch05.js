$(function () {
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
        $(this).after(newp);


        $(this).remove();


    });
})