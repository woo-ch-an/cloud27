/** @format */
const ArticleWriter = ({ inputData: { subject, content, email, membersVO }, onChangeSubject, onChangeEmail, onChangeId, onChangeContent, onClickSaveButton, onClickCancleButton }) => {

    if()
    return (
        <div>
            <div>제목</div>
            <input type="text" onChange={onChangeSubject} value={subject} />
            <div> 이메일</div>
            <input type="text" onChange={onChangeEmail} value={email} />
            <div> 아이디</div>
            <input type="text" onChange={onChangeId} value={membersVO.name} />
            <div> 내용</div>
            <input type="text" onChange={onChangeContent} value={content} />

            <div>
                <button type="button" onClick={onClickSaveButton}> 글 작성하기</button>
            </div>


            <div>
                <button type="button" onClick={onClickCancleButton}> 취소하기</button>
            </div>

        </div>
    )

};

export default ArticleWriter;