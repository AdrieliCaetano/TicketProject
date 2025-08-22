import { useEffect, useState } from "react"
import "../../styles/Style.css"
import type { ISale, ISaleUpdate } from "../../types/ISale"
import { getAllSales, updateSale } from "../../Repositories/SaleRepository"
import { formatDate } from "../../utils/date"

const ListSales = () => {

    const [ sales, setSales ] = useState<ISale[]>([])
    const [editingSaleId, setEditingSaleId] = useState<string | null>(null)
    const [newStatus, setNewStatus] = useState<string>("")
    const [filterStatus, setFilterStatus] = useState<string>("TODOS")

    
    useEffect(() => {
      
      getAllSales()
      .then(response => {
        console.log(response)
        setSales(response)
      })
      .catch(error => console.error(error))
      
    }, [])
    
    const filteredSales = sales.filter(sale => 
      filterStatus === "TODOS" ? true : sale.saleStatus === filterStatus)
      
    const handleUpdateStatus = async (sale: ISale) => {
    try {
      const modifiedSale: ISaleUpdate = {
        id: sale.id,
        user_id: sale.user.id,
        event_id: sale.event.id,
        saleDate: sale.saleDate,
        createdAt: sale.createdAt,
        saleStatus: newStatus
      }

      await updateSale(modifiedSale)

      setSales(prev =>
        prev.map(s =>
          s.id === sale.id ? { ...s, saleStatus: newStatus } : s
        )
      )

      setEditingSaleId(null)
    } catch (err) {
      console.log(err)
      alert("Erro ao alterar status da venda.")
    }
  }
  
  const statusOptions = ["EM_ABERTO", "PAGO", "CANCELADO", "ESTORNADO", "OUTRO"]

    return(

    <div style={{ padding: "20px" }}>
      <h2>Lista de Vendas:</h2>
      <div>
        <label htmlFor="status">Filtrar por status: </label>
        <select 
          id="status" 
          value={filterStatus} 
          onChange={e => setFilterStatus(e.target.value)}
        >
          <option value="TODOS">TODOS</option>
          <option value="EM_ABERTO">EM_ABERTO</option>
          <option value="PAGO">PAGO</option>
          <option value="CANCELADO">CANCELADO</option>
          <option value="ESTORNADO">ESTORNADO</option>
          <option value="OUTRO">OUTRO</option>
        </select>
      </div>
      <div className="main-container">
        {filteredSales.map(sale => (
          <div key={sale.id} className="main-card">
            <div className="main-card-header">
              <h3>Venda #{sale.id}</h3>
            </div>
              <div className="main-card-body">
                <p><strong>Data da venda:</strong> {formatDate(sale.saleDate)}</p>
                <p><strong>Comprador(a):</strong> {sale.user.name}</p>
                <hr />
                  <h3>Evento</h3>
                    <p><strong>Descrição: </strong> {sale.event.description}</p>
                    <p><strong>Data: </strong> {formatDate(sale.event.date)}</p>
                <hr />
                <p><strong>Status:</strong></p>
                  <span className={`status-badge ${sale.saleStatus.toLowerCase()}`}>
                    {sale.saleStatus}
                  </span>
                   {editingSaleId === sale.id ? (
                <div>
                  <select
                    value={newStatus || sale.saleStatus}
                    onChange={(e) => setNewStatus(e.target.value)}
                  >
                    {statusOptions.map(status => (
                      <option key={status} value={status}>{status}</option>
                    ))}
                  </select>
                  <button onClick={() => handleUpdateStatus(sale)}>Salvar</button>
                  <button onClick={() => setEditingSaleId(null)}>Cancelar</button>
                </div>
              ) : (
                <button onClick={() => {
                  setEditingSaleId(sale.id)
                  setNewStatus(sale.saleStatus)
                }}>
                  Alterar Status
                </button>
              )}
              </div>
          </div>
          ))}
        </div>
    </div>

    )

}

export default ListSales