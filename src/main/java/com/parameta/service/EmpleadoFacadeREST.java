/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameta.service;

import com.parameta.model.Empleado;
import com.parameta.model.ExtraData;
import com.parameta.webservice.EmpleadoWebService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Cristhian
 */
@Path("/empleados")
@Produces(MediaType.APPLICATION_JSON)
public class EmpleadoFacadeREST {

    @GET
    @Path("/{nombre}/{apellido}/"
            + "{tipo_documento}/{numero_documento}/"
            + "{fecha_nacimiento}/{fecha_vinculacion}/"
            + "{cargo}/{salario}")
    public Response checkEmpleado(@PathParam("nombre") String nombre,
            @PathParam("apellido") String apellido,
            @PathParam("tipo_documento") String tipo_documento,
            @PathParam("numero_documento") String numero_documento,
            @PathParam("fecha_nacimiento") String fecha_nacimiento,
            @PathParam("fecha_vinculacion") String fecha_vinculacion,
            @PathParam("cargo") String cargo,
            @PathParam("salario") int salario) throws ParseException {

        if (validarFormatoFecha(fecha_nacimiento)
                && validarFormatoFecha(fecha_vinculacion)
                && validarMayoriaEdad(stringToDate(fecha_nacimiento))) {
            System.out.println("Fecha nacimiento: " + stringToDate(fecha_nacimiento));
            System.out.println("Fecha vinculacion: " + stringToDate(fecha_vinculacion));
            Empleado empleado = new Empleado(numero_documento,
                    apellido,
                    nombre,
                    tipo_documento,
                    stringToDate(fecha_nacimiento),
                    stringToDate(fecha_vinculacion),
                    cargo,
                    salario);
            
            EmpleadoWebService ews = new EmpleadoWebService();
            boolean check = ews.addEmpleado(empleado);
            System.out.println("CHECK ------> " + check);
            if (check) {
                List<Integer> lista = new ArrayList<Integer>();
                lista = fechaNumero(stringToDate(fecha_nacimiento));
                ExtraData extra = setFechaNacimiento(lista);
                List<Integer> lista2 = new ArrayList<Integer>();
                lista2 = fechaNumero(stringToDate(fecha_vinculacion));
                extra = setFechaVinculacion(lista2, extra);
                return Response.ok(extra.toString(), MediaType.APPLICATION_JSON).build();
            } else {
                return Response.ok("Ocurrió un Error!", MediaType.APPLICATION_JSON).build();
            }
        } else {
            return Response.ok("Ocurrió un Error!", MediaType.APPLICATION_JSON).build();
        }
    }

    public ExtraData setFechaNacimiento(List<Integer> lista) {
        ExtraData extra = new ExtraData();
        extra.setEdad_anos(lista.get(0));
        extra.setEdad_meses(lista.get(1));
        extra.setEdad_dias(lista.get(2));
        return extra;
    }

    public ExtraData setFechaVinculacion(List<Integer> lista, ExtraData extra) {
        extra.setVinculacion_anos(lista.get(0));
        extra.setVinculacion_meses(lista.get(1));
        extra.setVinculacion_dias(lista.get(2));
        return extra;
    }

    public Date stringToDate(String fecha) {
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public boolean validarFormatoFecha(String fecha) {
        try{
            Date date = stringToDate(fecha);
            return date != null;
        }catch(Exception e){
            return false;
        }
        
    }

    public boolean validarMayoriaEdad(Date fecha) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(fecha);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int date = c.get(Calendar.DATE);
            LocalDate l1 = LocalDate.of(year, month, date);
            LocalDate now1 = LocalDate.now();
            Period diff1 = Period.between(l1, now1);
            return diff1.getYears() >= 18;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Integer> fechaNumero(Date fecha) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);
        List<Integer> lista = new ArrayList<>();
        lista.add(diff1.getYears());
        lista.add(diff1.getMonths());
        lista.add(diff1.getDays());
        System.out.println("LISTA -----------------> " + lista);
        return lista;
    }

}
