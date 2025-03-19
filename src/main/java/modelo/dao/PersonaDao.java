package modelo.dao;

import controlador.Coordinador;
import modelo.vo.PersonaVo;

public class PersonaDao {

    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public void registrarPersona(PersonaVo miPersona) {
        /*
         * Aquí se realiza toda la lógica de registro de la persona
         */
    }
}
