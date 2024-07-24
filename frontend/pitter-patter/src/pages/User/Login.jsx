import "./Login.css";
// get src/assets/img
import X from "../../assets/img/logo/X.png";
import kakao from "../../assets/img/logo/kakao.png";
import naver from "../../assets/img/logo/naver.png"; 

function Login() {
  return (
    <div className="layout-base">
      <div className="layout-login">
        <div className="layout-row">
          <img src={X} alt="X" className="icon-x"/>
        </div>
        <div className="layout-row center">
          <h1 className="main-text">로그인</h1>
        </div>
        <div className="layout-row" style={{ marginBottom: "2vw" }}></div>
        <div className="layout-column">
          <input
            type="text"
            id="id"
            placeholder="아이디"
            className="input-text"
          />
          <input
            type="password"
            id="password"
            placeholder="비밀번호"
            className="input-text"
          />
          <div className="layout-row end">
            <a href="/forgot-password" className="forgot-password">
              비밀번호를 잊으셨나요?
            </a>
          </div>
          <button id="button-login">로그인</button>
          <div className="layout-row end">
            <span className="sign-up">
              계정이 없으신가요?{" "}
              <a href="/signup" className="sign-up">
                회원가입
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

export default Login;