/** @format */

import { useContext, useRef } from "react";
import Alert from "../Modals";
import { TodoContext } from "./contexts/todocontext.jsx";
const TodoAppender = () => {

    const { addTodo } = useContext(TodoContext);
    const todoRef = useRef();
    const dateRef = useRef();
    const priortyRef = useRef();

    const alertRef = useRef();

    const onClickSaveButtonForAppend = () => {
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

        addTodo(
            todoRef.current.value,
            dateRef.current.value,
            priortyRef.current.value,
        )

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
            <button type="button" onClick={onClickSaveButtonForAppend}>Save</button>
        </footer>
    );
};

export default TodoAppender;
