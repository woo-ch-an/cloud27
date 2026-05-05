/** @format */
import { configureStore } from "@reduxjs/toolkit";
import { todoSlice } from "./slices/todoSlice.js";
import { articlesSlice } from "./slices/articlesSlice";
// import { userSlice } from "./slices/userSlice";
import { Children } from "react";
import { Provider } from "react-redux";

const ToolkitStore = configureStore({
    // toolkitStore 에 slice Sotre 를 등록하기 
    reducer: {
        // todo 이름의 state 만든다
        // it's over anakin i have a high-ground
        todo: todoSlice.reducer,
        article: articlesSlice.reducer,
        // user: userSlice.reducer,
    }
});

export const ToolkitProvider = ({ children }) => {
    return <Provider store={ToolkitStore}> {children} </Provider>;
};
