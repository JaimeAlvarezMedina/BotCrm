import React from "react";
import axios from "axios";
import "./styles.css";
import Nav from "./Nav";

class Clientes extends React.Component{
  constructor(props){
    super(props);
    this.state={datos:[],pagina:"cliente",id:""};

    this.mostrar_oportunidades=this.coger_oportunidades.bind(this);
  }

  pasar(id,estado){
    console.log("Entra");
    axios.post(`http://localhost:8080/clientes/${id}/${estado}`).then((response)=>{
        console.log(response);
        this.mostrar_oportunidades();
    })
  }

  coger_oportunidades(){
    console.log("Aqui tmb");
    axios.get("http://localhost:8080/clientes").then((response)=>{
      console.log(response);
      this.setState({datos:response.data})
    })
  }

  componentDidMount(){
      this.mostrar_oportunidades();
      
  }

  render(){
    return(
      <div id="root" >
        <Nav/>
        <div id="datos">
          {
            this.state.datos.map((dato)=>{
                if(dato.cliente==false){
                    return(
                      <div id="dato" value={dato.cliente}>
                        <button onClick={this.pasar.bind(this,dato.id,true)}>Pasar a cliente</button>
                        <h5>{dato.nombre}</h5>
                        <p>{dato.email}</p>
                        <p>{dato.tel}</p>
                      </div>
                    )
                  }
            })
          }
        </div>
      </div>
    )
  }

}

export default Clientes;