import { useRef, useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Header from "../../LandingPage/Header";
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
  GoResultButton,
  Countdown,
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
  const BlankRefs = useRef([]);
  const [isFilled, setIsFilled] = useState(false);
  const [timer, setTimer] = useState([null, null, null, null]);

  function getImage(index) {
    const targetRef = BlankRefs.current[index];

    // remove previous image
    if (imageList[index]) {
      setImageList(imageList.map((img, i) => (i === index ? null : img)));
    }

    const video = document.createElement("video");
    const canvas = document.createElement("canvas");
    const ctx = canvas.getContext("2d");

    const canvasWidth = 140;
    const canvasHeight = 126;
    canvas.width = canvasWidth;
    canvas.height = canvasHeight;
    canvas.style.objectFit = "cover";

    video.width = canvasWidth;
    video.height = canvasHeight;

    video.style.position = "absolute";
    video.style.top = "0";
    video.style.left = "0";
    video.style.transform = "scaleX(-1)";

    let stream = null;

    navigator.mediaDevices.getUserMedia({ video: true, audio: false })
      .then((mediaStream) => {
        stream = mediaStream;
        video.srcObject = mediaStream;
        video.play();
        targetRef.appendChild(video);
      })
      .catch((err) => {
        console.log(err);
      });

    // 타이머 표시
    let countdown = 3;
    setTimer(prevTimer => {
      const newTimer = [...prevTimer];
      newTimer[index] = countdown;
      return newTimer;
    });

    const interval = setInterval(() => {
      countdown -= 1;
      setTimer(prevTimer => {
        const newTimer = [...prevTimer];
        newTimer[index] = countdown;
        return newTimer;
      });

      if (countdown === 0) {
        clearInterval(interval);

        const videoWidth = video.videoWidth;
        const videoHeight = video.videoHeight;
        const aspectRatio = canvasWidth / canvasHeight;
        let cropWidth, cropHeight;

        if (videoWidth / videoHeight > aspectRatio) {
          cropHeight = videoHeight;
          cropWidth = videoHeight * aspectRatio;
        } else {
          cropWidth = videoWidth;
          cropHeight = videoWidth / aspectRatio;
        }

        const cropX = (videoWidth - cropWidth) / 2;
        const cropY = (videoHeight - cropHeight) / 2;

        ctx.translate(canvasWidth, 0);
        ctx.scale(-1, 1);
        
        ctx.drawImage(video, cropX, cropY, cropWidth, cropHeight, 0, 0, canvasWidth, canvasHeight);
        const image = canvas.toDataURL("image/png");
        setImageList(imageList.map((img, i) => (i === index ? image : img)));
        video.remove();
        
        let tracks = stream.getTracks();
        tracks.forEach(function(track) {
          track.stop();
        });

        video.srcObject = null;
        setTimer(prevTimer => {
          const newTimer = [...prevTimer];
          newTimer[index] = null;
          return newTimer;
        });
      }
    }, 1000);
  }

  useEffect(() => {
    if (imageList.every((img) => img !== null)) {
      setIsFilled(true);
    }
  }, [imageList, navigate]);

  return (
    <MainWrap>
      <Header />
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
              <>
                <Blank onClick={() => getImage(0)} active ref={(el) => (BlankRefs.current[0] = el)}>
                  {(imageList[0] && <UserImg src={imageList[0]} alt="snapshot" />) || (
                      <AddImg src={AddImageIcon} alt="add" />
                  )}
                </Blank>
                {timer[0] !== null && <Countdown timer={timer[0]} index={0}>{timer[0]}</Countdown>}
              </>
              <>
                <Blank onClick={() => getImage(1)} active ref={(el) => (BlankRefs.current[1] = el)}>
                  {(imageList[1] && <UserImg src={imageList[1]} alt="snapshot" />) || (
                      <AddImg src={AddImageIcon} alt="add" />
                  )}
                </Blank>
                {timer[1] !== null && <Countdown timer={timer[1]} index={1}>{timer[1]}</Countdown>}
              </>
            </BlankRow>
            <BlankRow>
              <>
                <Blank onClick={() => getImage(2)} active ref={(el) => (BlankRefs.current[2] = el)}>
                  {(imageList[2] && <UserImg src={imageList[2]} alt="snapshot" />) || (
                      <AddImg src={AddImageIcon} alt="add" />
                  )}
                </Blank>
                {timer[2] !== null && <Countdown timer={timer[2]} index={2}>{timer[2]}</Countdown>}
              </>
              <>
                <Blank onClick={() => getImage(3)} active ref={(el) => (BlankRefs.current[3] = el)}>
                  {(imageList[3] && <UserImg src={imageList[3]} alt="snapshot" />) || (
                      <AddImg src={AddImageIcon} alt="add" />
                  )}
                </Blank>
                {timer[3] !== null && <Countdown timer={timer[3]} index={3}>{timer[3]}</Countdown>}
              </>
            </BlankRow>
          </Frame>
        </CenterRow>
      </CenterColumn>
      {
        isFilled && <GoResultButton onClick={() => navigate("./result", { state: { imageList } })}>
          결과 확인하기
        </GoResultButton>
      }
    </MainWrap>
  );
}

export default Snapshot;
