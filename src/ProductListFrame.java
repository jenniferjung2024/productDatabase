import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;


public class ProductListFrame extends JFrame implements ActionListener {
    private JTextField productIDField; 
    private JTextField productNameField;
    private JTextField manufacturerField;
    private JFormattedTextField priceField;
    final static int DEPT_SIZE = 12;
    
    private JLabel tableLabel;
    private JLabel productIDLabel;
    private JLabel productNameLabel;
    private JLabel manufacturerLabel;
    private JLabel priceLabel;
    private JLabel departmentLabel;
    private JButton addButton;                 
    private JButton quitButton;
    private JTable productListTable; 


    private static ArrayList<Product> productList;

    JSpinner departmentSpinner;

    ProductListFrame() {

        Object[][] tableVals = new Object[5][5];                // Create table
        String[] columnHeadings = {"Product ID", "Product Name", "Manufacturer", "Price", "Department"};
        GridBagConstraints layoutConst = null;                  // GUI component layout
        NumberFormat currencyFormat = null;                     // Format for price
  
        // Set frame's title
        setTitle("Product List");
  
        // Create table
        tableLabel = new JLabel("Product List - Details:");
        productIDLabel = new JLabel("Product ID:");
        productNameLabel = new JLabel("Product Name:");
        manufacturerLabel =  new JLabel("Manufacturer:");
        priceLabel = new JLabel("Price:");
        departmentLabel = new JLabel("Department:");

        productIDField = new JTextField(20);
        productIDField.setEditable(true);

        productNameField = new JTextField(20);
        productNameField.setEditable(true);

        manufacturerField = new JTextField(20);
        manufacturerField.setEditable(true);

        currencyFormat = NumberFormat.getCurrencyInstance();
        currencyFormat.setMaximumFractionDigits(0);
        priceField = new JFormattedTextField(currencyFormat);
        priceField.setEditable(true);
        priceField.setValue(0.0);

        String[] departmentStrings = new String[DEPT_SIZE]; 
        setDepartment(departmentStrings);
        SpinnerListModel departmentModel = new SpinnerListModel(departmentStrings);
        departmentSpinner = new JSpinner(departmentModel);

        addButton = new JButton("Add");
        addButton.addActionListener(this);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);

        // Initialize table
        DefaultTableModel model = new DefaultTableModel(columnHeadings, 0);
        productListTable = new JTable(model);
        productListTable.setEnabled(false); // Prevent user input via table


        // Create an ArrayList and add 5 instances of the product object
         productList = new ArrayList<Product>();
        productListAddInitialElements(productList, model);
        
        makeEmpty(productList, model);


