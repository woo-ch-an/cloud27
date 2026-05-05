/** @format */
import { useState } from "react";

const Counter = () => {

    const [value, setValue] = useState(0);
    const onButtonClickHandler = (event) => {
        const className = event.target.classList.value;


        setValue((prevCount) => {
            if (className.includes("addtion")) {
                if (prevCount > 99) {
                    return prevCount;
                }
                return prevCount + 1;
            }
            else if (className.includes("reduction")) {
                if (prevCount < 1) {
                    return prevCount;
                }
                return prevCount - 1;
            }
            return prevCount;
        })

    }

    return (
        <div className="counter-wrapper">
            <div className="redution">
                <button className="counter-btn reduction" onClick={onButtonClickHandler}>-</button>
            </div>
            <div className="count-num"> <p>{value}</p></div>
            <div className="addtion">
                <button className="counter-btn addtion" onClick={onButtonClickHandler}>+</button>
            </div>


        </div>
    )
};

export default Counter;