import React from 'react';
import {Link , Routes , Route, useNavigate} from 'react-router-dom';
import Login from './Login';
import SignUp from './SignUp';
import { Carousel, Nav, Navbar, Container,} from 'react-bootstrap';
import WishList from './WishList';


 
const HomePage = () => {

  const isAuthenticated = localStorage.getItem("token") !== null;
  const navigate = useNavigate();

  const handleLogOut = () =>{
    localStorage.removeItem("token");
    localStorage.removeItem("email");
    navigate('/');
  }
  
 return (
    <div>
      {/* Navbar */}
      <Navbar bg="dark" variant="dark" expand="lg">
        <Container>
          <Navbar.Brand href="#home">WebFlix</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="ml-auto">
			        <Link className='HomeButton'to='/'>Home</Link>
              <Link href="#login" className='LoginButton' to='/login'>Login</Link>
              <Link href="#signup" className='SignUpButton' to='/signup'>Signup</Link>
              {isAuthenticated &&(<Link href='#Dashboard' className='DashBoardButton' to='/dashboard'>DashBoard</Link>)}
              {isAuthenticated && (<Link href="#WishList" className='WishListButton' to='/wishlist'>WishList</Link>)}
              {isAuthenticated && (<Link href="#LogOut" className='LogOutButton' to='/' onClick={handleLogOut}>LogOut</Link>)}
              </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
 
      {/* Carousel */}
	  <Routes>
		<Route 
		path='/'
		element ={
      
      <Carousel className="w-100">
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="/images/movie7.jpg"
            alt="First slide"
          />
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="/images/movie8.jpg"
            alt="Second slide"
          />
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="/images/movie9.jpg"
            alt="Third slide"
          />
        </Carousel.Item>
      </Carousel>} />
	  <Route path='/login' element={<Login />} />
	  <Route path='/signup' element={<SignUp />} />
    <Route path='/wishlist' element={<WishList/>} />
	  {/*<Route path='./dashboard' element={<DashBoard/>} />*/}
	  </Routes>
    
</div>
  );
};
 
export default HomePage;