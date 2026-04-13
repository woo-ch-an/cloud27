$(function() {
    $(".page-navigator").find("a").on("click", function(){
            var pageNo =$(this).data("page-no");
             var listSize= $("#list-size").val();
             var searchType = $("#search-type").val();
             var searchKeyword = $("#search-keyword").val();
             

             location.href = "/?pageNo=" + pageNo +  "&listSize=" + listSize + "&searchType=" + searchType + "&searchKeyword=" + searchKeyword;
    });
    
    $("#list-size").on("change", function(){
       // location.href = "/?pageNo=0&listSize=" + $(this).val(); 
       $(".search-button").trigger("click");
    });
    
    $(".search-button").on("click", function(){
       // ?pageNo=0&listSize=#list-size&searchType=#search-type&searchKeyWord=#search-keyword  
       var pageNo =0;
       var listSize= $("#list-size").val();
       var searchType = $("#search-type").val();
       var searchKeyword = $("#search-keyword").val();
       

       location.href = "/?pageNo=" + pageNo +  "&listSize=" + listSize + "&searchType=" + searchType + "&searchKeyword=" + searchKeyword;
    });
    
    
    // ".add-file" 을 클릭하면 
    // 새로운 파일 인과 버튼을 
    // ".attach-files" 아래 추가한다

    // $(".add-file").on("click", function(){ 새로 생긴 button, cl래스들에게 이벤트를 주기위해 부모한테 주고 뿌리기
    $(".attach-files").on("click", ".add-file", function() {
        // 새로운 파일이 추가 될 때마다 기존 "add-file 을 "del-file"로 변경
        // 텍스트를 + -> - 로 변경 
        $(this).closest(".attach-files").children(".add-file").removeClass("add-file").addClass("del-file").text("-").off("click").on("click", function() {
            // 버튼 왼쪽 input tag, this 삭제
            $(this).prev().remove();
            $(this).remove();
        });

        var fileInput = $("<input />");
        fileInput.attr({
            type: "file",
            name: "attachFile",
        });
        var addButton = $("<button />");
        addButton.attr("type", "button").addClass("add-file").text("+");


        $(".attach-files").append(fileInput).append(addButton);

    });

    $("#writeVO").on("submit", function(event) {
        event.preventDefault();

        $(this).find(".VaildationError").remove();

        var subtitle = $("#subject").val();
        if (!(subtitle.length > 3)) {
            var subtitleErrorMessage = $("<div>");
            subtitleErrorMessage.addClass("VaildationError");
            subtitleErrorMessage.text("Subject's Length  has to be OVER 3WORD")

            $("#subject").after(subtitleErrorMessage);
        }

        var email = $("#email").val();
        if (!email) {
            var emailErrorMessage = $("<div>");
            emailErrorMessage.addClass("VaildationError");
            emailErrorMessage.text("이메일형태아님ㄴ다.");

            $("#email").after(emailErrorMessage);
        }
        
        if( $(".VaildationError").length ===0){
            this.submit();
        }

    });
});