import { useState } from "react";
import { createEvent } from "../../Repositories/EventRepository";
import type { IEventCreate } from "../../types/IEvent";
import { useNavigate } from "react-router-dom";

export default function EventCreate() {
    
    const navigate = useNavigate()

    const [description, setDescription] = useState("");
    const [type, setType] = useState("");
    const [price, setPrice] = useState(0);
    const [startSales, setStartSales] = useState("");
    const [endSales, setEndSales] = useState("");
    const [date, setDate] = useState("");

    const handleSubmit = async (e: React.FormEvent) => {  
        e.preventDefault()  
        try {
            const newEvent: IEventCreate = {
                description,
                type,
                date,
                startSales,
                endSales,
                price,
            }
            
            const createdEvent = await createEvent(newEvent)
            alert(`Evento criado com sucesso! Id: ${createdEvent.id}`)
            navigate("/events")
        } catch (err) {
            console.error(err)
            alert("Erro ao criar evento" )
        }
    }


  return (
    <div style={{ padding: "20px" }}>
      <h1>Cadastrar Evento</h1>
      <form className="form-container" onSubmit={handleSubmit}>
        <label>Descrição:</label>
        <input type="text" value={description} required onChange={e => setDescription(e.target.value)} />

        <label>Tipo:</label>
        <select value={type} required onChange={e => setType(e.target.value)}>
          <option value="" disabled >Selecione:</option>
          <option value="PALESTRA">Palestra</option>
          <option value="SHOW">Show</option>
          <option value="TEATRO">Teatro</option>
          <option value="CURSO">Curso</option>
          <option value="OUTRO">Outro</option>
        </select>

        <label>Preço:</label>
        <input type="number" step="0.01" value={price} onChange={e => setPrice(parseFloat(e.target.value))} />

        <label>Data do Evento:</label>
        <input type="datetime-local" value={date} required onChange={e => setDate(e.target.value)} />

        <label>Início das Vendas:</label>
        <input type="datetime-local" value={startSales} required onChange={e => setStartSales(e.target.value)} />

        <label>Fim das Vendas:</label>
        <input type="datetime-local" value={endSales} required onChange={e => setEndSales(e.target.value)} />

        <button type="submit">Criar Evento</button>
      </form>
    </div>
  )
}
