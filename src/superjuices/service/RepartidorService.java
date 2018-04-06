/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superjuices.service;

import java.sql.SQLException;
import superjuices.data.*;
import superjuices.repository.EstatusRepository;
import superjuices.repository.OrdenRepository;
import superjuices.repository.PagoRepository;
import superjuices.repository.RepartidorRepository;

/**
 *
 * @author alejandro
 */
public class RepartidorService {
    
    public static void entregar(OrdenData orden) throws SQLException {
        // La cocina le entrega la orden al repartidor.
        // necesitamos asignar un repartidor a la orden, cambiar el estatus y actualizar la orden.
        
        RepartidorData repartidor = RepartidorRepository.getAleatorio();
        orden.setRepartidor(repartidor);
        
        EstatusData estatus = EstatusRepository.buscarById(2);
        orden.setEstatus(estatus);
        
        OrdenRepository.actualizar(orden);
    }
    
    public static void pagar(OrdenData orden) throws SQLException {
        // El cliente debe de pagarle al cliente
        // necesitamos asignar el pago e inserta el pago en DB, actualizar el estatus y actualizar la orden.
        
        PagoData pago = new PagoData();
        pago.setToken_paypal("TGY236");
        pago.setCompletado(true);
        PagoRepository.insertar(pago);
        orden.setPago(pago);
        
        EstatusData estatus = EstatusRepository.buscarById(4);
        orden.setEstatus(estatus);
        
        OrdenRepository.actualizar(orden);
        
    }
    
}
