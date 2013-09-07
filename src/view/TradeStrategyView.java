package view;

import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pei Wang
 */
public class TradeStrategyView extends javax.swing.JFrame {

	
	private void clearlabs(){
		payoff_lab1.setIcon(null);
		payoff_lab3.setIcon(null);
		payoff_lab5.setIcon(null);
		payoff_lab7.setIcon(null);
		
		payoff_lab2.setText("");
		payoff_lab4.setText("");
		payoff_lab6.setText("");

	}
	
	private void setpayoff(String payoff, int index){
		javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/payoffs/"+payoff+".png"));
		switch(index){
		case 1: payoff_lab1.setIcon(icon); 
				break;
		case 3: payoff_lab3.setIcon(icon); 
				break;
		case 5: payoff_lab5.setIcon(icon); 
				break;
		case 7: payoff_lab7.setIcon(icon); 
				break;		
		}		
	}
	
	private void setsymbol(String symbol, int index){
		switch(index){
		case 2:	payoff_lab2.setText(symbol);
				break;
		case 4:	payoff_lab4.setText(symbol);
				break;		
		case 6:	payoff_lab6.setText(symbol);
				break;
		}		
	}
	
	private void setsymbol(int numberofplus){
		if(numberofplus >= 1){
			payoff_lab2.setText("+");
			payoff_lab4.setText("=");
		}
		if(numberofplus >= 2){
			payoff_lab4.setText("+");
			payoff_lab6.setText("=");
		}		
	}

	
	private void addpane(int num){
		while(num!=0){
			order_pane.add(new TradePanel(), FlowLayout.LEFT);
			num--;
		}
	}
	
	private void resetview(){
        clearlabs();
		order_pane.removeAll();		
        //order_pane.add(new TradePanel(), FlowLayout.LEFT);
	}
	
    /**
     * Creates new form TradePanel
     */
    public TradeStrategyView() {
        initComponents();
        
        strategy_combo.setModel(new javax.swing.DefaultComboBoxModel(strategies));
        
        resetview();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        background_pane = new javax.swing.JPanel();
        jLayeredPane = new javax.swing.JLayeredPane();
        strategy_lab = new javax.swing.JLabel();
        strategy_combo = new javax.swing.JComboBox();
        but_explain = new javax.swing.JButton();
        but_select = new javax.swing.JButton();
        cash_num_lab = new javax.swing.JLabel();
        cash_lab = new javax.swing.JLabel();
        payoff_scroll = new javax.swing.JScrollPane();
        payoff_pane = new javax.swing.JPanel();
        payoff_lab1 = new javax.swing.JLabel();
        payoff_lab2 = new javax.swing.JLabel();
        payoff_lab3 = new javax.swing.JLabel();
        payoff_lab4 = new javax.swing.JLabel();
        payoff_lab5 = new javax.swing.JLabel();
        payoff_lab6 = new javax.swing.JLabel();
        payoff_lab7 = new javax.swing.JLabel();
        symbol_combo = new javax.swing.JComboBox();
        symbol_lab = new javax.swing.JLabel();
        order_scroll = new javax.swing.JScrollPane();
        order_pane = new javax.swing.JPanel();
        trade_lab = new javax.swing.JLabel();
        trade_back_lab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(4147, 4147));

        background_pane.setBackground(new java.awt.Color(255, 255, 255));
        background_pane.setMaximumSize(new java.awt.Dimension(3377, 3377));

        jLayeredPane.setMaximumSize(new java.awt.Dimension(3277, 3277));

