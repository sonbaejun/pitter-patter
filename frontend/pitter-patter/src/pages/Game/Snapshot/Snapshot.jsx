import { useRef, useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import {
  MainWrap,
  CenterColumn,
  CenterRow,
  Title,
  Frame,
  BlankRow,
  Blank,
  UserImg,
  AddImg,
} from "./SnapshotStyle";
import AddImageIcon from "/src/assets/icons/AddImage.png";
import EG1 from "/src/assets/img/Snapshot/eg1.png";
import EG2 from "/src/assets/img/Snapshot/eg2.png";
import EG3 from "/src/assets/img/Snapshot/eg3.png";
import EG4 from "/src/assets/img/Snapshot/eg4.png";

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
          setImageList(imageList.map((img, i) => (i === index ? image : img)));
        };
        reader.readAsDataURL(file);
      }
    };
    input.click();
  }

  useEffect(() => {
    if (imageList.every((img) => img !== null)) {
      navigate("./result", { state: { imageList } }); // 이미지가 모두 채워지면 navigate 함수를 통해 /snapshot/result로 이동
    }
  }, [imageList, navigate]);

  return (
    <MainWrap>
      <CenterColumn>
        <Title>피터와 패터를 따라 사진을 찍어보세요 !</Title>
        <CenterRow>
          <Frame>
            <BlankRow>
              <Blank>
                <UserImg src={EG1} alt="example" />
              </Blank>
              <Blank>
                <UserImg src={EG2} alt="example" />
              </Blank>
            </BlankRow>
            <BlankRow>
              <Blank>
                <UserImg src={EG3} alt="example" />
              </Blank>
              <Blank>
                <UserImg src={EG4} alt="example" />
              </Blank>
            </BlankRow>
          </Frame>
          <Frame ref={frameRef}>
            <BlankRow>
              <Blank onClick={() => getImage(0)}>
                {(imageList[0] && <UserImg src={imageList[0]} alt="snapshot" />) || (
                  <AddImg src={AddImageIcon} alt="add" />
                )}
              </Blank>
              <Blank onClick={() => getImage(1)}>
                {(imageList[1] && <UserImg src={imageList[1]} alt="snapshot" />) || (
                  <AddImg src={AddImageIcon} alt="add" />
                )}
              </Blank>
            </BlankRow>
            <BlankRow>
              <Blank onClick={() => getImage(2)}>
                {(imageList[2] && <UserImg src={imageList[2]} alt="snapshot" />) || (
                  <AddImg src={AddImageIcon} alt="add" />
                )}
              </Blank>
              <Blank onClick={() => getImage(3)}>
                {(imageList[3] && <UserImg src={imageList[3]} alt="snapshot" />) || (
                  <AddImg src={AddImageIcon} alt="add" />
                )}
              </Blank>
            </BlankRow>
          </Frame>
        </CenterRow>
      </CenterColumn>
    </MainWrap>
  );
}

export default Snapshot;
