package com.parameta.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-17T10:32:47")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> tipoDocumento;
    public static volatile SingularAttribute<Empleado, Date> fechaVinculacion;
    public static volatile SingularAttribute<Empleado, String> cargoEmpleado;
    public static volatile SingularAttribute<Empleado, Date> fechaNacimiento;
    public static volatile SingularAttribute<Empleado, String> apellidosEmpleado;
    public static volatile SingularAttribute<Empleado, String> numeroDocumento;
    public static volatile SingularAttribute<Empleado, String> nombreEmpleado;
    public static volatile SingularAttribute<Empleado, Integer> salarioEmpleado;

}