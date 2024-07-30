import styled from "styled-components";
import AttendanceBackground from "/src/assets/img/Attendance/attendance-background.png";
import StarIcon from "/src/assets/icons/star.png";

export const LayoutBase = styled.div`
  display: flex;
  min-height: 100vh;
  min-width: 100vw;
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: url(${AttendanceBackground});
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  background-color: transparent;
`;

export const LayoutMyPage = styled.div`
  display: flex;
  background-color: var(--box-green-color);
  height: 80vh;
  width: 70vw;
  border-radius: 40px;
  box-shadow: 0px 11px 39.6px 0px rgba(0, 0, 0, 0.25);
  display: flex;
  flex-direction: column;
  align-items: center;
  box-sizing: border-box;
  padding: 1vw;
`;

export const LayoutRow = styled.div`
  display: flex;
  display: flex;
  flex-direction: row;
  width: 100%;
`;

export const LayoutColumn = styled.div`
  display: flex;
  display: flex;
  flex-direction: column;
  height: 100%;
`;

export const MenuWrap = styled.div`
  width: 30%;
`;

export const BackArrow = styled.a`
  width: 0.5vw;
  height: 0.5vw;
  padding: 2vw 1vh;
  display: flex;
  justify-content: flex-start;
`;

export const ArrowPic = styled.img`
  width: 2.5vw;
`;

export const MenuItemWrap = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 2vw;
`;

export const MenuItem = styled.button`
  font-size: 1.5vw;
  margin-top: 1vw;
  margin-bottom: 1vw;
  font-weight: 700;
  color: #616161;
  box-shadow: none;
  background: none;
  border: none;
  cursor: pointer;

  &.selected {
    color: #629d1b;
  }
`;

export const MainWrap = styled.div`
  background-color: white;
  border-radius: 30px;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const CalendarWrapper = styled.div`
  width: 50vw;
  height: 76vh;
  .react-calendar {
    width: 100%;
    border: none;
    border-radius: 40px;
    padding: 1vw;
    background-color: #fff;
  }

  .react-calendar__month-view {
    padding: 12px 32px;
  }

  .react-calendar__tile {
    text-align: center;
    height: 9vh;
    display: flex;
    flex-direction: column;
    justify-content: start;
    align-items: start;
    border-radius: 0;

    &.attendance-day {
      background-image: url(${StarIcon});
      background-repeat: no-repeat;
      background-position: center;
      background-size: contain;
    }
  }

  .react-calendar__navigation button {
    min-width: 44px;
    background: none;
  }

  .react-calendar__tile--now {
    background: #ffff76;
  }

  .react-calendar__tile--active {
    background: #76ff76;
  }
`;
