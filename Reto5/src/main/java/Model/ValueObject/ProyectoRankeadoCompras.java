package Model.ValueObject;

public class ProyectoRankeadoCompras{

    //atributos
    private Integer idProyecto;
    private String clasificacion;
    private Integer gastoCompra;
    private String serial;

    //constructor
    public ProyectoRankeadoCompras(){
    }

    public ProyectoRankeadoCompras(Integer idProyecto, String clasificacion, Integer gastoCompra, String serial) {
        this.idProyecto = idProyecto;
        this.clasificacion = clasificacion;
        this.gastoCompra = gastoCompra;
        this.serial = serial;
    }
    //getters y setters
    public Integer getIdProyecto() {
        return idProyecto;
    }
    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public Integer getGastoCompra() {
        return gastoCompra;
    }
    public void setGastoCompra(Integer gastoCompra) {
        this.gastoCompra = gastoCompra;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }

    
    



}