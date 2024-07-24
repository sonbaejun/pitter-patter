import "./SignUp.css";

import X from "../../assets/img/logo/X.png";
import kakao from "../../assets/img/logo/kakao.png";
import naver from "../../assets/img/logo/naver.png";

function SignUp() {
  return (
    <div className="layout-base">
      <div className="layout-signup">
        <div className="layout-row">
          <img src={X} alt="X" className="icon-x"/>
        </div>
        <div className="layout-row center">
          <h1 className="main-text">회원 가입</h1>
        </div>
        <div className="layout-row" style={{ marginBottom: "2vw" }}></div>
        <div className="layout-column">
          <input
            type="text"
            id="id"
            placeholder="아이디"
            className="input-text"
          />
          <button id="button-check-id">중복 확인</button>
          <input
            type="password"
            id="password"
            placeholder="비밀번호"
            className="input-text"
          />
          <input
            type="password"
            id="password-check"
            placeholder="비밀번호 확인"
            className="input-text"
          />
          <button id="button-signup">회원 가입</button>
          <div className="layout-row end">
            <span className="login">
              이미 계정이 있으신가요? {" "}
              <a href="/login" className="login">
                로그인
              </a>
            </span>
          </div>
          <div className="layout-row center">
            <span className="or">
              또는
            </span>
          </div>
          <div className="layout-row evenly">
            <img src={kakao} alt="kakao" className="icon-social"/>
            <img src={naver} alt="naver" className="icon-social"/>
          </div>
        </div>
      </div>
    </div>
  );
}

export default SignUp;