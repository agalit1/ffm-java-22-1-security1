import axios from "axios";

type Props = {
    username: string,
    onLogout: () => void
}

export default function SecuredPage(props: Props) {

    const logout = () => {
        axios.get("/api/app-users/logout")
            .then(response => response.data)
            .then(props.onLogout)
    }

    return <>
        <section><h1>Secured</h1></section>
        <h1>Willkommen {props.username}</h1>
        <button onClick={() => logout()}>Logout</button>
    </>
}
