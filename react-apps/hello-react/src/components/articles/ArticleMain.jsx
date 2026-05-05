/** @format */
// json 불러오기
import ArticleHeader from "./ArticleHeader.jsx";
import ArticleList from "./ArticleList.jsx";
import ArticleWriter from "./ArticleWriter.jsx";
import ArticleWriter2 from "./ArticleWriter2.jsx";
import ArticleWrtieBtn from "./ArticleWriteBtn.jsx"
import ArticleLoginSection from "./ArticleLoginSection.jsx"

// useState 용 import
import { useState } from "react";
import { fetchAddArticle, fetchArticlesList, fetchJsonWebToken } from "../../http/article/fetcharticle.js";
import { useEffect } from "react";
import { isString } from "../../utils/type.js";
import { getValidationResult } from "../../utils/exceptionHandler.js";
import { useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { articleAction } from "../../store/toolkit/slices/articlesSlice.js";

// TODO 글 취소하기 -> Clean , 작가에 닉넴(이메일) , 닉넴이멜 MembersVO에 몰아서 던지기
const ArticleMain = () => {


    const [viewPageNo, setViewPageNo] = useState(0);

    const onPaginationButtonClickHandler = (nextPageNo) => {
        setViewPageNo(nextPageNo);
    };

    console.log("ArticleMain - useSelector");
    const storeDispatcher = useDispatch();


    // const [{ count, result, pageNo, pageCount }, setArticles] = useState(
    //     {
    //         count: 0,
    //         result: [],
    //         pageNo: 0,
    //         pageCount: 0,
    //     }
    // );

    const refreshArticleList = async () => {
        const articles = await fetchArticlesList(viewPageNo);
        // const { result: { count, result }, pagination: { pageNo = 0, pageCount = 0 } } = articles;
        console.log(articles);


        console.log("refreshArticleList");

        storeDispatcher(articleAction.refresh(articles))
        // console.log(articleList);
        // setArticles({ count, result, pageNo, pageCount });

        console.log("--------------------------");
        console.log(result);
        console.log("--------------------------");
    };

    useEffect(() => {
        refreshArticleList();
    }, [viewPageNo]);

    const onClickSaveButtonHandler = async (subject, content, attachFile) => {
        const addReuslt = await fetchAddArticle(token, subject, content, attachFile);

        if (addReuslt.error) {
            writeRef.current.setResponseError(addReuslt.error);
        }

        refreshArticleList();
    };
    const onClickCancleButtonHandler = () => {
        setViewWriteComponent(!isViewWriteComponent);
    };


    // jwt 발행용
    const [token, setToken] = useState("");
    const [loginErorrs, setLoginErrores] = useState();
    const [userInfo, setUserInfo] = useState(
        {
            id: "",
            password: "",
        }
    );

    const writeRef = useRef();
    const requestTokenApiHandler = async () => {
        const fetchToken = await fetchJsonWebToken(userInfo.id, userInfo.password)

        setToken(fetchToken.token);

        if (fetchToken.error) {
            if (isString(fetchToken.error)) {
                setLoginErrores(fetchToken.error);
            } else {
                setLoginErrores(getValidationResult(fetchToken.error));
            }
        }
    };

    useEffect(() => {
        requestTokenApiHandler();
    }, [userInfo]);

    const { list: { result = { count: 0, result: [] }, pagination = { pageNo: 0, pageCount: 0 } } } = useSelector((store) => store.article);
    const onclickLoginEventDebug = (id, password) => {
        console.log("onclickLoginEventDebug");

        const user = {
            id,
            password,
        }

        setUserInfo(user);
    };

    const [isViewWriteComponent, setViewWriteComponent] = useState(false);
    console.log("??");
    console.log(result);
    console.log(result.result);

    return (
        <div className="wrapper">
            {!token && (
                <div>
                    {isString(loginErorrs) && <div> {loginErorrs} </div>}
                </div>
            )}
            <ArticleLoginSection testevent={onclickLoginEventDebug} errors={loginErorrs} />
            <p> 총 {result.count} 개의 게시글이 검색되었습니다</p>
            <table className="article-table">
                <thead>
                    <ArticleHeader />
                </thead>
                <tbody>
                    <ArticleList articleData={result} />
                </tbody>
            </table>
            <div>
                {pagination.pageNo > 0 && (<button onClick={onPaginationButtonClickHandler.bind(this, pagination.pageNo - 1)}>이전</button>)}
                {/* {pageNo === 0 && pageCount - 1 > pageNo && (<button onClick={onPaginationButtonClickHandler.bind(this, pageNo + 1)}>다음</button>)} */}
                {pagination.pageNo < pagination.pageCount - 1 && (<button onClick={onPaginationButtonClickHandler.bind(this, pagination.pageNo + 1)}>다음</button>)}
            </div>

            {/**게시글 작성 폼 (제목 이메일 내용 정도만) */}
            {/** Math.random() , 을 이용하여 조회수 채우기 (원하면 ) , 제목/이름/이메일을 적으면 목록에 채우도록 , Key추가될수있도록하고, 게시글아이디는 그냥 숫자로 (Length 쓰기) */}
            {isViewWriteComponent === true ? (
                <>
                    <ArticleWriter2
                        errorHandleRef={writeRef}
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