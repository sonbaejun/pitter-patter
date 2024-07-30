import "./Snapshot.css";

import Share from "../../../assets/img/Snapshot/share.png";
import Save from "../../../assets/img/Snapshot/save.png";

function SnapshotResult() {
  const imageList = location.state.imageList;

  return (
    <div className="main-wrap">
      <div className="center-column">
        <span className="title">우와 멋진 사진이네요 !</span>
        <div className="center-row">
          <div className="frame">
            <div className="blank-row">
              <div className="blank">
                {imageList && <img src={imageList[0]} alt="snapshot" className="user-img" />}
              </div>
              <div className="blank">
                {imageList && <img src={imageList[1]} alt="snapshot" className="user-img" />}
              </div>
            </div>
            <div className="blank-row">
              <div className="blank">
                {imageList && <img src={imageList[2]} alt="snapshot" className="user-img" />}
              </div>
              <div className="blank">
                {imageList && <img src={imageList[3]} alt="snapshot" className="user-img" />}
              </div>
            </div>
          </div>
          <div className="toolbar">
            <button>게임 선택으로 돌아가기</button>
            <button>메인 화면으로 돌아가기</button>
            <div className="tool-wrap">
              <span className="tool-title">다양한 방법으로 사진을 보관해보세요!</span>
              <div className="tool-row">
                <div className="tool">
                  <img src={Share} alt="share" />
                  <span>공유하기</span>
                </div>
                <div className="tool">
                  <img src={Save} alt="save" />
                  <span>저장하기</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SnapshotResult;