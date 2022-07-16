import "./style.css";
import imageDefault from "../../../assets/image/imageDefault.png";
import { useState } from "react";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
export function Comentar({ postId, listarComentariosDoPost }) {
  const [inputValues, setInputValues] = useState();
  const postApi = usePostApi();

  function handleChange(eventoDeChange) {
    const { name, value } = eventoDeChange.target;
    setInputValues({ ...inputValues, [name]: value });
  }

  async function handleSubmit() {
    const category = "COMMENT";

    await postApi.incluirComentario(
      inputValues?.description,
      category,
      postId
    );
  }
  return (
    <>
      <div className="postar_div-postar">
        <div className="postar_div-photoPerfil-input">
          <img src={imageDefault} alt="" />

          <form className="comment-form">
            <input
              value={inputValues?.description}
              onChange={handleChange}
              autoComplete="off"
              className=""
              placeholder="O que esta acontecendo?"
              name="description"
            />
          </form>
        </div>
        <div className="postar_div-imgs-post-submit">
          <div>
            <img src={imageDefault} alt="" />
            <img src={imageDefault} alt="" />
            <img src={imageDefault} alt="" />
            <img src={imageDefault} alt="" />
            <img src={imageDefault} alt="" />
            <img src={imageDefault} alt="" />
          </div>
          <div>
            <input
              type="submit"
              value={"IfTar"}
              onClick={handleSubmit}
              className="postar-button"
            />
          </div>
        </div>
      </div>
    </>
  );
}
