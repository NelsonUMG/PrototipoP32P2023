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
    private String tipoPersona;
    private String descripcion;
    private String Estatus;

    public clsBancos(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public clsBancos(String tipoPersona, String descripcion) {
        this.tipoPersona = tipoPersona;
        this.descripcion = descripcion;
    }

    public clsBancos(String tipoPersona, String descripcion, String Estatus) {
        this.tipoPersona = tipoPersona;
        this.descripcion = descripcion;
        this.Estatus = Estatus;
    }

    public clsBancos() {
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
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
    public clsBancos getBuscarInformacionBancoPorDecripcion(clsBancos banco)
    {
        daoBancos daoBancos = new daoBancos();
        return daoBancos.consultaBancoPorDescripcion(banco);
    }
    public clsBancos getBuscarInformacionBancoPorTipo(clsBancos banco)
    {
        daoBancos daoBancos= new daoBancos();
        return daoBancos.consultaBancoPorTipo(banco);
    }    
    public List<clsBancos> getListadoBancos()
    {
        daoBancos daoBancos = new daoBancos();
        List<clsBancos> listadoBancos = daoBancos.consultaBanco();
        return listadoBancos;
    }
    public int setBorrarBanco(clsBancos banco)
    {
        daoBancos daoBancos = new daoBancos();
        return daoBancos.borrarBanco(banco);
    }          
    public int setIngresarBanco(clsBancos banco)
    {
        daoBancos daoBancos= new daoBancos();
        return daoBancos.ingresaBanco(banco);
    }              
    public int setModificarBanco(clsBancos banco)
    {
        daoBancos daoBancos = new daoBancos();
        return daoBancos.actualizaBanco(banco);
    }              
}
