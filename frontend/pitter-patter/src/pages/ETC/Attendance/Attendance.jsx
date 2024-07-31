import React, { useState } from 'react';
import 'react-calendar/dist/Calendar.css';
import CalendarPage from './CalendarPage';
import AttendanceEvent from './AttendanceEvent';
import {
  LayoutBase,
  LayoutMyPage,
  LayoutRow,
  LayoutColumn,
  MenuWrap,
  BackArrow,
  ArrowPic,
  MenuItemWrap,
  MenuItem,
  MainWrap,
} from './AttendanceStyle';
import ArrowLeftIcon from '/src/assets/icons/ArrowLeft.png';

function Atd() {
  const [selectedMenu, setSelectedMenu] = useState('attendance'); // Default to 'attendance'

  return (
    <LayoutBase>
      <LayoutMyPage>
        <LayoutRow>
          <LayoutColumn as={MenuWrap}>
            <BackArrow href=''>
              <ArrowPic src={ArrowLeftIcon} alt="ArrowLeft" />
            </BackArrow>
            <MenuItemWrap>
              <MenuItem 
                onClick={() => setSelectedMenu('attendance')} 
                className={selectedMenu === 'attendance' ? 'menuitem selected' : 'menuitem'}
              >
                출석 달력 보기
              </MenuItem>
              <MenuItem 
                onClick={() => setSelectedMenu('event')} 
                className={selectedMenu === 'event' ? 'menuitem selected' : 'menuitem'}
              >
                이벤트 확인
              </MenuItem>
            </MenuItemWrap>
          </LayoutColumn>
          <LayoutColumn as={MainWrap}>
            {selectedMenu === 'attendance' && <CalendarPage />}
            {selectedMenu === 'event' && <AttendanceEvent />}
          </LayoutColumn>
        </LayoutRow>
      </LayoutMyPage>
    </LayoutBase>
  );
}

export default Atd;
