import VS from "../../assets/img/Game/vs.png";
import { CenterRow, BoxWrap, ImageBox, GameImage, ItemName } from "./SelectModeStyle";

function SelectMode() {
  return (
    <CenterRow>
      <BoxWrap bgColor="#ffe65c">
        <ImageBox shadow="4px 4px 27.5px 0px #c0a93e inset">
          <GameImage src={VS} alt="VS" />
        </ImageBox>
        <ItemName color="#f9810a">게임 시작하기</ItemName>
      </BoxWrap>
      <BoxWrap bgColor="#a4e6f3">
        <ImageBox shadow="4px 4px 27.5px 0px #6ca0ab inset">
          <GameImage src={VS} alt="VS" />
        </ImageBox>
        <ItemName color="#17b1f3">인생 네 컷 찍기</ItemName>
      </BoxWrap>
    </CenterRow>
  );
}

export default SelectMode;
