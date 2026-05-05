/** @format */

import { useRef } from "react";
import { Confirm } from "../Modals";
import { useContext } from "react";
import TodoContext from "./context/TodoContext.jsx";
import { useDispatch, useSelector } from "react-redux";
import { fetchAllDoneTodo, fetchTodoList } from "../../http/todo/fetchTodo.js";
import { todoAction } from "../../store/toolkit/slices/todoSlice.js";
const TodoHeader = () => {

    console.log("TodoHeader");

    const reactReduxDispacher = useDispatch();


    const diaolgConfirmRef = useRef();
    const checkboxRef = useRef();
    const { componentName } = useContext(TodoContext);


    //react-redux store 가져오기 (todo만)
    const { list: todoList } = useSelector((store) => store.todo);
    const count = {
        all: todoList.length,
        done: todoList.filter((todo) => todo.done).length, // isDone = True 인 배열을 뽑아서 그 길이를 재겠다
        process: todoList.filter((todo) => !todo.done).length, //  ** = false 인 배열을 뽑아서 그 길이를 재겠따
    }

    // 잘못된 위치면 그냥 안띄우기 
    if (!componentName || componentName !== "TodoList") {
        return <></>;
    }

    const onAllDoneChangeHandler = () => {
        const checked = checkboxRef.current.checked;

        if (checked) {
            diaolgConfirmRef.current.showConfirm("모든 아이템들을 작업완료 처리하시겠습니까 ?");
        } else {
            diaolgConfirmRef.current.showConfirm("모든 아이템들을  미완료 처리하시겠습니까 ?");
        }

        // onAllDoneChange(event.target.checked);
    }

    // 사용자가 
    const onConfirmOkClickHandler = async () => {
        reactReduxDispacher(todoAction.allDone());
        const fetchAllDoneResult = await fetchAllDoneTodo();

        if (fetchAllDoneResult.errors) {
            alert(fetchAllDoneResult.errors);
        }
        const fetchResult = await fetchTodoList();

        reactReduxDispacher(todoAction.refresh(fetchResult.body));




        checkboxRef.current.checked = !checkboxRef.current.checked;
    };

    const onConfirmCancleClickHandler = () => {
        checkboxRef.current.checked = !checkboxRef.current.checked;
    };

    return (
        <>
            <li className="tasks-counter">
                <div>전체: {count.all}</div>
                <div>진행중 :{count.process}</div>
                <div>완료 : {count.done}</div>
            </li>
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
        </>
    );
};

export default TodoHeader;
