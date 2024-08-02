import React from 'react';
import { LayoutIsReady, LayoutInModal, ModalIcon, Title, Context, Button } from '../../style/modalStyel';
import warningSign from 'src/assets/icons/warningSign.png'; // 이미지 경로가 맞는지 확인하세요

function IsReady() {
  return (
    <LayoutIsReady>
      <LayoutInModal>
        <ModalIcon src={warningSign} alt="Warning Sign" />
      </LayoutInModal>
      <LayoutInModal>
        <Title>스트레칭은 하셨나요?</Title>
      </LayoutInModal>
      <LayoutInModal>
        <Context>안전한 진행을 위해 충분한 몸풀기 운동을 권장합니다.</Context>
      </LayoutInModal>
      <LayoutInModal style={{ marginTop: "10px" }}>
        <Button>시작</Button>
      </LayoutInModal>
    </LayoutIsReady>
  );
}

export default IsReady;
