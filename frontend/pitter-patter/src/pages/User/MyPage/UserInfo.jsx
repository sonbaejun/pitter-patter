import React from 'react';
import styled from 'styled-components';

import {
  LayoutMyPage,
  Profile,
  MainImg,
  InputWrap,
  InputItem,
  InputTitle,
} from './UserInfoStyle';
import SingingBanana from "../../../assets/img/User/SingingBanana.png";

const InputBox = styled.input`
  width: 15vw;
  padding: 0.5vw;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1vw;
`;

const SelectBox = styled.select`
  width: 15vw;
  padding: 0.5vw;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1vw;
`;

function UserInfo() {
  return (
    <LayoutMyPage>
      <Profile>
        <MainImg src={SingingBanana} alt="SingingBanana" />
      </Profile>
      <InputWrap>
        <InputItem>
          <InputTitle>아이디</InputTitle>
          <InputBox type="text" placeholder="아이디" />
        </InputItem>
        <InputItem>
          <InputTitle>닉네임</InputTitle>
          <InputBox type="text" placeholder="닉네임" />
        </InputItem>
        <InputItem>
          <InputTitle>이름</InputTitle>
          <InputBox type="text" placeholder="이름" />
        </InputItem>
        <InputItem>
          <InputTitle>생년월일</InputTitle>
          <InputBox type="date" placeholder="생년월일" />
        </InputItem>
        <InputItem>
          <InputTitle>성별</InputTitle>
          <SelectBox>
            <option value="male">남자</option>
            <option value="female">여자</option>
          </SelectBox>
        </InputItem>
      </InputWrap>
    </LayoutMyPage>
  )
}

export default UserInfo;
