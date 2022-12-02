import React from "react";
import axios from "axios";
import "./styles.css";
import Nav from "./Nav";

class Clientes extends React.Component{
  constructor(props){
    super(props);
    this.state={datos:[],id:""};

    this.mostrar_clientes=this.coger_clientes.bind(this);
  }

  pasar(id){
    axios.post(`http://localhost:8080/clientes/${id}/${false}`).then((response)=>{
        console.log(response);
        this.mostrar_clientes();
    })
  }

  coger_clientes(){
    axios.get("http://localhost:8080/clientes").then((response)=>{
      console.log(response);
      this.setState({datos:response.data})
    })
  }

  componentDidMount(){
      this.coger_clientes();
      
  }

  render(){
    return(
      <div id="root" >
        <Nav/>
        <div id="datos">
          {
           this.state.datos.map((dato)=>{
            if(dato.cliente==true){
                return(
                  <div id="dato" value={dato.cliente}>
                    <button onClick={this.pasar.bind(this,dato.id)}>Pasar a oportunidad</button>
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