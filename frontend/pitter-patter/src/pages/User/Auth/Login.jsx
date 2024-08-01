import React from 'react';
import styled from 'styled-components';
import {
  LayoutBase,
  LayoutLogin,
  MainText,
  ButtonLogin,
  ForgotPassword,
  SignUp,
} from './LoginStyle.jsx';
import X from "../../../assets/img/logo/X.png";
import kakao from "../../../assets/img/logo/kakao.png";
import naver from "../../../assets/img/logo/naver.png"; 

const IconX = styled.img`
  width: 1.5vw;
  cursor: pointer;
  position: absolute;
`;

const InputText = styled.input`
  padding: 1vw;
  /* margin-bottom: 1vw; */
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1vw;
`;

const CenterText = styled.span`
  font-size: 1vw;
  color: #757575;
  margin: 2vh 0;
`;

const SocialIcon = styled.img`
  width: 3vw;
  cursor: pointer;
`;

function Login() {
  return (
    <LayoutBase>
      <LayoutLogin>
        <div style={{ display: 'flex', justifyContent: 'flex-start', width: '80%' }}>
          <IconX src={X} alt="X" />
        </div>
        <div style={{ display: 'flex', justifyContent: 'center', width: '100%' }}>
          <MainText>로그인</MainText>
        </div>
        <div style={{ marginBottom: '1vw' }}></div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: '.5vw' }}>
          <InputText
            type="text"
            id="id"
            placeholder="아이디"
          />
          <InputText
            type="password"
            id="password"
            placeholder="비밀번호"
          />
          <div style={{ display: 'flex', justifyContent: 'flex-end', alignItems: 'flex-start', width: '100%' }}>
            <ForgotPassword href="/forgot-password">비밀번호를 잊으셨나요?</ForgotPassword>
          </div>
          <ButtonLogin>로그인</ButtonLogin>
          <div style={{ display: 'flex', justifyContent: 'flex-end', alignItems: 'center', width: '100%' }}>
            <SignUp>
              계정이 없으신가요? <a href="/signup">회원가입</a>
            </SignUp>
          </div>
          <div style={{ display: 'flex', justifyContent: 'center', width: '100%' }}>
            <CenterText>또는</CenterText>
          </div>
          <div style={{ display: 'flex', justifyContent: 'space-evenly', width: '100%' }}>
            <SocialIcon src={kakao} alt="kakao" />
            <SocialIcon src={naver} alt="naver" />
          </div>
        </div>
      </LayoutLogin>
    </LayoutBase>
  );
}

export default Login;
