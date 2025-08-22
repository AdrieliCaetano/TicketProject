import { useEffect, useState } from "react"
import { getAllEvents } from "../../Repositories/EventRepository"
import type { IEvent } from "../../types/IEvent"
import "../../styles/Style.css"
import { formatDate } from "../../utils/date"

const ListEvents = () => {

    const [ events, setEvents ] = useState<IEvent[]>([])

    useEffect(() => {

        getAllEvents()
            .then(response => {
                console.log(response)
                setEvents(response)
            })
            .catch(error => console.error(error))

    }, [])

    return(

    <div style={{ padding: "20px" }}>
      <h2>Lista de Eventos:</h2>

      <div className="main-container">
        {events.map(event => (
          <div key={event.id} className="main-card">
            <h3>{event.description}</h3>
            <h5>{formatDate(event.date)}</h5>
            <p>Tipo: {event.type}</p>
            <p>Início das vendas: {formatDate(event.startSales)}</p>
            <p>Fim das vendas: {formatDate(event.endSales)}</p>
            <p>Preço: R$ {event.price.toFixed(2)}</p>
          </div>
        ))}
      </div>
    </div>

    )

}

export default ListEvents