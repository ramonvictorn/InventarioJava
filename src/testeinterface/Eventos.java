
package testeinterface;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author ramon
 */
public class Eventos extends JFrame implements ActionListener{
    JButton btOk;
    public Eventos(){
        super("Janela eventos");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
        //Container c = getContentPane();
        btOk = new JButton("Ok");
        add(btOk);
        btOk.addActionListener(this);
    }
    public static void main(String[] args) {
        new Eventos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // System.out.print("Botão Clicado");
       if(btOk.getText() == "Ok"){
       btOk.setText("Botão foi clicado");
       }else {
           btOk.setText("Ok");
       }
       
       Janela janela1 = new Janela();
       //System.out.print(btOk.getText());
    }
}
