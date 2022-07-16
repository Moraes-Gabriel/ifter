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
  PostDetails,
} from "./ui/index";
import { Mensagem } from "./ui/screen/mensagem/Mensagem.screen";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function App() {
  const [user] = useGlobalUser();
  const [error] = useGlobalError();

  function PrivateRoute({ children }) {
    if (user) {
      return (
        <>
          <Header />
          {children}
        </>
      );
    } else {
      return <Navigate to="/" />;
    }
  }

  return (
    <>
      <ToastContainer />

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
