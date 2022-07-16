import "./style.css";
import { useEffect, useState } from "react";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
import { useNavigate, useParams } from "react-router-dom";
import { Notices, Utilities, Post, PerfilDetalhes } from "../..";
import { useGlobalUser } from "../../../context/user.context";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";

export function PerfilScreen() {
  const [usuario, setUsuario] = useState([]);
  const [posts, setPosts] = useState([]);
  const [user] = useGlobalUser();
  const { identify } = useParams();
  const postApi = usePostApi();


  async function procurarPostsDoUsuario() {
    const response = await postApi.listarPostsDoUsuarioPorIdentify(identify);
    setPosts(response);
  }
  function getPosts() {
  }
  useEffect(() => {
    procurarPostsDoUsuario();
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
            {posts?.map((post) => {
              return <Post post={post} getPosts={getPosts} />;
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
