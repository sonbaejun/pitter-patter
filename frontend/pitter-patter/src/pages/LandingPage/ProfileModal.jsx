import React from 'react';
import styled from "styled-components";
import home from '/src/assets/img/Landing/home.png';

const ModalOverlay = styled.div`
  display: flex;
  justify-content: end;
  align-items: start;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  position: fixed;
`;

const ModalContent = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: .5rem;
  background: white;
  padding: 20px;
  border-radius: 25px;
  width: 150px; 
  height: 150px;
  box-shadow: 0px 11px 39.6px 0px rgba(0, 0, 0, 0.25);
  position: absolute;
  right: 30px;
  top: 60px;
`;

const GridItem = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const ProfilePicture = styled.img`
  width: 60px;
  height: 60px;
  border-radius: 50%;
  background-color: #D9D9D9;
`;

function ProfileModal({ isOpen, onClose }) {
  if (!isOpen) return null;

  return (
    <ModalOverlay onClick={onClose}>
      <ModalContent onClick={e => e.stopPropagation()}>
        <GridItem>
          <ProfilePicture src='' alt="자녀 1" />
        </GridItem>
        <GridItem>
          <ProfilePicture src='' alt="자녀 2" />
        </GridItem>
        <GridItem>
          <ProfilePicture src='' alt="자녀 3" />
        </GridItem>
        <GridItem>
          <ProfilePicture src='' alt="자녀 4" />
        </GridItem>
      </ModalContent>
    </ModalOverlay>
  );
}

export default ProfileModal;
