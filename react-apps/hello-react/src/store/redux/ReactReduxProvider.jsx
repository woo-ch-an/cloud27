// React Redux Reducer 생성
import { Provider } from "react-redux";
import { createStore } from "redux";
/**
 * 
 * @param {*} store 리액트 리덕스가 관리하는 state 저장소
 * @param {*} action  store의 state을 변경할 객체 ) type,action)
 */
const reactReduxReducer = (
    store = {
        todo: [],
        article: [],
        token: null,
    },
    action,) => {

    console.log(action);

    const { type, payload } = action;
    if (type === "todo-refresh") {
        return { ...store, todo: payload };  //   메모리 바꿔서 바뀌게 인지하도록 
    }

    if (type === "todo-all-done") {
        return {
            ...store, todo: store.todo.map((eachTodo) => ({ ...eachTodo, done: true }))
        }
    }
    if (type === "todo-done-item") {
        return {
            ...store, todo: store.todo.map((eachTodo) => {
                if (eachTodo.id === payload) {
                    eachTodo.done = true;
                }
                return eachTodo;
            })
        }
    }

    return store;
};
// React redux stor 생성
const createReactReduxStore = () => {

    return createStore(reactReduxReducer);

}

// React-Redux-Provider 생성

export const ReactReduxProvider = ({ children }) => {
    const store = createReactReduxStore();
    return <Provider store={store}>{children}</Provider>
};