import React from 'react';
import { Link } from 'react-router-dom';
import { useState } from 'react';
import {
  LayoutBase,
  LayoutMyPage,
  MenuWrap,
  MenuIcon,
  MenuItemWrap,
  MenuItem,
  MainWrap,
} from './MyPageStyle';
import ArrowLeft from "../../../assets/icons/ArrowLeft.png";
import UserInfo from "./UserInfo";
import ChangePassword from "./ChangePassword"
import DeleteUser from './DeleteUser';

function MyPage() {
  const [modalOpen, setModalOpen] = useState(false);

  return (
    <LayoutBase>
      {/* <DeleteUser /> */}
      <LayoutMyPage>
        <div style={{ display: 'flex', flexDirection: 'row', width: '100%', height: '100%'}}>
          <MenuWrap>
            <div>
              <button>
                <MenuIcon src={ArrowLeft} alt="ArrowLeft" />
              </button>
            </div>
            <MenuItemWrap>
              <MenuItem color='white'><Link to='/userinfo'>프로필 수정</Link></MenuItem>
              <MenuItem><Link to='/changePW'>비밀번호 변경</Link></MenuItem>
              <MenuItem><Link to='/changePW'>2차 비밀번호 변경</Link></MenuItem>
              <button onClick={() => setModalOpen(true)} style={{ border: 'none', background: 'none', padding: 0 }}>
                <MenuItem>회원 탈퇴</MenuItem>
              </button>
            </MenuItemWrap>
            {modalOpen && <DeleteUser onClose={() => setModalOpen(false)} />}
          </MenuWrap>
          <MainWrap>
            <UserInfo />
            {/* <ChangePassword /> */}
          </MainWrap>
        </div>
      </LayoutMyPage>
    </LayoutBase>
  );
}

export default MyPage;
