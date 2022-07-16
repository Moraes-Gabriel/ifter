import createGlobalState from 'react-create-global-state'

const KEY_LOCALSTORAGE = 'token'

const pegandoLocalStorage = localStorage.getItem(KEY_LOCALSTORAGE)

const valorInicial =  JSON.parse(pegandoLocalStorage) || null

const [useUsuario,  UserGlobalProvider] = createGlobalState(valorInicial)

function useGlobalUser() {
  const [usuario, setUsuario] = useUsuario()
  
  function setInformacoesUsuario(valorRecebido) {
    setUsuario(valorRecebido)
    localStorage.setItem(KEY_LOCALSTORAGE, JSON.stringify(valorRecebido))
  }
  return [usuario, setInformacoesUsuario]
}

export { useGlobalUser, UserGlobalProvider }
