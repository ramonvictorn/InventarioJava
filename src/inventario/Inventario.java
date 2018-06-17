//questionar sobre nota usando interface ou codigossssssss
package inventario;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Inventario extends JFrame implements ActionListener {
    JButton cadastrarPc;
    JButton inserirPc;
    JButton cadastrarNote;
    JButton inserirNote;
    JButton visualizar;
    JButton buscaAvancada;
    CadastroComputador pcCadastro = new CadastroComputador();
    CadastroNotebook noteCadastro = new CadastroNotebook();
    Patrimonios patrimonios = new Patrimonios();
    Computador tempPc;
    boolean permitirInserirPc = false;
    boolean permitirInserirNote = false;
    Notebook tempNote;
    Visualizar visualizarPatrimonio = new Visualizar();
    BuscaAvancada busca = new BuscaAvancada();
  
    
    public Inventario(){
        super("Inventario");
        //pcTeste = new Computador(11,"string", "string" , 13, "str" );
        
        //Container c = getContentPane();
        
        Container c = getContentPane();  
        c.setLayout(new GridLayout(3,2));  //2 linhas e 2 
        
        
        // botao para inserir os dados do computador
        cadastrarPc = new JButton("Cadastrar Computador");
        add(cadastrarPc);
        cadastrarPc.addActionListener(this);

        // botao para inserir os dados do notebook        
        cadastrarNote = new JButton("Cadastrar Notebook");
        add(cadastrarNote);
        cadastrarNote.addActionListener(this);
        
        
        
        //para inserir os dados informados antes na lista de patrimonios
        inserirPc = new JButton("Inserir Computador");
        add(inserirPc);
        inserirPc.addActionListener(this);
        //inserirPc.setEnabled(false);
        
        
        //para inserir os dados informados antes na lista de patrimonios
        inserirNote = new JButton("Insetir Notebook");
        add(inserirNote);
        inserirNote.addActionListener(this);
        //inserirNote.setEnabled(false);
        
        
        //visualizar os patrimonios
        visualizar = new JButton("Visualizar");
        add(visualizar);
        visualizar.addActionListener(this);
        
        buscaAvancada = new JButton("Busca Avançada");
        add(buscaAvancada);
        buscaAvancada.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,200);
        setVisible(true);
        
        verificarPermissaoNote();
        verificarPermissaoPc();
    }
    
    public static void main(String[] args) {
        new Inventario();
    }
    
    public void verificarDadosPc(Computador tempPc){
        tempPc.getMarca();
    }
    
    public void verificarPermissaoPc(){  
        if(pcCadastro.pcAdd != null){
        permitirInserirPc = true;
        //busca.passarDados(patrimonios);
        }
    }
    
    public void verificarPermissaoNote(){  
        if(noteCadastro.noteAdd != null){
        permitirInserirNote = true;
        //busca.passarDados(patrimonios);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== cadastrarPc){
            System.out.print("Click no cadastro pc");
            pcCadastro.setarPatrimonio(patrimonios.ultimoPatrimonio);
            pcCadastro.visivel();
        }
        if(e.getSource()== cadastrarNote){
            System.out.print("Click no cadastro Note"); 
            noteCadastro.setarPatrimonio(patrimonios.ultimoPatrimonio);
            noteCadastro.visivel();
        }
        if(e.getSource()== inserirPc){
                System.out.print("Click no inserir pc");
                //patrimonios.adicionarPc(pcTeste);
                verificarPermissaoPc();
                if(permitirInserirPc){
                    Computador tempPc = pcCadastro.pcInformado();
                    pcCadastro.pcAdd = null;
                    patrimonios.adicionarPc(tempPc);
                    patrimonios.atualizarPatrimonio();
                    pcCadastro.pcAdd = null;
                    tempPc = null;
                    permitirInserirPc = false;
                }else{
                    JOptionPane.showMessageDialog(null, "Primeiro Cadastre um Computador e depois insira !");
                }
                    
       
                    
                
        }
        if(e.getSource()== inserirNote){
            verificarPermissaoNote();
                if(permitirInserirNote){  
                    Notebook temp = noteCadastro.noteInformado();
                    patrimonios.adicionarNote(temp);
                    patrimonios.atualizarPatrimonio();
                    temp = null;
                    noteCadastro.noteAdd = null;
                    permitirInserirNote= false;
                }else{
                    JOptionPane.showMessageDialog(null, "Primeiro Cadastre um Notebook e depois insira !");
                }          
        }
        if(e.getSource()== visualizar){
            System.out.print("Click no visualizar");  
            visualizarPatrimonio.visivel();
            visualizarPatrimonio.inserirPc(this.patrimonios.computadores);
            visualizarPatrimonio.inserirNote(this.patrimonios.notebooks);
        }
        
        if(e.getSource() == buscaAvancada){
            System.out.print("Clique em busca avançada");
            busca.setVisible(true);
            busca.passarDados(patrimonios);
        }
    }
    
}
