package controlador;

import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        // Obtener la conexión
        Connection conexion = ConexionBD.obtenerConexion();

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