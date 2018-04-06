/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superjuices.service;

import java.sql.SQLException;
import superjuices.data.*;
import superjuices.repository.EstatusRepository;
import superjuices.repository.OrdenJugosRepository;
import superjuices.repository.OrdenRepository;
import superjuices.repository.SucursalRepository;

/**
 *
 * @author alejandro
 */
public class SucursalService {
    
    public static void pedir(OrdenData orden) throws SQLException {
        // El cliente pide una orden a una sucursal.
        //insertamos una nueva lista de jugos a la orden, asignamos sucursal y asignamos estado.
        
        OrdenRepository.insertar(orden);
        
        OrdenJugosRepository.insertarListaJugos(orden);
        orden.setJugos(OrdenRepository.getListaJugos(orden.getId()));
        
        SucursalData sucursal = SucursalRepository.getAleatorio();
        orden.setSucursal(sucursal);
        
        EstatusData estatus = EstatusRepository.buscarById(1);
        orden.setEstatus(estatus);
        
        OrdenRepository.actualizar(orden);
        
        
    }
    
}
