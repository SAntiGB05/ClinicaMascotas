package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.Coordinador;
import modelo.conexion.ConexionBD;
import modelo.vo.NacimientoVo;

public class NacimientoDao {
    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }

    public Long registrarNacimiento(NacimientoVo miNacimiento) {

        Long idNacimiento=null;
        Connection connection = null;
        ConexionBD conexion = new ConexionBD();
        PreparedStatement preStatement = null;

        ResultSet result=null;

        connection = conexion.getConection();
        String consulta = "INSERT INTO nacimiento (ciudad_nacimiento,departamento_nacimiento,fecha_nacimiento,pais_nacimiento)"
                + "  VALUES (?,?,?,?)";

        try {
            preStatement = connection.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
            preStatement.setString(1, miNacimiento.getCiudadNacimiento());
            preStatement.setString(2, miNacimiento.getDepartamentoNacimiento());
            preStatement.setString(3, miNacimiento.getFechaNacimiento().toString());
            preStatement.setString(4, miNacimiento.getPaisNacimiento());
            preStatement.execute();

            result=preStatement.getGeneratedKeys();
            if (result.next()) {
                idNacimiento=result.getLong(1);
            }

        } catch (SQLException e) {
            System.out.println("No se pudo registrar los datos del nacimiento: " + e.getMessage());
            e.printStackTrace();
            idNacimiento = null;
        } catch (Exception e) {
            System.out.println("No se pudo registrar los datos del nacimiento: " + e.getMessage());
            e.printStackTrace();
            idNacimiento = null;
        }
        finally {
            conexion.cerrarConexion(connection);
        }
        System.out.println("El ID del Nacimiento es: "+idNacimiento);
        return idNacimiento;

    }
}
