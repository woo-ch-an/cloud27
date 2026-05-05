/** @format */

import { useRef, useContext } from "react";
import { Confirm } from "../Modals";
import { TodoContext } from "./contexts/todocontext";

const TodoItem = ({ id, priorities }) => {

    const { getTodo, done } = useContext(TodoContext);

    const todoItem = getTodo(id);

    const doneClass = todoItem.done ? "done" : "";
    const isDoneRef = useRef();
    const diagoItemList = useRef();

    const onWorkDoneHanlder = () => {
        // Confirm 불러오기 
        const checked = isDoneRef.current.checked;
        if (checked) {
            diagoItemList.current.showConfirm(todoItem.todo + " 을(를) 미완료 처리하시겠습니까 ?");
        } else {
            diagoItemList.current.showConfirm(todoItem.todo + " 을(를) 작업완료 처리하시겠습니까 ?");
        }

        // onAllDoneChange(event.target.checked);

    }

    const onConfirmOkClickHandler = () => {
        done(todoItem.id, !todoItem.done);
    };

    const onConfirmCancleClickHandler = () => {
        // checkboxRef.current.checked = !checkboxRef.current.checked;
    };


    const onDoneChangeHandler = (event) => {

        if (!event.target.value) {
            diagoItemList.current.showConfirm(todoItem.todo + " 을(를) 미완료 처리하시겠습니까 ?");
        } else {
            diagoItemList.current.showConfirm(todoItem.todo + " 을(를) 작업완료 처리하시겠습니까 ?");
        }
    };
    return (
        <>
            <li className="tasks-item ">
                <Confirm dialogRef={diagoItemList}
                    onOkClick={onConfirmOkClickHandler}
                    onCloseClick={onConfirmCancleClickHandler} />
                <input id={todoItem.id} type="checkbox" checked={todoItem.done} onChange={onDoneChangeHandler} ref={isDoneRef} />
                <label className={doneClass} onClick={onWorkDoneHanlder}>{todoItem.todo}</label>
                <span className={`due-date ${doneClass} `}>{todoItem.dueDate}</span>
                <span className={`priority ${doneClass} `}>{priorities[todoItem.priority]}</span>
            </li>
        </>
    );
};

export default TodoItem;

export const TodoItemForChildren = ({ children }) => {
    return <li className="tasks-item ">{children}</li>;
}; 