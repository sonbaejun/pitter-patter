import { MainWrap, HeaderBody, MainColumn, SubTitle, Title, MainImage, Button, TextButton } from "./LandingPageStyle";

import Header from "./Header";

function LandingPage() {
    return (
        <MainWrap>
            <HeaderBody>
                <Header />
            </HeaderBody>
            <MainColumn>
                <SubTitle>웹 캠을 통한 유아, 소아 피트니스 게임 서비스</SubTitle>
                <Title>우리 아이 운동, 게임으로 더 즐겁게 !</Title>
                <MainImage src="/src/assets/img/Landing/home.png" alt="MainImage" />
                <Button>게임 시작하기</Button>
                <TextButton>무료로 가입하기</TextButton>
            </MainColumn>
        </MainWrap>
    );
}

export default LandingPage;
