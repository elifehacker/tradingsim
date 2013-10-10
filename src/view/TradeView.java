package view;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Portfolio;

import order.Order;

import derivative.Derivative;
import derivative.Stock;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pei Wang
 */
public class TradeView extends javax.swing.JFrame {

    public void updateCredit(){
        cash_num_lab.setText(""+portfolio.getCredit());    	
    }
    
    public Portfolio getPortfolio(){
    	return portfolio;
    }
    
    
	public String getSelectedSymbol(){
		return (String) symbol_combo.getSelectedItem();
	}
    
    /**
     * Creates new form TradePanel
     */
    public TradeView(Portfolio p, String[] f, String selected) {
        initComponents();
        portfolio = p;
        firms = f;
        symbol_combo.setModel(new javax.swing.DefaultComboBoxModel(f));
        cash_num_lab.setText(""+portfolio.getCredit());
        symbol_combo.setSelectedItem(selected);
        updateCredit();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        background_pane = new javax.swing.JPanel();
        jLayeredPane = new javax.swing.JLayeredPane();
        trade_lab = new javax.swing.JLabel();
        trade_back_lab = new javax.swing.JLabel();
        cash_num_lab = new javax.swing.JLabel();
        cash_lab = new javax.swing.JLabel();
        order_scroll = new javax.swing.JScrollPane();
        order_pane = new javax.swing.JPanel();
        symbol_lab = new javax.swing.JLabel();
        symbol_combo = new javax.swing.JComboBox();
        but_select = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        background_pane.setBackground(new java.awt.Color(255, 255, 255));

        trade_lab.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        trade_lab.setText("Trade");
        trade_lab.setBounds(10, 0, 110, 40);
        jLayeredPane.add(trade_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        trade_back_lab.setFont(new java.awt.Font("Consolas", 1, 60)); // NOI18N
        trade_back_lab.setForeground(new java.awt.Color(204, 204, 204));
        trade_back_lab.setText("Trade");
        trade_back_lab.setBounds(10, 0, 200, 60);
        jLayeredPane.add(trade_back_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cash_num_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cash_num_lab.setText("jLabel1");
        cash_num_lab.setBounds(440, 10, 160, 30);
        jLayeredPane.add(cash_num_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cash_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cash_lab.setText("Cash:");
        cash_lab.setBounds(380, 10, 50, 30);
        jLayeredPane.add(cash_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        order_pane.setBackground(new java.awt.Color(255, 255, 255));
        order_pane.setMaximumSize(new java.awt.Dimension(3277, 3277));
        order_pane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        order_scroll.setViewportView(order_pane);

        order_scroll.setBounds(10, 90, 590, 360);
        jLayeredPane.add(order_scroll, javax.swing.JLayeredPane.DEFAULT_LAYER);

        symbol_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        symbol_lab.setText("Symbol");
        symbol_lab.setBounds(10, 50, 90, 30);
        jLayeredPane.add(symbol_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        symbol_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        symbol_combo.setMinimumSize(new java.awt.Dimension(51, 30));
        symbol_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbol_comboActionPerformed(evt);
            }
        });
        symbol_combo.setBounds(110, 50, 161, 30);
        jLayeredPane.add(symbol_combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        but_select.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_select.setText("Select");
        but_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_selectActionPerformed(evt);
            }
        });
        but_select.setBounds(380, 50, 159, 34);
        jLayeredPane.add(but_select, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout background_paneLayout = new javax.swing.GroupLayout(background_pane);
        background_pane.setLayout(background_paneLayout);
        background_paneLayout.setHorizontalGroup(
            background_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_paneLayout.createSequentialGroup()
                .addComponent(jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        background_paneLayout.setVerticalGroup(
            background_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_paneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(background_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(background_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    
    private void but_selectActionPerformed(java.awt.event.ActionEvent evt) {
		order_pane.add(new TradePanel(portfolio,getSelectedSymbol() , ""), FlowLayout.LEFT);

    }
    private void symbol_comboActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    	resetview();
    } 
    
	private void resetview(){
		order_pane.removeAll();
		order_pane.revalidate();
		order_pane.repaint();
        //order_pane.add(new TradePanel(), FlowLayout.LEFT);
	}
    
    private String[] firms;
    private Portfolio portfolio;
    private javax.swing.JPanel background_pane;
    private javax.swing.JButton but_select;
    private javax.swing.JLabel cash_lab;
    private javax.swing.JLabel cash_num_lab;
    private javax.swing.JLayeredPane jLayeredPane;
    private javax.swing.JPanel order_pane;
    private javax.swing.JScrollPane order_scroll;
    private javax.swing.JComboBox symbol_combo;
    private javax.swing.JLabel symbol_lab;
    private javax.swing.JLabel trade_back_lab;
    private javax.swing.JLabel trade_lab;                 
}
