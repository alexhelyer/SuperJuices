/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superjuices.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import superjuices.data.*;

/**
 *
 * @author alejandro
 */
public class OrdenJugosRepository {
    
    //La funcion que nos permitira insertar un nuevo cliente
    public static void insertar(OrdenJugosData ordenJugos) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" INSERT INTO orden_jugos(orden, jugo, cantidad) VALUES(?, ?, ?); ");
        
        st.setInt(1, ordenJugos.getOrden().getId());
        st.setInt(2, ordenJugos.getJugo().getId());
        st.setInt(3, ordenJugos.getCantidad());
        
        st.executeUpdate();
        
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()) {
            ordenJugos.setId(rs.getInt(1));
        }
        
        // System.out.println("Se ha insertado una nueva ordenJugo con ID:"+ordenJugos.getId());
        
    }
    // TODO: TERMINAR EL OrdenRepository
    public static void actualizar(OrdenJugosData ordenJugos) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" UPDATE orden_jugos SET orden=?, jugo=?, cantidad=? WHERE id=?; ");
        
        st.setInt(1, ordenJugos.getOrden().getId());
        st.setInt(2, ordenJugos.getJugo().getId());
        st.setInt(3, ordenJugos.getCantidad());
        
        st.setInt(4, ordenJugos.getId());
        
        st.executeUpdate();
        
        // System.out.println("Se actualizó la informacion de una ordenJugos con ID:"+ordenJugos.getId());
    }
    
    public static void eliminar(OrdenJugosData ordenJugos) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" DELETE FROM orden_jugos WHERE id=?; ");
        
        st.setInt(1, ordenJugos.getId());
        
        st.executeUpdate();
        
        // System.out.println("Se eliminó una ordenJugo con ID:"+ordenJugos.getId());
    }
    
    public static OrdenJugosData buscarById(int id) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" SELECT * FROM orden_jugos WHERE id=?; ");
        
        st.setInt(1, id);
        
        ResultSet rs = st.executeQuery();
        
        OrdenJugosData ordenJugos = new OrdenJugosData();
        ordenJugos.setId(id);
        
        if(rs.next()) {
            ordenJugos.setOrden(OrdenRepository.buscarById(rs.getInt("orden")));
            ordenJugos.setJugo(JugoRepository.buscarById(rs.getInt("jugo")));
            ordenJugos.setCantidad(rs.getInt("cantidad"));
        }
        
        return ordenJugos;
        
    }
    
    public static List<OrdenJugosData> buscarByOrden(int idOrden) throws SQLException {
        
        PreparedStatement st = DBManager.myQuery(" SELECT * FROM orden_jugos WHERE orden=?; ");
        
        st.setInt(1, idOrden);
        
        ResultSet rs = st.executeQuery();
        
        List<OrdenJugosData> ordenJugos = new ArrayList();
        //ordenJugos.setId(id);
        
        if(rs.next()) {
            //JugoData jugo = new JugoData();
            OrdenJugosData ordenJugo = new OrdenJugosData();
            int id = rs.getInt("id");
            ordenJugo.setId(id);
            ordenJugo.setOrden(OrdenRepository.buscarById(id));
            ordenJugo.setJugo(JugoRepository.buscarById(id));
            ordenJugo.setCantidad(idOrden);
            
            ordenJugos.add(ordenJugo);
        }
        
        return ordenJugos;
        
    }
    
    public static void insertarListaJugos(OrdenData orden) throws SQLException {
        int random, cantidad;
        
        random = (int) (Math.random()*5 + 1);
        
        OrdenJugosData ordenJugo = new OrdenJugosData();
        ordenJugo.setOrden(orden);
        
        for(int i=0; i<random; i++) {
            cantidad = (int) (Math.random()*3 + 1);
            ordenJugo.setJugo(JugoRepository.getAleatorio());
            ordenJugo.setCantidad(cantidad);
            
            OrdenJugosRepository.insertar(ordenJugo);
            
            // System.out.println("RANDOM:"+i+"   CANTIDAD:"+cantidad);
        }
    }
    
}
