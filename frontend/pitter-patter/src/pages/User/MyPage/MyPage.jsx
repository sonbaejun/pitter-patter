import React from 'react';
import { Link } from 'react-router-dom';
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

function MyPage() {
  return (
    <LayoutBase>
      <LayoutMyPage>
        <div style={{ display: 'flex', flexDirection: 'row', width: '100%', height: '100%'}}>
          <MenuWrap>
            <div>
              <button>
                <MenuIcon src={ArrowLeft} alt="ArrowLeft" />
              </button>
            </div>
            <MenuItemWrap>
              <MenuItem color='white'><Link to='/userinfo'>회원 정보 수정</Link></MenuItem>
              <MenuItem><Link to='/'>자녀 정보 수정</Link></MenuItem>
              <MenuItem><Link to='/'>비밀번호 변경</Link></MenuItem>
              <MenuItem><Link to='/'>회원 탈퇴</Link></MenuItem>
            </MenuItemWrap>
          </MenuWrap>
          <MainWrap>
            <UserInfo />
          </MainWrap>
        </div>
      </LayoutMyPage>
    </LayoutBase>
  );
}

export default MyPage;
