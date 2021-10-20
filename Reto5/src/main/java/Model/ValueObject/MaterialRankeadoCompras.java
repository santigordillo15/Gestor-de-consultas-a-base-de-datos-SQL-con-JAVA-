package Model.ValueObject;



public class MaterialRankeadoCompras {

    private String Nombre_Material;
    private String Importado;
    private Integer No_Compras;

    public MaterialRankeadoCompras(){

    }

    public MaterialRankeadoCompras(String nombre_Material, String importado, Integer no_Compras) {
        Nombre_Material = nombre_Material;
        Importado = importado;
        No_Compras = no_Compras;
    }

    //getters y setters
    public String getNombre_Material() {
        return Nombre_Material;
    }

    public void setNombre_Material(String nombre_Material) {
        Nombre_Material = nombre_Material;
    }

    public String isImportado() {
        return Importado;
    }

    public void setImportado(String importado) {
        Importado = importado;
    }

    public Integer getNo_Compras() {
        return No_Compras;
    }

    public void setNo_Compras(Integer no_Compras) {
        No_Compras = no_Compras;
    }

    
    


    
}
