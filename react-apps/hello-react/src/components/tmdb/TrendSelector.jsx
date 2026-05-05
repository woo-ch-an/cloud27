/** @format */

const TrendSelector = ({ onClickTrendChangeEvent }) => {

    const onClickTrendChangeHandler = (event) => {
        console.log("onClickTrendChangeHandler" + event.target.value);
        console.log(event.target);
        console.log(event.target);
        onClickTrendChangeEvent(event.target.value);

    }

    return (
        <>
            {/* <div className="display-flex-div">
                <div onClick={onClickTrendChangeHandler} value="오늘">
                    오늘
                </div>
                <div onClick={onClickTrendChangeHandler} value="이번 주">
                    이번 주
                </div> 
            </div> */}

            <input name="aa" type="radio" onClick={onClickTrendChangeHandler} value="오늘" />오늘
            <input name="aa" type="radio" onClick={onClickTrendChangeHandler} value="이번주" />이번 주


            {/* {
                selectors.map((selector) => (
                    <button key={selector} type="button" onClick={onClickTrendChangeHandler}>{selector}</button>
                ))
            } */}
        </>
    )
};

export default TrendSelector;