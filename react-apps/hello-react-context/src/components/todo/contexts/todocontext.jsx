
import { createContext, useState } from "react";

export const TodoContext = createContext({
    todos: [],
    done(todoId, doneStatus) { },
    alldone(doneStatus) { },
    addTodo(taskName, dueDate, priority) { },
    getTodo(todoId) { },

});



const TodoContextProvider = ({ children }) => {
    // todo context를 제공하는 컴포넌트 역할

    const todoDatas = [
        { id: "todo_1", todo: "React Component Master", dueDate: "2026-04-22", priority: 2, isDone: true }
        , { id: "todo_2", todo: "React Component Major", dueDate: "2026-04-12", priority: 1, isDone: false }
        , { id: "todo_3", todo: "React Component Seargeant", dueDate: "2026-04-02", priority: 3, isDone: false }
        , { id: "todo_4", todo: "끼얏호우", dueDate: "2026-02-02", priority: 3, isDone: false },
    ];


    const [cachedData, setCachcedData] = useState(todoDatas);

    const todoContextProps = {
        todos: cachedData,
        done(todoId, doneStatus) {
            setCachcedData((prevData) => {
                // const newStateMemory = [...prevdData];

                // java foreach
                // for (const todo of newStateMemory) {
                //     if (todo.id === todoId) {
                //         todo.isDone = doneStatus;
                //         break;
                //     }
                // }
                const newStateMemory = prevData.map((todo) => {
                    if (todo.id === todoId) {
                        todo.isDone = doneStatus;
                    }
                    return todo;
                });

                return newStateMemory;
            });
        },
        allDone(doneStatus) {
            setCachcedData((prevdData) => {
                const newData = prevdData.map((todo) => ({ ...todo, isDone: doneStatus }));
                return newData;
            });

        },
        addTodo(taskName, dueDate, priority) {
            console.log("저장할게요~")

            setCachcedData((prevdData) => [...prevdData, { id: "todo_" + (prevdData.length + 1), todo: taskName, dueDate, priority, isDone: false }])
        },
        getTodo(todoId) {
            const todo = cachedData.find((eachTodo) => eachTodo.id === todoId);

            console.log(todo);
            return todo; // 없으면 undefinded 뜸
        },
    };

    // Context 의 Provider 값을 공유받을 수 있는 컴포넌트는 Context.Provider의 자식 컴포넌틈나 대상 
    return <TodoContext.Provider value={todoContextProps}>
        {children} {/** 얘는 공유받는 얘가 될 예정 */}
    </TodoContext.Provider>
};

export default TodoContextProvider;