        strategy_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        strategy_lab.setText("Strategy");
        strategy_lab.setBounds(20, 40, 100, 30);
        jLayeredPane.add(strategy_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        strategy_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Market Order", "Stop Order", "Limit Order", "Stop Limit" }));
        strategy_combo.setBounds(120, 40, 159, 30);
        jLayeredPane.add(strategy_combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        but_explain.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_explain.setText("Explain");
        but_explain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_explainActionPerformed(evt);
            }
        });
        but_explain.setBounds(500, 40, 160, 34);
        jLayeredPane.add(but_explain, javax.swing.JLayeredPane.DEFAULT_LAYER);

        but_select.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_select.setText("Select");
        but_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_selectActionPerformed(evt);
            }
        });
        but_select.setBounds(320, 40, 159, 34);
        jLayeredPane.add(but_select, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cash_num_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cash_num_lab.setText("jLabel1");
        cash_num_lab.setBounds(1010, 40, 140, 30);
        jLayeredPane.add(cash_num_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cash_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cash_lab.setText("Cash:");
        cash_lab.setBounds(950, 40, 50, 30);
        jLayeredPane.add(cash_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        payoff_pane.setBackground(new java.awt.Color(255, 255, 255));
        payoff_pane.setMaximumSize(new java.awt.Dimension(3277, 3277));

        payoff_lab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payoffs/collar.png"))); // NOI18N

        payoff_lab2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        payoff_lab2.setText("+");

        payoff_lab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payoffs/collar.png"))); // NOI1

        payoff_lab4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        payoff_lab4.setText("+");

        payoff_lab5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payoffs/collar.png"))); // NOI1

        payoff_lab6.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        payoff_lab6.setText("=");

        payoff_lab7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payoffs/collar.png"))); // NOI1

        javax.swing.GroupLayout payoff_paneLayout = new javax.swing.GroupLayout(payoff_pane);
        payoff_pane.setLayout(payoff_paneLayout);
        payoff_paneLayout.setHorizontalGroup(
            payoff_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payoff_paneLayout.createSequentialGroup()
                .addComponent(payoff_lab1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payoff_lab2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payoff_lab3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payoff_lab4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payoff_lab5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payoff_lab6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payoff_lab7)
                .addGap(0, 980, Short.MAX_VALUE))
        );
        payoff_paneLayout.setVerticalGroup(
            payoff_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payoff_paneLayout.createSequentialGroup()
                .addComponent(payoff_lab1)
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(payoff_paneLayout.createSequentialGroup()
                .addGroup(payoff_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payoff_lab3)
                    .addComponent(payoff_lab5)
                    .addComponent(payoff_lab7)
                    .addGroup(payoff_paneLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(payoff_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(payoff_lab2)
                            .addComponent(payoff_lab4)
                            .addComponent(payoff_lab6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        payoff_scroll.setViewportView(payoff_pane);

        payoff_scroll.setBounds(20, 80, 1200, 210);
        jLayeredPane.add(payoff_scroll, javax.swing.JLayeredPane.DEFAULT_LAYER);

        symbol_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        symbol_combo.setMinimumSize(new java.awt.Dimension(51, 30));
        symbol_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbol_comboActionPerformed(evt);
            }
        });
        symbol_combo.setBounds(120, 300, 161, 30);
        jLayeredPane.add(symbol_combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        symbol_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        symbol_lab.setText("Symbol");
        symbol_lab.setBounds(20, 300, 90, 30);
        jLayeredPane.add(symbol_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        order_pane.setBackground(new java.awt.Color(255, 255, 255));
        order_pane.setMaximumSize(new java.awt.Dimension(3277, 3277));
        order_pane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        order_pane.add(new TradePanel(), FlowLayout.LEFT);
        order_pane.add(new TradePanel(), FlowLayout.LEFT);

        order_scroll.setViewportView(order_pane);

        order_scroll.setBounds(20, 340, 1200, 350);
        jLayeredPane.add(order_scroll, javax.swing.JLayeredPane.DEFAULT_LAYER);

        trade_lab.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        trade_lab.setText("Trade Strategy");
        trade_lab.setBounds(10, 0, 300, 40);
        jLayeredPane.add(trade_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        trade_back_lab.setFont(new java.awt.Font("Consolas", 1, 55)); // NOI18N
        trade_back_lab.setForeground(new java.awt.Color(224, 224, 224));
        trade_back_lab.setText("Trade Strategy");
        trade_back_lab.setBounds(10, 10, 520, 60);
        jLayeredPane.add(trade_back_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout background_paneLayout = new javax.swing.GroupLayout(background_pane);
        background_pane.setLayout(background_paneLayout);
        background_paneLayout.setHorizontalGroup(
            background_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_paneLayout.createSequentialGroup()
                .addComponent(jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        background_paneLayout.setVerticalGroup(
            background_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_paneLayout.createSequentialGroup()
                .addComponent(jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void but_explainActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void but_selectActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    	int index = strategy_combo.getSelectedIndex();
    	String strategy = (String) strategy_combo.getSelectedItem();
    	
    	resetview();
    	if(index>=0 && index < 5 ){
    		if(strategy.equals("Stock")) setpayoff("stock", 1);
    		if(strategy.equals("Long Call")) setpayoff("longcall", 1);
    		if(strategy.equals("Long Put")) setpayoff("longput", 1);
    		if(strategy.equals("Short Call")) setpayoff("shortcall", 1);    		
    		if(strategy.equals("Short Put")) setpayoff("shortput", 1);
    		addpane(1);
    	}else if(index >=5){
    		if(strategy.equals("Collar")){
    			setpayoff("longput", 1);
    			setpayoff("stock", 3);
    			setpayoff("shortcall", 5);
    			setpayoff("collar", 7);    			
    			setsymbol(2);
    			addpane(3);
    			
    		}else if(strategy.equals("Covered Call")){
    			setpayoff("stock", 1);
    			setpayoff("shortcall",3);
    			setpayoff("covered",5);
    			setsymbol(1);
    			addpane(2);
    			
    		}else if(strategy.equals("Protective Put")){
    			setpayoff("longput", 1);
    			setpayoff("stock",3);
    			setpayoff("protective",5);
    			setsymbol(1);
    			addpane(2);
    		}else if(strategy.equals("Spread")){
    			setpayoff("longcall2", 1);
    			setpayoff("shortcall",3);
    			setpayoff("spread",5);
    			setsymbol(1);
    			addpane(2);
    		}else if(strategy.equals("Straddle")){
    			setpayoff("longput", 1);
    			setpayoff("longcall",3);
    			setpayoff("straddle",5);
    			setsymbol(1);
    			addpane(2);
    		}
    	}
    }                                          

    private void symbol_comboActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

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
            java.util.logging.Logger.getLogger(TradeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TradeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TradeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TradeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TradeStrategyView().setVisible(true);
            }
        });
    }
    
    private String[] strategies = {"Stock", "Long Call", "Long Put", "Short Call", "Short Put",
    		"Collar", "Covered Call", "Protective Put", "Spread", "Straddle"};
    // Variables declaration - do not modify                     
    private javax.swing.JPanel background_pane;
    private javax.swing.JButton but_explain;
    private javax.swing.JButton but_select;
    private javax.swing.JLabel cash_lab;
    private javax.swing.JLabel cash_num_lab;
    private javax.swing.JLayeredPane jLayeredPane;
    private javax.swing.JPanel order_pane;
    private javax.swing.JScrollPane order_scroll;
    private javax.swing.JLabel payoff_lab1;
    private javax.swing.JLabel payoff_lab2;
    private javax.swing.JLabel payoff_lab3;
    private javax.swing.JLabel payoff_lab4;
    private javax.swing.JLabel payoff_lab5;
    private javax.swing.JLabel payoff_lab6;
    private javax.swing.JLabel payoff_lab7;
    private javax.swing.JPanel payoff_pane;
    private javax.swing.JScrollPane payoff_scroll;
    private javax.swing.JComboBox strategy_combo;
    private javax.swing.JLabel strategy_lab;
    private javax.swing.JComboBox symbol_combo;
    private javax.swing.JLabel symbol_lab;
    private javax.swing.JLabel trade_back_lab;
    private javax.swing.JLabel trade_lab;
    // End of variables declaration                   
}
