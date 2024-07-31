import React from 'react';
import styled from "styled-components";
import home from '/src/assets/img/Landing/home.png';

const ModalOverlay = styled.div`
  display: flex;
  justify-content: end;
  align-items: center;
  padding-right: 20px;
`;

const ModalContent = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 10px;
  background: white;
  padding: 10px;
  border-radius: 20px;
  width: 20%;
  box-shadow: 0px 11px 39.6px 0px rgba(0, 0, 0, 0.25);
`;

const GridItem = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const ProfilePicture = styled.img`
  width: 5vw;
  height: 5vw;
  border-radius: 100%;
  background-color: gray;
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
