import axios from "axios";
import React from "react";
import Nav from "./Nav";

class Anadir extends React.Component{
  constructor(props){
    super(props);
    this.state={info:"",tel:"",correo:"",};
    this.recogerinfo=this.comprobar_info.bind(this);
    // this.cambioNombre=this.cn.bind(this);
    // this.cambioCorreo=this.cc.bind(this);
    // this.cambioTel=this.ct.bind(this);
  }

  comprobar_info(){
    let nombre=document.getElementById("campo_nombre").value;
    let email=document.getElementById("campo_correo").value;
    let tel=document.getElementById("campo_tel").value;
    let emailresp;
    let telresp;
    let id;
    if(nombre!="" && email!="" && tel!=""){
      axios.post(`http://localhost:8080/email/${email}`).then((resp)=>{
        this.setState({correo:resp.data});
      })
      axios.post(`http://localhost:8080/tel/${tel}`).then((resp)=>{
        this.setState({tel:resp.data});
      })
      setTimeout(()=>{

        if(this.state.correo==true&&this.state.tel==true){
          axios.post(`http://localhost:8080/clientes/${nombre}/${email}/${tel}`).then((resp)=>{
            if(resp.data==true){
              this.setState({info:"Oportunidad añadida"});
              document.getElementById("info").style.color="green";
            }else{
              this.setState({info:"Error al insertar la oportunidad"});
              document.getElementById("info").style.color="red";
            }
          })
        }else{
          this.setState({info:"Error al insertar la oportunidad"});
          document.getElementById("info").style.color="red";
        }

      },1000)
      }else{
        this.setState({info:"Error en el programa"});
        document.getElementById("info").style.color="red";
      }
    }



  render(){
    return(
      <div id="root">
        <Nav/>
        <div>
            <input type="text" placeholder="Escriba el nombre" id="campo_nombre" />
            <input type="text" placeholder="Escriba el correo" id="campo_correo" />
            <input type="text" placeholder="Escriba el numero de telefono" id="campo_tel" />
            <br></br>
            <button onClick={this.recogerinfo} id="boton">Enviar</button>
            <p id="info">{this.state.info}</p>
        </div>
      </div>
    )
  }

}

export default Anadir;