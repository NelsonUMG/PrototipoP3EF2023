/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Hecho por Carlos González, 9959-20-6164

package Peliculas.Controlador;

import java.util.List;
import java.util.prefs.BackingStoreException;

import Peliculas.Modelo.daoPeliculasCines;

/**
 *
 * @author visitante
 */
public class clsPeliculasCines {
    private int IdCines;
    private String NombreCine;
    private String DireccionCine;

    public clsPeliculasCines() {
    }

    public clsPeliculasCines(int IdCines) {
        this.IdCines = IdCines;
    }

    public clsPeliculasCines(int IdCines, String NombreCine) {
        this.IdCines = IdCines;
        this.NombreCine = NombreCine;
    }

    public clsPeliculasCines(String NombreCine, String DireccionCine) {
        this.NombreCine = NombreCine;
        this.DireccionCine = DireccionCine;
    }

    public int getIdCines() {
        return IdCines;
    }

    public void setIdCines(int IdCines) {
        this.IdCines = IdCines;
    }

    public String getNombreCine() {
        return NombreCine;
    }

    public void setNombreCine(String NombreCine) {
        this.NombreCine = NombreCine;
    }

    public String getDireccionCine() {
        return DireccionCine;
    }

    public void setDireccionCine(String DireccionCine) {
        this.DireccionCine = DireccionCine;
    }
    
    @Override
    public String toString() {
        return "clsPeliculasCines{" + "cIdCines =" + IdCines   + ", NombreCine=" + NombreCine + ", DireccionCine=" + DireccionCine + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsPeliculasCines getBuscarInformacionCinePorNombre(clsPeliculasCines cines)
    {
        daoPeliculasCines daocinespelículas= new daoPeliculasCines();
        return daocinespelículas.consultaCinePorNombre(cines);
    }
    public clsPeliculasCines getBuscarInformacionCinePorId(clsPeliculasCines cines)
    {
        daoPeliculasCines daocinespelículas= new  daoPeliculasCines();
        return daocinespelículas.consultaCinePorId(cines);
    }    
    public List<clsPeliculasCines> getListadoCine()
    {
         daoPeliculasCines daocinespelículas= new  daoPeliculasCines();
        List<clsPeliculasCines> listadoCines=daocinespelículas.consultaCine();
        return listadoCines;
    }
    public int setBorrarCine(clsPeliculasCines cines)
    {
        daoPeliculasCines daocinespelículas = new  daoPeliculasCines();
        return daocinespelículas.borrarCine(cines);
    }          
    public int setIngresarCine(clsPeliculasCines cines)
    {
         daoPeliculasCines daocinespelículas = new  daoPeliculasCines();
        return daocinespelículas.ingresarCine(cines);
    }              
    public int setModificarCine(clsPeliculasCines cines)
    {
        daoPeliculasCines daocinespelículas = new daoPeliculasCines();
        return daocinespelículas.actualizaCine(cines);
    }              

}
