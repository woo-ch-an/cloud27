// ReduxToolkit slice store 생성 
import { createSlice } from "@reduxjs/toolkit";

export const todoSlice = createSlice({
    name: "todo-slice", // action 의 Type (간접적 사용 Redux가 이 값을 참조함 )
    initialState: {
        list: [],
    },
    reducers: {

        refresh(store, action) {
            store.list = action.payload; // 가변객체라 막 써도 되긴하는데 메모리를변경해서는 안됨

        }, // 여기 함수가 State를 변경할 예정
        doneItem(store, action) {
            // store.list에서 id가 action과 같은 todo의 인덱스를찾아와서
            const index = store.list.findIndex((todo) => todo.id === action.payload);

            // 해당 인덱스 찾아가서 값 바꾸기
            store.list[index].done = true;
        },
        allDone(store) {
            store.list = store.list.map((todo) => ({ ...todo, done: true }));
        },

    },
});

export const todoAction = todoSlice.actions;