/** @format */

const TodoItem = ({ todo, priorities, onDoneChange }) => {

    const doneClass = todo.isDone ? "done" : "";

    const onDoneChangeHandler = () => {
        onDoneChange(todo.id, !todo.isDone);
    };
    return (
        <>
            <li className="tasks-item ">
                <input id={todo.id} type="checkbox" checked={todo.isDone} onChange={onDoneChangeHandler} />
                <label htmlFor={todo.id} className={doneClass} >{todo.todo}</label>
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