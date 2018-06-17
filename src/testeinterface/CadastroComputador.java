package testeinterface;


import java.awt.Container;// getContentPane
import java.awt.GridLayout; //layout grid
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // eventos
import javax.swing.JButton;// botoes
import javax.swing.JFrame; // extends
import javax.swing.JLabel; //JLabel
import javax.swing.JTextField; //TextFild



public class CadastroComputador extends JFrame  implements ActionListener{
    
    JButton cancelar = new JButton("Cancelar");  
    JButton ok = new JButton("ok");  
    JTextField patrimonio = new JTextField();  
    JTextField processador = new JTextField();  
    JTextField ram = new JTextField();  
    JTextField marca = new JTextField(); 
    JTextField serial = new JTextField();  
    Computador pcAdd;
    int i;
    public CadastroComputador(){
        super("Cadastro de computadores");
        Container c = getContentPane();  
        c.setLayout(new GridLayout(6,2));  //2 linhas e 2 
        i = 0;
        //linha 1
        c.add(new JLabel ("Numero do Patrimônio:"));
        c.add(patrimonio);
        
        //linha 2
        c.add(new JLabel ("Informe o processador:"));  
        c.add(processador);
        
        c.add(new JLabel ("Tamanho da RAM:"));  
        c.add(ram);  
        
        c.add(new JLabel ("Digite a marca:"));
        c.add(marca);
        

        c.add(new JLabel ("Digite o serial:"));  
        c.add(serial); 
        
        
        c.add(ok);
        ok.addActionListener(this);
        c.add(cancelar);
        cancelar.addActionListener(this);
        
        
        setSize(600,300);//tamanho
        setVisible(true);//deixar visivel
        setDefaultCloseOperation(EXIT_ON_CLOSE);//o X encerra todo o programa
    }
    public static void main(String[] args) {
        CadastroComputador cadastro = new CadastroComputador();
    }
    
    public void cad(){
        int valuePatrimonio = Integer.parseInt(patrimonio.getText());
        String valueProcessador = processador.getText();
        int valueRam = Integer.parseInt(ram.getText());
        String valueMarca = marca.getText();
        String valueSerial = serial.getText();
        
        pcAdd = new Computador(valuePatrimonio, valueMarca , valueProcessador , valueRam,valueSerial);
        //System.out.print(pcAdd.getMarca());
        
    }
    
    public Computador get(){
        
    return pcAdd;}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== cancelar){
            System.out.print("cancelar");
        }
        
        cad();
        //i= 1;
    }
    
}
