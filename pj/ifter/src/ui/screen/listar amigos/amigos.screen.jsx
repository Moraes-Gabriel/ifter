import "./style.css";
import { useEffect, useState } from "react";
import { Notices, Utilities, PerfilDetalhes } from "../..";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { AmigoComponent } from "../../components/amigos component/amigo.components";
import { useParams } from "react-router-dom";

export function ListarAmigosScreen() {

  const [usuario, setUsuario] = useState([]);
  const userApi = useUsuarioApi();
  const { identify } = useParams();

  async function buscarUsuarioLogado() {
    const response = await userApi.pesquisarPorIdentify(identify);
    setUsuario(response);
  }
  useEffect(() => {
    buscarUsuarioLogado();
  }, []);

  console.log(usuario);
  return (
    <>
      <div className="main">
        <div className="main_div-utilities">
          <Utilities />
        </div>
        <div className="main_div-content">
          <PerfilDetalhes usuario={usuario} />

          <div>
            <h1>Sao amigos</h1>
          {usuario?.friends?.map((a) => {
              return <AmigoComponent amigo={a} frase={"Voces sao amigos"}/>;
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
