package testeinterface;

import java.awt.BorderLayout; // layout 
import java.awt.Container; // parte do container
import javax.swing.JButton; // usar botoes
import javax.swing.JFrame; // usar frames
/**
 *
 * @author ramon
 */
public class Janela extends JFrame {
    JButton botao1 = new JButton("Cadastrar Computador");
    JButton botao2 = new JButton("Cadastrar Notebook");
    JButton botao3 = new JButton("Visualizar");
    public Janela(){
        
        super("Home"); // passar nome do topo da janela
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.NORTH,botao1);
        c.add(BorderLayout.SOUTH,botao2);
        c.add(BorderLayout.CENTER,botao3);
        JFrame frame = new JFrame();
        
        setSize(300,300);//tamanho
        setVisible(true);//deixar visivel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fechar programa encerra
                
        
        System.out.println("janela criada");
    }
}
