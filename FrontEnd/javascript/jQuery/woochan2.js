$(function () {
    $(".load-git-users").on("click", function () {
        var fechPromise = fetch("https://api.github.com/users");
        fechPromise.then(function (jsonResponse) {
            // --> 뭔가 가져옴

            return jsonResponse.json();
        }).then(function (body) {
            //-> 가져온 데이터 가공하기
            /*
            데이터 꼬라지 be like ->
            login : 
            id : 
            node_id
            avatar_url
            gravatar_id
            url
            html_url
            followers_url
            following_url
            gists_url
            starred_url
            subscrptions_url
            organizations_url
            repos_url
            events_url
            received_events_url
            type
            user_view_type
            site_admin
            */


            //2. 파일 내 ".load-git-users" 를 클릭하면 위 URL을 fetch 로 호출해 반환되는 데이터를 console 로 출력하도록 합니다
            for (var i = 0; i < body.length; i++) {
                var datas = body[i];
                var loginData = datas.login;
                var idData = datas.id;
                var node_idData = datas.node_id;
                var avata_urlData = datas.avatar_url;
                var gravatar_idData = datas.gravatar_id;
                var urlData = datas.url;
                var html_urlData = datas.html_url;
                var followers_urlData = datas.followers_url
                var following_urlData = datas.following_url;
                var gists_urlData = datas.gists_url;
                var starred_urlData = datas.starred_url;
                var subscrptions_urlData = datas.subscrptions_url;
                var organizations_urlData = datas.organizations_url;
                var repos_urlData = datas.repos_url;
                var events_urlData = datas.events_url;
                var received_events_urlData = datas.received_events_url;
                var typeData = datas.type;
                var user_view_typeData = datas.user_view_type;
                var site_admin = datas.site_admin;

                // 와 이걸  와 아니 하 
                // console.log(datas);


                $.each(datas, function (key, value) {
                    console.log("Foreach ~ " + key + " : " + value);
                });

                //3. 반환되는 데이터 중 객체 한개 마다 ".posts"의 li로 추가합니다.
                // ???

                //5. 반환되는 데이터 중 "login"의 값을 <div></div>에 추가하고 이름이 나오도록 합니다.
                var divItem = $("<div>").text(loginData).css({ "font-weight": "700", "font-size": "2rem" }).data("url", html_urlData);

                $(".posts").append(divItem);
                $(".posts").append($("<li>").text(idData));
                $(".posts").append($("<li>").text(node_idData));

                //4. 반환되는 데이터 중 "avatar_url" 의 값을 <img src="" /> 에 추가하고 이미지가 나오도록 합니다. (이미지는 완전한 동그라미로 나오도록 해보세요)
                var images = $("<img>").attr("src", avata_urlData).addClass("profileImages").css({ "width": "100px", "height": "100px", "border-radius": "50%" });
                $(".posts").append(images);

                $(".posts").append($("<li>").text(gravatar_idData));
                $(".posts").append($("<li>").text(urlData));

                //6. 반횐되는 데이터 중 "html_url"의 값을 5에서 만든 div를 클릭했을 때 이동하도록 이벤트를 생성합니다
                $(".posts").append($("<li>").text(html_urlData));
                $(".posts").append($("<li>").text(followers_urlData));
                $(".posts").append($("<li>").text(following_urlData));
                $(".posts").append($("<li>").text(gists_urlData));
                $(".posts").append($("<li>").text(starred_urlData));
                $(".posts").append($("<li>").text(subscrptions_urlData));
                $(".posts").append($("<li>").text(organizations_urlData));
                $(".posts").append($("<li>").text(repos_urlData));
                $(".posts").append($("<li>").text(events_urlData));
                $(".posts").append($("<li>").text(received_events_urlData));
                $(".posts").append($("<li>").text(typeData));
                $(".posts").append($("<li>").text(user_view_typeData));
                $(".posts").append($("<li>").text(site_admin));

                divItem.on("click", function () {
                    window.location.href = $(this).data("url");
                })
            }
        })
    })


    $(".load-comments").one("click", function () {
        $(".spinner").show();
        // 비동기로 https://jsonplaceholder.typicode.com/comments 호출하기
        // window.fetch(url); ==> Promise 반환. (비동기)
        var fechProm = fetch("https://jsonplaceholder.typicode.com/comments");
        fechProm.then(function (jasonResponse) {

            return jasonResponse.json();
        }).then(function (body) {
            // body 꼬라지 : [ {PostId, id,name,email,body},{},{}]
            for (var i = 0; i < body.length; i++) {
                var comments = body[i];
                var bodycom = comments.body;

                var liItem = $("<li>").text(bodycom);
                $(".comments").append(liItem);
            }
            $(".spinner").hide();
        });
    });
});
