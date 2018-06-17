
package testeinterface;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Inicio extends JFrame implements ActionListener {
    JButton pc;
    JButton btOk;
    CadastroComputador pcCadastro;
    public Patrimonios patrimonios = new Patrimonios();
    public ArrayList<Computador> computadores = new ArrayList<Computador>();
    
    
    
    public Inicio(){
        super("Janela eventos");
        Computador pcTeste = new Computador(11,"string", "string" , 13, "str" );
        computadores.add(pcTeste);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
        //Container c = getContentPane();
        
        Container c = getContentPane();  
        c.setLayout(new GridLayout(1,2));  //2 linhas e 2 
        
        pc = new JButton("Computador");
        add(pc);
        pc.addActionListener(this);
        
        btOk = new JButton("ok");
        add(btOk);
        btOk.addActionListener(this);
    }
    
    public static void main(String[] args) {
        new Inicio();
    }
    
     public Computador getComputador(int patri){
        Computador compAchado = null;
        boolean naoEncontrou = true;
        while(naoEncontrou){
            for (Computador computador : computadores) {
                if(computador.getPatrimonio() == patri){
                    naoEncontrou = false;
                }
            }
        }
    return compAchado;}
     

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== pc){
            System.out.print("pc");
            pcCadastro = new CadastroComputador();
        }
        
        if(e.getSource()== btOk){
            System.out.print("ok");
            patrimonios.computadores2.add(pcCadastro.get());
            System.out.print(patrimonios.computadores2.get(0).processador);
        }
        
        
        
        //while(pcCadastro.i != 1){
          //  patrimonios.computadores2.add(pcCadastro.get());
            //System.out.print(patrimonios.computadores2.get(0).processador);
        //}
    }
}
