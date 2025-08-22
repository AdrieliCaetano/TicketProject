import { Link } from "react-router-dom"
import ListSales from "../../components/sales/ListSales"

export default function Sales() {
  return (
    <div style={{ padding: "20px" }}>
      <h1>Vendas</h1>

      <Link to="/sale/create">
        <button style={{ backgroundColor:"rgb(131, 160, 26)"}}>
          + Nova Venda
        </button>
      </Link>
      <ListSales/>
    </div>
  )
}