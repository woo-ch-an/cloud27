/** @format */

import { useRef } from "react";

const ArticleLoginSection = ({ testevent, errors }) => {
    const loginEmail = useRef();
    const loginPassword = useRef();

    const onClickloginButton = () => {

        testevent(loginEmail.current.value, loginPassword.current.value);
    };

    return (
        <>
            <input type="text" placeholder="Email" ref={loginEmail} /> {errors?.email && <div> {errors.email} </div>}
            <input type="password" ref={loginPassword} />{errors?.password && <div> {errors.password} </div>}

            <button onClick={onClickloginButton}>login</button>
        </>
    );
}

export default ArticleLoginSection;