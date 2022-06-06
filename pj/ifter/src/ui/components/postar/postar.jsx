import "./style.css";
import imageDefault from "../../../assets/image/imageDefault.png";
import { useEffect, useState } from "react";
import { usePostApi } from "../../../hooks/api/post/use-post-api.hook";
import { useNavigate } from "react-router-dom";
import { useUsuarioApi } from "../../../hooks/api/usuario/use-usuario-api.hook";

export function Postar({ getPosts }) {
  const [inputValues, setInputValues] = useState();
  const [userLogin,setUserLogin] = useState();  
  const postApi = usePostApi();
  const userApi = useUsuarioApi();
  const navigate = useNavigate();

  async function buscarUsuarioLogado(){
    const response = await userApi.buscarUsuarioLogado();
    setUserLogin(response)
  }
  function handleChange(eventoDeChange) {
    const { name, value } = eventoDeChange.target;
    setInputValues({ ...inputValues, [name]: value });
  }

  function handleSubmit() {
    const response = postApi.incluir(inputValues?.description, inputValues?.category);
    //setResponse(response)
    getPosts();
  }
  function handlerProfile() {
    navigate(`/${userLogin?.identify}`)
  }

  useEffect(() => {
    buscarUsuarioLogado();
  }, [])

  return (
    <>
      <div className="postar_div-postar">
        <div className="postar_div-photoPerfil-input">
          <img src={imageDefault}  onClick={handlerProfile} alt=""/>

          <form className="postar-form">
            <input
              value={inputValues?.description}
              onChange={handleChange}
              autoComplete="off"
              className=""
              placeholder="O que esta acontecendo?"
              name="description"
            />
            <select name="category" id="category" form="category" onChange={handleChange}>
              <option value="">none</option>
              <option value="PUBLIC">PUBLIC</option>
              <option value="PRIV">PRIV</option>
            </select>
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
            <input type="submit" value={'IFtar'} onClick={handleSubmit} className='postar-button'/>

          </div>
        </div>
      </div>
    </>
  );
}
