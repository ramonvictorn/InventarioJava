
package inventario;

import java.util.ArrayList;

public class Patrimonios {
    ArrayList<Computador> computadores = new ArrayList<Computador>();
    ArrayList<Notebook> notebooks = new ArrayList<Notebook>();
    int ultimoPatrimonio = 0;
    public Patrimonios(){
        
    }
    
    public static void main(String[] args) {
        new Patrimonios();
    }
    
    public void adicionarPc(Computador pcParaAdicionar){
        computadores.add(pcParaAdicionar);
    }
    
    public Computador getPc(int indice){
        return computadores.get(indice);
    }
    
    public void atualizarPatrimonio(){
        ultimoPatrimonio++;
    }
    
    public void adicionarNote(Notebook noteParaAdicionar){
            notebooks.add(noteParaAdicionar);
    }
    
    public Notebook getNote(int indice){
        return notebooks.get(indice);
    }
}
