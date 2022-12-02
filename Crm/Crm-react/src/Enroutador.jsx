import React from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Clientes from './Clientes';
import Login from "./Login";
import Oportunidad from "./Oportunidad";
import Anadir from "./Anadir"


export default function App_Final() {
    return (
      <BrowserRouter>
        <Routes>
            <Route path="anadir" element={<Anadir/>}/>
            <Route path="oportunidad" element={<Oportunidad/>} />
            <Route path="cliente" element={<Clientes/>} />
            <Route path="login" element={<Login />} />
            <Route index element={<Login />} />
            <Route path="/" element={<Login />} >
          </Route>
        </Routes>
      </BrowserRouter>
    );
  }