import React from 'react';
import styled from "styled-components";
import { Link } from 'react-router-dom';

const Navbar = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  max-height: 25%;
  background: white;
  padding: 10px 20px;
  position: fixed;
  top: 0;
  z-index: 1000;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
`;

const NavXContainer = styled.div`
  position: fixed;
  top: 10px;
  right: 20px;
  z-index: 1001;
`;

const NavItemWrap = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 15px;
  width: 15vw;
  cursor: pointer;
`;

const NavIcon = styled.img`
  width: 50%;
  margin-right: 10px;
  margin-bottom: 10px;
`;

const NavText = styled.div`
  font-size: 1rem;
`;

const LayoutNav = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: center; 
  align-items: center;
  flex: 1; 
`;

const CloseButtonImg = styled.img`
  width: 20px;
  height: 20px;
  cursor: pointer;
`;

function MenuModal({ isOpen, onClose }) {
  if (!isOpen) {
    return null;
  }

  return (
    <>
      <Navbar>
        <LayoutNav>
          <Link to='/game/select-mode'>
            <NavItemWrap>
              <NavIcon src='/src/assets/img/NavBar/toGame.png' alt="game" />
              <NavText>게임 시작하기</NavText>
            </NavItemWrap>
          </Link>
          <Link to='/shop'>
            <NavItemWrap>
              <NavIcon src="/src/assets/img/NavBar/toMarket.png" alt="market" />
              <NavText>상점 둘러보기</NavText>
            </NavItemWrap>
          </Link>
          <Link to='/rank'>
            <NavItemWrap>
              <NavIcon src="/src/assets/img/NavBar/toRanking.png" alt="ranking" />
              <NavText>랭킹 확인하기</NavText>
            </NavItemWrap>
          </Link>
          <Link to='/SFA'>
            <NavItemWrap>
              <NavIcon src="/src/assets/img/NavBar/toMypage.png" alt="mypage" />
              <NavText>마이 페이지</NavText>
            </NavItemWrap>
          </Link>
        </LayoutNav>
      </Navbar>
      <NavXContainer>
        <CloseButtonImg src="/src/assets/icons/X.png" alt="close" onClick={onClose} />
      </NavXContainer>
    </>
  );
}

export default MenuModal;
