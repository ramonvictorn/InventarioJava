
package inventario;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Visualizar extends JFrame implements ActionListener {
    JTable tabela = new JTable();
    JTable tabelaNote = new JTable();
    ArrayList<Computador> pcs;
    JButton voltar;
    public Visualizar(){
        super("Visualizar Patrimonios");
        setLayout(new BorderLayout());
        add(BorderLayout.CENTER, new JLabel ("<---Computadores    |   "
                + " Notebooks  --> "));
        add(BorderLayout.WEST, new JScrollPane(tabela));
        add(BorderLayout.PAGE_END , voltar = new JButton("Voltar"));
        voltar.addActionListener(this);
        configurarTabelaPc();
        
        
        
        //add(BorderLayout.EAST, new JLabel ("Notebooks cadastrados: "));
        add(BorderLayout.EAST, new JScrollPane(tabelaNote));
        configurarTabelaNote();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new Visualizar();
        
    }
    
    public void configurarTabelaPc(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Patrimonio Ufsc");
        modelo.addColumn("Marca");
        modelo.addColumn("Processador");
        modelo.addColumn("Memoria");
        modelo.addColumn("Serial");
        
        this.tabela.setModel(modelo);
        
    }
    
    public void configurarTabelaNote(){
        DefaultTableModel modeloNote = new DefaultTableModel();
        modeloNote.addColumn("Patrimonio Ufsc");
        modeloNote.addColumn("Marca");
        modeloNote.addColumn("Processador");
        modeloNote.addColumn("Memoria");
        modeloNote.addColumn("Serial");
        modeloNote.addColumn("Tam Tela");
        this.tabelaNote.setModel(modeloNote);
        
    }
    
    
    
    public void inserirPc(ArrayList<Computador> pcsTemp){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //modelo.addRow(new Object[]{44, "dd", "dd","dd","ee"});
        //modelo.addRow(new Object[]{"patri aqui", "Marca aqui", "Processador","Memoria","Serial"});
        //System.out.println("parte visualizar");
        //System.out.print(pcsTemp.get(1).getPatrimonio());
        int atual = 0;
        while(atual != pcsTemp.size()){ 
        modelo.addRow(new Object[]{pcsTemp.get(atual).getPatrimonio(), pcsTemp.get(atual).getMarca(),
            pcsTemp.get(atual).getProcessador(),pcsTemp.get(atual).getMemoria(),pcsTemp.get(atual).getSerial()});    
            atual++;
        }
    }
    
    public void inserirNote(ArrayList<Notebook> notesTemp){
        DefaultTableModel modeloNote = (DefaultTableModel) tabelaNote.getModel();
        modeloNote.setNumRows(0);
        int atual = 0;
        while(atual != notesTemp.size()){ 
        modeloNote.addRow(new Object[]{notesTemp.get(atual).getPatrimonio(), notesTemp.get(atual).getMarca(),
            notesTemp.get(atual).getProcessador(),notesTemp.get(atual).getMemoria(),notesTemp.get(atual).getSerial(), notesTemp.get(atual).getTamTela()});    
            atual++;
        }
    }
    public void printarPatrimonios(ArrayList<Computador> pcsTemp){
        System.out.print(pcsTemp.get(0).getPatrimonio());
        System.out.print("visualizado aqui");
    }
    
    public void visivel(){
        setVisible(true);
    }
    public void invisivel(){
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== voltar){
           System.out.print("clique em voltar");
           setVisible(false);
       }
    }
}
