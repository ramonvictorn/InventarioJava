
package inventario;

public class Notebook {
    public String processador;
    public int memoria;
    public String marca;
    public String serial;    
    public int patrimonio;
    public int tamTela;

    public Notebook(String processador, int memoria, String marca, String serial, int patrimonio, int tamTela) {
        this.processador = processador;
        this.memoria = memoria;
        this.marca = marca;
        this.serial = serial;
        this.patrimonio = patrimonio;
        this.tamTela = tamTela;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    public int getTamTela() {
        return tamTela;
    }

    public void setTamTela(int tamTela) {
        this.tamTela = tamTela;
    }
    
    
}
