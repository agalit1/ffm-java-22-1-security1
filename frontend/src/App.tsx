import React, {useEffect, useState} from 'react';
import './App.css';
import axios from "axios";
import LoginPage from "./LoginPage";
import SecuredPage from "./SecuredPage";

function App() {

  const [username, setUsername] = useState<string>();

  const fetchUsername = () => {
    axios.get("/api/app-users/me")
        .then(response => response.data)
        .then(setUsername)
  }

  useEffect(fetchUsername, [])

  if (username === undefined) {
    return <>Bitte haben Sie einen Augenblick Geduld</>
  }
  if (username === "anonymousUser") {
    return <LoginPage onLogin={fetchUsername}></LoginPage>
  }
  return <SecuredPage username={username} onLogout={fetchUsername}></SecuredPage>
}

export default App;
