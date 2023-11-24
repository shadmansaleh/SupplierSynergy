/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSTableMetro;
import java.sql.*;
import SypplierSynergy.DBConnection;
import SypplierSynergy.Globals;
import SypplierSynergy.HomePage;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.util.Vector;
import java.util.function.Consumer;

/**
 *
 * @author shadman
 */
public class JSqlTablel1 extends RSTableMetro {
    private String SQLQuery = "";
    private int LIMIT = 0;
    DefaultTableModel model = new DefaultTableModel();
    RSTableMetro tbl = this;
    


    public String getSQLQuery() {
        return SQLQuery;
    }

    public void setSQLQuery(String query) {
        this.SQLQuery = query;
        tbl.setModel(model);
        load_data();
        repaint();
    }

    public int getLIMIT() {
        return LIMIT;
    }

    public void setLIMIT(int LIMIT) {
        this.LIMIT = LIMIT;
    }

    public void load_data() {
        try {
            if (!SQLQuery.equals("")) {
                Connection con = DBConnection.getConnection();
                PreparedStatement pat = con.prepareStatement(SQLQuery + (LIMIT == 0 ? "" : " LIMIT " + String.valueOf(LIMIT)));

                ResultSet rs = pat.executeQuery();
                var metadata = rs.getMetaData();
                var tot_columns = metadata.getColumnCount();
                Vector<String> columns = new Vector<>();
                for (int i = 1; i <= tot_columns; i++) {
                    columns.add(metadata.getColumnName(i));
                }
                
                model.setColumnCount(tot_columns);
                model.setRowCount(0);
                model.setColumnIdentifiers(columns);

                while (rs.next()) {
                    Vector<Object> data = new Vector<>();
                    for (int i = 1; i <= tot_columns; i++) {
                        data.add(rs.getObject(i));
                    }
                    model.addRow(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSqlTablel1() {
        tbl.setModel(model);

        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl.setFillsViewportHeight(true);
        tbl.setColorBackgoundHead(new java.awt.Color(51, 102, 255));
        tbl.setColorBordeFilas(new java.awt.Color(51, 102, 255));
        tbl.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl.setColorFilasForeground1(new java.awt.Color(102, 102, 102));
        tbl.setColorFilasForeground2(new java.awt.Color(102, 102, 102));
        tbl.setColorSelBackgound(new java.awt.Color(102, 102, 102));
        tbl.setFont(new java.awt.Font("Glass Antiqua", 0, 25)); // NOI18N
        tbl.setFuenteFilas(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tbl.setFuenteHead(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tbl.setRowHeight(40);

        load_data();
    }

}
