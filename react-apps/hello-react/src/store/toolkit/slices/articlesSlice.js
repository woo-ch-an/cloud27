// ReduxToolkit slice store 생성 
import { createSlice } from "@reduxjs/toolkit";

export const articlesSlice = createSlice({
    name: "article-slice",
    initialState: {
        list: [],
    },
    reducers: {
        refresh(store, action) {
            store.list = action.payload;
        },
    },
});

export const articleAction = articlesSlice.actions;