        // Add components using GridBagLayout
        setLayout(new GridBagLayout());

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(tableLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 0, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.gridwidth = 4;
        add(productListTable.getTableHeader(), layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.gridwidth = 4;
        add(productListTable, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        add(productIDLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        layoutConst.gridwidth = 1;
        add(productIDField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        add(productNameLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        add(productNameField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 3;
        add(manufacturerLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 4;
        add(manufacturerField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 3;
        layoutConst.gridy = 3;
        add(priceLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 3;
        layoutConst.gridy = 4;
        add(priceField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 4;
        layoutConst.gridy = 3;
        add(departmentLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 4;
        layoutConst.gridy = 4;
        layoutConst.gridwidth = 2;
        add(departmentSpinner, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 5, 10, 10);
        // layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        add(addButton, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 5, 10, 10);
        // dlayoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        add(quitButton, layoutConst);
    }

    private void setDepartment(String[] departmentList) {

        departmentList[0] = "HOME";
        departmentList[1] = "FOOD";
        departmentList[2] = "CLOTHING";
        departmentList[3] = "ELECTRONICS";
        departmentList[4] = "TOYS";
        departmentList[5] = "BOOKS";
        departmentList[6] = "SPORTING_GOODS";
        departmentList[7] = "ACCESSORIES";
        departmentList[8] = "FOOTWEAR";
        departmentList[9] = "HEALTHandBEAUTY";
        departmentList[10] = "AUTOMOTIVE";
        departmentList[11] = "STATIONARY";

    }

    public void productListAddInitialElements(ArrayList<Product> productArray, DefaultTableModel tableModel) {

        final int INITIAL_PRODUCT_LIST_SIZE = 5; 

        Product product1 = new Product("Chicken Noodle Soup", 1.50);
        product1.setProductID("0010");
        product1.setDepartment("FOOD");
        product1.setManufacturer("Campbell");

        productArray.add(product1);

        /* 
        for (int index = 0; index < INITIAL_PRODUCT_LIST_SIZE; ++index) {
           productArray.add(new Product());
        }
        */

        Object[] row = { productArray.get(0).getProductID(), productArray.get(0).getProductName(), productArray.get(0).getManufacturer(), productArray.get(0).getPrice(), productArray.get(0).getDepartment() };
        tableModel.addRow(row);

    }

    public static void makeEmpty(ArrayList<Product> productArray, DefaultTableModel tableModel) {


        tableModel.removeRow(tableModel.getRowCount() - 1);

        int index;      // Loop index
        
        for (index = 0; index < productArray.size(); ++ index) {
           productArray.get(index).makeEmpty();

        }

    }

    /* Called when either button is pressed. */
    @Override
    public void actionPerformed(ActionEvent event) {

        Product productElement;  // Product information
        String productID;
        String productName;
        String manufacturer;
        int price;  
        String department;

        int productNum;
        final int NUM_PRODUCTS = 5;

        // Get source of event (2 buttons in GUI)
        JButton sourceEvent = (JButton) event.getSource();

        // User pressed the add button
        if (sourceEvent == addButton) {

            productID = productIDField.getText();
            productName = productNameField.getText();
            manufacturer = manufacturerField.getText();
            price = ((Number) priceField.getValue()).intValue();
            department = (String) departmentSpinner.getValue();

            productElement = new Product(productName, price);         // Create new Product object
            productElement.setManufacturer(manufacturer);
            productElement.setProductID(productID);
            productElement.setDepartment(department);

            productList.add(productElement); // Add product to ArrayList
            DefaultTableModel model = (DefaultTableModel)productListTable.getModel();
            Object[] row = { productElement.getProductID(), productElement.getProductName(), productElement.getManufacturer(), productElement.getPrice(), productElement.getDepartment() };
            model.addRow(row);

            updateTable();                        // Synchronize table with its ArrayList

            // Show success dialog
            JOptionPane.showMessageDialog(this, "Product Added.");
        }
      

        else if (sourceEvent == quitButton) {
            dispose();                               // Terminate program
        }
    }


    /* Updates the product list detail information displayed by the table */
    public void updateTable() {
        final int productIDCol = 0;     // Col num for product ID
        final int productNameCol = 1;   // Col num for product name
        final int manufacturerCol = 2;  // Col num for manufacturer
        final int priceCol = 3;         // Col num for price
        final int departmentCol = 4;    // Col num for department
        int index;                          // Loop index

        for (index = 0; index < productList.size(); ++index) {

            if (productList.get(index).isEmpty()) { // Clear table entries 
                productListTable.setValueAt(null, index, productIDCol);
                productListTable.setValueAt(null, index, productNameCol);
                productListTable.setValueAt(null, index, manufacturerCol);
                productListTable.setValueAt(null, index, priceCol);
                productListTable.setValueAt(null, index, departmentCol);
            }
       
            else {                             // Update table with content in the productListTable ArrayList
                productListTable.setValueAt(productList.get(index).getProductID(), index, productIDCol);
                productListTable.setValueAt(productList.get(index).getProductName(), index, productNameCol);
                productListTable.setValueAt(productList.get(index).getManufacturer(), index, manufacturerCol);
                productListTable.setValueAt((Number)productList.get(index).getPrice(), index, priceCol);
                productListTable.setValueAt(productList.get(index).getDepartment(), index, departmentCol);
            }
        }
    }
 

}