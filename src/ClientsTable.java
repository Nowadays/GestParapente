import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

/**
 * Created by Morgan on 04/11/2015.
 */
class ClientsTable extends JPanel {
    private String[] columnNames ={"Nom", "Pr\u00e9nom", "Adresse", "Ville", "CP", "Poid", "Taille", "T\u00e9l\u00e9phone", "Licence", "Niveau"};
    private Vector<String> data;
    private JTable clients;

    public ClientsTable(){
        super();
        this.setLayout(new BorderLayout(10,10));
        data = new Vector<>();
        for (int i = 0; i <= columnNames.length; i++){
            data.add(columnNames[i]);
        }
        clients = new JTable(GestionVector.vPersonne,data);

        clients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel listSelectionModel = clients.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                /*if (clients.getSelectedRow() != -1) {
                    supprimerButton.setEnabled(true);
                    modifierButton.setEnabled(true);
                } else {
                    supprimerButton.setEnabled(false);
                    modifierButton.setEnabled(false);
                }*/
            }
        });
        clients.setSelectionModel(listSelectionModel);
        clients.getTableHeader().setReorderingAllowed(false);
        clients.getTableHeader().setResizingAllowed(false);
        clients.setAutoCreateRowSorter(true);

       JScrollPane scrollPane = new JScrollPane(clients);
        scrollPane.setPreferredSize(new Dimension(380,230));

        /*TableColumn col;
        for(int i = 0; i < clients.getColumnCount(); i++){
            if(i == 0){
                col = clients.getColumnModel().getColumn(i);
                col.setMaxWidth(40);
            } else if(i==4){
                col = clients.getColumnModel().getColumn(i);
                col.setPreferredWidth(80);
            }
        }*/
    }

    public void updateModel(){

    }


}