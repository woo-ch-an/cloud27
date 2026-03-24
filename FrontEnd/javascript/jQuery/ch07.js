$(function () {
    $("#package-ticket-count").on("keyup", function () {

        var price = $(this).closest(".package").data("price");
        var count = $(this).val();
        var amount = price * count;
        $("#amount").text(amount);

    }).on("change", function () {
        $(this).trigger("keyup");
    })
});