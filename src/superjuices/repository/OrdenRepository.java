/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superjuices.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import superjuices.data.*;

/**
 *
 * @author alejandro
 */
public class OrdenRepository {
    
    //La funcion que nos permitira insertar un nuevo cliente
    public static void insertar(OrdenData orden) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" INSERT INTO ordenes(cliente, sucursal, repartidor, cobro, pago, estatus) VALUES( ?, ?, ?, ?, ?, ?); ");
        
        st.setInt(1, orden.getCliente().getId());
        if(orden.getSucursal()!=null)
            st.setInt(2, orden.getSucursal().getId());
        else
            st.setInt(2, 0);
        
        if( orden.getRepartidor()!=null )
            st.setInt(3, orden.getRepartidor().getId());
        else
            st.setInt(3, 0);
        
        if(orden.getCobro()!=null)
            st.setInt(4, orden.getCobro().getId());
        else
            st.setInt(4, 0);
        
        if(orden.getPago()!=null)
            st.setInt(5, orden.getPago().getId());
        else
            st.setInt(5, 0);
        
        if(orden.getEstatus()!=null)
            st.setInt(6, orden.getEstatus().getId());
        else
            st.setInt(6, 0);
        
        st.executeUpdate();
        
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()) {
            orden.setId(rs.getInt(1));
        }
        
        // System.out.println("Se ha insertado una nueva orden de jugo:"+orden.getId());
        
    }
    // TODO: TERMINAR EL OrdenRepository
    public static void actualizar(OrdenData orden) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" UPDATE ordenes SET cliente=?, sucursal=?, repartidor=?, cobro=?, pago=?, estatus=? WHERE id=?; ");
        
        st.setInt(1, orden.getCliente().getId());
        if(orden.getSucursal()!=null)
            st.setInt(2, orden.getSucursal().getId());
        else
            st.setInt(2, 0);
        
        if( orden.getRepartidor()!=null )
            st.setInt(3, orden.getRepartidor().getId());
        else
            st.setInt(3, 0);
        
        if(orden.getCobro()!=null)
            st.setInt(4, orden.getCobro().getId());
        else
            st.setInt(4, 0);
        
        if(orden.getPago()!=null)
            st.setInt(5, orden.getPago().getId());
        else
            st.setInt(5, 0);
        
        if(orden.getEstatus()!=null)
            st.setInt(6, orden.getEstatus().getId());
        else
            st.setInt(6, 0);
        
        st.setInt(7, orden.getId());
        
        st.executeUpdate();
        
        // System.out.println("Se actualizó la informacion de una orden con ID:"+orden.getId());
    }
    
    public static void eliminar(OrdenData orden) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" DELETE FROM ordenes WHERE id=?; ");
        
        st.setInt(1, orden.getId());
        
        st.executeUpdate();
        
        // System.out.println("Se eliminó una orden con ID:"+orden.getId());
    }
    
    public static OrdenData buscarById(int id) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" SELECT * FROM ordenes WHERE id=?; ");
        
        st.setInt(1, id);
        
        ResultSet rs = st.executeQuery();
        
        OrdenData orden = new OrdenData();
        orden.setId(id);
        
        if(rs.next()) {
            orden.setCliente(ClienteRepository.buscarById(rs.getInt("cliente")));
            orden.setSucursal(SucursalRepository.buscarById(rs.getInt("sucursal")));
            orden.setRepartidor(RepartidorRepository.buscarById(rs.getInt("repartidor")));
            orden.setCobro(CobroRepository.buscarById(rs.getInt("cobro")));
            orden.setPago(PagoRepository.buscarById(rs.getInt("pago")));
            orden.setEstatus(EstatusRepository.buscarById(rs.getInt("estatus")));
        }
        
        return orden;
        
    }
    
    public static int calcularTotal(int id) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" SELECT SUM(A.cantidad * B.precio) AS total FROM orden_jugos AS A LEFT JOIN jugos AS B ON A.jugo=B.id WHERE A.orden=?; ");
        
        st.setInt(1, id);
        
        ResultSet rs = st.executeQuery();
        
        if(rs.next()) {
            return rs.getInt("total");
        }
        
        return -1;
        
    }
    
    public static List<JugoData> getListaJugos(int idOrden) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" SELECT * FROM orden_jugos WHERE orden=?; ");
        
        st.setInt(1, idOrden);
        
        ResultSet rs = st.executeQuery();
        
        List<JugoData> jugos = new ArrayList();
        
        while(rs.next()) {
            
            JugoData jugo = JugoRepository.buscarById(rs.getInt("jugo"));
            
            for(int i=0; i<rs.getInt("cantidad"); i++)
                jugos.add(jugo);
        }
        
        return jugos;
        
    }
    //SELECT SUM(A.cantidad * B.precio) AS total FROM orden_jugos AS A LEFT JOIN jugos AS B ON A.jugo=B.id WHERE A.orden=?;
    
}
