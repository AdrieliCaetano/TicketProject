import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import type { ISaleCreate } from "../../types/ISale";
import { createSale } from "../../Repositories/SaleRepository";
import type { IUser } from "../../types/IUser";
import { getAllUsers } from "../../Repositories/UserRepository";
import { getAllEvents } from "../../Repositories/EventRepository";
import type { IEvent } from "../../types/IEvent";

export default function SaleCreate () {
    const navigate = useNavigate()

    const [users, setUsers] = useState<IUser[]>([]);
    const [events, setEvents] = useState<IEvent[]>([]);

    const [user_id, setUser_id] = useState("");
    const [event_id, setEvent_id] = useState("");
    const [saleDate, setSaleDate] = useState("");
    const [saleStatus, setSaleStatus] = useState("");

    useEffect(() => {

        getAllUsers()
            .then(data => setUsers(data))
            .catch(error => console.error(error))

        getAllEvents()
            .then(data => setEvents(data))
            .catch(error => console.log(error));

    }, [])

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault()
        try {
            const newSale: ISaleCreate = {
                user_id,
                event_id,
                saleDate,
                saleStatus,
            }

            const createdSale = await createSale(newSale)
            alert(`Venda criada com sucesso! Id: ${createdSale.id}`)
            navigate("/sales")
        } catch (err){
            console.log(err)
            alert("Erro ao criar venda")
        }
    }

     return (
    <div style={{ padding: "20px" }}>
      <h1>Registrar Venda</h1>
      <form className="form-container" onSubmit={handleSubmit}>
        <label>Comprador(a):</label>
        <select 
          value={user_id} 
          required 
          onChange={e => setUser_id(e.target.value)}
        >
          <option value="" disabled>Selecione um usuário:</option>
          {users.map(user => (
            <option key={user.id} value={user.id}>
              {user.name}
            </option>
          ))}
        </select>

        <label>Evento:</label>
        <select 
          value={event_id} 
          required 
          onChange={e => setEvent_id(e.target.value)}
        >
          <option value="" disabled>Selecione um evento:</option>
          {events.map(event => (
            <option key={event.id} value={event.id}>
              {event.description} – {new Date(event.date).toLocaleDateString("pt-BR")}
            </option>
          ))}
        </select>

        <label>Status:</label>
        <select value={saleStatus} required onChange={e => setSaleStatus(e.target.value)}>
          <option value="" disabled >Selecione:</option>
          <option value="EM_ABERTO">EM_ABERTO</option>
          <option value="PAGO">PAGO</option>
          <option value="CANCELADO">CANCELADO</option>
          <option value="ESTORNADO">ESTORNADO</option>
          <option value="OUTRO">OUTRO</option>
        </select>

        <label>Data da venda:</label>
        <input type="datetime-local" value={saleDate} required onChange={e => setSaleDate(e.target.value)} />

        <button type="submit">Registrar</button>
      </form>
    </div>
  )
}