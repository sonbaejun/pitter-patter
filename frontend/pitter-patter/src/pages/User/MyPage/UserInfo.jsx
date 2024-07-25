import "./UserInfo.css";
import SingingBanana from "../../../assets/img/User/SingingBanana.png";

function UserInfo() {
  return (
    <div className="layout-mypage">
      <button className="profile">
        <img src={SingingBanana} alt="SingingBanana" className="main-img" />
      </button>
      <div className="input-wrap">
        <div className="input-item">
          <div className="input-title">아이디</div>
          <input type="text" className="input-box" placeholder="아이디" />
        </div>
        <div className="input-item">
          <div className="input-title">닉네임</div>
          <input type="text" className="input-box" placeholder="닉네임" />
        </div>
        <div className="input-item">
          <div className="input-title">이름</div>
          <input type="text" className="input-box" placeholder="이름" />
        </div>
        <div className="input-item">
          <div className="input-title">생년월일</div>
          <input type="date" className="input-box" placeholder="생년월일" />
        </div>
        <div className="input-item">
          <div className="input-title">성별</div>
          <select className="input-box">
            <option value="male">남자</option>
            <option value="female">여자</option>
          </select>
        </div>
      </div>
    </div>
  )
}

export default UserInfo;