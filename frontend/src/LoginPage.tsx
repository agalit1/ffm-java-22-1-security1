import React, {useState} from 'react';
import axios from "axios";

type Props = {
    onLogin: () => void,
}

export default function LoginPage(props: Props) {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const register = () => {
        axios.post("/api/app-users", {
            username,
            password
        })
    }

    const login = () => {
        axios.get("/api/app-users/login", {
            auth: {
                username,
                password
            }
        })
            .then(props.onLogin)
    }

    return <>
        <br/>
        <label htmlFor="username">Benutzername</label>
        <input type="text" id="username" onChange={event => setUsername(event.target.value)}/>
        <br/>
        <label htmlFor="password">Passwort</label>
        <input type="password" id="password" onChange={event => setPassword(event.target.value)}/>
        <br/>
        <button onClick={() => register()}>Registrieren</button>
        <button onClick={() => login()}>Anmelden</button>
    </>
}
