package controlador;

import modelo.dao.MascotaDao;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;
import vistas.gui.RegistrarMascotaGui;
import vistas.gui.RegistrarPersonaGui;
import vistas.gui.RegistrarProductoGui;
import vistas.gui.VentanaPrincipal;

public class Relaciones {

    public Relaciones() {
        //Se declaran las clases que van a representar instancias unicas
        VentanaPrincipal miVentanaPrincipal;
        RegistrarPersonaGui miRegistrarPersonasGui;
        RegistrarMascotaGui miRegistrarMascotasGui;
        RegistrarProductoGui miRegistrarProductosGui;
        Coordinador miCoordinador;
        PersonaDao miPersonaDao;
        NacimientoDao miNacimientoDao;
        MascotaDao miMascotaDao;
        ProductoDao miProductoDao;
        PersonaProductoDao miPersonaProductoDao;

        //Se instancian por unica ocasión las clases declaradas
        miVentanaPrincipal= new VentanaPrincipal();
        miRegistrarPersonasGui= new RegistrarPersonaGui(miVentanaPrincipal, true);
        miRegistrarMascotasGui= new RegistrarMascotaGui(miVentanaPrincipal, true, "");
        miRegistrarProductosGui= new RegistrarProductoGui(miVentanaPrincipal, true);
        miCoordinador= new Coordinador();
        miPersonaDao= new PersonaDao();
        miMascotaDao= new MascotaDao();
        miNacimientoDao= new NacimientoDao();
        miProductoDao= new ProductoDao();
        miPersonaProductoDao= new PersonaProductoDao();

        //Se establece la relación entre el coordinador y cada instancia unica
        //Al coordinador se le asigna el control de cada clase unica
        miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
        miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
        miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
        miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
        miCoordinador.setPersonaDao(miPersonaDao);
        miCoordinador.setMascotaDao(miMascotaDao);
        miCoordinador.setNacimientoDao(miNacimientoDao);
        miCoordinador.setProductoDao(miProductoDao);
        miCoordinador.setPersonaProductoDao(miPersonaProductoDao);

        //A cada clase unica se le asigna la unica instancia del coordinador
        miVentanaPrincipal.setCoordinador(miCoordinador);
        miRegistrarPersonasGui.setCoordinador(miCoordinador);
        miRegistrarMascotasGui.setCoordinador(miCoordinador);
        miRegistrarProductosGui.setCoordinador(miCoordinador);
        miPersonaDao.setCoordinador(miCoordinador);
        miNacimientoDao.setCoordinador(miCoordinador);
        miMascotaDao.setCoordinador(miCoordinador);
        miProductoDao.setCoordinador(miCoordinador);
        miPersonaProductoDao.setCoordinador(miCoordinador);

        //Se muestra la ventana principal.
        miVentanaPrincipal.setVisible(true);
    }

    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }
}
