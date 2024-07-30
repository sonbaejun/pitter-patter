import  { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import moment from 'moment';
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
  CalendarWrapper
} from './AttendanceStyle';
import ArrowLeftIcon from '/src/assets/icons/ArrowLeft.png';

function Attendance() {
  const [date, setDate] = useState(new Date());
  const [activeMonth, setActiveMonth] = useState(moment(date).format('YYYY-MM'));

  const onChange = date => {
    setDate(date);
  };

  const getActiveMonth = activeStartDate => {
    const newActiveMonth = moment(activeStartDate).format('YYYY-MM-DD');
    setActiveMonth(newActiveMonth);
  };

  const dayList = ["2024-07-24", "2024-07-25", "2024-07-26"];

  const tileClassName = ({ date, view }) => {
    if (view === 'month') {
      if (dayList.find(day => day === moment(date).format('YYYY-MM-DD'))) {
        return 'attendance-day';
      }
    }
    return null;
  };

  return (
    <LayoutBase>
      <LayoutMyPage>
        <LayoutRow>
          <LayoutColumn as={MenuWrap}>
            <BackArrow href=''>
              <ArrowPic src={ArrowLeftIcon} alt="ArrowLeft" />
            </BackArrow>
            <MenuItemWrap>
              <MenuItem className="selected">출석 달력 보기</MenuItem>
              <MenuItem>이벤트 확인</MenuItem>
            </MenuItemWrap>
          </LayoutColumn>
          <LayoutColumn as={MainWrap}>
            <CalendarWrapper>
              <Calendar
                onChange={onChange}
                value={date}
                next2Label={null}
                prev2Label={null}
                formatDay={(locale, date) => moment(date).format('D')}
                tileClassName={tileClassName}
                onActiveStartDateChange={({ activeStartDate }) => getActiveMonth(activeStartDate)}
              />
            </CalendarWrapper>
          </LayoutColumn>
        </LayoutRow>
      </LayoutMyPage>
    </LayoutBase>
  );
}

export default Attendance;
