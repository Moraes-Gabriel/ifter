import "./login.screen.css";
import ifsul from "../../../assets/image/icon-ifsul.jpg";
import iconIfsul from "../../../assets/image/iconIF.png";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useGlobalUser } from "../../../context/user.context";
import { useLoginApi } from "../../../hooks/api/login/use-login-api.hook"
import { useGlobalError } from "../../../context/error.context";
import { toast } from 'react-toastify';

export function LoginScreen() {

  const [inputValues, setInputValues] = useState();
  const [globalUser, setGlobalUser] = useGlobalUser();
  const [,setError] = useGlobalError();
  const navigate = useNavigate();
  const loginApi = useLoginApi();


  const handleChange = (eventoDeChange) => {
    const { name, value } = eventoDeChange.target;
    setInputValues({ ...inputValues, [name]: value });
  };

  function handlerRegister() {
    navigate("/register")
  }

  async function onLoginSubmit(event) {
    event.preventDefault()
    try {
      const user = await loginApi.logar(inputValues?.email, inputValues?.password);

      setGlobalUser(user)
      localStorage.setItem('token', JSON.stringify(user))
      toast("Logado com sucesso");
      navigate("/home")

    } catch (error) {
      setError(error.response?.data?.message)
    }
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
        <form className="login-form" onSubmit={onLoginSubmit}>
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
