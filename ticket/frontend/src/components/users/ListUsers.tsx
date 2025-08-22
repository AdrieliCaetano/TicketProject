import { useEffect, useState } from "react"
import type { IUser } from "../../types/IUser"
import { getAllUsers } from '../../Repositories/UserRepository'

const ListUsers = () => {

    // Hook: useState
    const [ users, setUsers ] = useState<IUser[]>([])

    // Hook: useEffect
    useEffect(() => {

        getAllUsers()
            .then(response => {
                console.log(response)
                setUsers(response)
            })
            .catch(error => console.error(error))

    }, [])

    return(

        <div style={{ padding: "20px" }}>
            <h2>Lista de Usuários:</h2>

            <div className="main-container">
                {users.map(user => (
                <div key={user.id} className="main-card">
                <h3>{user.name}</h3>
                <p>Email: {user.email}</p>
          </div>
        ))}
      </div>

        </div>

    )

}

export default ListUsers