// ecma function (fat arrow function) fat(=) arrow(>)
// const : 상수를 정의하는 키워드
// (parameter) => {function body} : fat arrow funtion

import { StateTest } from "./StateTest.jsx";
import TodoAppender from "./TodoAppender.jsx";
import TodoHeader from "./TodoHeader.jsx";
import TodoList from "./TodoList.jsx";
import TodoItem, { TodoItemForChildren } from "./TodoItem.jsx";
import TodoGrid from "./TodoGrid.jsx";
import { useEffect } from "react";
import { fetchTodoList } from "../../http/todo/fetchTodo.js";
import { useDispatch, useSelector } from "react-redux";
import { todoAction } from "../../store/toolkit/slices/todoSlice.js";

// function 과 fat arrow function 의 기능적 차이
// function => 함수를 호출한 대상을 this 객체로알수있음
// fat arrow function => this 없음 ( 함수 호출한 대상 없나 ?
// 그건아니고 event 파라미터로 어떻게 잘 돌리면 알 수 있음

// export default 이후에 const 키워드가 나타날 수 없음
const TodoMain = () => {
    console.log("TodoMain");
    const priorities = ["영", "높음", "보통", "낮음"];


    // const [cachedData, setCachcedData] = useState([]);
    // ReactRedux Stroe에서 todo State를 가져올예정
    const { list: todoList } = useSelector((store) => store.todo);
    console.log(todoList);
    const storeDispatcher = useDispatch();

    const refreshTodoList = async () => {
        const fetchResult = await fetchTodoList();
        storeDispatcher(todoAction.refresh(fetchResult.body));

        console.log(fetchResult);

        if (fetchResult.errors) {
            alert(fetchResult.errors);
        }
    };

    useEffect(() => {
        refreshTodoList();
    }, []);




    // 컴포넌트가 만들어줄 HTML Tag set 반환
    return (
        <div className="wrapper">
            {/* <StateTest /> */}
            <header>React Todo </header>
            <TodoGrid>
                {/* <ul className="tasks"> */}
                <TodoList>
                    <TodoHeader />
                    {todoList.map((todo) => (
                        <TodoItem key={todo.id} todo={todo} priorities={priorities} />

                        // <TodoItemForChildren>
                        //     <input id={todo.id} type="checkbox" />
                        //     <label htmlFor={todo.id}>{todo.todo}</label>
                        //     <span className="due-date">{todo.dueDate}</span>
                        //     <span className="priority">{priorities[todo.priority]}</span>
                        // </TodoItemForChildren>
                    ))}
                </TodoList>
                {/* </ul> */}
            </TodoGrid>
            <TodoAppender />
        </div >
    );
};
export default TodoMain;



