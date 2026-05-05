/** @format */

import { useRef } from "react";
import Alert from "../Modals.jsx";

const ArticleWriter2 = ({ onClickSaveButton, onClickCancleButton }) => {


    const subjectRef = useRef();
    const nameRef = useRef();
    const emailRef = useRef();
    const contentRef = useRef();

    const alertRef = useRef();

    const onSaveButtonClickHandler = () => {

        if (!subjectRef.current.value) {
            alertRef.current.showModal("제목을 입력해주세요");
            return;
        };
        if (!nameRef.current.value) {
            alertRef.current.showModal("이름을 입력해주세요");
            return;
        };
        if (!emailRef.current.value) {
            alertRef.current.showModal("이메일을 입력해주세요");
            return;
        };
        if (!contentRef.current.value) {
            alertRef.current.showModal("내용을 입력해주세요");
            return;
        };
        onClickSaveButton(
            subjectRef.current.value,
            nameRef.current.value,
            emailRef.current.value,
            contentRef.current.value,
        );

        subjectRef.current.value = "";
        nameRef.current.value = "";
        emailRef.current.value = "";
        contentRef.current.value = "";
    }

    return (
        <div>
            <div>제목</div>
            <input type="text" ref={subjectRef} />
            <div> 이메일</div>
            <input type="text" ref={emailRef} />
            <div> 아이디</div>
            <input type="text" ref={nameRef} />
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