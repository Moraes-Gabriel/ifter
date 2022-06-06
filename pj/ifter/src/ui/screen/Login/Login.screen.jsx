import "./login.screen.css";
import ifsul from "../../../assets/image/icon-ifsul.jpg";
import iconIfsul from "../../../assets/image/iconIF.png";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useGlobalUser } from "../../../context/user.context";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
import { useLoginApi } from "../../../hooks/api/login/use-login-api.hook"

export function LoginScreen() {

  const [inputValues, setInputValues] = useState();
  const [globalUser, setGlobalUser] = useGlobalUser();
  const navigate = useNavigate();
  const loginApi = useLoginApi();

  const handleChange = (eventoDeChange) => {
    const { name, value } = eventoDeChange.target;
    setInputValues({ ...inputValues, [name]: value });
  };

  async function getLoginApi() {
    try{
      const response = await loginApi.logar(inputValues?.email, inputValues?.password);
      setGlobalUser(response)
    }catch(error){

    }
  }
  function handlerRegister() {
    navigate("/register")
  }

  async function handleSubmit(event) {
    event.preventDefault();
    getLoginApi();
    if(globalUser) navigate('/home')
      console.log("asd");
    localStorage.setItem('token', null)
  }
  return (
    <div className="login_div-main">
      <div className="login_div_logo">
        <img src={ifsul} alt="" />
      </div>
      <div className="login_div_content">
        <img src={iconIfsul} alt="" />
        <h1>Acontecendo agora</h1>
        <h1>Inscreva-se no Twitter hoje mesmo.</h1>
        <form className="login-form" onSubmit={handleSubmit}>
      <input
        value={inputValues?.email}
        onChange={handleChange}
        autoComplete="off"
        className="login-form__input"
        placeholder="Email" 
        name="email"
      />
      <input
        value={inputValues?.password}
        onChange={handleChange}
        autoComplete="off"
        className="login-form__input"
        placeholder="password"
        name="password"
        type="password"
      />
      <button type="submit" >
        logar
      </button>
        <a onClick={handlerRegister}> nao tem conta? inscreva-se agora</a>
    </form>
      </div>
    </div>
  );
}
