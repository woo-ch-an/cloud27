// ecma function (fat arrow function) fat(=) arrow(>)
// const : 상수를 정의하는 키워드
// (parameter) => {function body} : fat arrow funtion

import { useState } from "react";
import { StateTest } from "./StateTest.jsx";
import TodoAppender from "./TodoAppender.jsx";
import TodoHeader from "./TodoHeader.jsx";
import TodoList from "./TodoList.jsx";

// function 과 fat arrow function 의 기능적 차이
// function => 함수를 호출한 대상을 this 객체로알수있음
// fat arrow function => this 없음 ( 함수 호출한 대상 없나 ?
// 그건아니고 event 파라미터로 어떻게 잘 돌리면 알 수 있음

// export default 이후에 const 키워드가 나타날 수 없음
const TodoMain = () => {
    const priorities = ["영", "높음", "보통", "낮음"];
    // const 상수정의 
    // let   변수정의 (반복문 아님 안쓰는데 그마저도 적음)
    // 암튼 JSON DATA 만들기
    const todoDatas = [
        { id: "todo_1", todo: "React Component Master", dueDate: "2026-04-22", priority: 2, isDone: true }
        , { id: "todo_2", todo: "React Component Major", dueDate: "2026-04-12", priority: 1, isDone: false }
        , { id: "todo_3", todo: "React Component Seargeant", dueDate: "2026-04-02", priority: 3, isDone: false }
        , { id: "todo_4", todo: "끼얏호우", dueDate: "2026-02-02", priority: 3, isDone: false },
    ];

    const [cachedData, setCachcedData] = useState(todoDatas);
    const [{ todo, dueDate, priority }, setNewTodoData] = useState({
        todo: "", dueDate: "", priority: 0,
    });
    const onAllDoneChangeHandler = (isDone) => {
        // cachedData 를 반복하면서 모든 isDone의 모든 값을 변경하고 변경된 결과를 반환한다
        setCachcedData((prevdData) => {
            const newData = prevdData.map((todo) => ({ ...todo, isDone }));
            return newData;
        });

    };

    // todo의 isDone 을 반전시키는 함수. 가 필요함.
    // 이 함수를 todo List 에게 props로 전달
    // TodoList는 todoItem에게 함수를 props 전달 

    const onDoneChangeHandler = (todoId, isDone) => {
        setCachcedData((prevdData) => {
            const newStateMemory = [...prevdData];

            // java foreach
            for (const todo of newStateMemory) {
                if (todo.id === todoId) {
                    todo.isDone = isDone;
                    break;
                }
            }
            return newStateMemory;
        });
    };

    const onTaskKeyUpHandler = (event) => {
        setNewTodoData((prevdData) => ({
            ...prevdData, todo: event.target.value
        }));
    };
    const onDateChangeHandler = (event) => {

        setNewTodoData((prevdData) => ({
            ...prevdData, dueDate: event.target.value
        }));
    };
    const onSaveButtonClickHandler = () => {
        console.log("저장할게요~")
        setCachcedData((prevdData) => [...prevdData, { id: "todo_" + (prevdData.length + 1), todo, dueDate, priority, isDone: false }])
        setNewTodoData({ todo: "", dueDate: " ", priority: 0 });

    };
    const onProiortySelectChangeHandler = (event) => {

        setNewTodoData((prevdData) => ({
            ...prevdData, priority: parseInt(event.target.value)
        }));
    };
    // 컴포넌트가 만들어줄 HTML Tag set 반환
    return (
        <div className="wrapper">
            {/* <StateTest /> */}
            <header>React Todo </header>
            <ul className="tasks">
                <TodoHeader onAllDoneChange={onAllDoneChangeHandler} />
                <TodoList onDoneChange={onDoneChangeHandler} todoDatas={cachedData} priorities={priorities} />
            </ul>
            <TodoAppender
                inputData={{ todo, dueDate, priority }}
                onTaskKeyUp={onTaskKeyUpHandler} onDateChange={onDateChangeHandler} onSaveButtonClick={onSaveButtonClickHandler} onProiortySelectChange={onProiortySelectChangeHandler} />
        </div >
    );
};
export default TodoMain;



