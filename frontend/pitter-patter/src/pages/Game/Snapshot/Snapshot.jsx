import "./Snapshot.css";

import { useRef, useState, useEffect } from "react";

import AddImageIcon from "../../../assets/icons/AddImage.png";
import { useNavigate } from "react-router-dom";

import EG1 from "../../../assets/img/Snapshot/eg1.png";
import EG2 from "../../../assets/img/Snapshot/eg2.png";
import EG3 from "../../../assets/img/Snapshot/eg3.png";
import EG4 from "../../../assets/img/Snapshot/eg4.png";

function Snapshot() {
  const frameRef = useRef(null);
  const [imageList, setImageList] = useState([null, null, null, null]);
  const navigate = useNavigate();

  function getImage(index) {
    const input = document.createElement("input");
    input.type = "file";
    input.accept = "image/*";
    input.onchange = () => {
      const file = input.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = () => {
          const image = reader.result;
          setImageList(imageList.map((img, i) => i === index ? image : img));
        }
        reader.readAsDataURL(file);
        
      }
    }
    input.click();
  }

  useEffect(() => {
    if (imageList.every((img) => img !== null)) {
      navigate("/snapshot/result", { state: { imageList } }); // 이미지가 모두 채워지면 navigate 함수를 통해 /snapshot/result로 이동
    }
  }, [imageList, navigate]);

  return (
    <div className="main-wrap">
      <div className="center-column">
        <span className="title">피터와 패터를 따라 사진을 찍어보세요 !</span>
        <div className="center-row">
          <div className="frame">
            <div className="blank-row">
              <div className="blank">
                <img src={EG1} alt="example" className="user-img" />
              </div>
              <div className="blank">
                <img src={EG2} alt="example" className="user-img" />
              </div>
            </div>
            <div className="blank-row">
              <div className="blank">
                <img src={EG3} alt="example" className="user-img" />
              </div>
              <div className="blank">
                <img src={EG4} alt="example" className="user-img" />
              </div>
            </div>
          </div>
            <div className="frame" ref={frameRef}>
              <div className="blank-row">
                <div className="blank" onClick={() => getImage(0)}>
                  {(imageList[0] && <img src={imageList[0]} alt="snapshot" className="user-img" />) || <img src={AddImageIcon} alt="add" className="add-img" />}
                </div>
              <div className="blank" onClick={() => getImage(1)}>
                {(imageList[1] && <img src={imageList[1]} alt="snapshot" className="user-img" />) || <img src={AddImageIcon} alt="add" className="add-img" />}
                </div>
              </div>
              <div className="blank-row">
              <div className="blank" onClick={() => getImage(2)}>
                {(imageList[2] && <img src={imageList[2]} alt="snapshot" className="user-img" />) || <img src={AddImageIcon} alt="add" className="add-img" />}
                </div>
              <div className="blank" onClick={() => getImage(3)}>
                {(imageList[3] && <img src={imageList[3]} alt="snapshot" className="user-img" />) || <img src={AddImageIcon} alt="add" className="add-img" />}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Snapshot