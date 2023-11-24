/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SypplierSynergy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shadman
 */
public class HomePage extends javax.swing.JFrame {

    int sbcurActive = 0;
    ArrayList<JLabel> sblabels = new ArrayList<>();
    ArrayList<JPanel> sbpanels = new ArrayList<>();

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
        showPieChart();
        sblabels.add(sbl1);
        sblabels.add(sbl2);
        sblabels.add(sbl3);
        sblabels.add(sbl4);
        sblabels.add(sbl5);
        sblabels.add(sbl6);
        sblabels.add(sbl7);

        sbpanels.add(sbp1);
        sbpanels.add(sbp2);
        sbpanels.add(sbp3);
        sbpanels.add(sbp4);
        sbpanels.add(sbp5);
        sbpanels.add(sbp6);
        sbpanels.add(sbp7);
//        sidebarCurActive = J
        update_dashboard_data();

        lbl_username.setText(Globals.username);
    }

    public void update_dashboard_data() {
        txt_supplier.setText(String.valueOf(DBConnection.getQueryValue("SELECT COUNT(*) FROM Supplier")));
        txt_ratailercount.setText(String.valueOf(DBConnection.getQueryValue("SELECT COUNT(*) FROM Retailer")));
        txt_employeecount.setText(String.valueOf(DBConnection.getQueryValue("SELECT COUNT(*) FROM Employee")));
        txt_porderscount.setText(String.valueOf(DBConnection.getQueryValue("SELECT COUNT(*) FROM Orders WHERE status=\"PENDING\"")));
    }

    public void switchpage(int idx){
        idx -= 1;
        sbpanels.get(sbcurActive).setBackground(new Color(51,51,51));
        sblabels.get(sbcurActive).setForeground(new Color(153,153,153));
        sbpanels.get(idx).setBackground(new Color(251,51,51));
        sblabels.get(idx).setForeground(new Color(255,255,255));
        sbcurActive = idx;
        main_view.setSelectedIndex(idx);
    }

    public void showPieChart() {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        barDataset.setValue("Pending", Double.valueOf(DBConnection.getQueryValue("SELECT COUNT(*) FROM Orders WHERE status=\"PENDING\"")));
        barDataset.setValue("Confirmed", Double.valueOf(DBConnection.getQueryValue("SELECT COUNT(*) FROM Orders WHERE status=\"CONFIRMED\"")));
        barDataset.setValue("Shiped", Double.valueOf(DBConnection.getQueryValue("SELECT COUNT(*) FROM Orders WHERE status=\"SHIPPED\"")));
        barDataset.setValue("Deliverd", Double.valueOf(DBConnection.getQueryValue("SELECT COUNT(*) FROM Orders WHERE status=\"DELIVERED\"")));
        barDataset.setValue("Paid", Double.valueOf(DBConnection.getQueryValue("SELECT COUNT(*) FROM Orders WHERE status=\"PAID\"")));

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Order Status", barDataset, false, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
        piePlot.setSectionPaint("Pending", new Color(255, 251, 102));
        piePlot.setSectionPaint("Confirmed", new Color(102, 251, 102));
        piePlot.setSectionPaint("Shiped", new Color(102, 251, 251));
        piePlot.setSectionPaint("Deliverd", new Color(251, 102, 251));
        piePlot.setSectionPaint("Paid", new Color(151, 151, 251));

        piePlot.setBackgroundPaint(new Color(255,255,255));

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        pnl_pichart.removeAll();
        pnl_pichart.add(barChartPanel, BorderLayout.CENTER);
        pnl_pichart.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSLabelImage1 = new rojerusan.RSLabelImage();
        jPanel2 = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        sbp7 = new javax.swing.JPanel();
        sbl7 = new javax.swing.JLabel();
        sbp6 = new javax.swing.JPanel();
        sbl6 = new javax.swing.JLabel();
        sbp5 = new javax.swing.JPanel();
        sbl5 = new javax.swing.JLabel();
        sbp4 = new javax.swing.JPanel();
        sbl4 = new javax.swing.JLabel();
        sbp3 = new javax.swing.JPanel();
        sbl3 = new javax.swing.JLabel();
        sbp2 = new javax.swing.JPanel();
        sbl2 = new javax.swing.JLabel();
        sbp1 = new javax.swing.JPanel();
        sbl1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        main_view = new javax.swing.JTabbedPane();
        home_page = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        txt_supplier = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txt_ratailercount = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txt_employeecount = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        txt_porderscount = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnl_pichart = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSqlTablel11 = new lib.JSqlTablel1();
        jScrollPane3 = new javax.swing.JScrollPane();
        jSqlTablel12 = new lib.JSqlTablel1();
        suppliers = new SypplierSynergy.Suppliers();
        retailers = new SypplierSynergy.Retailers();
        oders = new SypplierSynergy.Orders();
        products = new SypplierSynergy.Products();
        employees = new SypplierSynergy.Employees();
        custom_query = new SypplierSynergy.CustomQuery();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booksh");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(rSLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 5, 40));

        lbl_username.setFont(new java.awt.Font("Glass Antiqua", 1, 20)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        lbl_username.setText("Admin");
        jPanel1.add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 10, 230, -1));

        jLabel2.setFont(new java.awt.Font("Glass Antiqua", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contact Us");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-close-50.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, -1, -1));

        jLabel24.setFont(new java.awt.Font("Glass Antiqua", 0, 28)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("SupplierSynergy");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel25.setFont(new java.awt.Font("Glass Antiqua", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("About Us");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        jLabel26.setFont(new java.awt.Font("Glass Antiqua", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("FAQ");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, -1));

        jLabel27.setFont(new java.awt.Font("Glass Antiqua", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Home");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 70));

        sidebar.setBackground(new java.awt.Color(51, 51, 51));
        sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(0, 102, 255));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel13.setText("Logout");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        sidebar.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 300, 60));

        sbp7.setBackground(new java.awt.Color(51, 51, 51));
        sbp7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sbp7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sbp7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sbp7MouseExited(evt);
            }
        });
        sbp7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sbl7.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        sbl7.setForeground(new java.awt.Color(153, 153, 153));
        sbl7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        sbl7.setText("Custom Query");
        sbp7.add(sbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        sidebar.add(sbp7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 300, 60));

        sbp6.setBackground(new java.awt.Color(51, 51, 51));
        sbp6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sbp6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sbp6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sbp6MouseExited(evt);
            }
        });
        sbp6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sbl6.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        sbl6.setForeground(new java.awt.Color(153, 153, 153));
        sbl6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        sbl6.setText("Employees");
        sbp6.add(sbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        sidebar.add(sbp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 300, 60));

        sbp5.setBackground(new java.awt.Color(51, 51, 51));
        sbp5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sbp5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sbp5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sbp5MouseExited(evt);
            }
        });
        sbp5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sbl5.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        sbl5.setForeground(new java.awt.Color(153, 153, 153));
        sbl5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        sbl5.setText("Products");
        sbp5.add(sbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        sidebar.add(sbp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 300, 60));

        sbp4.setBackground(new java.awt.Color(51, 51, 51));
        sbp4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sbp4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sbp4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sbp4MouseExited(evt);
            }
        });
        sbp4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sbl4.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        sbl4.setForeground(new java.awt.Color(153, 153, 153));
        sbl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        sbl4.setText("Oders");
        sbp4.add(sbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        sidebar.add(sbp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 300, 60));

        sbp3.setBackground(new java.awt.Color(51, 51, 51));
        sbp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sbp3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sbp3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sbp3MouseExited(evt);
            }
        });
        sbp3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sbl3.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        sbl3.setForeground(new java.awt.Color(153, 153, 153));
        sbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        sbl3.setText("Retailers");
        sbp3.add(sbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        sidebar.add(sbp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 60));

        sbp2.setBackground(new java.awt.Color(51, 51, 51));
        sbp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sbp2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sbp2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sbp2MouseExited(evt);
            }
        });
        sbp2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sbl2.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        sbl2.setForeground(new java.awt.Color(153, 153, 153));
        sbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        sbl2.setText("Suppliers");
        sbp2.add(sbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        sidebar.add(sbp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 300, 60));

        sbp1.setBackground(new java.awt.Color(251, 51, 51));
        sbp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sbp1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sbp1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sbp1MouseExited(evt);
            }
        });
        sbp1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sbl1.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        sbl1.setForeground(new java.awt.Color(255, 255, 255));
        sbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        sbl1.setText("Dashboard");
        sbp1.add(sbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        sidebar.add(sbp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 300, 60));

        jLabel5.setFont(new java.awt.Font("Glass Antiqua", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tables");
        sidebar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 30));

        getContentPane().add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 300, 730));

        main_view.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                main_viewFocusGained(evt);
            }
        });

        home_page.setBackground(new java.awt.Color(255, 255, 255));
        home_page.setForeground(new java.awt.Color(153, 153, 153));
        home_page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(251, 51, 51)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_supplier.setFont(new java.awt.Font("Glass Antiqua", 1, 50)); // NOI18N
        txt_supplier.setForeground(new java.awt.Color(102, 102, 102));
        txt_supplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        txt_supplier.setText("152");
        jPanel12.add(txt_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        home_page.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 220, 130));

        jLabel15.setFont(new java.awt.Font("Glass Antiqua", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Supplier Details");
        home_page.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel17.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("No of Retailers");
        home_page.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, 20));

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(51, 102, 255)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ratailercount.setFont(new java.awt.Font("Glass Antiqua", 1, 50)); // NOI18N
        txt_ratailercount.setForeground(new java.awt.Color(102, 102, 102));
        txt_ratailercount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        txt_ratailercount.setText("344");
        jPanel13.add(txt_ratailercount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        home_page.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 220, 130));

        jLabel18.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Employees");
        home_page.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, 20));

        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(251, 51, 51)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_employeecount.setFont(new java.awt.Font("Glass Antiqua", 1, 50)); // NOI18N
        txt_employeecount.setForeground(new java.awt.Color(102, 102, 102));
        txt_employeecount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        txt_employeecount.setText("81");
        jPanel14.add(txt_employeecount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        home_page.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 220, 130));

        jLabel20.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Pending Oders");
        home_page.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, -1, 20));

        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(51, 102, 255)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_porderscount.setFont(new java.awt.Font("Glass Antiqua", 1, 50)); // NOI18N
        txt_porderscount.setForeground(new java.awt.Color(102, 102, 102));
        txt_porderscount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        txt_porderscount.setText("2");
        jPanel15.add(txt_porderscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        home_page.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 220, 130));

        jLabel22.setFont(new java.awt.Font("Glass Antiqua", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("No of Suppliers");
        home_page.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel23.setFont(new java.awt.Font("Glass Antiqua", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Retailer Details");
        home_page.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        pnl_pichart.setLayout(new java.awt.BorderLayout());
        home_page.add(pnl_pichart, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 420, 400));

        jSqlTablel11.setLIMIT(25);
        jSqlTablel11.setSQLQuery("SELECT supplier_id, name, address, rating FROM Supplier");
        jScrollPane1.setViewportView(jSqlTablel11);

        home_page.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 670, 170));

        jSqlTablel12.setLIMIT(25);
        jSqlTablel12.setSQLQuery("SELECT retailer_id, name, address, phone FROM Retailer");
        jScrollPane3.setViewportView(jSqlTablel12);

        home_page.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 690, 170));

        main_view.addTab("tab1", home_page);
        main_view.addTab("tab8", suppliers);
        main_view.addTab("tab3", retailers);
        main_view.addTab("tab4", oders);
        main_view.addTab("tab5", products);
        main_view.addTab("tab6", employees);
        main_view.addTab("tab7", custom_query);

        getContentPane().add(main_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 1200, 780));

        setSize(new java.awt.Dimension(1500, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        new LoginPage().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jPanel11MouseClicked

    private void sbp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp1MouseClicked
        // TODO add your handling code here:
        switchpage(1);
        update_dashboard_data();
    }//GEN-LAST:event_sbp1MouseClicked

    private void sbp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp2MouseClicked
        // TODO add your handling code here:
        switchpage(2);
    }//GEN-LAST:event_sbp2MouseClicked

    private void sbp3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp3MouseClicked
        // TODO add your handling code here:
        switchpage(3);
    }//GEN-LAST:event_sbp3MouseClicked

    private void sbp4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp4MouseClicked
        // TODO add your handling code here:
        switchpage(4);
    }//GEN-LAST:event_sbp4MouseClicked

    private void sbp5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp5MouseClicked
        // TODO add your handling code here:
        switchpage(5);
    }//GEN-LAST:event_sbp5MouseClicked

    private void sbp6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp6MouseClicked
        // TODO add your handling code here:
        switchpage(6);
    }//GEN-LAST:event_sbp6MouseClicked

    private void sbp7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp7MouseClicked
        // TODO add your handling code here:
        switchpage(7);
    }//GEN-LAST:event_sbp7MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        new FAQ().setVisible(true);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        new AboutUs().setVisible(true);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        new ContactUS().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void main_viewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_main_viewFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_main_viewFocusGained

    private void sb_mousehover(int idx, boolean stat) {
        if (sbcurActive == idx) return;
        if (stat) sbpanels.get(idx).setBackground(Cl.fgs);
        else sbpanels.get(idx).setBackground(Cl.bgs);
    }
    private void sbp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp2MouseEntered
        // TODO add your handling code here:
        sb_mousehover(1, true);
    }//GEN-LAST:event_sbp2MouseEntered

    private void sbp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp2MouseExited
        // TODO add your handling code here:
        sb_mousehover(1, false);
    }//GEN-LAST:event_sbp2MouseExited

    private void sbp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp1MouseEntered
        // TODO add your handling code here:
        sb_mousehover(0, true);
    }//GEN-LAST:event_sbp1MouseEntered

    private void sbp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp1MouseExited
        // TODO add your handling code here:
        sb_mousehover(0, false);
    }//GEN-LAST:event_sbp1MouseExited

    private void sbp3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp3MouseEntered
        // TODO add your handling code here:
        sb_mousehover(2, true);
    }//GEN-LAST:event_sbp3MouseEntered

    private void sbp3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp3MouseExited
        // TODO add your handling code here:
        sb_mousehover(2, false);
    }//GEN-LAST:event_sbp3MouseExited

    private void sbp4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp4MouseEntered
        // TODO add your handling code here:
        sb_mousehover(3, true);
    }//GEN-LAST:event_sbp4MouseEntered

    private void sbp4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp4MouseExited
        // TODO add your handling code here:
        sb_mousehover(3, false);
    }//GEN-LAST:event_sbp4MouseExited

    private void sbp5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp5MouseEntered
        // TODO add your handling code here:
        sb_mousehover(4, true);
    }//GEN-LAST:event_sbp5MouseEntered

    private void sbp5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp5MouseExited
        // TODO add your handling code here:
        sb_mousehover(4, false);
    }//GEN-LAST:event_sbp5MouseExited

    private void sbp6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp6MouseEntered
        // TODO add your handling code here:
        sb_mousehover(5, true);
    }//GEN-LAST:event_sbp6MouseEntered

    private void sbp6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp6MouseExited
        // TODO add your handling code here:
        sb_mousehover(5, false);
    }//GEN-LAST:event_sbp6MouseExited

    private void sbp7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp7MouseEntered
        // TODO add your handling code here:
        sb_mousehover(6, true);
    }//GEN-LAST:event_sbp7MouseEntered

    private void sbp7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbp7MouseExited
        // TODO add your handling code here:
        sb_mousehover(6, false);
    }//GEN-LAST:event_sbp7MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public SypplierSynergy.CustomQuery custom_query;
    public SypplierSynergy.Employees employees;
    public javax.swing.JPanel home_page;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private lib.JSqlTablel1 jSqlTablel11;
    private lib.JSqlTablel1 jSqlTablel12;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JTabbedPane main_view;
    public SypplierSynergy.Orders oders;
    private javax.swing.JPanel pnl_pichart;
    public SypplierSynergy.Products products;
    private rojerusan.RSLabelImage rSLabelImage1;
    public SypplierSynergy.Retailers retailers;
    private javax.swing.JLabel sbl1;
    private javax.swing.JLabel sbl2;
    private javax.swing.JLabel sbl3;
    private javax.swing.JLabel sbl4;
    private javax.swing.JLabel sbl5;
    private javax.swing.JLabel sbl6;
    private javax.swing.JLabel sbl7;
    private javax.swing.JPanel sbp1;
    private javax.swing.JPanel sbp2;
    private javax.swing.JPanel sbp3;
    private javax.swing.JPanel sbp4;
    private javax.swing.JPanel sbp5;
    private javax.swing.JPanel sbp6;
    private javax.swing.JPanel sbp7;
    private javax.swing.JPanel sidebar;
    public SypplierSynergy.Suppliers suppliers;
    private javax.swing.JLabel txt_employeecount;
    private javax.swing.JLabel txt_porderscount;
    private javax.swing.JLabel txt_ratailercount;
    private javax.swing.JLabel txt_supplier;
    // End of variables declaration//GEN-END:variables
}
