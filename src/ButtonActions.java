import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ButtonActions {

    public static void DeleteLastAction(ArrayList<Product> productList, JTable productListTable) {

        DefaultTableModel model = (DefaultTableModel)productListTable.getModel();
        
        
        if (!productList.isEmpty()) {
                model.removeRow(productList.size() - 1);  // empty row
                productList.remove(productList.size() - 1);
                updateTable();
            }
            else
                JOptionPane.showMessageDialog(this, "No product in database to delete.");
    }


    public void AddAction() {

    }

    public void DeleteAllAction() {

    }

    public void QuitAction() {

    }


}
