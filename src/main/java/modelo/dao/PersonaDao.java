package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.ConexionBD;
import modelo.vo.PersonaVo;

public class PersonaDao {

    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }

    public String registrarPersona(PersonaVo miPersona) {

        String resultado = "";

        Connection connection = null;
        ConexionBD conexion = new ConexionBD();
        PreparedStatement preStatement = null;

        connection = conexion.getConection();
        String consulta = "INSERT INTO persona (id_persona,nombre_persona,profesion_persona,telefono_persona,tipo_persona,nacimiento_id)"
                + "  VALUES (?,?,?,?,?,?)";

        try {
            preStatement = connection.prepareStatement(consulta);
            preStatement.setLong(1, miPersona.getIdPersona());
            preStatement.setString(2, miPersona.getNombre());
            preStatement.setString(3, miPersona.getProfesion());
            preStatement.setString(4, miPersona.getTelefono());
            preStatement.setInt(5, miPersona.getTipo());

            preStatement.setLong(6, miPersona.getNacimiento().getIdNacimiento());
            preStatement.execute();

            resultado = "ok";

        }catch (SQLException e) {
            System.out.println("No se pudo registrar la persona, verifique el documento no exista: " + e.getMessage());
            e.printStackTrace();
            resultado = "No se pudo registrar la persona";
        }
        catch (Exception e) {
            System.out.println("No se pudo registrar la persona: " + e.getMessage());
            e.printStackTrace();
            resultado = "No se pudo registrar la persona";
        }
        finally {
            conexion.cerrarConexion(connection);
        }

        return resultado;

    }

}

