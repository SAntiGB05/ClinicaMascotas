package modelo.vo;

public class PersonaProductoVo {

    private Long personaId;
    private Long productoId;

    public PersonaProductoVo() {

    }

    public PersonaProductoVo(Long personaId, Long productoId) {
        super();
        this.personaId = personaId;
        this.productoId = productoId;
    }
    public Long getPersonaId() {
        return personaId;
    }
    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }
    public Long getProductoId() {
        return productoId;
    }
    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    @Override
    public String toString() {
        return "PersonasProductos [personaId=" + personaId + ", productoId=" + productoId + "]";
    }

}

