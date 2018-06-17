
package inventario;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class BuscaAvancada extends JFrame  implements ActionListener {

    JTextField buscarInput;
    JButton buscarButton;
    JButton voltar;
    Patrimonios patriTemp;
    Container c = getContentPane(); 
    JLabel resultado;
    
    public BuscaAvancada(){
        super("Busca Avançada");
         
        c.setLayout(new GridLayout(2,3));  //2 linhas e 2 
        
        buscarInput = new JTextField();
        buscarButton = new JButton("Buscar");
        voltar = new JButton("Voltar");
        
        c.add(buscarInput);
        c.add(buscarButton);
        c.add(voltar);
        
        buscarButton.addActionListener(this);
        voltar.addActionListener(this);
        
        setSize(300,50);//tamanho
        setVisible(false);//deixar visivel
        setDefaultCloseOperation(EXIT_ON_CLOSE);//o X encerra todo o programa
    }
    public static void main(String[] args) {
        new BuscaAvancada();
    }
    
    public void buscar(int patrimonio){
        if(patrimonio <= patriTemp.ultimoPatrimonio){
            boolean achou = false;
            int atual = 0;
            int index = 0;
            String tipo = "";
            while (achou == false && atual < patriTemp.computadores.size() ){
                if(patriTemp.computadores.get(atual).getPatrimonio() == patrimonio){
                    index = atual;
                    achou = true;
                    tipo = "pc";
                    mostrarPc(index);
                    atual++;
                }
            }
            
            if(achou == false){atual = 0; System.out.print("rr");}
            
            while (achou == false && atual < patriTemp.notebooks.size() ){
                if(patriTemp.notebooks.get(atual).getPatrimonio() == patrimonio){
                    index = atual;
                    achou = true;
                    tipo = "Note";
                    mostrarNote(index);
                    atual++;
                }
            }
            
            if(achou == false){
                JOptionPane.showMessageDialog(null, "O equipamento que você pesquisou não foi encontrado");
            }

        }
    }
    
    public void mostrarPc(int index){
        Computador comp = patriTemp.computadores.get(index);
        JOptionPane.showMessageDialog(null, "O equipamento que você pesquisou é um Computador, "
                + "com patrimônio " + comp.patrimonio + " da marca " + comp.getMarca() + 
                " possui " + comp.getMemoria() + " de memória Ram " + " e processador " + 
                comp.getProcessador() + ", seu serial é" + comp.getSerial());
    }
    
    public void mostrarNote(int index){
        Notebook comp = patriTemp.notebooks.get(index);
        JOptionPane.showMessageDialog(null, "O equipamento que você pesquisou é um Notebook, "
                + "com patrimônio " + comp.patrimonio + " da marca " + comp.getMarca() + 
                " possui " + comp.getMemoria() + " de memória Ram " + " e processador " + 
                comp.getProcessador() + ", seu serial é" + comp.getSerial() + " além da dela de" +
                comp.getTamTela() + " polegadas");
    }
    
    public void passarDados(Patrimonios patri){
        this.patriTemp = patri;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buscarButton){
            buscar(Integer.parseInt(buscarInput.getText()));
            System.out.print(Integer.parseInt(buscarInput.getText()));
        }
        
        if(e.getSource()== voltar){
            setVisible(false);
        }
    }
    
}
