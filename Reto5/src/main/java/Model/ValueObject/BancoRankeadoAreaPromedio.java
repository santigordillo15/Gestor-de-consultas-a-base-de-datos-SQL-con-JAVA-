package Model.ValueObject;

public class BancoRankeadoAreaPromedio {
    //atributos, columnas de la tabla
    private String bancoVinculado;
    private Double areaPromedio;

    //constructor vacio
    public BancoRankeadoAreaPromedio(){

    }

    //Metodos
    public String getBancoVinculado() {
        return bancoVinculado;
    }
    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }
    public Double getAreaPromedio() {
        return areaPromedio;
    }
    public void setAreaPromedio(Double areaPromedio) {
        this.areaPromedio = areaPromedio;
    }

    


}
