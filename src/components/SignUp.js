import axios from "axios";
import { useState,useNavigate } from "react";
import Footer from './Footer';


export default function SignUp() {

    
    
    const [username,setUserName] = useState();
    const [emailId,setEmailId] = useState();
    const [password,setPassword] = useState();

    const submitForm = async () => {
        // api call
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if(!emailRegex.test(emailId)){
            alert("Invalid EmailId");
        }

        if(password.length<6){
            alert("Password must be atleast six characters");
            return;
        }

        if(username.trim()===""){
            alert("Username cannot be empty")
        }

     try {
            const response = await axios.post("http://ec2-3-216-146-132.compute-1.amazonaws.com:8081/api/v2/user",{
                username,
                emailId,
                password,
            });
            alert("Registration Sucesfull");
        } catch(error){
            console.error("Registration failed", error.message);
        }
       
    }

    return(
        <div className="row justify-content-center pt-5" style={{backgroundImage:'url(./images/movie5.jpg)',backgroundSize:'cover',minHeight:'100vh'}}>
            <div className="col-sm-6">
                <div className="card p-4" style={{backgroundColor:'#f9f9f9',borderRadius:'10px'}}>
                    <h1 className="text-center mb-3" style = {{color:"#333"}}>SignUp </h1>
                    <div className="form-group">
                        <label>username</label>
                        <input type="test" className="form-control" placeholder="Enter username"
                            onChange={e=>setUserName(e.target.value)}
                        id="emailId" />
                    </div>
                    <div className="form-group mt-3">
                        <label>EmailId:</label>
                        <input type="email" className="form-control" placeholder="Enter emailId"
                            onChange={e=>setEmailId(e.target.value)}
                        id="emailId" />
                    </div>

                    <div className="form-group mt-3">
                        <label>Password:</label>
                        <input type="password" className="form-control" placeholder="Enter password"
                            onChange={e => setPassword(e.target.value)}
                        id="pwd" />
                    </div>
                    <button type="button" onClick={submitForm} className="btn btn-primary mt-4">Register</button>
                </div>
            </div>
            <Footer />
        </div>
    )
}

