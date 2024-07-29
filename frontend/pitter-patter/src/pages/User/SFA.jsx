import { useState, useEffect } from 'react';
import "./SFA.css";

import ArrowLeft from "../../assets/icons/ArrowLeft.png";
import BackSpace from "../../assets/icons/BackSpace.png";

function SFA() {
  const [password, setPassword] = useState("");

  const handleKeyPress = (value) => {
    if (password.length < 4) {
      setPassword(password + value);
    }
  };

  const handleBackspace = () => {
    setPassword(password.slice(0, -1));
  };

  useEffect(() => { // TODO: axios 요청 보내는 코드로 대체
    if (password.length === 4) {
      setTimeout(() => {
        alert(`입력된 암호: ${password}`);
        setPassword("");
      }, 100); // 이거 안 하면 점 덜 채워진 채로 alert 뜸..
    }
  }, [password]);

  return (
    <div className="layout-base">
      <div className="layout-column layout-sfa around">
        <div className="layout-row" style={{ height: "10vh" }}>
          <img src={ArrowLeft} alt="ArrowLeft" className="icon-x" />
        </div>
        <span>2차 비밀번호를 입력해주세요</span>
        <div className="layout-row evenly dot-wrap">
          {[...Array(4)].map((_, i) => (
            <div key={i} className={`password-dot ${i < password.length ? 'filled' : ''}`}></div>
          ))}
        </div>
        <div className="numpad-wrap">
          <div className="numpad-row evenly">
            <div className="numpad" onClick={() => handleKeyPress(1)}>1</div>
            <div className="numpad" onClick={() => handleKeyPress(2)}>2</div>
            <div className="numpad" onClick={() => handleKeyPress(3)}>3</div>
          </div>
          <div className="numpad-row evenly">
            <div className="numpad" onClick={() => handleKeyPress(4)}>4</div>
            <div className="numpad" onClick={() => handleKeyPress(5)}>5</div>
            <div className="numpad" onClick={() => handleKeyPress(6)}>6</div>
          </div>
          <div className="numpad-row evenly">
            <div className="numpad" onClick={() => handleKeyPress(7)}>7</div>
            <div className="numpad" onClick={() => handleKeyPress(8)}>8</div>
            <div className="numpad" onClick={() => handleKeyPress(9)}>9</div>
          </div>
          <div className="numpad-row evenly">
            <div className="numpad"></div>
            <div className="numpad" onClick={() => handleKeyPress(0)}>0</div>
            <div className="numpad" onClick={handleBackspace}>
              <img src={BackSpace} alt="BackSpace" className="icon-backspace" />
            </div>
          </div>
        </div>
        <div className="forgot-password">비밀번호를 잊으셨나요?</div>
      </div>
    </div>
  );
}

export default SFA;
