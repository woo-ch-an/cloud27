/** @format */

import { useRef, useContext } from "react";
import { Confirm } from "../Modals";
import { TodoContext } from "./contexts/todocontext.jsx";
const TodoHeader = () => {

    const { allDone } = useContext(TodoContext);


    const diaolgConfirmRef = useRef();

    const checkboxRef = useRef();

    const onAllDoneChangeHandler = () => {
        const checked = checkboxRef.current.checked;


        if (checked) {
            diaolgConfirmRef.current.showConfirm("모든 아이템들을 작업완료 처리하시겠습니까 ?");
        } else {
            diaolgConfirmRef.current.showConfirm("모든 아이템들을  미완료 처리하시겠습니까 ?");
        }

        // onAllDoneChange(event.target.checked);
    }

    const onConfirmOkClickHandler = () => {
        // onAllDoneChange(checkboxRef.current.checked);
        allDone(checkboxRef.current.checked);
    };

    const onConfirmCancleClickHandler = () => {
        checkboxRef.current.checked = !checkboxRef.current.checked;
    };

    return (
        <li className="tasks-header">
            <Confirm dialogRef={diaolgConfirmRef}
                onOkClick={onConfirmOkClickHandler}
                onCloseClick={onConfirmCancleClickHandler}
            />

            <input id="checkall" type="checkbox" onChange={onAllDoneChangeHandler} ref={checkboxRef} />
            <label>Task</label>
            <span className="due-date">Due date</span>
            <span className="priority">1</span>
        </li>
    );
};

export default TodoHeader;
