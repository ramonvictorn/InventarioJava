/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroNotebook extends JFrame  implements ActionListener {

    JButton cancelar = new JButton("Cancelar");  
    JButton ok = new JButton("ok");  
    JTextField patrimonio = new JTextField();  
    JTextField processador = new JTextField();  
    JTextField ram = new JTextField();  
    JTextField marca = new JTextField(); 
    JTextField serial = new JTextField();  
    JTextField tamTela = new JTextField();  
    public Notebook noteAdd;
    
    
    public CadastroNotebook(){
        super("Cadastro de computadores");
        Container c = getContentPane();  
        c.setLayout(new GridLayout(7,2));  //2 linhas e 2 

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
        
        c.add(new JLabel ("Tamanho da tela:")); 
        c.add(tamTela);
        
        c.add(ok);
        ok.addActionListener(this);
        c.add(cancelar);
        cancelar.addActionListener(this);
        
        
        setSize(600,300);//tamanho
        setVisible(false);//deixar visivel
        setDefaultCloseOperation(EXIT_ON_CLOSE);//o X encerra todo o programa
    }
    
    public static void main(String[] args) {
        new CadastroNotebook();        
    }
    
    public void cad(){
        
        
        int valuePatrimonio = Integer.parseInt(patrimonio.getText());
        String valueProcessador = processador.getText();
        int valueRam = Integer.parseInt(ram.getText());
        String valueMarca = marca.getText();
        String valueSerial = serial.getText();
        int valueTela =Integer.parseInt(tamTela.getText());
        
        noteAdd = new Notebook(valueProcessador, valueRam ,valueMarca , valueSerial, valuePatrimonio , valueTela);
        System.out.print(noteAdd.getMarca());
        
    }
    
    public Notebook noteInformado(){
        return noteAdd;
    }
    
    
    public void visivel(){
        setVisible(true);
    }
    

    public void invisivel(){
        setVisible(false);
    }
    
    public void setarPatrimonio(int ultimo){
        patrimonio.setText(Integer.toString(ultimo)+1);
    }
    
    public void limparCampos(){
        //patrimonio.setText("");
        processador.setText("");
        ram.setText("");
        marca.setText("");
        serial.setText("");
        tamTela.setText("");
    }
    
    public boolean verificarCampos(){
        boolean verificado = false;
        
        String valuePatrimonio = patrimonio.getText();
        String valueProcessador = processador.getText();
        String valueRam = ram.getText();
        String valueMarca = marca.getText();
        String valueSerial = serial.getText();
        String valueTela = tamTela.getText();
        
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
        verificado = false;
        if(valueTela.length()>0){
            verificado = true;
        }
    return verificado;}
    //eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== cancelar){
            System.out.print("cancelar");
            invisivel();
            limparCampos();
        }
        
        if(e.getSource()== ok){
            
            if(verificarCampos()){
                System.out.print("note verificado como true");
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
            //System.out.print("click em Ok");
            //invisivel();
            //try{
            //     cad();
            //}catch (NumberFormatException erroTi) {
   //System.out.println(" (preencha os campos)Erro: " + erroTi);
//}
           
            //limparCampos();
        }
    }
    
}
