import React from "react";
import axios from "axios";

class Login extends React.Component{
  constructor(props){
    super(props);
    this.state={error:""};

    this.iniciar_sesion=this.iniciar_sesionf.bind(this);
  }

  iniciar_sesionf(){
    if(document.getElementById("user").value=="admin"&&document.getElementById("contra").value=="admin"){
      window.location.href="cliente";
    }else this.setState({error:"Error en el login"});
    
  }


  render(){
    return(
      <div id="root">
        <div id="login">
          <h2>Usuario:</h2>
          <input type="text" placeholder='Escriba su usuario' id="user"/>
          <h2>Contraseña:</h2>
          <input type="pass" placeholder='Escriba su contraseña'  id="contra"/>
          <br></br>
          <button onClick={this.iniciar_sesion} id="boton">Iniciar sesión</button>
          {this.state.error}
        </div>
      </div>
    )
  }

}

export default Login;
