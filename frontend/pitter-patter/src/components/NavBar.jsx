import { Link } from 'react-router-dom';
import './component.css';

function NavBar() {
    return (
        <div className='body'>
            <div className="nav-body">
                <div className='nav-x'>
                    <img src="src/assets/icons/X.png" alt="" />
                </div>
                <div className='layout-nav'>
                    <Link to='/'>
                        <div className='nav-item-wrap'>
                            <img src="src/assets/img/NavBar/toGame.png" alt="" className='nav-icon'/>
                            <div className='nav-text'>게임 시작하기</div>
                        </div>
                    </Link>
                    <Link to='/'>
                        <div className='nav-item-wrap'>
                            <img src="src/assets/img/NavBar/toMarket.png" alt="" className='nav-icon'/>
                            <div className='nav-text'>상점 둘러보기</div>
                        </div>
                    </Link>
                    <Link to='/'>
                        <div className='nav-item-wrap'>
                            <img src="src/assets/img/NavBar/toRanking.png" alt="" className='nav-icon'/>
                            <div className='nav-text'>랭킹 확인하기</div>
                        </div>
                    </Link>
                    <Link to='/'>
                        <div className='nav-item-wrap'>
                            <img src="src/assets/img/NavBar/toMypage.png" alt="" className='nav-icon'/>
                            <div className='nav-text'>마이 페이지</div>
                        </div>
                    </Link>
                </div>
            </div>
            <div className='nav-bottom-area'></div>
        </div>
    );
}

export default NavBar;