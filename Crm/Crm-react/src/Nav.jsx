import React from "react";
import { Link } from "react-router-dom";
import "./styles.css";

class Nav extends React.Component{
  constructor(props){
    super(props);
    this.state={};
  }

  render(){
    return(
      <div id="root" >
        <div id="nav">
          <li><Link to="/cliente">Clientes</Link></li>
          <li><Link to="/oportunidad">Oportunidades</Link></li>
          <li><Link to="/anadir">Añadir</Link></li>
          <li><Link to="/login">Cerrar sesion</Link></li>
        </div>
      </div>
    )
  }

}

export default Nav;