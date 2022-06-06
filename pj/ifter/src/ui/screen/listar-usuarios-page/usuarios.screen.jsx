import "./style.css";
import { useEffect, useState } from "react";
import { Notices, Utilities, PerfilDetalhes } from "../..";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { AmigoComponent } from "../../components/amigos component/amigo.components";
import { useParams } from "react-router-dom";

export function ListarUsuariosScreen() {

  const [usuario, setUsuario] = useState([]);
  const userApi = useUsuarioApi();
  const { page } = useParams();

  async function buscarTodosUsuariosPage() {
    const response = await userApi.listarTodosUsuariosPage(page);
    console.log(response);
    setUsuario(response);
  }
  useEffect(() => {
    buscarTodosUsuariosPage();
  }, []);

  return (
    <>
      <div className="main">
        <div className="main_div-utilities">
          <Utilities />
        </div>
        <div className="main_div-content">
          <div>
            <h1>Todos os usuarios</h1>
          {usuario?.map((a) => {
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
