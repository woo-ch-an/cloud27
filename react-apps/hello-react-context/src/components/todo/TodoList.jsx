/** @format */

import { useContext } from "react";
import TodoItem, { TodoItemForChildren } from "./TodoItem.jsx";
import { TodoContext } from "./contexts/todocontext.jsx";

const TodoList = () => {


    // Set 함수는 안들고 와도 되네요 신기 

    const { todos } = useContext(TodoContext);
    const priorities = ["영", "높음", "보통", "낮음"];

    return (
        <>
            {
                todos.map(({ id }) => (
                    <TodoItem key={id} id={id} priorities={priorities} />

                    // <TodoItemForChildren>
                    //     <input id={todo.id} type="checkbox" />
                    //     <label htmlFor={todo.id}>{todo.todo}</label>
                    //     <span className="due-date">{todo.dueDate}</span>
                    //     <span className="priority">{priorities[todo.priority]}</span>
                    // </TodoItemForChildren>
                ))
            }

        </>
    );
};

export default TodoList;
