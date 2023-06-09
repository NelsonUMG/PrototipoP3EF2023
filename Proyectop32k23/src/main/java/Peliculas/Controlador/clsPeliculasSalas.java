/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Hecho por Carlos González, 9959-20-6164

package Peliculas.Controlador;
import Peliculas.Controlador.*;
import java.util.List;
import java.util.prefs.BackingStoreException;
import Peliculas.Modelo.daoPeliculasSalas;

/**
 *
 * @author visitante
 */
public class clsPeliculasSalas {
    private int IdSalas;
    private int IdCines;
    private int fkCines;
    private String Descripcion;
    private String formatoPeli;
    private int Puntos;
    private double PrecioSala;

    public clsPeliculasSalas() {
    }

    public clsPeliculasSalas(int IdSalas, int IdCines, int fkCines, String Descripcion, String formatoPeli, int Puntos, double PrecioSala) {
        this.IdSalas = IdSalas;
        this.IdCines = IdCines;
        this.fkCines = fkCines;
        this.Descripcion = Descripcion;
        this.formatoPeli = formatoPeli;
        this.Puntos = Puntos;
        this.PrecioSala = PrecioSala;
    }

    public int getIdSalas() {
        return IdSalas;
    }

    public void setIdSalas(int IdSalas) {
        this.IdSalas = IdSalas;
    }

    public int getIdCines() {
        return IdCines;
    }

    public void setIdCines(int IdCines) {
        this.IdCines = IdCines;
    }

    public int getFkCines() {
        return fkCines;
    }

    public void setFkCines(int fkCines) {
        this.fkCines = fkCines;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFormatoPeli() {
        return formatoPeli;
    }

    public void setFormatoPeli(String formatoPeli) {
        this.formatoPeli = formatoPeli;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public double getPrecioSala() {
        return PrecioSala;
    }

    public void setPrecioSala(double PrecioSala) {
        this.PrecioSala = PrecioSala;
    }

  


 

    
    @Override
    public String toString() {
        return "clsPeliculasSalas{" + "IdSalas =" + IdSalas   + ",IdCines= " + IdCines +", fkCines=" + fkCines + ", Descripcion=" + Descripcion + ", formatoPeli  =" + formatoPeli + ", Puntos  =" + Puntos + ", PrecioSala= " + PrecioSala + '}';
    }
    //Metodos de acceso a la capa controlador
 
    public clsPeliculasSalas getBuscarInformacionSalaPorId(clsPeliculasSalas Sala)
    {
        daoPeliculasSalas daopeliculassalas  = new daoPeliculasSalas();
        return daopeliculassalas .consultarSalaPorId(Sala);
    }    
    public List<clsPeliculasSalas> getListadoSala()
    {
        daoPeliculasSalas daopeliculassalas  = new daoPeliculasSalas();
        List<clsPeliculasSalas> listadoSalas =daopeliculassalas.consultaSala();
        return listadoSalas;
    }
    public int setBorrarSala(clsPeliculasSalas sala)
    {
        daoPeliculasSalas daopeliculassalas  = new daoPeliculasSalas();
        return daopeliculassalas.borrarSala(sala);
    }          
    public int setIngresarSala(clsPeliculasSalas sala)
    {
        daoPeliculasSalas daopeliculassalas  = new daoPeliculasSalas();
        return daopeliculassalas.ingresarSala(sala);
    }              
    public int setModificarSala(clsPeliculasSalas sala)
    {
        daoPeliculasSalas daopeliculassalas  = new daoPeliculasSalas();
        return daopeliculassalas.actualizarSala(sala);
    }              

}
