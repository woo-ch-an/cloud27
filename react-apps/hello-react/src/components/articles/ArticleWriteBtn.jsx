/** @format */


const ArticleWrtieBtn = ({ onClickCancleButton }) => {
    console.log("ArticleWrtieBtn");
    return (
        <div>
            <button onClick={onClickCancleButton}> 글쓰깅 </button>
        </div>
    );
};

export default ArticleWrtieBtn;