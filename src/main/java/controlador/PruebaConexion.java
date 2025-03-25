package controlador;

import modelo.conexion.ConexionBD;

import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        // Obtener la conexión
        Connection conexion = ConexionBD.getConection();

        // Verificar si la conexión fue exitosa
        if (conexion != null) {
            System.out.println("¡Conexión exitosa!");
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }

        // Cerrar la conexión
        ConexionBD.cerrarConexion(conexion);
    }
}