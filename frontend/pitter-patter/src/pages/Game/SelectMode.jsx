import VS from "../../assets/img/Game/vs.png";
import { MainWrap, BoxWrap, ImageBox, GameImage, ItemName } from "./SelectModeStyle";

function SelectMode() {
  return (
    <MainWrap>
      <BoxWrap bgColor="var(--logo-pink-color)">
        <ImageBox shadow="4px 4px 27.5px 0px #933557 inset">
          <GameImage src={VS} alt="VS" />
        </ImageBox>
        <ItemName color="#FFD8DF">게임 시작하기</ItemName>
      </BoxWrap>
      <BoxWrap bgColor="var(--box-green-color)">
        <ImageBox shadow="4px 4px 27.5px 0px #629D1B inset">
          <GameImage src={VS} alt="VS" />
        </ImageBox>
        <ItemName color="#629D1B">인생 네 컷 찍기</ItemName>
      </BoxWrap>
    </MainWrap>
  );
}

export default SelectMode;
