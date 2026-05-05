/** @format */

import trendDatas from "./trend.json"
import TrendBox from "./TrendBox.jsx";

const TmdbMain = () => {

    return (<TrendBox trendDatas={trendDatas}> </TrendBox>
    );
};
export default TmdbMain;