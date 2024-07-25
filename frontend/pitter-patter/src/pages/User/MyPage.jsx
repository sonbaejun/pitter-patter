import "./MyPage.css";

import ArrowLeft from "../../assets/icons/ArrowLeft.png";
import UserInfo from "./MyPage/UserInfo";

function MyPage() {
  return (
    <div className="layout-base">
      <div className="layout-my-page">
        <div className="layout-row">
          <div className="layout-column menu-wrap">
            <div>
              <button>
                <img src={ArrowLeft} alt="ArrowLeft" className="menu-icon" />
              </button>
            </div>
            <div className="menu-item-wrap">
              <button className="menu-item menu-item-selected">회원 정보 수정</button>
              <button className="menu-item">자녀 정보 수정</button>
              <button className="menu-item">비밀번호 변경</button>
              <button className="menu-item">회원 탈퇴</button>
            </div>
          </div>
          <div className="layout-column main-wrap">
            <UserInfo />
          </div>
        </div>
      </div>
    </div>
  );
}

export default MyPage;