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
        var newp = $("<p>");
        newp.text("From $399.99")
        $(".package-green-button").after(newp);

        $(".package-green-button").remove();
    });
})