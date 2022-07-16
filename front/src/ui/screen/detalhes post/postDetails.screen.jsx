import "./postDetails.screen.css";
import { useEffect, useState } from "react";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
import { useParams } from "react-router-dom";
import { Notices, Utilities } from "../..";
import { Post } from "../../components/post/post.components";
import { Comentar } from "../../components/Comentar/Comentar.component";

export function PostDetails() {
  const [postDetails, setPostDetails] = useState();
  const [comments, setComments] = useState([]);
  const { identity, postId } = useParams();
  const postApi = usePostApi();

  async function pesquisarPostPorId() {
    const response = await postApi.buscarPostPorId(postId);
    setPostDetails(response);
  }

  async function listarComentariosDoPost() {
    const response = await postApi.listarComentariosPorPostId(postId);
    setComments(response);
  }
  
  useEffect(() => {
    pesquisarPostPorId();
    listarComentariosDoPost();
  }, [ ]);

  return (
    <>
      <div className="main">
        <div className="main_div-utilities">
          <Utilities />
        </div>
        <div className="pesquisarUsuario_div-main">

          <Post post={postDetails} />
          <Comentar postId ={postId} listarComentariosDoPost ={listarComentariosDoPost}/>
          
          {comments?.map(c => {
            return <Post post={c} getPosts={listarComentariosDoPost} />;
          })}
        </div>
        
        <div className="main_div-notices">
          <Notices />
        </div>
      </div>
    </>
  );
}
