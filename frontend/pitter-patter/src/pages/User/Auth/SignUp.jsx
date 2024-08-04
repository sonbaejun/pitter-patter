import { useState } from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import {
  LayoutBase,
  LayoutSignup,
  MainText,
  ButtonCheckId,
  ButtonSignup,
  LoginText,
  ValidationText,
} from './SignUpStyle';
import { Link } from 'react-router-dom';
import X from "../../../assets/img/logo/X.png";
import kakao from "../../../assets/img/logo/kakao.png";
import naver from "../../../assets/img/logo/naver.png";

import { signUp, checkDuplicateEmail } from "/src/pages/User/userApi.js";

const IconX = styled.img`
  width: 1.5vw;
  cursor: pointer;
`;

const InputText = styled.input`
  padding: 1vw;
  margin: .5vw 0;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1vw;
`;

const CenterText = styled.span`
  font-size: 1vw;
  color: #757575;
  margin: 1.5vw 0;
`;

const SocialIcon = styled.img`
  width: 3vw;
  cursor: pointer;
`;

function SignUp() {
  const navigator = useNavigate();

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [passwordCheck, setPasswordCheck] = useState('');
  const [isValidated, setIsValidated] = useState(false);

  const isPasswordValid = () => {
    if (password === passwordCheck) {
      return "";
    } else {
      return "비밀번호가 일치하지 않습니다.";
    }
  };

  const isEmailValid = async () => {
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailRegex.test(email)) {
      setIsValidated(false);
      alert('이메일 형식이 올바르지 않습니다.');
      return;
    }

    try {
      const response = await checkDuplicateEmail(email);
      if (response.status === 200) {
        setIsValidated(true);
        alert('사용 가능한 이메일입니다.');
      }
    } catch (error) {
      if (error.response) {
        if (error.response.status === 409) {
          setIsValidated(false);
          alert('이미 사용중인 이메일입니다.');
        } else {
          setIsValidated(false);
          alert('이메일 중복 확인에 실패했습니다.');
        }
      } else {
        setIsValidated(false);
        alert('네트워크 오류가 발생했습니다. 다시 시도해 주세요.');
      }
    }
  };

  const handleSignUp = async () => {
    if (!isValidated) {
      alert('이메일 중복 확인을 해주세요.');
      return;
    }

    if (isPasswordValid() !== "") {
      alert('비밀번호가 일치하지 않습니다.');
      return;
    }

    const data = {
      email,
      password,
    };

    const response = await signUp(data);
    if (response.data) {
      alert('회원가입이 완료되었습니다.');
      navigator('/login');
    } else {
      alert('회원가입에 실패했습니다.');
    }
  }

  return (
    <LayoutBase>
      <LayoutSignup>
        <div style={{ display: 'flex', justifyContent: 'flex-start', width: '90%' }}>
          <Link to='/'><IconX src={X} alt="X" /></Link>
        </div>
        <div style={{ display: 'flex', justifyContent: 'center', width: '100%' }}>
          <MainText>회원 가입</MainText>
        </div>
        <div style={{ marginBottom: '2vw' }}></div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: '0vw' }}>
          <InputText
            type="text"
            id="email"
            placeholder="이메일"
            onChange={(e) => setEmail(e.target.value)}
          />
          <ButtonCheckId id="button-check-id" onClick={isEmailValid}>
            중복 확인
          </ButtonCheckId>
          <InputText
            type="password"
            id="password"
            placeholder="비밀번호"
            onChange={(e) => setPassword(e.target.value)}
          />
          <InputText
            type="password"
            id="password-check"
            placeholder="비밀번호 확인"
            onChange={(e) => setPasswordCheck(e.target.value)}
          />
          <ValidationText isvalid={isPasswordValid() ? true : undefined}>
            {isPasswordValid()}
          </ValidationText>
          <ButtonSignup id="button-signup" onClick={handleSignUp}>
            회원 가입
          </ButtonSignup>
          <div style={{ display: 'flex', justifyContent: 'center', width: '100%' }}>
            <LoginText>
              이미 계정이 있으신가요? <a href="/login">로그인</a>
            </LoginText>
          </div>
          <div style={{ display: 'flex', justifyContent: 'center', width: '100%' }}>
            <CenterText>또는</CenterText>
          </div>
          <div style={{ display: 'flex', justifyContent: 'space-evenly', width: '100%' }}>
            <SocialIcon src={kakao} alt="kakao" />
            <SocialIcon src={naver} alt="naver" />
          </div>
        </div>
      </LayoutSignup>
    </LayoutBase>
  );
}

export default SignUp;
