package controlador;

import modelo.dao.MascotaDao;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;
import modelo.vo.MascotaVo;
import modelo.vo.PersonaVo;
import vistas.gui.RegistrarMascotaGui;
import vistas.gui.RegistrarPersonaGui;
import vistas.gui.RegistrarProductoGui;
import vistas.gui.VentanaPrincipal;

public class Coordinador {
    VentanaPrincipal miVentanaPrincipal;
    RegistrarPersonaGui miRegistrarPersonasGui;
    RegistrarMascotaGui miRegistrarMascotasGui;
    RegistrarProductoGui miRegistrarProductosGui;
    PersonaDao miPersonaDao;
    NacimientoDao miNacimientoDao;
    MascotaDao miMascotaDao;
    ProductoDao miProductoDao;
    PersonaProductoDao miPersonaProductoDao;

    public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
        this.miVentanaPrincipal=miVentanaPrincipal;
    }

    public void setRegistrarPersonasGui(RegistrarPersonaGui miRegistrarPersonasGui) {
        this.miRegistrarPersonasGui=miRegistrarPersonasGui;
    }

    public void setRegistrarMascotasGui(RegistrarMascotaGui miRegistrarMascotasGui) {
        this.miRegistrarMascotasGui=miRegistrarMascotasGui;
    }

    public void setRegistrarProductosGui(RegistrarProductoGui miRegistrarProductosGui) {
        this.miRegistrarProductosGui=miRegistrarProductosGui;
    }

    public void setPersonaDao(PersonaDao miPersonaDao) {
        this.miPersonaDao=miPersonaDao;
    }

    public void setMascotaDao(MascotaDao miMascotaDao) {
        this.miMascotaDao=miMascotaDao;
    }

    public void setNacimientoDao(NacimientoDao miNacimientoDao) {
        this.miNacimientoDao=miNacimientoDao;
    }

    public void setProductoDao(ProductoDao miProductoDao) {
        this.miProductoDao=miProductoDao;
    }

    public void setPersonaProductoDao(PersonaProductoDao miPersonaProductoDao) {
        this.miPersonaProductoDao=miPersonaProductoDao;
    }

    public void mostrarVentanaRegistroPersona() {
        miRegistrarPersonasGui.setVisible(true);
    }

    public void mostrarVentanaRegistroMascota() {
        miRegistrarMascotasGui.setVisible(true);
    }

    public String registrarPersona(PersonaVo miPersona) {
        return miPersonaDao.registrarPersona(miPersona);
    }

    public Long registrarNacimiento(PersonaVo miPersona) {
        return miNacimientoDao.registrarNacimiento(miPersona.getNacimiento());
    }


    public void RegistrarMascota(MascotaVo miMascota){
        miMascotaDao.RegistrarMascota(miMascota);
    }
}
