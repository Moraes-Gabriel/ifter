import "./perfilDetalhes.components.css";
import image from "../../../assets/image/dog-perfil.jpg";
import imagemCoracao from "../../../assets/image/coracao.png";
import capa from "../../../assets/image/capa.jpg";
import imagemCoracaoP from "../../../assets/image/coracao-p.png";
import downloadIcon from "../../../assets/image/download.png";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export function PerfilDetalhes() {
  const postApi = usePostApi();
  const [usuario, setUsuario] = useState();
  const [userLogin, setUserLogin] = useState();
  const { identify } = useParams();
  const usuarioApi = useUsuarioApi();

  async function buscarUsuarioLogado() {
    const response = await usuarioApi.buscarUsuarioLogado();
    setUserLogin(response);
  }

  async function handlerSeguir() {
    await usuarioApi.seguir(usuario?.identify);
    buscarUsuarioLogado();
  }

  async function pesquisarUsuarioIdentity() {
    const response = await usuarioApi.pesquisarPorIdentify(identify);
    setUsuario(response);
  }

  useEffect(() => {
    pesquisarUsuarioIdentity();
    buscarUsuarioLogado();
  }, []);

  const verifyFriend = usuario?.amigo ? "deseguir" : "seguir";
  return (
    <div className="perfilDetails_div-main">
      <div className="perfilDetails_div-capa">
        <img src={capa} alt="" className="perfilDetails_img-capa" />
        <img src={capa} alt="" id="perfilDetails_photo-perfil" />
      </div>
      <div className="perfilDetails_div-infos">
        <div className="perfilDetails_div-buttonEditar">
          {userLogin?.identify === usuario?.identify && (
            <button>Editar perfil</button>
          )}
          {userLogin?.identify !== usuario?.identify && (
            <button
              onClick={handlerSeguir}
              className="perfilDetails_button-follow"
            >
              {verifyFriend}
            </button>
          )}
        </div>
        <div className="perfilDetails_div-div">
          <div className="perfilDetails_div-nicks">
            <h1>{usuario?.nickName}</h1>
            <h3>{usuario?.identify}</h3>
          </div>
          <div className="perfilDetails_div-description">
            <p>{usuario?.description}</p>
          </div>
          <div className="perfilDetails_div-local">
            Sapucaia do Sul, Brasil . Ingressou em janeiro de 2013
          </div>
          <div>
            {`Seguindo ${usuario?.following?.length} 
            Seguidores ${usuario?.followers?.length} Amigos ${usuario?.friends?.length}`}
          </div>
          <div className="perfilDetails_div-followers"></div>
        </div>
      </div>
    </div>
  );
}
