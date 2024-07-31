import VS from "../../assets/img/Game/vs.png";
import { Wallpaper, BoxWrap, ImageBox, GameImage, ItemName } from "./ShopStyle";

function Shop() {
  return (
    <Wallpaper>
      <BoxWrap bgColor="#ffe65c">
        <ImageBox shadow="4px 4px 27.5px 0px #c0a93e inset">
          <GameImage src={VS} alt="VS" />
        </ImageBox>
        <ItemName color="#f9810a">네 컷 프레임 상점</ItemName>
      </BoxWrap>
      <BoxWrap bgColor="#a4e6f3">
        <ImageBox shadow="4px 4px 27.5px 0px #6ca0ab inset">
          <GameImage src={VS} alt="VS" />
        </ImageBox>
        <ItemName color="#17b1f3">게임 배경 상점</ItemName>
      </BoxWrap>
    </Wallpaper>
  );
}

export default Shop;
