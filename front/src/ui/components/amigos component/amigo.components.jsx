import "./amigo.components.css";
import React from 'react'
import image from "../../../assets/image/dog-perfil.jpg";
import { useNavigate } from "react-router-dom";

export function AmigoComponent({ amigo, frase }) {
  const navigate = useNavigate();
 
  function handleClickler() {
    navigate(`/${amigo?.identify}`)
  }

   return (
    <div className="usuario_div-main">
      <div className="usuario_button">
        <button className="usuario_button-foto-perfil" onClick={handleClickler}>
          <img src={image} alt="" />
        </button>
        <div className="usuario_div-content">
          <div className="usuario_div-info-person">
            <h1 className="usuario_nickName">{amigo?.nickName}</h1>
            <h1>@{amigo?.identify}</h1>
            <h1>.</h1>
            <h1>20h</h1>
          </div>
          <p>{frase}</p>
        </div>
      </div>
    </div>
  );
}
