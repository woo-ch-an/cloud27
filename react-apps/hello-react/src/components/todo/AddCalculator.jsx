import { userCallback, useState } from "react";

const AddCalculator = () => {

    const [addResult, setAddResult] = useState(0);
    const [startNum, setStartNum] = useState(1);

    const [endNum, setEndNum] = useState(1);

    // Startnum ~ endNum  까지 모든 숫자 더해서 Reuslt에 추가

    const add = userCallback(() => {
        let sum = 0;

        for (let i = parseInt(startNum); i <= parseInt(endNum); i++) {
            sum += i;
        }
        setAddResult(sum);
    }, [startNum, endNum]);

    return <div>
        <input type="number" value={startNum} onChange={add} /> ~ {"    "}
        <input type="number" value={endNum} /> = <span> {addResult} </span>
        <div>
            <button type="button" onClick={add}> 계산하기 </button>

        </div>
    </div>

};
export default AddCalculator;