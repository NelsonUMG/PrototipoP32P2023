/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoBancos;
/**
 *
 * @author visitante
 */
public class clsBancos {
    private int tipoPersona;
    private String descripcion;
    private String Estatus;

    public clsBancos(int tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public clsBancos(int tipoPersona, String descripcion, String Estatus) {
        this.tipoPersona = tipoPersona;
        this.descripcion = descripcion;
        this.Estatus = Estatus;
    }

    public clsBancos(String descripcion, String Estatus) {
        this.descripcion = descripcion;
        this.Estatus = Estatus;
    }

    public clsBancos() {
    }

    public int getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(int tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

  @Override
    public String toString() {
        return "clsBancos{" + "tipoPersona=" + tipoPersona + ", descripcion=" + descripcion + ", Estatus=" + Estatus + '}';
    }

    
    //Metodos de acceso a la capa controlador
    public clsBancos getBuscarInformacionAplicacionPorNombre(clsBancos banco)
    {
        daoBancos daoBancos = new daoBancos();
        return daoBancos.consultaAplicacionPorNombre(banco);
    }
    public clsBancos getBuscarInformacionAplicacionPorId(clsBancos banco)
    {
        daoBancos daoBancos= new daoBancos();
        return daoBancos.consultaAplicacionPorId(banco);
    }    
    public List<clsBancos> getListadoAplicaciones()
    {
        daoBancos daoBancos = new daoBancos();
        List<clsBancos> listadoBancos = daoBancos.consultaBanco();
        return listadoBancos;
    }
    public int setBorrarAplicacion(clsBancos banco)
    {
        daoBancos daoBancos = new daoBancos();
        return daoBancos.borrarAplicacion(banco);
    }          
    public int setIngresarAplicacion(clsBancos banco)
    {
        daoBancos daoBancos= new daoBancos();
        return daoBancos.ingresaAplicacion(banco);
    }              
    public int setModificarAplicacion(clsBancos aplicacion)
    {
        daoBancos daoBancos = new daoBancos();
        return daoBancos.actualizaAplicacion(banco);
    }              
}
