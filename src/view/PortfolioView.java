package view;

import java.util.LinkedList;

import simulation.model.Derivative;
import simulation.model.Option;
import simulation.model.Order;
import simulation.model.Portfolio;
import simulation.model.Stock;

public class PortfolioView extends javax.swing.JFrame {

	private static boolean TestingMode = true;
    /**
     * Creates new form Portfolio
     */
    public PortfolioView(Portfolio p) {
        initComponents();
        portfolio = p;
        cash_lab_num.setText(""+p.getCredit());
        updateTable();
        
    }

    private void updateTable() {
		// TODO Auto-generated method stub
    	
    	setOrderTable();
    	setOnhandTable();
    	//setHistoryTable();

	}

	private void setOnhandTable() {
		// TODO Auto-generated method stub
		LinkedList<Derivative> list = portfolio.getOnhand();
		LinkedList<Stock> slist = new LinkedList<Stock>();
		LinkedList<Option> olist = new LinkedList<Option>();

		for(Derivative d : list){
			
			if(d instanceof Stock){
				slist.add((Stock) d);
			}else if(d instanceof Option){
				olist.add((Option) d);
			}
		}
		
		String[][] stocks = new String[slist.size()+1][stock_title.length]; 
		String[][] options = new String[olist.size()+1][option_title.length]; 

		// String stock_title[] = {"Symbol","Bought at","Volume", "Current Price", "Proft/Loss"};

		int i = 0;
		float total = 0;
		for(Stock s : slist){
			float cur_price;
			if(TestingMode) cur_price = (float)4.22;
			else  cur_price = SimulationView.get_price(s.getSymbol());
			stocks[i][0] =  ""+s.getId();
			stocks[i][1] =  s.getSymbol();
			stocks[i][2] =  ""+s.getPrice();
			stocks[i][3] =  ""+s.getVolume();
			stocks[i][4] =  ""+cur_price;
			float net = (cur_price-s.getPrice())*s.getVolume();
			if(net > 0)stocks[i][5] ="+"+net;
			else stocks[i][5] =""+net;
			total+=net;
			i++;
		}
		stocks[i][4] = "Total";
		stocks[i][5] = ""+total;
		stock_table.setModel(new javax.swing.table.DefaultTableModel(stocks,stock_title));
		
	    // String option_title[] = {"Symbol","Type","Bought at","Volume", "Strike price", "Current price", "Maturity", "Proft/Loss"};

		i = 0;
		total = 0;
		for(Option o : olist){
			float cur_price;
			if(TestingMode) cur_price = (float)4.22;
			else  cur_price = SimulationView.get_price(o.getSymbol());
			options[i][0] =  ""+o.getId();
			options[i][1] =  o.getSymbol();
			options[i][2] =  ""+o.getType();
			options[i][3] =  ""+o.getUnderlying().getPrice();
			options[i][4] =  ""+o.getVolume();
			options[i][5] =  ""+o.getStrike();
			options[i][6] =  ""+cur_price;
			options[i][7] =  ""+o.getMaturity();
			float net =0;
			if(o.getType().equals(Option.optiontype.call)) net= (cur_price-o.getStrike())*o.getVolume();
			else if(o.getType().equals(Option.optiontype.put))net= (o.getStrike()-cur_price)*o.getVolume();
			if(net > 0)options[i][8] ="+"+net;
			else options[i][8] =""+net;
			total+=net;
			i++;
		}
		options[i][7] = "Total";
		options[i][8] = ""+total;
		option_table.setModel(new javax.swing.table.DefaultTableModel(options,option_title));

	}

