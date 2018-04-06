/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superjuices.service;

import java.sql.SQLException;
import superjuices.data.*;
import superjuices.repository.CobroRepository;
import superjuices.repository.EstatusRepository;
import superjuices.repository.OrdenRepository;

/**
 *
 * @author alejandro
 */
public class ClienteService {
    
    public static void cobrar(OrdenData orden) throws SQLException {
        //El repartidor le cobra al CLiente;
        // para esto el cliente debe de cobrar al cliente e insertamos cobro en DB, actualizar el estatus y actualizar la orden;
        
        CobroData cobro = new CobroData();
        cobro.setTotal(OrdenRepository.calcularTotal(orden.getId()));
        cobro.setToken_paypal("TGY236");
        cobro.setCompletado(true);
        CobroRepository.insertar(cobro);
        orden.setCobro(cobro);
        
        EstatusData estatus = EstatusRepository.buscarById(3);
        orden.setEstatus(estatus);
        
        OrdenRepository.actualizar(orden);
        
    }
    
    public static void entregar(OrdenData orden) throws SQLException {
        //Se le entrega la orden al cliente
        //Aqui solo se actualiza el estatus y la orden.
        
        EstatusData estatus = EstatusRepository.buscarById(5);
        orden.setEstatus(estatus);
        
        OrdenRepository.actualizar(orden);
        
    }
    
}
