import { useLocation } from "react-router-dom";
import {
  MainWrap,
  CenterColumn,
  CenterRow,
  Title,
  Frame,
  BlankRow,
  Blank,
  UserImg,
  Toolbar,
  Button,
  ToolWrap,
  ToolTitle,
  ToolRow,
  Tool,
  ToolImg,
} from "./SnapshotStyle";
import Share from "../../../assets/img/Snapshot/share.png";
import Save from "../../../assets/img/Snapshot/save.png";

function SnapshotResult() {
  const location = useLocation();
  const { imageList } = location.state;

  return (
    <MainWrap>
      <CenterColumn>
        <Title>우와 멋진 사진이네요 !</Title>
        <CenterRow>
          <Frame>
            <BlankRow>
              <Blank>
                {imageList && <UserImg src={imageList[0]} alt="snapshot" />}
              </Blank>
              <Blank>
                {imageList && <UserImg src={imageList[1]} alt="snapshot" />}
              </Blank>
            </BlankRow>
            <BlankRow>
              <Blank>
                {imageList && <UserImg src={imageList[2]} alt="snapshot" />}
              </Blank>
              <Blank>
                {imageList && <UserImg src={imageList[3]} alt="snapshot" />}
              </Blank>
            </BlankRow>
          </Frame>
          <Toolbar>
            <Button>게임 선택으로 돌아가기</Button>
            <Button>메인 화면으로 돌아가기</Button>
            <ToolWrap>
              <ToolTitle>다양한 방법으로 사진을 보관해보세요!</ToolTitle>
              <ToolRow>
                <Tool>
                  <ToolImg src={Share} alt="share" />
                  <span>공유하기</span>
                </Tool>
                <Tool>
                  <ToolImg src={Save} alt="save" />
                  <span>저장하기</span>
                </Tool>
              </ToolRow>
            </ToolWrap>
          </Toolbar>
        </CenterRow>
      </CenterColumn>
    </MainWrap>
  );
}

export default SnapshotResult;
