package modelo.dao;

import controlador.Coordinador;
import modelo.vo.MascotaVo;

public class MascotaDao {
    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public void RegistrarMascota(MascotaVo miMascota) {
        /*
         * Aquí se realiza toda la lógica de registro de la persona
         */
    }
}
