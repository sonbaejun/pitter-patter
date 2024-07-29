import './Child.css';
import { Link } from 'react-router-dom';
import Header from "../LandingPage/Header";
import ChildActivityTable from './ChildActivityTable';

function ChildPage() {
    return (
        <div className="body">
            <Header />
            <div className="child-body">
                <div className="child-background">
                    <div className='child-menu'>
                        <Link to="/" className='backspace'>
                            <img src="src/assets/icons/backArrow.png" alt="" />
                        </Link>
                        <div className='child-menu-item' is-active="true">신체 정보 입력하기</div>
                        <div className='child-menu-item'>활동량 분석표 보기</div>
                        <div className='child-menu-item'>BMI 분석표 보기</div>
                    </div>
                    <div className='context-background'>
                        <div className='context-item'>
                            <ChildActivityTable />
                        </div>
                    </div>
                </div>

            </div>
        </div>
    );
}

export default ChildPage;