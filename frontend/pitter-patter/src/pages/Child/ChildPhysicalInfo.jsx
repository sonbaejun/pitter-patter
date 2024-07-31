import React from 'react';
import { ContentBody, PhysicalInfoInput, PhysicalInfoHistory, PhysicalInfoHistoryInnerDiv, ImgDiv, InputDiv, InputInnerDiv, AddBtnDiv } from './ChildPhysicalInfoStyle';

// 더미 데이터 배열
const physicalInfoData = [
    { height: '170cm', weight: '60kg', date: '2024.07.08' },
    { height: '165cm', weight: '55kg', date: '2024.07.09' },
    { height: '172cm', weight: '68kg', date: '2024.07.10' },
    { height: '160cm', weight: '50kg', date: '2024.07.11' },
    { height: '175cm', weight: '70kg', date: '2024.07.12' },
    { height: '175cm', weight: '70kg', date: '2024.07.12' },
  ];

function ChildPhysicalInfo() {
    return (
      <ContentBody>
        <PhysicalInfoInput>
            <ImgDiv>
                <img src='/src/assets/img/Game/vs.png'  alt="Attendance Background" />
            </ImgDiv>
            <InputDiv>
                <InputInnerDiv>
                    <div>
                        <label>현재 키</label>
                    </div>
                    <input type="text" placeholder="키를 입력하세요" />
                </InputInnerDiv>
                <InputInnerDiv>
                    <div>
                        <label>현재 몸무게</label>
                    </div>
                    <input type="text" placeholder="키를 입력하세요" />
                </InputInnerDiv>
            </InputDiv>
            <AddBtnDiv>
                <button>추가</button>
            </AddBtnDiv>
        </PhysicalInfoInput>
        <PhysicalInfoHistory>
            <PhysicalInfoHistoryInnerDiv>
                {physicalInfoData.map((info, index) => (
                    <div key={index}>
                        <span>키: {info.height} 몸무게: {info.weight}</span>
                        <span>{info.date}</span>
                        <button>삭제하기</button>
                    </div>
                ))}
            </PhysicalInfoHistoryInnerDiv>
        </PhysicalInfoHistory>
      </ContentBody>
    );
  }
  
  export default ChildPhysicalInfo;
