/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superjuices.service;

import java.sql.SQLException;
import java.util.List;
import superjuices.data.*;
import superjuices.repository.*;

/**
 *
 * @author alejandro
 */
public class ImprimirService {
    
    public static void imprimir(OrdenData orden) throws SQLException {
        ImprimirService.imprimir(orden.getEstatus());
        ImprimirService.imprimir(orden.getCliente());
        ImprimirService.imprimir(OrdenRepository.getListaJugos(orden.getId()));
        ImprimirService.imprimir(orden.getSucursal());
        ImprimirService.imprimir(orden.getRepartidor());
        ImprimirService.imprimir(orden.getCobro());
        ImprimirService.imprimir(orden.getPago());
        System.out.println("====================================================");
    }
    
    public static void imprimir(EstatusData estatus) {
        if (estatus == null) {
            System.out.println("Estatus: SIN ESTATUS");
            return;
        }
        System.out.printf("Estatus:%d   [%s]\n", estatus.getId(), estatus.getEstado());
    }
    
    public static void imprimir(ClienteData cliente) {
        if (cliente == null) {
            System.out.println("Cliente: NO ASIGNADO");
            return;
        }
        System.out.printf("Cliente:%d    %s [%s] \n", cliente.getId(), cliente.getNombre(), cliente.getDireccion());
    }
    
    public static void imprimir(SucursalData sucursal) {
        if (sucursal == null) {
            System.out.println("Sucursal: NO ASIGNADA");
            return;
        }
        System.out.printf("Sucursal:%d    %s [%s] \n", sucursal.getId(), sucursal.getNombre(), sucursal.getDireccion());
    }
    
    public static void imprimir(RepartidorData repartidor) {
        if (repartidor == null) {
            System.out.println("Repartidor: NO ASIGNADO");
            return;
        }
        System.out.printf("Repartidor:%d    %s [%s] \n", repartidor.getId(), repartidor.getNombre(), repartidor.getPlacas());
    }
    
    public static void imprimir(CobroData cobro) {
        if (cobro == null) {
            System.out.println("Cobro: NO ASIGNADO");
            return;
        }
        System.out.printf("Cobro:%d    %d    %s(%s)\n", cobro.getId(), cobro.getTotal(), cobro.getToken_paypal(), cobro.isCompletado());
    }
    
    public static void imprimir(PagoData pago) {
        if (pago == null) {
            System.out.println("Pago: NO ASIGNADO");
            return;
        }
        System.out.printf("Pago:%d    %s(%s)\n", pago.getId(), pago.getToken_paypal(), pago.isCompletado());
    }
    
    public static void imprimir(JugoData jugo) {
        if (jugo == null) {
            System.out.println("Jugo: NO ASIGNADO");
            return;
        }
        System.out.printf("Jugo:%d    %s(%s)   [$%d]\n", jugo.getId(), jugo.getSabor(), jugo.getTam(), jugo.getPrecio());
    }
    
    public static void imprimir( List<JugoData> jugos) {
        if (jugos == null) {
            System.out.println("Jugos: NO SE HA ASIGNADO UN PEDIDO DE JUGOS");
            return;
        }
        for(JugoData jugo:jugos) {
            ImprimirService.imprimir(jugo);
        }
    }
    
}
