import './App.css'
import { Routes, Route } from "react-router-dom"
import Home from "./pages/Home"
import Users from "./pages/Users"
//import Sales from "./pages/Sales"
import Events from "./pages/events/Events"
import Navbar from "./components/Navbar"
import EventCreate from './pages/events/EventCreate'
import Sales from './pages/sales/Sales'
import SaleCreate from './pages/sales/SaleCreate'
function App() {

  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/users" element={<Users />} />
        <Route path="/events" element={<Events />} />
        <Route path="/event/create" element={<EventCreate />} />
        <Route path="/sales" element={<Sales />} />
        <Route path="/sale/create" element={<SaleCreate />} />
        
      </Routes>
      <div style={{borderBottom: "1px solid #ccc" }} ></div>
      <footer  style={{ padding: "1rem"}}>
        <p>Sistema de Vendas de Tickets</p>
        <p>© 2025</p>
        </footer>
    </>
  )
}

export default App
