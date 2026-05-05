/** @format */

import { useState } from "react";
import TrendHeader from "./TrendHeader.jsx";
import TrendList from "./TrendList.jsx";

const TrendBox = (trendDatas) => {


    const [{ sectionName, selectorsKR, items }] = useState(trendDatas.trendDatas);

    const [selectedTrend, setSelectedContent] = useState("today");

    const onClickTrendChangeEventHandler = (selectedItem) => {
        setSelectedContent(() => (selectedItem === "오늘" ? "today" : "week")
        );

        console.log(selectedTrend);
    };

    return (
        <>
            <TrendHeader sectionName={sectionName} selectors={selectorsKR} onaaClickTrendChangeEvent={onClickTrendChangeEventHandler} ></TrendHeader >

            <TrendList selectedTrend={selectedTrend} items={items[selectedTrend]}></TrendList>
        </>
    );

};

export default TrendBox;