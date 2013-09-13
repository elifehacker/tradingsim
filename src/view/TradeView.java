package view;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import order.Order;

import derivative.Derivative;
import derivative.Stock;

import simulation.model.Portfolio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pei Wang
 */
public class TradeView extends javax.swing.JFrame {

    /**
     * Creates new form TradePanel
     */
    public TradeView(Portfolio p) {
    	portfolio = p;
        initComponents();
        addlisteners();
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
        security_lab = new javax.swing.JLabel();
        security_combo = new javax.swing.JComboBox();
        but_select = new javax.swing.JButton();
        mid_pane = new javax.swing.JPanel();
        stock_pane = new javax.swing.JPanel();
        option_pane = new javax.swing.JPanel();
        option_type_lab = new javax.swing.JLabel();
        option_type_combo = new javax.swing.JComboBox();
        x_price_lab = new javax.swing.JLabel();
        x_price_tf = new javax.swing.JTextField();
        x_date_lab = new javax.swing.JLabel();
        x_date_tf = new javax.swing.JTextField();
        bottom_pane = new javax.swing.JPanel();
        blank_pane = new javax.swing.JPanel();
        market_pane = new javax.swing.JPanel();
        market_lab = new javax.swing.JLabel();
        market_tf = new javax.swing.JTextField();
        stop_pane = new javax.swing.JPanel();
        stop_lab = new javax.swing.JLabel();
        stop_tf = new javax.swing.JTextField();
        limit_pane = new javax.swing.JPanel();
        limit_lab = new javax.swing.JLabel();
        limit_tf = new javax.swing.JTextField();
        stop_limit_pane = new javax.swing.JPanel();
        comb_limit_lab = new javax.swing.JLabel();
        comb_limit_tf = new javax.swing.JTextField();
        comb_stop_lab = new javax.swing.JLabel();
        comb_stop_tf = new javax.swing.JTextField();
        action_combo = new javax.swing.JComboBox();
        action_lab = new javax.swing.JLabel();
        symbol_lab = new javax.swing.JLabel();
        symbol_combo = new javax.swing.JComboBox();
        order_type_lab = new javax.swing.JLabel();
        order_type_combo = new javax.swing.JComboBox();
        volume_lab = new javax.swing.JLabel();
        volume_tf = new javax.swing.JTextField();
        total_lab = new javax.swing.JLabel();
        total_tf = new javax.swing.JTextField();
        but_calculate = new javax.swing.JButton();
        but_make_order = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        cash_num_lab.setBounds(350, 20, 140, 30);
        jLayeredPane.add(cash_num_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cash_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cash_lab.setText("Cash:");
        cash_lab.setBounds(290, 20, 50, 30);
        jLayeredPane.add(cash_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        security_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        security_lab.setText("Security");
        security_lab.setBounds(10, 70, 100, 30);
        jLayeredPane.add(security_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        security_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Stock", "Option" }));
        security_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                security_comboActionPerformed(evt);
            }
        });
        security_combo.setBounds(110, 70, 160, 30);
        jLayeredPane.add(security_combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        but_select.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_select.setText("Select");
        but_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_selectActionPerformed(evt);
            }
        });
        but_select.setBounds(290, 110, 160, 34);
        jLayeredPane.add(but_select, javax.swing.JLayeredPane.DEFAULT_LAYER);

        mid_pane.setBackground(new java.awt.Color(255, 255, 255));
        mid_pane.setLayout(new java.awt.CardLayout());

        stock_pane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout stock_paneLayout = new javax.swing.GroupLayout(stock_pane);
        stock_pane.setLayout(stock_paneLayout);
        stock_paneLayout.setHorizontalGroup(
            stock_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        stock_paneLayout.setVerticalGroup(
            stock_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        mid_pane.add(stock_pane, "stock_pane");

        option_pane.setBackground(new java.awt.Color(255, 255, 255));

        option_type_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        option_type_lab.setText("Option");

        option_type_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Call", "Put" }));

        x_price_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        x_price_lab.setText("X Price");

        x_date_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        x_date_lab.setText("X Date");

        javax.swing.GroupLayout option_paneLayout = new javax.swing.GroupLayout(option_pane);
        option_pane.setLayout(option_paneLayout);
        option_paneLayout.setHorizontalGroup(
            option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option_paneLayout.createSequentialGroup()
                .addGroup(option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(option_type_lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(x_price_lab, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(x_price_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(option_type_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(x_date_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(x_date_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        option_paneLayout.setVerticalGroup(
            option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option_paneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option_type_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x_price_lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(x_price_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x_date_lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(x_date_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147))
        );

        mid_pane.add(option_pane, "Option");

        mid_pane.setBounds(10, 190, 570, 90);
        jLayeredPane.add(mid_pane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bottom_pane.setBackground(new java.awt.Color(255, 255, 255));
        bottom_pane.setLayout(new java.awt.CardLayout());

        blank_pane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout blank_paneLayout = new javax.swing.GroupLayout(blank_pane);
        blank_pane.setLayout(blank_paneLayout);
        blank_paneLayout.setHorizontalGroup(
            blank_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        blank_paneLayout.setVerticalGroup(
            blank_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        bottom_pane.add(blank_pane, "blank_pane");

        market_pane.setBackground(new java.awt.Color(255, 255, 255));

        market_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        market_lab.setText("Market Order Price");

        market_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                market_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout market_paneLayout = new javax.swing.GroupLayout(market_pane);
        market_pane.setLayout(market_paneLayout);
        market_paneLayout.setHorizontalGroup(
            market_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(market_paneLayout.createSequentialGroup()
                .addGroup(market_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(market_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(market_paneLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(market_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        market_paneLayout.setVerticalGroup(
            market_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(market_paneLayout.createSequentialGroup()
                .addComponent(market_lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(market_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bottom_pane.add(market_pane, "Market Order");

        stop_pane.setBackground(new java.awt.Color(255, 255, 255));

        stop_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        stop_lab.setText("Stop Order Price");

        stop_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stop_paneLayout = new javax.swing.GroupLayout(stop_pane);
        stop_pane.setLayout(stop_paneLayout);
        stop_paneLayout.setHorizontalGroup(
            stop_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stop_paneLayout.createSequentialGroup()
                .addGroup(stop_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stop_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(stop_paneLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(stop_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        stop_paneLayout.setVerticalGroup(
            stop_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stop_paneLayout.createSequentialGroup()
                .addComponent(stop_lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(stop_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bottom_pane.add(stop_pane, "Stop Order");

        limit_pane.setBackground(new java.awt.Color(255, 255, 255));

        limit_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        limit_lab.setText("Limit Order Price");

        limit_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limit_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout limit_paneLayout = new javax.swing.GroupLayout(limit_pane);
        limit_pane.setLayout(limit_paneLayout);
        limit_paneLayout.setHorizontalGroup(
            limit_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(limit_paneLayout.createSequentialGroup()
                .addGroup(limit_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limit_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(limit_paneLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(limit_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        limit_paneLayout.setVerticalGroup(
            limit_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(limit_paneLayout.createSequentialGroup()
                .addComponent(limit_lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(limit_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bottom_pane.add(limit_pane, "Limit Order");

        stop_limit_pane.setBackground(new java.awt.Color(255, 255, 255));

        comb_limit_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        comb_limit_lab.setText("Limit Order Price");

        comb_limit_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comb_limit_tfActionPerformed(evt);
            }
        });

        comb_stop_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        comb_stop_lab.setText("Stop Order Price");

        comb_stop_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comb_stop_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stop_limit_paneLayout = new javax.swing.GroupLayout(stop_limit_pane);
        stop_limit_pane.setLayout(stop_limit_paneLayout);
        stop_limit_paneLayout.setHorizontalGroup(
            stop_limit_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stop_limit_paneLayout.createSequentialGroup()
                .addGroup(stop_limit_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stop_limit_paneLayout.createSequentialGroup()
                        .addContainerGap(101, Short.MAX_VALUE)
                        .addComponent(comb_stop_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(stop_limit_paneLayout.createSequentialGroup()
                        .addComponent(comb_stop_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(stop_limit_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stop_limit_paneLayout.createSequentialGroup()
                        .addComponent(comb_limit_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stop_limit_paneLayout.createSequentialGroup()
                        .addComponent(comb_limit_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        stop_limit_paneLayout.setVerticalGroup(
            stop_limit_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stop_limit_paneLayout.createSequentialGroup()
                .addGroup(stop_limit_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comb_stop_lab)
                    .addComponent(comb_limit_lab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stop_limit_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comb_stop_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb_limit_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        bottom_pane.add(stop_limit_pane, "Stop Limit");

        bottom_pane.setBounds(10, 280, 560, 60);
        jLayeredPane.add(bottom_pane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        action_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Long","Short" }));
        action_combo.setMinimumSize(new java.awt.Dimension(51, 30));
        action_combo.setBounds(400, 150, 161, 30);
        jLayeredPane.add(action_combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        action_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        action_lab.setText("Action");
        action_lab.setBounds(290, 150, 90, 30);
        jLayeredPane.add(action_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        symbol_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        symbol_lab.setText("Symbol");
        symbol_lab.setBounds(10, 150, 90, 30);
        jLayeredPane.add(symbol_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        symbol_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        symbol_combo.setMinimumSize(new java.awt.Dimension(51, 30));
        symbol_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbol_comboActionPerformed(evt);
            }
        });
        symbol_combo.setBounds(110, 150, 161, 30);
        jLayeredPane.add(symbol_combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        order_type_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        order_type_lab.setText("Order Type");
        order_type_lab.setBounds(290, 70, 112, 30);
        jLayeredPane.add(order_type_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        order_type_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Market Order", "Stop Order", "Limit Order", "Stop Limit" }));
        order_type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_type_comboActionPerformed(evt);
            }
        });
        order_type_combo.setBounds(400, 70, 159, 30);
        jLayeredPane.add(order_type_combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        volume_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        volume_lab.setText("Volume");
        volume_lab.setBounds(10, 350, 90, 30);
        jLayeredPane.add(volume_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);
        volume_tf.setBounds(110, 350, 159, 29);
        jLayeredPane.add(volume_tf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        total_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        total_lab.setText("Total");
        total_lab.setBounds(290, 350, 90, 30);
        jLayeredPane.add(total_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);
        total_tf.setBounds(400, 350, 160, 29);
        jLayeredPane.add(total_tf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        but_calculate.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_calculate.setText("Calculate");
        but_calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_calculateActionPerformed(evt);
            }
        });
        but_calculate.setBounds(110, 390, 159, 34);
        jLayeredPane.add(but_calculate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        but_make_order.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_make_order.setText("Make Order");
        but_make_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_make_orderActionPerformed(evt);
            }
        });
        but_make_order.setBounds(290, 390, 160, 34);
        jLayeredPane.add(but_make_order, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout background_paneLayout = new javax.swing.GroupLayout(background_pane);
        background_pane.setLayout(background_paneLayout);
        background_paneLayout.setHorizontalGroup(
            background_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_paneLayout.createSequentialGroup()
                .addComponent(jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        background_paneLayout.setVerticalGroup(
            background_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_paneLayout.createSequentialGroup()
                .addComponent(jLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(background_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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

    
    class reselectListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
	        CardLayout cl = (CardLayout)(mid_pane.getLayout());
			cl.show(mid_pane, "stock_pane");
			cl = (CardLayout)(bottom_pane.getLayout());
			cl.show(bottom_pane, "blank_pane");
			selected = false;
		}
    	
    }
    
    private void addlisteners(){
    	reselectListener rl = new reselectListener();
    	security_combo.addActionListener(rl);
    	order_type_combo.addActionListener(rl);

    }
    
    private void security_comboActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void but_selectActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)(mid_pane.getLayout());
		cl.show(mid_pane, (String)security_combo.getSelectedItem());
		cl = (CardLayout)(bottom_pane.getLayout());
		cl.show(bottom_pane, (String)order_type_combo.getSelectedItem());
		selected = true;
    }                                          

    private void but_calculateActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }             
    private void order_type_comboActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                        
    

    private void but_make_orderActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    	if(selected){
    		int n = JOptionPane.showConfirmDialog(
    			    this,
    			    "Are you sure to make this order?",
    			    "Confirmation",
    			    JOptionPane.YES_NO_OPTION);
    		System.out.println("Confirmation is "+n); // yes == 0 , no == 1
    		if(n == 0){
    			
    			String symbol = (String)symbol_combo.getSelectedItem();     			
    			Order order;    			
    			String otype = (String)order_type_combo.getSelectedItem();
    			String dtype = (String)security_combo.getSelectedItem();
    			
    			if(otype.equals("Market Order")){
    				
    			}else if(otype.equals("Limit Order")){
    				
    			}else if(otype.equals("Stop Order")){
    				
    			}else if(otype.equals("Stop Limit")){
    				
    			}    			
    			
    		}
    		
    	}else{
			JOptionPane.showMessageDialog(null,
				    "Click \"Select\" buttone to lock in order");
    	}
    }                                              


    private void symbol_comboActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void market_tfActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void stop_tfActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void limit_tfActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void comb_limit_tfActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void comb_stop_tfActionPerformed(java.awt.event.ActionEvent evt) {                                             
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

                new TradeView(new Portfolio(10000)).setVisible(true);
            }
        });
    }
    
    private boolean selected = false;
    private Portfolio portfolio;
    // Variables declaration - do not modify                     
    private javax.swing.JComboBox action_combo;
    private javax.swing.JLabel action_lab;
    private javax.swing.JPanel background_pane;
    private javax.swing.JPanel blank_pane;
    private javax.swing.JPanel bottom_pane;
    private javax.swing.JButton but_calculate;
    private javax.swing.JButton but_make_order;
    private javax.swing.JButton but_select;
    private javax.swing.JLabel cash_lab;
    private javax.swing.JLabel cash_num_lab;
    private javax.swing.JLabel comb_limit_lab;
    private javax.swing.JTextField comb_limit_tf;
    private javax.swing.JLabel comb_stop_lab;
    private javax.swing.JTextField comb_stop_tf;
    private javax.swing.JLayeredPane jLayeredPane;
    private javax.swing.JLabel limit_lab;
    private javax.swing.JPanel limit_pane;
    private javax.swing.JTextField limit_tf;
    private javax.swing.JLabel market_lab;
    private javax.swing.JPanel market_pane;
    private javax.swing.JTextField market_tf;
    private javax.swing.JPanel mid_pane;
    private javax.swing.JPanel option_pane;
    private javax.swing.JComboBox option_type_combo;
    private javax.swing.JLabel option_type_lab;
    private javax.swing.JComboBox order_type_combo;
    private javax.swing.JLabel order_type_lab;
    private javax.swing.JComboBox security_combo;
    private javax.swing.JLabel security_lab;
    private javax.swing.JPanel stock_pane;
    private javax.swing.JLabel stop_lab;
    private javax.swing.JPanel stop_limit_pane;
    private javax.swing.JPanel stop_pane;
    private javax.swing.JTextField stop_tf;
    private javax.swing.JComboBox symbol_combo;
    private javax.swing.JLabel symbol_lab;
    private javax.swing.JLabel total_lab;
    private javax.swing.JTextField total_tf;
    private javax.swing.JLabel trade_back_lab;
    private javax.swing.JLabel trade_lab;
    private javax.swing.JLabel volume_lab;
    private javax.swing.JTextField volume_tf;
    private javax.swing.JLabel x_date_lab;
    private javax.swing.JTextField x_date_tf;
    private javax.swing.JLabel x_price_lab;
    private javax.swing.JTextField x_price_tf;
    // End of variables declaration                   
}
