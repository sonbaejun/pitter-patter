import { Link } from 'react-router-dom';
import './modal.css';

function InputH() {
    return (
        <body>
            <div className='layout-inputH'>
                <div className='layout-inModal'>
                    <img src="src/assets/icons/warningSign.png" alt="" className='modal-icon'/>
                </div>
                <div className='layout-inModal'>
                    <span className='Htitle'>마지막으로 신체 정보를 입력한지 1주일이 지났습니다.</span>
                </div>
                <div className='layout-inModal'>
                    <span className='context'>정확한 그래프를 위해 꾸준한 입력을 권장드립니다.</span>
                </div>
                <div className='layout-inModal' style={{margin: "20px 0"}}>
                    <div className='layout-button-wrap'>
                        <Link to='/'>
                            <div className='context' style={{textDecoration: "underline"}}>다음에 할게요.</div>
                        </Link>
                        <button>입력하러 가기</button>
                    </div>
                </div>
                <div className='layout-inModal' style={{marginBottom: "20px"}}>
                    <input type="checkbox" id='none-for-a-week'/>
                    <label for='none-for-a-week'>&nbsp;1주일동안 보지 않기</label>
                </div>
            </div>
        </body>
    )
}

export default InputH;