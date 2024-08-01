import React, { useState } from 'react';
import { ContentBody, PhysicalInfoInput, PhysicalInfoHistory, PhysicalInfoHistoryInnerDiv, ImgDiv, InputDiv, InputInnerDiv, AddBtnDiv } from './ChildPhysicalInfoStyle';

// 초기 더미 데이터 배열
const initialPhysicalInfoData = [
    { height: '170cm', weight: '60kg', date: '2024-07-08' },
    { height: '165cm', weight: '55kg', date: '2024-07-09' },
    { height: '172cm', weight: '68kg', date: '2024-07-10' },
];

function ChildPhysicalInfo() {
    const [physicalInfoData, setPhysicalInfoData] = useState(initialPhysicalInfoData);
    const [height, setHeight] = useState('');
    const [weight, setWeight] = useState('');

    const handleAdd = () => {
        if (!height || !weight) {
            alert("키와 몸무게를 입력해주세요.");
            return;
        }

        if (height <= 20 || height >= 255) {
            alert("키는 20 이상 255 이하의 값을 입력해주세요.");
            return;
        }

        if (weight < 0 || weight >= 255) {
            alert("몸무게는 0 이상 255 이하의 값을 입력해주세요.");
            return;
        }

        const newEntry = {
            height: `${height}cm`,
            weight: `${weight}kg`,
            date: new Date().toISOString().split('T')[0]
        };
        setPhysicalInfoData([...physicalInfoData, newEntry]);
        setHeight('');
        setWeight('');
    };

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
                    <input 
                        type="number" 
                        placeholder="키를 입력하세요" 
                        value={height}
                        onChange={(e) => setHeight(e.target.value)} 
                    />
                </InputInnerDiv>
                <InputInnerDiv>
                    <div>
                        <label>현재 몸무게</label>
                    </div>
                    <input 
                        type="number" 
                        placeholder="몸무게를 입력하세요" 
                        value={weight}
                        onChange={(e) => setWeight(e.target.value)} 
                    />
                </InputInnerDiv>
            </InputDiv>
            <AddBtnDiv>
                <button onClick={handleAdd}>추가</button>
            </AddBtnDiv>
        </PhysicalInfoInput>
        <PhysicalInfoHistory>
            <PhysicalInfoHistoryInnerDiv>
                {physicalInfoData.map((info, index) => (
                    <div key={index}>
                        <span>키: {info.height} 몸무게: {info.weight}</span>
                        <span>{info.date}</span>
                        <button>수정하기</button>
                    </div>
                ))}
            </PhysicalInfoHistoryInnerDiv>
        </PhysicalInfoHistory>
      </ContentBody>
    );
  }
  
  export default ChildPhysicalInfo;
