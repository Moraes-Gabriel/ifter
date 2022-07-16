import "./post.components.css";
import image  from "../../../assets/image/dog-perfil.jpg"
import imagemCoracao from "../../../assets/image/coracao.png"
import imagemCoracaoP from "../../../assets/image/coracao-p.png"
import downloadIcon from "../../../assets/image/download.png"
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
import { useNavigate } from "react-router-dom";

export function Post({ post, getPosts }) {

  const postApi = usePostApi();
  const navigate = useNavigate();

  function handlerNavigatePerfil() {
    navigate(`/${post?.usuario?.identify}`)
  }
  function handlerNavigatePost() {
    navigate(`/${post?.usuario?.identify}/status/${post?.id}`)
  }
  async function handleGostar() {
    await postApi.gostar(post?.id)
    getPosts()
  }
  
  async function handleDesgostar() {
    await postApi.desgostar(post?.id)
    getPosts()
  }
  return (
    <div className="post_div-main" >
        <button className="post_button" >
          <button className="post_button-foto-perfil" onClick={handlerNavigatePerfil}>
            <img src={image} alt="" />
          </button>
          <div className="post_div-content" onClick={handlerNavigatePost}>
            <div className="post_div-info-person">
              <h1 className="post_nickName">{post?.usuario?.nickName}</h1>
              <h1>@{post?.usuario?.identify}</h1>
              <h1>.</h1>
              <h1>20h</h1>
              <h1 className="post_category">{post?.category}</h1>
            </div>
            <p className="post_content">{post?.description}</p>
          </div>
        </button>
        <div className="post_div-actions"> 
          <div className="post_div-curtidas">
          <button onClick={handleGostar}>
            <img src={imagemCoracao} alt="" />
          </button>
          <p>{post?.likes}</p>
          </div>
          <button onClick={handleDesgostar}>
          <img src={imagemCoracaoP} alt="" />
          </button>
          <button >
            <img src={downloadIcon} alt="" />
          </button>
        </div>
    </div>
  );
}
