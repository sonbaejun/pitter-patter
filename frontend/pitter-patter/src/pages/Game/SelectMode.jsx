import "./SelectMode.css";

import VS from "../../assets/img/Game/vs.png";

function SelectMode() {
  return (
    <div className="center-row">
      <div className="box-wrap" style={{backgroundColor:"#ffe65c"}}>
        <div className="image-box" style={{boxShadow:"4px 4px 27.5px 0px #c0a93e inset"}}>
          <img src={VS} alt="VS" className="game-image" />
        </div>
        <div className="item-name" style={{color:"#f9810a"}}>
          게임 시작하기
        </div>
      </div>
      <div className="box-wrap" style={{backgroundColor:"#a4e6f3"}}>
        <div className="image-box" style={{boxShadow:"4px 4px 27.5px 0px #6ca0ab inset"}}>
          <img src={VS} alt="VS" className="game-image" />
        </div>
        <div className="item-name" style={{color:"#17b1f3"}}>
          인생 네 컷 찍기
        </div>
      </div>
    </div>
  );
}

export default SelectMode;