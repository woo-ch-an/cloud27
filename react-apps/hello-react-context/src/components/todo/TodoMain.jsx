// ecma function (fat arrow function) fat(=) arrow(>)
// const : 상수를 정의하는 키워드
// (parameter) => {function body} : fat arrow funtion

import { StateTest } from "./StateTest.jsx";
import TodoAppender from "./TodoAppender.jsx";
import TodoHeader from "./TodoHeader.jsx";
import TodoList from "./TodoList.jsx";
import TodoContextProvider from "./contexts/todocontext.jsx";

// function 과 fat arrow function 의 기능적 차이
// function => 함수를 호출한 대상을 this 객체로알수있음
// fat arrow function => this 없음 ( 함수 호출한 대상 없나 ?
// 그건아니고 event 파라미터로 어떻게 잘 돌리면 알 수 있음

// export default 이후에 const 키워드가 나타날 수 없음
const TodoMain = () => {

    return (
        <div className="wrapper">
            {/* <StateTest /> */}
            <header>React Todo </header>

            <TodoContextProvider>
                <ul className="tasks">
                    <TodoHeader />
                    <TodoList />
                </ul>
                <TodoAppender />
            </TodoContextProvider>

        </div >
    );
};
export default TodoMain;



