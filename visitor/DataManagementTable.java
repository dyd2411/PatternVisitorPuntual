package visitor;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import composite.*;

public class DataManagementTable {
    
    private String [] columnNames = {"Order id",
    "Order type"};
    private JTable ordersTable;
    private JScrollPane spTable;
    private TableModel tableModel;

    public DataManagementTable() {
        Object[][] data = {};
        tableModel = new DefaultTableModel(data, columnNames);
        ordersTable = new JTable(tableModel);
        this.configureTable();
        spTable = new JScrollPane(ordersTable);
    }

    public void configureTable () {
        // Make table non-editable
        ordersTable.setDefaultEditor(Object.class, null);
        // Trigger an event when the user double clicks a row
        ordersTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               if (me.getClickCount() == 2) {     // to detect doble click events
                    JTable target = (JTable)me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    JOptionPane.showMessageDialog(null, ordersTable.getValueAt(row, 0)); // get the value of a row and column.
               }
            }
        });
    }

    public JTable getOrdersTable() {
        return ordersTable;
    }

    public void setOrdersTable(JTable ordersTable) {
        this.ordersTable = ordersTable;
    }

    public JScrollPane getSpTable() {
        return spTable;
    }

    public void setSpTable(JScrollPane spTable) {
        this.spTable = spTable;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void updateOrdersTable(OrderComposite objOrderComp) {
        // Use the new methods to get the lastest order
        // and get the order's collection size
        DefaultTableModel model = (DefaultTableModel) this.ordersTable.getModel();
        Object[] row = {objOrderComp.getOrdersSize(), 
            objOrderComp.getLastestOrder().getClass().getSimpleName()};
        model.addRow(row);
    }

}
