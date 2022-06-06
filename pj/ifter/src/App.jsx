import { Navigate, Route, Routes } from "react-router-dom";
import "./App.css";
import { useGlobalError } from "./context/error.context";
import { useGlobalUser } from "./context/user.context";
import {
  Main,
  LoginScreen,
  Buscar,
  Header,
  PerfilScreen,
  Notificacao,
  RegisterScreen,
  ListarAmigosScreen,
  ListarSeguindoScreen,
  ListarUsuariosScreen,
} from "./ui/index";
import { PostDetails } from "./ui/screen/detalhes post/postDetails.screen";
import { Mensagem } from "./ui/screen/mensagem/Mensagem.screen";

function App() {
  const [user] = useGlobalUser();
  const [error] = useGlobalError();

  function PrivateRoute({ children }) {
    const [, setError] = useGlobalError();
    if (user) {
      return <>{children}</>;
    } else {
      return <Navigate to="/" />;
    }
  }
  console.log(user !== null);
  return (
    <>
      {user || user === {} ? <Header /> : null}
      {error && <p className="error_mensagem">{error.mensagem}</p>}
      <Routes>
        <Route path="/" element={<LoginScreen />} />

        <Route path="/register" element={<RegisterScreen />} />

        <Route
          path="/home"
          element={
            <PrivateRoute>
              <Main />
            </PrivateRoute>
          }
        />
        <Route
          path="/buscar/:identity"
          element={
            <PrivateRoute>
              <Buscar />
            </PrivateRoute>
          }
        />
        <Route
          path="/:identify"
          element={
            <PrivateRoute>
              <PerfilScreen />
            </PrivateRoute>
          }
        />
        <Route
          path="/:identify/status/:postId"
          element={
            <PrivateRoute>
              <PostDetails />
            </PrivateRoute>
          }
        />
        <Route
          path="/:identify/notificacao"
          element={
            <PrivateRoute>
              <Notificacao />
            </PrivateRoute>
          }
        />
        <Route
          path="/:identify/seguindo"
          element={
            <PrivateRoute>
              <ListarSeguindoScreen />
            </PrivateRoute>
          }
        />

        <Route
          path="/:identify/amigos"
          element={
            <PrivateRoute>
              <ListarAmigosScreen />
            </PrivateRoute>
          }
        />

        <Route
          path="/usuarios/:page"
          element={
            <PrivateRoute>
              <ListarUsuariosScreen />
            </PrivateRoute>
          }
        />
          <Route
          path="/:identify/mensagem"
          element={
            <PrivateRoute>
              <Mensagem />
            </PrivateRoute>
          }
        />
      </Routes>
    </>
  );
}

export default App;
