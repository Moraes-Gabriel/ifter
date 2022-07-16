import "./usuarioPesquisado.css";
import image from "../../../assets/image/dog-perfil.jpg";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export function UsuarioPesquisado({ usuario, pesquisar }) {

  const usuarioApi = useUsuarioApi();
  const navigate = useNavigate();
  
  async function handlerSeguir() {
       await usuarioApi.seguir(usuario?.identify)
       pesquisar()
  }
  async function handlerDeseguir() {
       await usuarioApi.deseguir(usuario?.identify)
       pesquisar()
  }
  function handleClickler() {
    navigate(`/${usuario?.identify}`)
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
          <p className="usuario_content">{usuario?.description}</p>
        </div>
       
        {!!!usuario?.amigo &&<button className="usuario_button-seguir" onClick={handlerSeguir}>
          Seguir
        </button>}
        {!!usuario?.amigo &&<button className="usuario_button-seguir" onClick={handlerDeseguir}>
          Deseguir
        </button>}

      </div>
    </div>
  );
}
