import { useMemo } from "react";
import { useGlobalUser } from "../../../context/user.context";
import { useHttp } from "../_base/use-http.hook";
import { url } from "../../../context/API_URL.js"
import { toast } from "react-toastify";


export function useLoginApi() {

  const [user,] = useGlobalUser();

  const API_URL = url+"";

  const httpInstance = useHttp(API_URL, {});

  async function logar(email, password) {
      const response = httpInstance.login('/login',
      {},
      {
        auth: {username: email, password: password}
      })
      return response;
  }

  async function logout() {
    const response = await httpInstance.post('/logout', 
     {} ,
    {
      headers: {
        'X-Auth-Token': user
      }
    });
    return response;
  } 

  async function register(inputValues) {
    try{
      const response = httpInstance.post('/usuario',
      inputValues,
      {})
      toast("registado com sucesso")

      return response;
      
    }catch(error){
      console.log("ASD");
    }
}
  
  

  return useMemo(
    () => ({
      logar,
      register,
      logout
    }),
    [user]
  );
}
