/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameta.webservice;

import com.parameta.controller.EmpleadoJpaController;
import com.parameta.model.Empleado;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Cristhian
 */
@WebService(serviceName = "EmpleadoWebService")
public class EmpleadoWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addEmpleado")
    public Boolean addEmpleado(@WebParam(name = "empleado") Empleado empleado) {
        //TODO write your implementation code here:
        EmpleadoJpaController jpa = new EmpleadoJpaController();
        try {
            jpa.create(empleado);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
