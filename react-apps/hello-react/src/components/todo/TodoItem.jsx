/** @format */

import { useRef } from "react";
import { Confirm } from "../Modals";

const TodoItem = ({ todo, priorities, onDoneChange }) => {

    const doneClass = todo.isDone ? "done" : "";
    const isDoneRef = useRef();
    const diagoItemList = useRef();

    const onWorkDoneHanlder = () => {
        // Confirm 불러오기 
        const checked = isDoneRef.current.checked;
        if (checked) {
            diagoItemList.current.showConfirm(todo.todo + " 을(를) 미완료 처리하시겠습니까 ?");
        } else {
            diagoItemList.current.showConfirm(todo.todo + " 을(를) 작업완료 처리하시겠습니까 ?");
        }

        // onAllDoneChange(event.target.checked);

    }

    const onConfirmOkClickHandler = () => {
        onDoneChange(todo.id, !todo.isDone);
    };

    const onConfirmCancleClickHandler = () => {
        // checkboxRef.current.checked = !checkboxRef.current.checked;
    };


    const onDoneChangeHandler = (event) => {

        if (!event.target.value) {
            diagoItemList.current.showConfirm(todo.todo + " 을(를) 미완료 처리하시겠습니까 ?");
        } else {
            diagoItemList.current.showConfirm(todo.todo + " 을(를) 작업완료 처리하시겠습니까 ?");
        }
    };
    return (
        <>
            <li className="tasks-item ">
                <Confirm dialogRef={diagoItemList}
                    onOkClick={onConfirmOkClickHandler}
                    onCloseClick={onConfirmCancleClickHandler} />
                <input id={todo.id} type="checkbox" checked={todo.isDone} onChange={onDoneChangeHandler} ref={isDoneRef} />
                <label className={doneClass} onClick={onWorkDoneHanlder}>{todo.todo}</label>
                <span className={`due-date ${doneClass} `}>{todo.dueDate}</span>
                <span className={`priority ${doneClass} `}>{priorities[todo.priority]}</span>
            </li>
        </>
    );
};

export default TodoItem;

export const TodoItemForChildren = ({ children }) => {
    return <li className="tasks-item ">{children}</li>;
}; 