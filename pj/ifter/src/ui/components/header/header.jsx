import "./style.css";
import iconIf from "../../../assets/image/iconIF.png";
import iconPesquisar from "../../../assets/image/iconPesquisar2.png"
import React from "react";
import { useNavigate } from "react-router-dom";

export function Header() {

  const navigate = useNavigate();
  
  function handlerChange(handler) {
    const identify = handler.target.value; 
    if(identify)
    navigate(`/buscar/${identify}`)

  }
function handlerBackHome( ){
  navigate('/home')
}

  return (
    <div className="header_div-main">
      <div className="header-div-icon">
        <img src={iconIf} alt="" onClick={handlerBackHome}/>
      </div>
      <div className="header_div-tittle">
          <h1>Pagina principal</h1>
      </div>
      <div className="header_div-pesquisar">
          <img src={iconPesquisar} alt="" />
          <input type="text" placeholder="Buscar no ifter"
           onChange={handlerChange} name="pesquisa"
           />
      </div>
    </div>
  );
}
