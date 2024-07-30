import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import './Attendance.css';
import moment from 'moment';

function AttendancePage() {
    const [date, setDate] = useState(new Date());
    const [activeMonth, setActiveMonth] = useState(moment(date).format('YYYY-MM'));

    const onChange = date => {
        setDate(date);
    }

    const getActiveMonth = (activeStartDate) => {
        const newActiveMonth = moment(activeStartDate).format('YYYY-MM-DD');
        setActiveMonth(newActiveMonth);
    }

    // 출석 날짜 리스트
    const dayList = ["2024-07-24", "2024-07-25", "2024-07-26"];

    // 특정 날짜에 클래스명 추가
    const tileClassName = ({ date, view }) => {
        if (view === 'month') {
            if (dayList.find((day) => day === moment(date).format('YYYY-MM-DD'))) {
                return 'attendance-day';
            }
        }
        return null;
    };

    return (
        <div className="layout-base">
            <div className="layout-my-page">
                <div className="layout-row">
                    <div className="layout-column menu-wrap">
                        <div>
                            <a className="back-arrow" href=''>
                                <img src="src/assets/icons/ArrowLeft.png" alt="ArrowLeft" className='arrow-pic'/>
                            </a>
                        </div>
                        <div className="menu-item-wrap">
                            <button className="menu-item menu-item-selected">출석 달력 보기</button>
                            <button className="menu-item">이벤트 확인</button>
                        </div>
                    </div>
                    <div className="layout-column main-wrap">
                        <Calendar
                            onChange={onChange}
                            value={date}
                            next2Label={null}
                            prev2Label={null}
                            formatDay={(locale, date) => moment(date).format('D')}
                            className="calendar"
                            tileClassName={tileClassName}
                            onActiveStartDateChange={({ activeStartDate }) => getActiveMonth(activeStartDate)}
                        />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AttendancePage;
