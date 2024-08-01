import styled from 'styled-components';

// Styled Components
export const ContentBody = styled.div`
  width: 75vw;
  height: 77vh;
  overflow: hidden;
`;

export const PhysicalInfoInput = styled.div`
  width: 100%;
  height: 28%;
  overflow: hidden;
  display: flex;
  justify-content: center;
  gap: 1.5em;
`;

export const PhysicalInfoHistory = styled.div`
    width: 100%;
    height: 60%;
    overflow: hidden;
    display: flex;
    justify-content: center;
    align-items: center;
`;

export const PhysicalInfoHistoryInnerDiv = styled.div`
    width: 68%;
    height: 100%;
    background-color: #D9D9D9;
    display: flex;
    flex-direction: column;
    gap: 1.7em;
    overflow-y: scroll;
    padding-top: 3em;

    div {
        padding: 0px 25px;
        display: flex;
        gap: 4em;
        justify-content: space-around;

        span:first-of-type {
            width: 13em;
        }

        span {
            font-size: 0.9em;
        }
    }

    button {
        color: #757575;
    }
`;

export const ImgDiv = styled.div`
    width: fit-content;
    display: flex;
    justify-content: center;
    align-items: center;

    img {
        width: 90px;
        border-radius: 50%;
        background-color: #757575;
    }
`;

export const InputDiv = styled.div`
    width: 38%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 0.8em;
`;

export const InputInnerDiv = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;

    div {
        display: flex;
        justify-content: center;
        width: 40%;
    }

    label {
        color: #616161;
        font-size: 15px;
    }

    input[type="number"]::-webkit-outer-spin-button,
    input[type="number"]::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
`;

export const AddBtnDiv = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;

    button {
        background-color: #A4E6F3;
        border-radius: 21px;
        width: 55px;
        height: 31px;
        box-shadow: 0px 5px 0px 0px #759FD1; /* 그림자 추가 */
        font-size: 12px;
    }
`;
