/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superjuices.data;

/**
 *
 * @author alejandro
 */
public class OrdenJugosData {
    
    int id;
    OrdenData orden;
    JugoData jugo;
    int cantidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrdenData getOrden() {
        return orden;
    }

    public void setOrden(OrdenData orden) {
        this.orden = orden;
    }

    public JugoData getJugo() {
        return jugo;
    }

    public void setJugo(JugoData jugo) {
        this.jugo = jugo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
