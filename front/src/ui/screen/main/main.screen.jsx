import { useEffect, useState } from "react";
import { useGlobalUser } from "../../../context/user.context";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
import { Notices, Utilities,Header,Postar,Post } from "../..";
import "./style.css";
import { useGlobalError } from "../../../context/error.context";

export function Main() {

  const postApi = usePostApi();
  const [posts, setPosts] = useState([]);
  const [user,] = useGlobalUser();


  async function getPosts() {
      const response = await postApi.listarPosts();
    setPosts(response);
  }

  useEffect(() => {
    getPosts();
  }, []);

  return (
    <>
      <div className="main">
        <div className="main_div-utilities">
          <Utilities />
        </div>
        <div className="main_div-content">
        <Postar getPosts={getPosts}/>
        
        {posts?.map(post => {
          return <Post post={post} getPosts={getPosts}/>
        })}
         
        </div>
        <div className="main_div-notices">
          <Notices />
        </div>
      </div>
    </>
  );
}
