package com.fundation.search.view;

import javax.swing.table.AbstractTableModel;

class SearchJTable extends AbstractTableModel {
    private String[] columnNames = { "First Name", "Last Name", "Sport",
            "# of Years", "Vegetarian" };

    private Object[][] data = {
            { "Mary", "Campione", "Snowboarding", new Integer(5),
                    new Boolean(false) },
            { "Alison", "Huml", "Rowing", new Integer(3), new Boolean(true) },
            { "Kathy", "Walrath", "Knitting", new Integer(2),
                    new Boolean(false) },
            { "Sharon", "Zakhour", "Speed reading", new Integer(20),
                    new Boolean(true) },
            { "Philip", "Milne", "Pool", new Integer(10),
                    new Boolean(false) } };

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }


}