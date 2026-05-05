import TodoMain from "./components/todo/TodoMain.jsx";
import ArticleMain from "./components/articles/ArticleMain.jsx";
import CalcMain from "./components/calcuator/CalcMain.jsx";
import TmdbMain from "./components/tmdb/TmdbMain.jsx";
import { ReactReduxProvider } from "./store/redux/ReactReduxProvider.jsx";
import { ToolkitProvider } from "./store/toolkit/ToolkitProvider.jsx";

/** @format */
export default function App() {
  return (
    <ToolkitProvider>
      {/* <TodoMain />; */}
      {/* <TmdbMain />; */}
      <ArticleMain />
      {/* <CalcMain /> */}
    </ToolkitProvider>
  )
}
