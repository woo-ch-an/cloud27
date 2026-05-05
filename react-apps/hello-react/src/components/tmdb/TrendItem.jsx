/** @format */

const TrendItem = ({ movieInfo }) => {


    return (
        <>
            <div>
                <img src={movieInfo.poster}></img>
                <p> {movieInfo.name} </p>
                <p> {movieInfo.openDate} </p>
            </div>
        </>
    );
};

export default TrendItem;