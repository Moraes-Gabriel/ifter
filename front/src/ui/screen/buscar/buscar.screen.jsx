import "./style.css";
import { useEffect, useState } from "react";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
import { useNavigate, useParams } from "react-router-dom";
import { Notices, Utilities } from "../../";
import { useGlobalUser } from "../../../context/user.context";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { UsuarioPesquisado } from "../../components/usuarioPesquisado/usuarioPesquisado.component";

export function Buscar() {
  const [usuariosPesquisados, setusuariosPesquisados] = useState([]);
  const [user] = useGlobalUser();
  const { identity } = useParams();
  const usuarioApi = useUsuarioApi();
  const postApi = usePostApi();

  async function pesquisarUsuarioIdentity() {
    const response = await usuarioApi.pesquisarPorIdentifyOrEmail(identity);
    setusuariosPesquisados(response);
  }
  useEffect(() => {
    pesquisarUsuarioIdentity();
  }, [identity]);

  return (
    <>
      <div className="main">
        <div className="main_div-utilities">
          <Utilities />
        </div>
        <div className="pesquisarUsuario_div-main">
          {usuariosPesquisados?.map((usuario) => {
            return <UsuarioPesquisado usuario={usuario} pesquisar={pesquisarUsuarioIdentity}/>;
          })}
          </div>
        <div className="main_div-notices">
          <Notices />
        </div>
      </div>
    </>
  );
}
