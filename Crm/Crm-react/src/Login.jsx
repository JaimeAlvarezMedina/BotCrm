import React from "react";

class Login extends React.Component{
  constructor(props){
    super(props);
    this.state={};

    this.iniciar_sesion=this.iniciar_sesionf.bind(this);
  }

  iniciar_sesionf(){
    
  }


  render(){
    return(
      <div id="root">
        <div id="login">
          <h2>Usuario:</h2>
          <input type="text" placeholder='Escriba su usuario' onChange={this.cambio_correo}/>
          <h2>Contraseña:</h2>
          <input type="pass" placeholder='Escriba su contraseña' onChange={this.cambio_contra}/>
          <br></br>
          <button onClick={()=>window.location.href="/cliente"}>Iniciar sesión</button>
        </div>
      </div>
    )
  }

}

export default Login;
