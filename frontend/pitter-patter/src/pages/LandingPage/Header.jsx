import { Link } from 'react-router-dom';
import {
  HeaderBody,
  LayoutHeader,
  LogoImg,
  LayoutHeaderButton,
  HeaderButton
} from './LandingPageStyle';
import Logo from '../../assets/img/logo/logo.png';
import UserIcon from '../../assets/icons/User.png';
import MenuIcon from '../../assets/icons/Menu.png';

function Header() {
  return (
    <HeaderBody>
      <LayoutHeader>
        <Link to='/'>
          <LogoImg src={Logo} alt="Logo" />
        </Link>
        <LayoutHeaderButton>
          <HeaderButton src={UserIcon} alt="User" />
          <HeaderButton src={MenuIcon} alt="Menu" />
        </LayoutHeaderButton>
      </LayoutHeader>
    </HeaderBody>
  );
}

export default Header;
