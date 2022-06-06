import "./style.css";
import { useEffect, useState } from "react";
import { Notices, Utilities, PerfilDetalhes } from "../..";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { AmigoComponent } from "../../components/amigos component/amigo.components";
import { useParams } from "react-router-dom";

export function ListarSeguindoScreen() {

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
            <h1>Usuarios quue voce segue:</h1>
          {usuario?.following?.map((a) => {
              return <AmigoComponent amigo={a} frase={"Voce esta segiundo"}/>;
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
