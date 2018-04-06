/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superjuices.test;

import java.sql.SQLException;
import superjuices.service.ClienteService;
import superjuices.service.ImprimirService;
import superjuices.service.RepartidorService;
import superjuices.service.SucursalService;
import superjuices.data.*;
import superjuices.repository.*;

/**
 *
 * @author alejandro
 */
public class SuperJuicesTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        
        DBManager.connect("jdbc:mysql://localhost/superjuice", "root", "root");
        
        
        System.out.println("====================================================");
        
        ClienteData cliente = ClienteRepository.getAleatorio();
        
        OrdenData orden = new OrdenData();
        orden.setCliente(cliente);
        
        SucursalService.pedir(orden);
        
        ImprimirService.imprimir(orden);
        
        RepartidorService.entregar(orden);
        
        ImprimirService.imprimir(orden);
        
        ClienteService.cobrar(orden);
        
        ImprimirService.imprimir(orden);
        
        RepartidorService.pagar(orden);
        
        ImprimirService.imprimir(orden);
        
        ClienteService.entregar(orden);
        
        ImprimirService.imprimir(orden);
        
        
        
        
        
        
        
        
        //ImprimirService.imprimir(OrdenRepository.getListaJugos(16));
        
        
        
        /*
        ClienteData cliente = new ClienteData();
        
        cliente.setId(6);
        cliente.setNombre("Victor el loco");
        cliente.setDireccion("Cerrada 1ro de Mayo");
        */
        
        //ClienteRepository.eliminar(cliente);
        
        /*
        ClienteData res = ClienteRepository.buscarById(4);
        System.out.println(res.getId());
        System.out.println(res.getNombre());
        System.out.println(res.getDireccion());
        */
        
        /*
        SucursalData sucursal = new SucursalData();
        sucursal.setId(4);
        sucursal.setNombre("Vallejos");
        sucursal.setDireccion("Av. Politecnico Num.102");
        
        SucursalRepository.eliminar(sucursal);
        */
        
        /*
        SucursalData sucursal = SucursalRepository.buscarById(1);
        System.out.println(sucursal.getId());
        System.out.println(sucursal.getNombre());
        System.out.println(sucursal.getDireccion());
        */
        
        /*
        RepartidorData repartidor = new RepartidorData();
        repartidor.setId(4);
        repartidor.setNombre("HectorX");
        repartidor.setPlacas("8T1PAX");
        repartidor.setDireccion("Matamoros Num.243X");
        
        RepartidorRepository.eliminar(repartidor);
        */
        /*
        RepartidorData repartidor = RepartidorRepository.buscarById(1);
        System.out.println(repartidor.getId());
        System.out.println(repartidor.getNombre());
        System.out.println(repartidor.getPlacas());
        System.out.println(repartidor.getDireccion());
        */
        
        /*
        JugoData jugo = new JugoData();
        jugo.setId(16);
        jugo.setSabor("ChocolateX");
        jugo.setTam("ChicoX");
        jugo.setPrecio(15);
        
        JugoRepository.eliminar(jugo);
        */
        /*
        JugoData jugo = JugoRepository.buscarById(1);
        System.out.println(jugo.getId());
        System.out.println(jugo.getSabor());
        System.out.println(jugo.getTam());
        System.out.println(jugo.getPrecio());
        */
        
        /*
        CobroData cobro = new CobroData();
        cobro.setId(2);
        cobro.setTotal(1000);
        cobro.setToken_paypal("TFUU4597X");
        cobro.setCompletado(true);
        
        CobroRepository.insertar(cobro);
        */
        /*
        CobroData cobro = CobroRepository.buscarById(1);
        System.out.println(cobro.getId());
        System.out.println(cobro.getTotal());
        System.out.println(cobro.getToken_paypal());
        System.out.println(cobro.getCompletado());
        */
        
        
        /*
        PagoData pago = new PagoData();
        pago.setId(2);
        pago.setToken_paypal("ITVS3094X");
        pago.setCompletado((short)0);
        
        PagoRepository.eliminar(pago);
        */
        /*
        PagoData pago = PagoRepository.buscarById(1);
        System.out.println(pago.getId());
        System.out.println(pago.getToken_paypal());
        System.out.println(pago.getCompletado());
        */
        
        
        /*
        EstatusData estatus = new EstatusData();
        estatus.setId(6);
        estatus.setEstado("Estado de prueba editado");
        EstatusRepository.eliminar(estatus);
        */
        /*
        EstatusData estatus = EstatusRepository.buscarById(1);
        System.out.println(estatus.getId());
        System.out.println(estatus.getEstado());
        */
        
        
        /*
        OrdenData orden = new OrdenData();
        int ID=2;
        orden.setId(ID);
        orden.setCliente(ClienteRepository.buscarById(ID));
        orden.setSucursal(SucursalRepository.buscarById(ID));
        orden.setRepartidor(RepartidorRepository.buscarById(ID));
        orden.setCobro(CobroRepository.buscarById(ID));
        orden.setPago(PagoRepository.buscarById(ID));
        orden.setEstatus(EstatusRepository.buscarById(ID));
        */
        /*
        OrdenData ordenData = OrdenRepository.buscarById(1);
        System.out.println(ordenData.getId());
        
        System.out.println(ordenData.getCliente().getId());
        System.out.println(ordenData.getSucursal().getId());
        System.out.println(ordenData.getRepartidor().getId());
        System.out.println(ordenData.getCobro().getId());
        System.out.println(ordenData.getPago().getId());
        System.out.println(ordenData.getEstatus().getId());
        */
        
        
        /*
        OrdenJugosData ordenJugosData = new OrdenJugosData();
        ordenJugosData.setId(2);
        ordenJugosData.setOrden(OrdenRepository.buscarById(10));
        ordenJugosData.setJugo(JugoRepository.buscarById(3));
        ordenJugosData.setCantidad(20);
        
        OrdenJugosRepository.eliminar(ordenJugosData);
        */
        /*
        OrdenJugosData ordenJugosData = OrdenJugosRepository.buscarById(2);
        System.out.println(ordenJugosData.getId());
        
        System.out.println(ordenJugosData.getOrden().getId());
        System.out.println(ordenJugosData.getJugo().getId());
        
        System.out.println(ordenJugosData.getCantidad());
        */
        
        
        
        
    }
    
}
