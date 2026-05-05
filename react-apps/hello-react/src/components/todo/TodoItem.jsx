/** @format */

import { useRef } from "react";
import { Confirm } from "../Modals";
import { useContext } from "react";
import TodoContext from "./context/TodoContext.jsx";
import { fetchDoneTodo, fetchTodoList } from "../../http/todo/fetchTodo.js";
import { useDispatch } from "react-redux";
import { todoAction } from "../../store/toolkit/slices/todoSlice.js";

const TodoItem = ({ todo, priorities }) => {
    const { componentName } = useContext(TodoContext);
    console.log("TodoItem");
    const doneClass = todo.done ? "done" : "";
    const isDoneRef = useRef();
    const diagoItemList = useRef();

    const reactReduxDispatcher = useDispatch();

    const onWorkDoneHanlder = () => {
        // Confirm 불러오기 
        const checked = isDoneRef.current.checked;
        if (checked) {
            diagoItemList.current.showConfirm(todo.task + " 을(를) 미완료 처리하시겠습니까 ?");
        } else {
            diagoItemList.current.showConfirm(todo.task + " 을(를) 작업완료 처리하시겠습니까 ?");
        }

        // onAllDoneChange(event.target.checked);

    }

    const onConfirmOkClickHandler = async () => {
        reactReduxDispatcher(todoAction.doneItem(todo.id));
        const doneResult = await fetchDoneTodo(todo.id);
        if (doneResult.errors) {
            alert(doneResult.errors);
        }

        const fetchResult = await fetchTodoList();
        reactReduxDispatcher(todoAction.refresh(fetchResult.body));
    };

    const onConfirmCancleClickHandler = () => {
        // checkboxRef.current.checked = !checkboxRef.current.checked;
    };


    const onDoneChangeHandler = (event) => {

        if (!event.target.value) {
            diagoItemList.current.showConfirm(todo.task + " 을(를) 미완료 처리하시겠습니까 ?");
        } else {
            diagoItemList.current.showConfirm(todo.task + " 을(를) 작업완료 처리하시겠습니까 ?");
        }
    };

    // 잘못된 위치면 그냥 안띄우기 
    if (!componentName || componentName !== "TodoList") {
        return <></>;
    }

    return (
        <>
            <li className="tasks-item ">
                <Confirm dialogRef={diagoItemList}
                    onOkClick={onConfirmOkClickHandler}
                    onCloseClick={onConfirmCancleClickHandler} />
                <input id={todo.id} type="checkbox" checked={todo.done} onChange={onDoneChangeHandler} ref={isDoneRef} />
                <label className={doneClass} onClick={onWorkDoneHanlder}>{todo.task}</label>
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