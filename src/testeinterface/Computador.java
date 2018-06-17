
package testeinterface;

public class Computador {
    public String processador;
    public int memoria;
    public String marca;
    public String serial;    
    public int patrimonio;

    public Computador(int patrimonio ,String marca, String processador, int memoria, String serial ) {
        this.processador = processador;
        this.memoria = memoria;
        this.marca = marca;
        this.serial = serial;
        this.patrimonio = patrimonio;
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
    
    
    
    
    
}