	private void setOrderTable() {
		// TODO Auto-generated method stub
		LinkedList<Order> list = portfolio.getOrder();

	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LayeredPane = new javax.swing.JLayeredPane();
        portfolio_front = new javax.swing.JLabel();
        Tabbs_pane = new javax.swing.JTabbedPane();
        Orders_pane = new javax.swing.JPanel();
        Order_scroll = new javax.swing.JScrollPane();
        orders_table = new javax.swing.JTable();
        but_neworder = new javax.swing.JButton();
        but_cancelorder = new javax.swing.JButton();
        Stock_pane = new javax.swing.JPanel();
        Stock_scroll = new javax.swing.JScrollPane();
        stock_table = new javax.swing.JTable();
        but_sell_stock = new javax.swing.JButton();
        Option_pane = new javax.swing.JPanel();
        Option_scroll = new javax.swing.JScrollPane();
        option_table = new javax.swing.JTable();
        but_sell_option = new javax.swing.JButton();
        Strategy_pane = new javax.swing.JPanel();
        Strategy_scroll = new javax.swing.JScrollPane();
        strategy_table = new javax.swing.JTable();
        but_sell_derivative = new javax.swing.JButton();
        but_neworder_1 = new javax.swing.JButton();
        but_cancelorder_1 = new javax.swing.JButton();
        History_pane = new javax.swing.JPanel();
        history_scroll = new javax.swing.JScrollPane();
        history_table = new javax.swing.JTable();
        portfolio_back = new javax.swing.JLabel();
        cash_lab = new javax.swing.JLabel();
        cash_lab_num = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        LayeredPane.setBackground(new java.awt.Color(255, 255, 255));

        portfolio_front.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        portfolio_front.setText("Portfolio");
        portfolio_front.setBounds(20, 10, 210, 40);
        LayeredPane.add(portfolio_front, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Orders_pane.setBackground(new java.awt.Color(255, 255, 255));

        orders_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Order_scroll.setViewportView(orders_table);

        but_neworder.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_neworder.setText("New Order");
        but_neworder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_neworderActionPerformed(evt);
            }
        });

        but_cancelorder.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_cancelorder.setText("Cancel Order");

        javax.swing.GroupLayout Orders_paneLayout = new javax.swing.GroupLayout(Orders_pane);
        Orders_pane.setLayout(Orders_paneLayout);
        Orders_paneLayout.setHorizontalGroup(
            Orders_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Order_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Orders_paneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(but_neworder, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_cancelorder, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        Orders_paneLayout.setVerticalGroup(
            Orders_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Orders_paneLayout.createSequentialGroup()
                .addComponent(Order_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Orders_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_cancelorder, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(but_neworder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Tabbs_pane.addTab("Orders", Orders_pane);

        Stock_pane.setBackground(new java.awt.Color(255, 255, 255));

        stock_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Stock_scroll.setViewportView(stock_table);

        but_sell_stock.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_sell_stock.setText("Sell Stock");

        javax.swing.GroupLayout Stock_paneLayout = new javax.swing.GroupLayout(Stock_pane);
        Stock_pane.setLayout(Stock_paneLayout);
        Stock_paneLayout.setHorizontalGroup(
            Stock_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Stock_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Stock_paneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(but_sell_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        Stock_paneLayout.setVerticalGroup(
            Stock_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stock_paneLayout.createSequentialGroup()
                .addComponent(Stock_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_sell_stock, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tabbs_pane.addTab("Onhand: Stock", Stock_pane);

        Option_pane.setBackground(new java.awt.Color(255, 255, 255));

        option_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Option_scroll.setViewportView(option_table);

        but_sell_option.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_sell_option.setText("Sell Option");

        javax.swing.GroupLayout Option_paneLayout = new javax.swing.GroupLayout(Option_pane);
        Option_pane.setLayout(Option_paneLayout);
        Option_paneLayout.setHorizontalGroup(
            Option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Option_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Option_paneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(but_sell_option, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        Option_paneLayout.setVerticalGroup(
            Option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Option_paneLayout.createSequentialGroup()
                .addComponent(Option_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_sell_option, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tabbs_pane.addTab("Onhand: Option", Option_pane);

        Strategy_pane.setBackground(new java.awt.Color(255, 255, 255));

        strategy_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Strategy_scroll.setViewportView(strategy_table);

        but_sell_derivative.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_sell_derivative.setText("Sell Derivative");

        but_neworder_1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_neworder_1.setText("New Order");
        but_neworder_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_neworder_1ActionPerformed(evt);
            }
        });

        but_cancelorder_1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_cancelorder_1.setText("Cancel Order");

        javax.swing.GroupLayout Strategy_paneLayout = new javax.swing.GroupLayout(Strategy_pane);
        Strategy_pane.setLayout(Strategy_paneLayout);
        Strategy_paneLayout.setHorizontalGroup(
            Strategy_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Strategy_scroll)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Strategy_paneLayout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(but_neworder_1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_cancelorder_1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_sell_derivative)
                .addGap(20, 20, 20))
        );
        Strategy_paneLayout.setVerticalGroup(
            Strategy_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Strategy_paneLayout.createSequentialGroup()
                .addComponent(Strategy_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Strategy_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_sell_derivative, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(but_cancelorder_1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(but_neworder_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Tabbs_pane.addTab("Strategy View", Strategy_pane);

        History_pane.setBackground(new java.awt.Color(255, 255, 255));

        history_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        history_scroll.setViewportView(history_table);

        javax.swing.GroupLayout History_paneLayout = new javax.swing.GroupLayout(History_pane);
        History_pane.setLayout(History_paneLayout);
        History_paneLayout.setHorizontalGroup(
            History_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(history_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        History_paneLayout.setVerticalGroup(
            History_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(History_paneLayout.createSequentialGroup()
                .addComponent(history_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        Tabbs_pane.addTab("Historical Action", History_pane);

        Tabbs_pane.setBounds(20, 50, 750, 400);
        LayeredPane.add(Tabbs_pane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        portfolio_back.setFont(new java.awt.Font("Consolas", 1, 60)); // NOI18N
        portfolio_back.setForeground(new java.awt.Color(204, 204, 204));
        portfolio_back.setText("Portfolio");
        portfolio_back.setBounds(10, 20, 340, 50);
        LayeredPane.add(portfolio_back, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cash_lab.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cash_lab.setText("Cash:");
        cash_lab.setBounds(570, 20, 50, 30);
        LayeredPane.add(cash_lab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cash_lab_num.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cash_lab_num.setText("jLabel1");
        cash_lab_num.setBounds(630, 20, 140, 30);
        LayeredPane.add(cash_lab_num, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LayeredPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LayeredPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void but_neworderActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void but_neworder_1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
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
            java.util.logging.Logger.getLogger(PortfolioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PortfolioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PortfolioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PortfolioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	if(TestingMode = true){
            		Portfolio p = new Portfolio (10000);
            		p.purchase(new Stock((float) 3.55, 20, "ABC"));
            		p.purchase(new Option((float) 1.50, 20, "ABC", new Stock((float) 3.55, 0, "ABC"), "11/12/2012",(float) 3.40, Option.optiontype.call));
            		p.purchase(new Option((float) 1.50, 20, "ABC", new Stock((float) 3.55, 0, "ABC"), "11/12/2012",(float) 5.40, Option.optiontype.call));

            		new PortfolioView(p).setVisible(true);
            	}else{
                    new PortfolioView(new Portfolio (10000)).setVisible(true);
            	}
            }
        });
    }
        
	private Portfolio portfolio;
	
    private String stock_title[] = {"ID","Symbol","Bought at","Volume", "Current Price", "Proft/Loss"};
    private String option_title[] = {"ID","Symbol","Type","Bought at","Volume", "Strike price", "Current price", "Maturity", "Proft/Loss"};

    private int selected_stock;
    private int selected_option;
    private int selected_order;
    
    // Variables declaration - do not modify                     
    private javax.swing.JPanel History_pane;
    private javax.swing.JLayeredPane LayeredPane;
    private javax.swing.JPanel Option_pane;
    private javax.swing.JScrollPane Option_scroll;
    private javax.swing.JScrollPane Order_scroll;
    private javax.swing.JPanel Orders_pane;
    private javax.swing.JPanel Stock_pane;
    private javax.swing.JScrollPane Stock_scroll;
    private javax.swing.JPanel Strategy_pane;
    private javax.swing.JScrollPane Strategy_scroll;
    private javax.swing.JTabbedPane Tabbs_pane;
    private javax.swing.JButton but_cancelorder;
    private javax.swing.JButton but_cancelorder_1;
    private javax.swing.JButton but_neworder;
    private javax.swing.JButton but_neworder_1;
    private javax.swing.JButton but_sell_derivative;
    private javax.swing.JButton but_sell_option;
    private javax.swing.JButton but_sell_stock;
    private javax.swing.JLabel cash_lab;
    private javax.swing.JLabel cash_lab_num;
    private javax.swing.JScrollPane history_scroll;
    private javax.swing.JTable history_table;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable option_table;
    private javax.swing.JTable orders_table;
    private javax.swing.JLabel portfolio_back;
    private javax.swing.JLabel portfolio_front;
    private javax.swing.JTable stock_table;
    private javax.swing.JTable strategy_table;
    // End of variables declaration                          
}
