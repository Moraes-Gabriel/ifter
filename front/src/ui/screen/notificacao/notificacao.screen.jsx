import "./style.css";
import { useEffect, useState } from "react";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
import { useNavigate, useParams } from "react-router-dom";
import { Notices, Utilities, Post, PerfilDetalhes } from "../..";
import { useGlobalUser } from "../../../context/user.context";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { NotificacaoComponent } from "../../components/notificacao/notificacao.components";

export function Notificacao() {
  const [usuario, setUsuario] = useState([]);
  const [notification, setNotification] = useState([]);
  const { identify } = useParams();
  const userApi = useUsuarioApi();

  async function listarNotificacaoPorIdentify() {
    const response = await userApi.listarNotificacaoUsuario();
    setNotification(response);
  }
  
  useEffect(() => {
    listarNotificacaoPorIdentify();
  }, []);

  return (
    <>
      <div className="main">
        <div className="main_div-utilities">
          <Utilities />
        </div>
        <div className="main_div-content">
          <PerfilDetalhes usuario={usuario} />

          <div>
            {notification?.map((u) => {
              return <NotificacaoComponent usuario={u} />;
            })}
          </div>
        </div>
        <div className="main_div-notices">
          <Notices />
        </div>
      </div>
    </>
  );
}
