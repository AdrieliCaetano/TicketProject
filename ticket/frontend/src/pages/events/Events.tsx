import { Link } from "react-router-dom"
import ListEvents from "../../components/events/ListEvents"

export default function Events() {
  return (
    <div style={{ padding: "20px" }}>
      <h1>Eventos</h1>

      <Link to="/event/create">
        <button style={{ backgroundColor:"rgb(131, 160, 26)"}}>
          + Novo Evento
        </button>
      </Link>
      <ListEvents/>
    </div>
  )
}
