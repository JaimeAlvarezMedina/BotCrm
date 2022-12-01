import React from "react";

class Anadir extends React.Component{
  constructor(props){
    super(props);
    this.state={};
  }




  render(){
    return(
      <div id="root">
        <input type="text" placeholder="Escriba el nombre" id="campo_nombre"></input>
      </div>
    )
  }

}

export default Anadir;