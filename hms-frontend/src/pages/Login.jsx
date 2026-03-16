import {useState} from "react";
import {loginUser} from "../services/authService.js";
import {useNavigate} from "react-router-dom";


function Login(){
    const navigate = useNavigate();
    const [username,setUsername]= useState("");
    const [password,setPassword]= useState("");

    const handleLogin = async (e)=>{
        e.preventDefault();

        try{
            const token = await loginUser({username,password});
            localStorage.setItem("token",token);
            alert("Login Successful!");
            navigate("/admin");
            }catch(error){
                alert("Login Failed");
                }
        };

    return (
            <div>
                <h2>Login</h2>

                <form onSubmit={handleLogin}>
                    <input type="text" placeholder="Username" value={username} onChange={(e)=> setUsername(e.target.value)}/>
                    <br/><br/>

                    <input type="password" placeholder="password" value={password} onChange={(e)=>setPassword(e.target.value)}/>
                    <br/><br/>
                    <button type="submit">Login</button>
                </form>
            </div>
        );
}
export default Login;