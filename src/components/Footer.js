import React from "react";
import { FaFacebook, FaInstagram, FaWhatsapp } from 'react-icons/fa';
import { Carousel, Nav, Navbar, Container, Col, Row } from 'react-bootstrap';

const Footer = () => {
    return (
    <div style={{display:'flex',flexDirection:'column', minHeight:'100vh'}}>
       <footer className="footer" style={{marginTop:'auto',background:'#f1f1f1',padding:'10px'}}>
        <Container>
          <Row>
            <Col>
              <h4>Contact</h4>
              <p>Email: contact@webflix.com</p>
            </Col>
            <Col>
              <h4>Follow Us</h4>
              <div className="social-icons">
                <FaFacebook className="icon" />
                <FaInstagram className="icon" />
                <FaWhatsapp className="icon" />
              </div>
            </Col>
          </Row>
        </Container>
      </footer> 
      </div>
    );
 };

 export default Footer;