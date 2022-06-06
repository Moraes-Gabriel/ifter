import "./notificacao.components.css";
import image from "../../../assets/image/dog-perfil.jpg";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export function NotificacaoComponent({ usuario }) {
  const navigate = useNavigate();
  const userApi = useUsuarioApi();
  function handleClickler() {
    navigate(`/${usuario?.identify}`);
  }

  function handlerAcceptSolicitation(){
      userApi.aceitarSolicitacao(usuario?.identify)
  }
  function handlerRecuseSolicitation(){
      userApi.recusarSolicitacao(usuario?.identify)
  }
   return (
    <div className="usuario_div-main">
      <div className="usuario_button">
        <button className="usuario_button-foto-perfil" onClick={handleClickler}>
          <img src={image} alt="" />
        </button>
        <div className="usuario_div-content">
          <div className="usuario_div-info-person">
            <h1 className="usuario_nickName">{usuario?.nickName}</h1>
            <h1>@{usuario?.identify}</h1>
            <h1>.</h1>
            <h1>20h</h1>
          </div>
          <p className="usuario_content">Voce tem uma solicitacao de amizade</p>
        </div>

        <button className="usuario_button-aceitar-solicitacao" onClick={handlerAcceptSolicitation}>aceitar</button>
        <button className="usuario_button-recusar-solicitacao" onClick={handlerRecuseSolicitation}>recusar</button>
      </div>
    </div>
  );
}
