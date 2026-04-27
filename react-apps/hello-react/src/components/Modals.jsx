/** @format */

import { useImperativeHandle, useState, useRef } from "react";
import { createPortal } from "react-dom";


export const Alert = ({ dialogRef }) => {
    const alertModleRef = useRef();

    const handledFromEvents = useRef({
        fired: false,
    });


    const onCloseNative = () => {
        if (!handledFromEvents.fired) {
            onCloseClickHandler();
        }
    };

    const [errorMessage, setErrorMessage] = useState();

    useImperativeHandle(dialogRef, () => {

        handledFromEvents.fired = true;
        // DialogRef 에게 할당해줄 데이터 들을 반환
        return {
            showModal(message) {
                alertModleRef.current.showModal();
                setErrorMessage(message);
            },
        };

    });
    /**
     * Props로 전달된 ref에게 dom이 아닌 함수 객체를 전달하기위한 방법 
     * 부모 컴포넌트 에게 전달 해줄 데이터 들 (함수나 객체 나 변수나 상수 등등)
     * 부모에게 전달해줄 데이터들은 Props로 전달한 ref에 담아서 전달
     */

    const onCloseClickHandler = () => {
        alertModleRef.current.close();
    };

    return (
        <>
            {
                createPortal(
                    <dialog className="modal" ref={alertModleRef} onClose={onCloseNative} >
                        <div className="modal-body">
                            <section className="modal-close-button" onClick={onCloseClickHandler}>X</section>
                            <div> {errorMessage} </div>
                        </div>
                    </dialog >
                    , document.querySelector("#modals"))
            }

        </>
    );
};

export const Confirm = ({ dialogRef, onOkClick, onCloseClick }) => {
    const confirmModalRef = useRef();

    const handledFromEvents = useRef({
        fired: false,
    });
    const [infoMessage, setInfoMessage] = useState();
    const onOkClickHandler = () => {
        handledFromEvents.fired = true;
        confirmModalRef.current.close();
        onOkClick();
    }
    const onCloseClickHandler = () => {
        handledFromEvents.fired = true;
        confirmModalRef.current.close();
        onCloseClick();
    }

    useImperativeHandle(dialogRef, () => {
        // DialogRef 에게 할당해줄 데이터 들을 반환 
        return {
            showConfirm(message) {
                confirmModalRef.current.showModal();
                setInfoMessage(message);
            },
        };

    });

    const onCloseNative = () => {
        console.log("onCloseNative");
        if (!handledFromEvents.fired) {

            onCloseClick();
        }

        handledFromEvents.fired = false;
    };

    return (
        <>
            {
                createPortal(<dialog className="modal" ref={confirmModalRef} onClose={onCloseNative} >
                    <div className="modal-body">
                        {infoMessage}
                        <section>
                            <button type="button" className="confirm-ok" onClick={onOkClickHandler}>
                                OK
                            </button>
                            <button
                                type="button"
                                className="confirm-cancel"
                                onClick={onCloseClickHandler}
                            >
                                Cancel
                            </button>
                        </section>
                    </div>
                </dialog >, document.querySelector("#modals"))}
        </>
    );
};
export default Alert;