import "./SelectProfile.css";

import PlusSquare from "../../assets/icons/PlusSquare.png";

function SelectProfile() {
  return (
    <div className="layout-base">
      <div className="layout-profile-wrap">
        <div className="layout-column center">
          <div className="main-text">플레이어를 선택해주세요.</div>
          <div className="profile-list">
            <div className="profile">
              <div className="profile-image">
              </div>
              <span className="user-id">user01</span>
            </div>
            <div className="profile">
              <div className="profile-image">
              </div>
              <span className="user-id">user02</span>
            </div>
            <div className="profile">
              <div className="profile-image">
              </div>
              <span className="user-id">user03</span>
            </div>
            <div className="profile">
              <div className="profile-image profile-add">
                <img src={PlusSquare} alt="PlusSquare" className="icon-plus"/>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SelectProfile;