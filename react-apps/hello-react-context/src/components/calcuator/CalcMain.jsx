/**@format */
import Counter from './Counter.jsx';
import Caclurator from './Caclurator.jsx';
const CalcMain = () => {

    return (
        <div className="wrapper">
            <div></div>
            <div className="content-box shadow-at-box">
                <div className="content-header"> 카운터 </div>
                <Counter />
            </div>
            <div className="content-box shadow-at-box">
                <div className="content-header"> 계산기 </div>
                <Caclurator />
            </div>

            <div></div>
        </div>
    );
};

export default CalcMain;

