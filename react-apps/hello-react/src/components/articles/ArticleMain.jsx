/** @format */
// json 불러오기
import articleData from "./articles.json";
import ArticleHeader from "./ArticleHeader.jsx";
import ArticleList from "./ArticleList.jsx";
import ArticleWriter from "./ArticleWriter.jsx";
import ArticleWriter2 from "./ArticleWriter2.jsx";
import ArticleWrtieBtn from "./ArticleWriteBtn.jsx"

// useState 용 import
import { useState } from "react";

// TODO 글 취소하기 -> Clean , 작가에 닉넴(이메일) , 닉넴이멜 MembersVO에 몰아서 던지기
const ArticleMain = () => {
    // console.log(articleData); 
    console.log("ArticleMain");

    // const [[{ id, subject, content, email, viewCnt, crtDt, mdfyDt, fileGroupId, membersVO, files }], setArticles] = useState(articleData.articles);
    const [artcleDatas, setArticles] = useState(articleData.articles);



    const onClickSaveButtonHandler = (subject, name, email, content) => {
        setArticles((prevData) => [...prevData, {
            id: "BO-20260424-00000" + (prevData.length + 1)
            , subject
            , content
            , email
            , viewCnt: Math.round(Math.random() * 10000)
            , crtDt: "2026-04-23 09:10:11"
            , mdfyDt: "2026-04-23 09:15:23"
            , fileGroupId: "FG-20260423-000001"
            , membersVO: { email, name }
            , files: [
                {
                    "fileNum": 1,
                    "fileGroupId": "FG-20260423-000001",
                    "displayName": "Testfile.exe",
                    "fileLength": 15000
                }
            ]
        }]);

        // const lpad = (str, length, defaultCharacter) => {
        //     const remainLength = length - (str + "").length;
        //     return defaultCharacter.repaet(remainLength) + str;
        // }; // lpad임

        // setArticles((prevData) => [...prevData]);
        // console.log(articleData);
    };
    const onClickCancleButtonHandler = () => {
        setViewWriteComponent(!isViewWriteComponent);
    };


    const [isViewWriteComponent, setViewWriteComponent] = useState(false);

    return (
        <div className="wrapper">
            <table className="article-table">
                <thead>
                    <ArticleHeader />
                </thead>
                <tbody>
                    <ArticleList articleData={artcleDatas} />
                </tbody>
            </table>
            {/**게시글 작성 폼 (제목 이메일 내용 정도만) */}
            {/** Math.random() , 을 이용하여 조회수 채우기 (원하면 ) , 제목/이름/이메일을 적으면 목록에 채우도록 , Key추가될수있도록하고, 게시글아이디는 그냥 숫자로 (Length 쓰기) */}
            {isViewWriteComponent === true ? (
                <>

                    <ArticleWriter2
                        onClickSaveButton={onClickSaveButtonHandler}
                        onClickCancleButton={onClickCancleButtonHandler}
                    />
                </>

            ) : (
                <ArticleWrtieBtn
                    onClickCancleButton={onClickCancleButtonHandler} />
            )}


        </div>
    );
};

export default ArticleMain;