/** @format */

export const fetchArticlesList = async (pageNo = 0, listSize = 10) => {
    try {
        console.log("fetchArticlesList");
        const articleResponse = await fetch(`http://localhost:8080/api/articles?pageNo=${pageNo}&listSize=${listSize}`);
        console.log(articleResponse);


        const articleList = await articleResponse.json();
        console.log(articleList)

        return articleList;
    }
    catch (e) {
        return {
            result: {
                count: 0,
                result: []
            },
            pagination: {}
        };
    }
};
export const fetchJsonWebToken = async (id, password) => {
    console.log("fetchJsonWebToken");
    console.log(id);
    try {
        const fetchRequestJWT = await fetch("http://192.168.211.11:8086/api/authorization", {
            method: "post",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                email: id,
                password,
            })
        });
        const fetchRequestJWTReuslt = await fetchRequestJWT.json();
        console.log(fetchRequestJWTReuslt);
        return fetchRequestJWTReuslt;
    }
    catch (e) {
        return {
            "error": [],
            "status": 400
        };
    }
};

export const fetchAddArticle = async (jwt, subject, content, attachFile) => {
    try {
        console.log("fetchAddArticle");
        console.log(jwt);
        console.log("jwt")
        const formData = new FormData();
        formData.append("subject", subject);
        formData.append("content", content);
        // attachFile 을 FileList 배열이라 나눠주기 
        // FileList의 파일 객체들을 ttachFiler러 하나씩 할당
        for (let file of attachFile) {
            formData.append("attachFile", file);
        }


        const writeResult = await fetch(`http://localhost:8080/api/articles`, {
            method: "post",
            headers: {
                // "Authorization": jwt,
                "Authorization": jwt,
            },
            body: formData,

        });
        console.log(writeResult);


        const addResult = await writeResult.json();
        console.log(addResult)

        return addResult;
    }
    catch (e) {
        return {
            result: {
                count: 0,
                result: []
            },
            pagination: {}
        };
    }
};