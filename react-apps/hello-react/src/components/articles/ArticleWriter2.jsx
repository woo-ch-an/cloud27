/** @format */

import { useState, useRef } from "react";
import Alert from "../Modals.jsx";
import { useImperativeHandle } from "react";
import { isString } from "../../utils/type.js";
import { getValidationResult } from "../../utils/exceptionHandler.js";

const ArticleWriter2 = ({ errorHandleRef, onClickSaveButton, onClickCancleButton }) => {



    const [addError, setAddError] = useState();
    useImperativeHandle(errorHandleRef, () => {
        return {
            setResponseError(fetchError) {
                if (isString(fetchError)) {
                    setAddError(fetchError);
                }
                else {
                    setAddError(getValidationResult(fetchError))
                }
            }
        };
    });

    const subjectRef = useRef();
    const attachFileRef = useRef();
    const contentRef = useRef();

    const alertRef = useRef();

    const onSaveButtonClickHandler = () => {

        if (!subjectRef.current.value) {
            alertRef.current.showModal("제목을 입력해주세요");
            return;
        };
        if (!contentRef.current.value) {
            alertRef.current.showModal("내용을 입력해주세요");
            return;
        };
        onClickSaveButton(
            subjectRef.current.value,
            contentRef.current.value,
            attachFileRef.current.files,
        );

        subjectRef.current.value = "";
        attachFileRef.current.value = "";
        contentRef.current.value = "";
    }

    return (
        <div>
            {isString(addError) && <div>{addError} </div>}
            <div>제목</div>
            <input type="text" ref={subjectRef} />
            <div>첨부파일</div>
            <input type="file" title="첨부파일" ref={attachFileRef} multiple />
            <div> 내용</div>
            <input type="text" ref={contentRef} />

            <div>
                <button type="button" onClick={onSaveButtonClickHandler} > 글 작성하기</button>
            </div>
            <Alert dialogRef={alertRef} />

            <div>
                <button type="button" onClick={onClickCancleButton}> 취소하기</button>
            </div>

        </div >
    )

};

export default ArticleWriter2;