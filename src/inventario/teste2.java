
package inventario;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ramon
 */
public class teste2 extends JFrame {
    JTable tabela = new JTable();
    
    public teste2(){
        super("teste 2");
        setLayout(new BorderLayout());
        add(BorderLayout.CENTER, new JScrollPane(tabela));
        configurarTabela();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,200);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new teste2();
    }
    
    public void configurarTabela(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Patrimonio Ufsc");
        modelo.addColumn("Marca");
        modelo.addColumn("Processador");
        modelo.addColumn("Memoria");
        modelo.addColumn("Serial");
        
        this.tabela.setModel(modelo);
        inserir();
    }
    
        public void inserir(){
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

            modelo.addRow(new Object[]{"tt", "dd", "dd","dd"});
        }
}
