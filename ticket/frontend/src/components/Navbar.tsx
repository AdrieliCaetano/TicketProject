import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav style={{ padding: "1rem", borderBottom: "1px solid #ccc" }}>
      <ul style={{ display: "flex", gap: "1rem", listStyle: "none", margin: 0, padding: 0 }}>
        <li>
          <Link to="/">Início</Link>
        </li>
        <li>
          <Link to="/users">Usuários</Link>
        </li>
        <li>
          <Link to="/events">Eventos</Link>
        </li>
        <li>
          <Link to="/sales">Vendas</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
