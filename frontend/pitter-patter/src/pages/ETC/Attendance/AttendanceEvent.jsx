import 'react-calendar/dist/Calendar.css';
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
  Board,
  Stone,
  SVGContainer
} from './AttendanceEventStyle';
import ArrowLeftIcon from '/src/assets/icons/ArrowLeft.png';
import UndoneImage from '/src/assets/icons/Undone.png'
import DoneImage from '/src/assets/icons/Done.png'

const stonePositions = [
  { src: DoneImage, alt: "done", style: { top: '5%', left: '10%' } },
  { src: UndoneImage, alt: "undone", style: { top: '16%', left: '30%' } },
  { src: UndoneImage, alt: "undone", style: { top: '15%', left: '50%' } },
  { src: UndoneImage, alt: "undone", style: { top: '10%', left: '66%' } },
  { src: UndoneImage, alt: "undone", style: { top: '30%', left: '78%' } },
  { src: UndoneImage, alt: "undone", style: { top: '37%', left: '50%' } },
  { src: UndoneImage, alt: "undone", style: { top: '33%', left: '30%' } },
  { src: UndoneImage, alt: "undone", style: { top: '42%', left: '10%' } },
  { src: UndoneImage, alt: "undone", style: { top: '50%', left: '30%' } },
  { src: UndoneImage, alt: "undone", style: { top: '52%', left: '50%' } },
  { src: UndoneImage, alt: "undone", style: { top: '49%', left: '70%' } },
  { src: UndoneImage, alt: "undone", style: { top: '66%', left: '82%' } },
  { src: UndoneImage, alt: "undone", style: { top: '70%', left: '45%' } },
  { src: UndoneImage, alt: "undone", style: { top: '80%', left: '23%' } },
];

function generatePathData(positions) {
  const pathData = positions.map(pos => {
    const x = parseFloat(pos.style.left) * 10;
    const y = parseFloat(pos.style.top) * 10;
    return { x, y };
  });

  let pathString = `M${pathData[0].x},${pathData[0].y}`;
  for (let i = 1; i < pathData.length; i++) {
    const prev = pathData[i - 1];
    const current = pathData[i];
    const cx = (prev.x + current.x) / 2;
    const cy = (prev.y + current.y) / 2;
    pathString += ` Q${cx},${cy} ${current.x},${current.y}`;
  }
  return pathString;
}

function AttendanceEvent() {
  return (
    <LayoutBase>
      <LayoutMyPage>
        <LayoutRow>
          <LayoutColumn as={MenuWrap}>
            <BackArrow href=''>
              <ArrowPic src={ArrowLeftIcon} alt="ArrowLeft" />
            </BackArrow>
            <MenuItemWrap>
              <MenuItem>출석 달력 보기</MenuItem>
              <MenuItem className="selected">이벤트 확인</MenuItem>
            </MenuItemWrap>
          </LayoutColumn>
          <LayoutColumn as={MainWrap}>
            <Board>
              {stonePositions.map((pos, index) => (
                <Stone key={index} src={pos.src} alt={pos.alt} style={pos.style} />
              ))}
              <SVGContainer>
                <svg width="100%" height="100%">
                  <path
                    d={generatePathData(stonePositions)}
                    stroke="green"
                    strokeWidth="2"
                    fill="none"
                    strokeDasharray="5,5"
                  />
                </svg>
              </SVGContainer>
            </Board>
          </LayoutColumn>
        </LayoutRow>
      </LayoutMyPage>
    </LayoutBase>
  );
}

export default AttendanceEvent;
