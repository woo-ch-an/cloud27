/** @format */

import TrendItem from "./TrendItem.jsx";

const TrendList = ({ items }) => {

    console.log(items);


    return (
        <div className="movie-items-wrapper">
            {items.map((item) => (
                <TrendItem key={item.id} movieInfo={item} />
            ))}
        </div>
    );


};

export default TrendList;