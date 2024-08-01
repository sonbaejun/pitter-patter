import { Link } from "react-router-dom";
import Header from "../LandingPage/Header";
import { MainWrap, BoxWrap, ImageBox, GameImage, ItemName } from "./SelectModeStyle";
import snapshot from "../../assets/img/Game/snapshot.png";
import goGame from "../../assets/img/Game/goGame.png";

function SelectMode() {
  return (
    <MainWrap>
      <Header />
      <Link to={"/game"}>
        <BoxWrap bgColor="var(--logo-pink-color)">
          <ImageBox shadow="4px 4px 27.5px 0px #933557 inset">
            <GameImage src={goGame} alt="goGame" style={{width: '150%'}} />
          </ImageBox>
          <ItemName color="#FFD8DF">게임 시작하기</ItemName>
        </BoxWrap>
      </Link>
      <Link to={"/game/snapshot"}>
        <BoxWrap bgColor="var(--box-green-color)">
          <ImageBox shadow="4px 4px 27.5px 0px #629D1B inset">
            <GameImage src={snapshot} alt="snapShot" />
          </ImageBox>
          <ItemName color="#629D1B">인생 네 컷 찍기</ItemName>
        </BoxWrap>
      </Link>
    </MainWrap>
  );
}

export default SelectMode;
