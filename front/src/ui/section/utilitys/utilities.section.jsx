import "./style.css";
import inicial from "../../../assets/image/botaoHome.png";
import notificacao from "../../../assets/image/notificacao.png";
import mensagens from "../../../assets/image/mensagens.png";
import perfil from "../../../assets/image/perfilDeUsuario.png";
import sair from "../../../assets/image/sair.png";
import { useNavigate } from "react-router-dom";
import { useGlobalUser } from "../../../context/user.context";
import { useEffect, useState } from "react";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { useLoginApi } from "../../../hooks/api/login/use-login-api.hook";

export function Utilities() {

  const [userLogin,setUserLogin] = useState();  
  const userApi = useUsuarioApi();
  const loginApi = useLoginApi();
  const [, setUserLogado] = useGlobalUser();
  const navigate = useNavigate();

  async function buscarUsuarioLogado(){
    const response = await userApi.buscarUsuarioLogado();
    setUserLogin(response)
  }
  function handlerPaginaInicial() {
    navigate('/home')
  }
  function handlerNotificacao() {
    navigate(`/${userLogin?.identify}/notificacao`)
  }
  function handlerSair(){
    setUserLogado(null);
    loginApi.logout();
  }
   useEffect(() => {
    buscarUsuarioLogado();
  }, [])
  
  return (
    <div className="utilities_div-main">
      <button onClick={handlerPaginaInicial}>
        <img src={inicial} alt="" />
        Pagina inicial
      </button>
      <button onClick={handlerNotificacao}>
      <img src={notificacao} alt="" />
        Notificacoes
      </button>
      <button>
      <img src={mensagens} alt="" />
        Mensagens
      </button>
      <button>
      <img src={perfil} alt="" />
        Perfil
      </button>
      <button onClick={handlerSair}>
      <img src={sair} alt="" />
        Sair
      </button>
    </div>
  );
}
