/** @format */

import { useState } from "react";

const Caclurator = () => {
    const [{ num1, num2, value }, setNums] = useState({
        num1: 0,
        num2: 0,
        value: 0,
    });

    // const [num1, setNum1Value] = useState(0);
    // const [num2, setNum2Value] = useState(0);
    // const [value, setValue] = useState(0);

    const onChangeFirstNumber = (event) => {
        setNums((prevNums) => {
            const newNums = { ...prevNums, num1: parseInt(event.target.value) };
            return newNums;
        });

    };
    const onChnageSecondNumber = (event) => {
        setNums((prevNums) => {
            const newNums = { ...prevNums, num2: parseInt(event.target.value) };
            return newNums;
        });
    };

    const onCalcButtonClickHandler = (operator) => {
        let value = 0;


        if (operator === "+") {
            value = num1 + num2;
        } else if (operator === "-") {
            value = num1 - num2;
        } else if (operator === "*") {
            value = num1 * num2;
        } else if (operator === "/") {
            value = (num1 / num2);
        }

        setNums((prevNums) => {
            const newNums = { ...prevNums, value };
            return newNums;
        });

    };

    return (
        <div className="calcurator-wrapper">
            <div>
                <input type="number" value={num1} onChange={onChangeFirstNumber} />
            </div>
            <div className="operators">
                <div>
                    <button onClick={onCalcButtonClickHandler.bind(this, "+")}>+</button>

                </div>
                <div>
                    <button onClick={onCalcButtonClickHandler.bind(this, "-")}>-</button>

                </div>
                <div>

                    <button onClick={onCalcButtonClickHandler.bind(this, "*")}>*</button>
                </div>
                <div>
                    <button onClick={onCalcButtonClickHandler.bind(this, "/")}>/</button>

                </div>
            </div>
            <div>
                <input type="number" value={num2} onChange={onChnageSecondNumber} />
            </div>
            <div>
                <span> = </span>
            </div>
            <div>
                <p>{value}</p>
            </div>

        </div>
    )
};

export default Caclurator;