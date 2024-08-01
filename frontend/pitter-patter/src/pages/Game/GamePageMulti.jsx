import { MainWrap, MyGame, OpponentGame } from "./GamePageMultiStyle";
import Header from "../LandingPage/Header";

function GamePageMulti() {
  return (
    <MainWrap>
      <Header />
      <MyGame />
      <OpponentGame />
    </MainWrap>
  );
}

export default GamePageMulti;
