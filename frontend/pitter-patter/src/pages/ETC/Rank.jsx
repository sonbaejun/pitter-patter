import "./Rank.css";

import NavBar from "../../components/NavBar";
import Trophy from "../../assets/img/Rank/Trophy.png";

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
  ]

  return (
    <div>
      {/* <NavBar /> */}
      <div className="outer-box">
        <div className="rank-bar-wrap" style={{ left: "41vw" }}>
          <img src={Trophy} alt="Trophy" className="profile-img" />
          <div className="rank-bar" style={{ height: "66vh" }}>
            <div className="rank-name">{rankData[0].name}</div>
          </div>
        </div>
        <div className="rank-bar-wrap" style={{ left: "11vw" }}>
          <img src={Trophy} alt="Trophy" className="profile-img" />
          <div className="rank-bar" style={{ height: "62vh" }}>
            <div className="rank-name">{rankData[1].name}</div>
          </div>
        </div>
        <div className="rank-bar-wrap" style={{ left: "71vw" }}>
          <img src={Trophy} alt="Trophy" className="profile-img" />
          <div className="rank-bar" style={{ height: "58vh" }}>
            <div className="rank-name">{rankData[2].name}</div>
          </div>
        </div>
        <div className="inner-box">
          <div className="rank-wrap">
            <div>
              <span className="rank">
                # {rankData[3].rank}
              </span>
              <span>{rankData[3].name}</span>
            </div>
            <span>{rankData[3].score}</span>
          </div>
          <div className="rank-wrap">
            <div>
              <span className="rank">
                # {rankData[4].rank}
              </span>
              <span>{rankData[4].name}</span>
            </div>
            <span>{rankData[4].score}</span>
          </div>
          <div className="rank-wrap">
            <div>
              <span className="rank">
                # {rankData[5].rank}
              </span>
              <span>{rankData[5].name}</span>
            </div>
            <span>{rankData[5].score}</span>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Rank;