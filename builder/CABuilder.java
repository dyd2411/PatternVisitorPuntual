package builder;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import visitor.CaliforniaOrder;
import visitor.Order;


public class CABuilder extends UIBuilder {

    private JTextField txtOrderAmount;
    private JTextField txtAdditionalTax;

    @Override
    public void addUIControls() {
        searchUI = new JPanel();
        JLabel lblOrderAmount = new JLabel("Order Amount:");
        txtOrderAmount = new JTextField(10);
        
        JLabel lblAdditionalTax = new JLabel("Additional Tax:");
        txtAdditionalTax = new JTextField(10);

        GridBagLayout gridbag = new GridBagLayout();
        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        searchUI.add(lblOrderAmount);
        searchUI.add(txtOrderAmount);
        searchUI.add(lblAdditionalTax);
        searchUI.add(txtAdditionalTax);

        gbc.anchor = GridBagConstraints.WEST;

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmount, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblAdditionalTax, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmount, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtAdditionalTax, gbc);

    }

    @Override
    public void initialize() {
        txtOrderAmount.setText("Enter Amount");
        txtAdditionalTax.setText("Enter Add Tax");
    }

    @Override
    public HashMap<String, String> getValues() {
        HashMap<String, String> values = new HashMap<String, String>();
        String strOrderAmount = txtOrderAmount.getText();
        String strTax = txtAdditionalTax.getText();

        values.put("orderAmount", strOrderAmount);
        values.put("additionalTax", strTax);

        return values;
    }

    @Override
    public void setValues(HashMap<String, String> values) {
        txtOrderAmount.setText(values.get("orderAmount"));
        txtAdditionalTax.setText(values.get("additionalTax"));
    }

}
