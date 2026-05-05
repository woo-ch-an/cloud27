/** @format */

import { memo, useRef } from "react";
import Alert from "../Modals";
import { fetchAddTodo, fetchTodoList } from "../../http/todo/fetchTodo";
import { useDispatch } from "react-redux";
import { useState } from "react";
import { todoAction } from "../../store/toolkit/slices/todoSlice";
const TodoAppender = memo(() => {
    console.log("TodoAppender");

    const [isFetching, setIsFetching] = useState(false);

    const todoRef = useRef();
    const dateRef = useRef();
    const priortyRef = useRef();

    const alertRef = useRef();

    const reactReduxDispatcher = useDispatch();

    const onClickSaveButtonForAppend = async () => {


        if (!todoRef.current.value) {
            alertRef.current.showModal("업무를 입력해주세요");
            return;

        };
        if (!dateRef.current.value) {
            alertRef.current.showModal("날짜를 입력해주세요");
            return;
        };
        if (!priortyRef.current.value || priortyRef.current.value === 0) {
            alertRef.current.showModal("우선순위를 입력해주세요");
            return;
        };
        setIsFetching(true);
        const fetchAddTodoResult = await fetchAddTodo(todoRef.current.value, dateRef.current.value, priortyRef.current.value);

        if (fetchAddTodoResult.errors) {
            alert(fetchAddTodoResult.errors);
        }
        setIsFetching(false);
        const fetchResult = await fetchTodoList();
        reactReduxDispatcher(todoAction.refresh(fetchResult.body));



        todoRef.current.value = "";
        dateRef.current.value = "";
        priortyRef.current.value = "";
    }

    return (
        <footer>
            <Alert dialogRef={alertRef} />
            <input type="text" placeholder="Task" ref={todoRef} />
            <input type="date" ref={dateRef} />
            <select ref={priortyRef}>
                <option value="">우선순위</option>
                <option value="1">높음</option>
                <option value="2">보통</option>
                <option value="3">낮음</option>
            </select>
            <button type="button" disabled={isFetching} onClick={onClickSaveButtonForAppend}> {isFetching ? ". . Saving . ." : "Save"}</button>

        </footer>
    );
});

export default TodoAppender;
