import "bootstrap/dist/css/bootstrap.min.css";
import  {BrowserRouter , Route , Routes} from 'react-router-dom';
import Home from './components/Home.js';
// import Login from './components/Login.js';
// import SignUp from './components/SignUp.js';
// import Header from './components/Header.js';
import DashBoard from "./components/DashBoard.js";
import './style.css';

function App() {
 return (
  <div>
   <BrowserRouter>
  <Home />
  <Routes>
    {/*<Route path="/login" element={<Login/>}/>*/}
    {/*<Route path="/signup" element={<SignUp/>} />*/}
    <Route path="/dashboard" element={<DashBoard />} />
  </Routes>
  </BrowserRouter>
  
  </div>
 )
}

export default App;
