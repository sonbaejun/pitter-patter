import { Link } from 'react-router-dom';
import './LandingPage.css'; 

function Header() {
    return (
        <div className='header-body'>
            <div className='layout-header'>
                <Link to='/'><img src="src/assets/img/logo/logo.png" alt="" className='logo-img'/></Link>
                <div className='layout-header-button'>
                    <img src="src/assets/icons/User.png" alt="" className='header-button'/>
                    <img src="src/assets/icons/Menu.png" alt="" className='header-button'/>
                </div>
            </div>
        </div>
    );
}

export default Header;