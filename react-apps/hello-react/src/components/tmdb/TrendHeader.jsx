/** @format */

import TrendSelector from "./TrendSelector.jsx";

const TrendHeader = ({ sectionName, selectors, onaaClickTrendChangeEvent }) => {
    const onClickTrendChangeEventHanlder = (selectedItem) => {

        console.log("onClickTrendChangeEventHanlder" + selectedItem);
        onaaClickTrendChangeEvent(selectedItem);
    };

    return (
        <>
            <div className="treand-head-wrapper">
                <h1> {sectionName} </h1>
                <TrendSelector selectors={selectors} onClickTrendChangeEvent={onClickTrendChangeEventHanlder}></TrendSelector>
            </div >
        </>
    );

};

export default TrendHeader;