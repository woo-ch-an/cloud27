$(function () {
    var refreshReplise = function () {

        var loginEmail = $(".member-info").data("email");
        var articleId = $(".view").data("article-id");
        fetch("/api/replies/" + articleId).then(function (response) {
            return response.json();
        })
            .then(function (json) {
                console.log(json);
                var count = json.count;
                $(".replies-count").children(".count").text(count);

                var replies = json.result;
                for (var i = 0; i < replies.length; i++) {
                    var reply = replies[i];
                    var replyTemplate = $(".reply-item-template").html();
                    replyTemplate = replyTemplate.replace("#replyId#", reply.id)
                        .replace("#name#", reply.memberVO.name)
                        .replace("#email", reply.email)
                        .replace("#createDate#", reply.crtDt)
                        .replace("#modifyDate#", reply.mdfyDt)
                        .replace("#recommendCount#", reply.recommendCnt)
                        .replace("#content#", reply.reply);
                    var replyDom = $(replyTemplate);

                    // 로그인 안하거나 내 댓글이면 추천 막기
                    if (!loginEmail || loginEmail === reply.email) {
                        replyDom.find(".links-recommend").remove();
                    }

                    if (loginEmail !== reply.email) {
                        replyDom.find(".links-update").remove();
                        replyDom.find(".links-delete").remove();
                    }
                    if (!reply.fileGroupId) {
                        replyDom.find(".reply-attach-files").remove();
                    } else {
                        replyDom.find(".reply-attach-files").data("files", JSON.stringify(reply.files));
                        for (var j = 0; j < reply.filesVO.length; j++) {
                            // a 태그 를 replace 머시기 암튼에 추가
                            var fileSize = reply.filesVO[j].fileLength;
                            var capaType = "byte";
                            if (fileSize > 1024) {
                                capaType = "kb";
                                fileSize = Math.ceil(fileSize) / 1024;
                            }
                            if (fileSize > 1024) {
                                capaType = "mb";
                                fileSize = Math.ceil(fileSize) / 1024;
                            }

                            var filesTags = $("<a>");
                            filesTags.attr("href", "/file/" + reply.filesVO[j].fileGroupId + "/" + reply.filesVO[j].fileNum);
                            filesTags.text(reply.filesVO[j].displayName);

                            replyDom.find(".reply-attach-files").append(filesTags);
                        }
                    }
                    if (!reply.mdfyDt) {
                        replyDom.find(".modify-date").remove();
                    }

                    // 추천 증가
                    replyDom.find(".links-recommend").on("click", function () {
                        // API 호출 + 호출 결과-> {replyId ~ , } 으로 오겠죠 ?
                        // 뭐 그거 암튼 뭐시기 알아서하셈
                        //  /api/replies/recommand/댓ㄷ글아디
                        var replyIdForRecommend = $(this).closest(".reply-item").data("reply-id");
                        fetch("/api/replies/recommend/" + replyIdForRecommend, {
                            method: "GET"
                        })
                            .then(function (response) {
                                return response.json();
                            })
                            .then(function (json) {
                                console.log(json);
                            });


                    });

                    // TODO 댓글 수정.
                    //      수정을 클릭하면, 댓글을 수정할 수 있는 폼이 완성된다.
                    replyDom.find(".links-update").on("click", function () {
                        $(".update-form").remove();

                        var replyAttachFiles = $(this)
                            .closest(".reply-item")
                            .find(".reply-attach-files")
                            .data("files");

                        if (replyAttachFiles) {
                            replyAttachFiles = JSON.parse(replyAttachFiles);
                        }

                        var content = $(this)
                            .closest(".reply-item")
                            .find(".content")
                            .text();

                        var updateTemplate = $(".reply-item-update-template").html();
                        var updateFormDom = $(updateTemplate);
                        updateFormDom.find("textarea").val(content);

                        updateFormDom.find(".update-cancel").on("click", function () {
                            $(".update-form").remove();
                        });


                        updateFormDom.find(".update-save").on("click", function () {
                            // 1. 수정 댓글 아디 , 내용 삭제 파일이름, 추가파일
                            var updateReplyId = $(this).closest(".reply-item").data("reply-id");
                            var updateContent = $(this).closest(".update-form").find("textarea").val();

                            var deleteFilesNum = $(this).closest(".update-file-list").find("input[type='checkbox']:checked");

                            var addFilesNum = $(this).closest(".update-form").find(".reply-update-attach-file")[0].files;

                            var updateFormData = new FormData();
                            updateFormData.append("content", updateContent);
                            deleteFilesNum.each(function () {
                                updateFormData.append("delFileNum", $(this).val());
                            });
                            for (var l = 0; l < addFilesNum.length; l++) {
                                updateFormData.append("newAttachFile", addFilesNum[l]);
                            }

                            fetch("/api/replies/" + updateReplyId, {
                                method: "POST",
                                body: updateFormData,
                            })
                                .then(function (response) {
                                    return response.json();
                                }).then(function (json) {
                                    $(".replies").html("");
                                    refreshReplise();
                                });
                        });


                        if (replyAttachFiles) {
                            var replyItemsTemplate = $(".reply-item-update-files").html();
                            for (var j = 0; j < replyAttachFiles.length; j++) {
                                var replyItemFile = replyAttachFiles[j];

                                var fileTemplate = replyItemsTemplate
                                    .replaceAll("#fileGroupId#", replyItemFile.fileGroupId)
                                    .replaceAll("#fileNum#", replyItemFile.fileNum)
                                    .replaceAll("#fileDisplayName#", replyItemFile.displayName);

                                updateFormDom.find(".update-file-list").append($(fileTemplate));
                            }
                        }

                        $(this)
                            .closest(".reply-item")
                            .find(".content")
                            .after(updateFormDom);
                    });


                    // 댓글 삭제 + 새로고침
                    replyDom.find(".links-delete").on("click", function () {
                        // 삭제하겟습니까 경고창 띄우고 새로고침은 없음 목록에서 제거,
                        //  /api/replies/delete/{댓글아디}
                        alert("!");
                    });

                    replyDom.css({ "margin-left": (reply.level - 1) * 32 + "px" });

                    replyDom.find(".links-write").on("click", function () {
                        var replyId = $(this).closest(".reply-item").data("reply-id");
                        console.log("Clikc - " + replyId);

                        $(".reply-form").children(".parent-reply-id").val(replyId);
                        $(".reply-content").focus();
                    });

                    $(".replies").append($(replyDom));
                }
            });
    };
    refreshReplise();

    $(".reply-save").on("click", function () {
        var replyContent = $(".reply-content").val();
        var articleId = $(this).data("article-id");
        var parentReplyId = $(".parent-reply-id").val();
        var files = $(".reply-attach-file")[0];

        var formData = new FormData();
        formData.append("reply", replyContent);
        formData.append("articleId", articleId);
        formData.append("parentReplyId", parentReplyId);

        if (files.length > 0) {
            for (var k = 0; k < files.files.length; k++) {
                formData.append("attachFile", files.files[k]);
            }
        }


        console.log(formData);
        fetch("/api/replies-with-file", {
            method: "POST",
            body: formData
        })
            .then(function (response) {
                return response.json();
            })
            .then(function (json) {
                console.log(json);

                $(".reply-form").children(".parent-reply-id").val("");
                $(".reply-content").val("");
                $(".replies").html("");
                refreshReplise();
            });
    });
});