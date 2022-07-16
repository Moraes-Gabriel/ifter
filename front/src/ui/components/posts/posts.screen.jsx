import "./style.css";
import imageDefault from "../../assets/image/imageDefault.png";
import { Postar } from "../postar/postar";
import { Post } from "../post/post.screen";
export function Posts() {
  return (
    <div className="posts_div-main">
        <Postar/>
        
        <Post/>
    </div>
  );
}
