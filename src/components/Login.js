import { useState } from "react"
import { useNavigate } from "react-router-dom";
import axios from "axios";
import Footer from "./Footer";

export default function Login() {
    const navigate = useNavigate();

    const [login, setLogin] = useState({
        emailId: "",
        password: ""
    });

    const handleChange = (event) => {
        const { name, value } = event.target;
        setLogin((login) =>( { ...login, [name]: value }));
    };

    const handleLogin = (event) => {
        event.preventDefault();
        
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if(!emailRegex.test(login.emailId)){
            alert("Invalid EmailId");
        }

        if(login.password.length<6){
            alert("Password must be atleast six characters");
            return;
        }



        axios.post("http://ec2-3-216-146-132.compute-1.amazonaws.com:8080/api/v1/login/user",{
                emailId:login.emailId,
                password:login.password
            }).then((response)=>{
                console.log(response.data);
                localStorage.setItem("token","Bearer "+response.data.token);
                localStorage.setItem("email",response.data.email);
                navigate("/dashboard");
            })
            .catch((error) => {
                // alert(error.response.data);
                console.log(error);
                console.log(error.response);
            });
    };
    
   return(
        <div className="row justify-content-center pt-5" style={{backgroundImage:'url(./images/movie6.jpg)',backgroundSize:'cover',minHeight:'100vh'}}>
            <div className="col-sm-6">
                <div className="card border-4 prime prime" style={{backgroundColor:'#fce4ec',borderRadius:'10px'}}>
                    <h1 className="text-center mb-3" style = {{color:"#d81b60"}}>Login </h1>
                    <div className="form-group">
                        <label style={{color:'#d8160'}}>Email address:</label>
                        <input type="email" className="form-control" placeholder="Enter email" name="emailId"
                        value={login.emailId}
                             onChange={handleChange}
                         />
                    </div>
                    <div className="form-group mt-3">
                        <label style={{color:'#d8160'}}>Password:</label>
                        <input type="password" className="form-control" placeholder="Enter password" name="password"
                        value={login.password}
                           onChange={handleChange}
                         />
                    </div>
                    <button type="button" onClick={handleLogin} className="btn btn-primary mt-4">Login</button>
                </div>
            </div>
            <Footer/>
        </div>
        
    )
}