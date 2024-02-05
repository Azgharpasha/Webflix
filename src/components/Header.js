import 'bootstrap/dist/css/bootstrap.css';
import  {Link} from 'react-router-dom';

const Header = () => {
    
     return (
        <header>
            <div className='navbar'>
                <div className='navbar-brand'>
                    <h2>WebFlix</h2>
                </div>
                <div className='navbar-links'>
                    <Link className='LoginButton' to="/login">Login</Link>
                    <Link className='SignUpButton' to="/signup">SignUp</Link>
                    <Link className='HomeButton' to="/">Home</Link>
                </div>
            </div>
        </header>
        
    )
}

export default Header;