package inventario;


import java.awt.Component;
import java.awt.Container;// getContentPane
import java.awt.GridLayout; //layout grid
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // eventos
import javax.swing.JButton;// botoes
import javax.swing.JFrame; // extends
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel; //JLabel
import javax.swing.JOptionPane;
import javax.swing.JTextField; //TextFild



public class CadastroComputador extends JFrame  implements ActionListener{
    
    JButton cancelar = new JButton("Cancelar");  
    JButton ok = new JButton("ok");  
    JTextField patrimonio = new JTextField();
    JTextField processador = new JTextField();  
    JTextField ram = new JTextField();  
    JTextField marca = new JTextField(); 
    JTextField serial = new JTextField();  
    public Computador pcAdd;
    int i;
    public CadastroComputador(){
        super("Cadastro de computadores");
        Container c = getContentPane();  
        c.setLayout(new GridLayout(6,2));  //2 linhas e 2 
        i = 0;
        //linha 1
        c.add(new JLabel ("Numero do Patrimônio:"));
        c.add(patrimonio);
        patrimonio.setEditable(false);
        
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
        setVisible(false);//deixar visivel
        setDefaultCloseOperation(EXIT_ON_CLOSE);//o X encerra todo o programa
    }
    public static void main(String[] args) {
        new CadastroComputador();        
    }
    
    public void cad(){
        
        
        int valuePatrimonio = Integer.parseInt(patrimonio.getText());
        String valueProcessador = processador.getText();
        int valueRam = Integer.parseInt(ram.getText());
        String valueMarca = marca.getText();
        String valueSerial = serial.getText();
        
        pcAdd = new Computador(valuePatrimonio, valueMarca , valueProcessador , valueRam,valueSerial);
        System.out.print(pcAdd.getMarca());
        
    }
    
    public Computador pcInformado(){
        return pcAdd;
    }
    
    public void visivel(){
        setVisible(true);
    }
    
    //eliminar os dados dos inputs
    public void invisivel(){
        setVisible(false);
    }

    public void setarPatrimonio(int ultimo){
        patrimonio.setText(Integer.toString(ultimo)+1);
    }
    
    public void limparCampos(){
        patrimonio.setText("");
        processador.setText("");
        ram.setText("");
        marca.setText("");
        serial.setText("");
        
    }
    
    public boolean verificarCampos(){
        boolean verificado = false;
        
        String valuePatrimonio = patrimonio.getText();
        String valueProcessador = processador.getText();
        String valueRam = ram.getText();
        String valueMarca = marca.getText();
        String valueSerial = serial.getText();
        
        if(valuePatrimonio.length()> 0){
            verificado = true;
        }
        verificado = false;
        if(valueProcessador.length()> 0){
            verificado = true;
        }
        verificado = false;
        if(valueRam.length()> 0){
            verificado = true;
        }
        verificado = false;
        if(valueMarca.length()> 0){
            verificado = true;
        }
        verificado = false;
        if(valueSerial.length()> 0){
            verificado = true;
        }
        
    return verificado;}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== cancelar){
            System.out.print("cancelar");
            invisivel();
            limparCampos();
        }
        
        if(e.getSource()== ok){
            System.out.print("click em Ok antigo");
            System.out.print("click em Ok");
            
            if(verificarCampos()){
                System.out.print("PC verificado como true");
                try{
                    cad();
                }catch (NumberFormatException erroTi) {
                    System.out.println(" (preencha os campos)Erro: " + erroTi);
                }
                invisivel();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Os dados foram salvos,agora clique em inserir Computador para salvar !");
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            }
            
            
            //como estava antes
            //invisivel();
            //try{
            //    cad();
            //}catch (NumberFormatException erroTi) {
            //    System.out.println(" (preencha os campos)Erro: " + erroTi);
            //}
           
            //limparCampos();
            
        }
            
                    
        
        //i= 1;
    }
    
}
