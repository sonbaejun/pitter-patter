import {
  OuterBox,
  InnerBox,
  RankWrap,
  RankOrder,
  RankBarWrap,
  RankBar,
  RankName,
  ProfileImg,
  RankBarOverlay
} from './RankStyle';
import Trophy from '/src/assets/img/Rank/Trophy.png';

function Rank() {
  const rankData = [
    {
      rank: 1,
      name: "Ranker 1",
      score: 12323451451243
    },
    {
      rank: 2,
      name: "Ranker 2",
      score: 12323451451243
    },
    {
      rank: 3,
      name: "Ranker 3",
      score: 12323451451243
    },
    {
      rank: 1234,
      name: "Player 1234",
      score: 12323451451243
    },
    {
      rank: 1235,
      name: "Me",
      score: 12323451451243
    },
    {
      rank: 1236,
      name: "Player 1236",
      score: 12323451451243
    }
  ];

  return (
    <div>
      {/* <NavBar /> */}
      <OuterBox>
        <RankBarOverlay>
          <RankBarWrap style={{ left: "41vw" }} delay={0}>
            <ProfileImg src={Trophy} alt="Trophy" />
            <RankBar style={{ height: "66vh" }}>
              <RankName>{rankData[0].name}</RankName>
            </RankBar>
          </RankBarWrap>
          <RankBarWrap style={{ left: "11vw" }} delay={0.3}>
            <ProfileImg src={Trophy} alt="Trophy" />
            <RankBar style={{ height: "62vh" }}>
              <RankName>{rankData[1].name}</RankName>
            </RankBar>
          </RankBarWrap>
          <RankBarWrap style={{ left: "71vw" }} delay={0.5}>
            <ProfileImg src={Trophy} alt="Trophy" />
            <RankBar style={{ height: "58vh" }}>
              <RankName>{rankData[2].name}</RankName>
            </RankBar>
          </RankBarWrap>
        </RankBarOverlay>
        <InnerBox>
          <RankWrap>
            <div>
              <RankOrder># {rankData[3].rank}</RankOrder>
              <span>{rankData[3].name}</span>
            </div>
            <span>{rankData[3].score}</span>
          </RankWrap>
          <RankWrap>
            <div>
              <RankOrder># {rankData[4].rank}</RankOrder>
              <span>{rankData[4].name}</span>
            </div>
            <span>{rankData[4].score}</span>
          </RankWrap>
          <RankWrap>
            <div>
              <RankOrder># {rankData[5].rank}</RankOrder>
              <span>{rankData[5].name}</span>
            </div>
            <span>{rankData[5].score}</span>
          </RankWrap>
        </InnerBox>
      </OuterBox>
    </div>
  );
}

export default Rank;