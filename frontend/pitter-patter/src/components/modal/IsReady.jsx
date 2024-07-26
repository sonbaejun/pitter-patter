import './modal.css';

function IsReady() {
    return (
        <body>
            <div className='layout-isready'>
                <div className='layout-inModal'>
                    <img src="src/assets/icons/warningSign.png" alt="" className='modal-icon'/>
                </div>
                <div className='layout-inModal'>
                    <span className='title'>스트레칭은 하셨나요?</span>
                </div>
                <div className='layout-inModal'>
                    <span className='context'>안전한 진행을 위해 충분한 몸풀기 운동을 권장합니다.</span>
                </div>
                <div className='layout-inModal' style={{marginTop: "10px"}}>
                    <button>시작</button>
                </div>
            </div>
        </body>
    )
}

export default IsReady;