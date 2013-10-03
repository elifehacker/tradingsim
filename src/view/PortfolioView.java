package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import action.Action;

import model.IndexTable;
import model.Portfolio;

import order.MarketOrder;
import order.Order;

import derivative.Derivative;
import derivative.Option;
import derivative.Stock;


public class PortfolioView extends javax.swing.JFrame {

	private static boolean TestingMode = false;
    /**
     * Creates new form Portfolio
     */
    public PortfolioView(Portfolio p) {
        initComponents();
        portfolio = p;
        updateTable();
        addlisteners();
        
    }

	private void updateTable() {
		// TODO Auto-generated method stub

    	setOrderTable();
    	setOnhandTable();
    	setStrategyTable();
    	setHistoryTable();

	}

	private void setHistoryTable(){
		
		LinkedList<Action> actions = portfolio.getAction();
		String[][] acts = new String[actions.size()][1];
		int i = 0;
		for(Action a: actions){
			acts[i][0] = a.getTime()+" "+a.getDesc();
			i++;
		}
		history_table.setModel(new javax.swing.table.DefaultTableModel(acts,history_title));

	}
	
	private void setStrats(Order o, int xy, String[][] strats){
		strats[xy][0] = ""+o.getStrategyid()+" "+o.getTag();
		strats[xy][1] = ""+o.getId();
		strats[xy][2] = "Order: "+o.getLongShort();
		strats[xy][3] = o.getUnderlying().getSymbol();
		strats[xy][4] = ""+o.getUnderlying().getVolume();
	}

	private void setStrats(Derivative d, int xy, String[][] strats){
		strats[xy][0] = ""+d.getStrategyid()+" "+d.getTag();
		strats[xy][1] = ""+d.getId();
		if(d instanceof Stock)	strats[xy][2] = "Stock";
		if(d instanceof Option)	strats[xy][2] = "Option";
		strats[xy][3] = d.getSymbol();
		strats[xy][4] = ""+d.getVolume();
	}

	private void setStrategyTable() {
		int total = portfolio.getOrder().size()+portfolio.getOnhand().size();
		String[][] strats = new String[total][strategy_title.length]; 
		LinkedList<Order> orders =portfolio.getOrder(); 
		LinkedList<Derivative> onhands = portfolio.getOnhand();
		Collections.sort(orders, new Comparator <Order>(){
			@Override
			public int compare(Order a, Order b) {
				// TODO Auto-generated method stub
				return a.getStrategyid()- b.getStrategyid();
			}
		});
		Collections.sort(onhands, new Comparator <Derivative>(){
			@Override
			public int compare(Derivative a, Derivative b) {
				// TODO Auto-generated method stub
				return a.getStrategyid()- b.getStrategyid();
			}
		});
		
		int x = 0;
		int y = 0;
		//  "Strat ID", "ID", "Type", "Symbol", "Volume"};
		while(x<orders.size() && y < onhands.size()){
			if(orders.get(x).getStrategyid()<onhands.get(y).getStrategyid()){
				Order o = orders.get(x);
				setStrats(o,x+y, strats);
				x++;
			}else{
				Derivative d = onhands.get(y);
				setStrats(d,x+y,strats);
				y++;
			}
			
		}
		while(x<orders.size()){
			Order o = orders.get(x);
			setStrats(o,x+y, strats);
			x++;
		}
		
		while(y<onhands.size()){
			Derivative d = onhands.get(y);
			setStrats(d,x+y,strats);
			y++;
		}
		
		strategy_table.setModel(new javax.swing.table.DefaultTableModel(strats,strategy_title));
	}
	
	private void setOnhandTable() {
		// TODO Auto-generated method stub
		LinkedList<Derivative> list = portfolio.getOnhand();
		slist = new LinkedList<Stock>();
		oplist = new LinkedList<Option>();

		for(Derivative d : list){
			
			if(d instanceof Stock){
				slist.add((Stock) d);
			}else if(d instanceof Option){
				oplist.add((Option) d);
			}
		}
		
		setStockTable();
		setOptionTable();
        cash_lab_num.setText(""+portfolio.getCredit());

	}

	private void setStockTable(){
		String[][] stocks = new String[slist.size()+1][stock_title.length]; 
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
	}
	
	private void setOptionTable(){
		
	    // String option_title[] = {"Symbol","Type","Bought at","Volume", "Strike price", "Current price", "Maturity", "Proft/Loss"};
		String[][] options = new String[oplist.size()+1][option_title.length]; 

		int i = 0;
		float  total = 0;
		for(Option o : oplist){
			float cur_price;
			if(TestingMode) cur_price = (float)4.22;
			else  cur_price = SimulationView.get_price(o.getSymbol());
			options[i][0] =  ""+o.getId();
			options[i][1] =  o.getSymbol();
			options[i][2] =  ""+o.getType();
			options[i][3] =  ""+o.getPrice();
			options[i][4] =  ""+o.getVolume();
			options[i][5] =  ""+o.getStrike();
			options[i][6] =  ""+cur_price;
			options[i][7] =  ""+o.getMaturity();
			float net =0;
			if(o.getType().equals("Call")) net= (cur_price-o.getStrike()-o.getPrice())*o.getVolume();
			else if(o.getType().equals("Put"))net= (o.getStrike()-cur_price-o.getPrice())*o.getVolume();
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
        cash_lab_num.setText(""+portfolio.getCredit());
		String[][] orders = new String[portfolio.getOrder().size()][order_title.length]; 
		//{"ID","Symbol","Security","Order Type", "Long/Short"};
		int i = 0;
		for(Order o : portfolio.getOrder()){
			Derivative d = o.getUnderlying();
			orders[i][0] = ""+o.getId();
			orders[i][1] = d.getSymbol();
			if(d instanceof Stock) orders[i][2] = "Stock";
			if(d instanceof Option) orders[i][2] = "Option";
			orders[i][3] = o.getClass().getName();
			orders[i][4] = o.getLongShort();
			orders[i][5] = ""+o.getUnderlying().getVolume();
			
			i++;
		}        
		orders_table.setModel(new javax.swing.table.DefaultTableModel(orders,order_title));

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
        but_cancelorder = new javax.swing.JButton();
        Stock_pane = new javax.swing.JPanel();
        Stock_scroll = new javax.swing.JScrollPane();
        stock_table = new javax.swing.JTable();
        Option_pane = new javax.swing.JPanel();
        Option_scroll = new javax.swing.JScrollPane();
        option_table = new javax.swing.JTable();
        but_excercise = new javax.swing.JButton();
        Strategy_pane = new javax.swing.JPanel();
        Strategy_scroll = new javax.swing.JScrollPane();
        strategy_table = new javax.swing.JTable();
        but_detail = new javax.swing.JButton();
        History_pane = new javax.swing.JPanel();
        history_scroll = new javax.swing.JScrollPane();
        history_table = new javax.swing.JTable();
        portfolio_back = new javax.swing.JLabel();
        cash_lab = new javax.swing.JLabel();
        cash_lab_num = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
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

        but_cancelorder.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_cancelorder.setText("Cancel Order");

        javax.swing.GroupLayout Orders_paneLayout = new javax.swing.GroupLayout(Orders_pane);
        Orders_pane.setLayout(Orders_paneLayout);
        Orders_paneLayout.setHorizontalGroup(
            Orders_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Order_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Orders_paneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(but_cancelorder, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        Orders_paneLayout.setVerticalGroup(
            Orders_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Orders_paneLayout.createSequentialGroup()
                .addComponent(Order_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_cancelorder, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
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

        javax.swing.GroupLayout Stock_paneLayout = new javax.swing.GroupLayout(Stock_pane);
        Stock_pane.setLayout(Stock_paneLayout);
        Stock_paneLayout.setHorizontalGroup(
            Stock_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Stock_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        Stock_paneLayout.setVerticalGroup(
            Stock_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stock_paneLayout.createSequentialGroup()
                .addComponent(Stock_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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

        but_excercise.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_excercise.setText("Excercise");
        but_excercise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_excerciseActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout Option_paneLayout = new javax.swing.GroupLayout(Option_pane);
        Option_pane.setLayout(Option_paneLayout);
        Option_paneLayout.setHorizontalGroup(
            Option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Option_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Option_paneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(but_excercise, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        Option_paneLayout.setVerticalGroup(
            Option_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Option_paneLayout.createSequentialGroup()
                .addComponent(Option_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_excercise, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
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

        javax.swing.GroupLayout Strategy_paneLayout = new javax.swing.GroupLayout(Strategy_pane);
        Strategy_pane.setLayout(Strategy_paneLayout);
        Strategy_paneLayout.setHorizontalGroup(
            Strategy_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Strategy_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        Strategy_paneLayout.setVerticalGroup(
            Strategy_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Strategy_paneLayout.createSequentialGroup()
                .addComponent(Strategy_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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
        but_detail.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_detail.setText("Detail");
        but_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_detailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout History_paneLayout = new javax.swing.GroupLayout(History_pane);
        History_pane.setLayout(History_paneLayout);
        History_paneLayout.setHorizontalGroup(
            History_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(history_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, History_paneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(but_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        History_paneLayout.setVerticalGroup(
            History_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(History_paneLayout.createSequentialGroup()
                .addComponent(history_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_detail, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
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
		new TradeView(portfolio, IndexTable.getFirms()).setVisible(true);

    }                                            

    private void but_detailActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
		int row = history_table.getSelectedRow();
		if(row!=-1){
			Action a = portfolio.getAction().get(row);
			Derivative d = a.getUnderlying();
    		JOptionPane.showMessageDialog(null,
				    "Underlying derivative was "+d.getClass()+"\n"+
				    "Strategy:"+d.getTag()+"\n"+
				    "ID:"+d.getId()+" RIC:"+d.getSymbol()+" price:"+d.getPrice()+" volume:"+d.getVolume());
		}
    }  
    
	private void but_excerciseActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		JTable selected_t = null;
		int spotprice_col = 0;
		if(Tabbs_pane.getSelectedIndex()==2){
			selected_t = option_table;
			spotprice_col = findSpotCol(option_title);
		}

		int row = selected_t.getSelectedRow();
		if(row!=-1){
			
			int n = JOptionPane.showConfirmDialog(
				    this,
				    "Are you sure to excercise this option?",
				    "Confirmation",
				    JOptionPane.YES_NO_OPTION);
			System.out.println("Confirmation is "+n); // yes == 0 , no == 1
			if(n == 0){
				String ids = (String) selected_t.getValueAt(row, 0);
				if(ids!=null){
					int id = Integer.parseInt(ids);
					float spotprice = Float.parseFloat((String) selected_t.getValueAt(row, spotprice_col));
					System.out.println("id of the option excercised is "+id);
					for(Derivative d : portfolio.getOnhand()){
						if(d.getId()== id){
							//portfolio.getOnhand().remove(d);
							if(d instanceof Option)
								portfolio.excerciseOption((Option)d, spotprice);
							break;
						}
					}
					setOnhandTable();
			    	setStrategyTable();
			    	setHistoryTable();
				}
			}
		}//end of if row == -1;
	}//end of but_excerciseActionPerformed
    
    private int findSpotCol(String[] title){
    	int i = 0;
    	for(String s : title){
    		if(s.equals("Spot price")) return i;
    		i++;
    	}
		return i;
    }
    
    private class ExcerciseOption implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JTable selected_t = null;
			int spotprice_col = 0;
			if(Tabbs_pane.getSelectedIndex()==1){
				selected_t = stock_table;
				spotprice_col = findSpotCol(stock_title);
			}else if(Tabbs_pane.getSelectedIndex()==2){
				selected_t = option_table;
				spotprice_col = findSpotCol(option_title);
			}else if(Tabbs_pane.getSelectedIndex()==3){
				selected_t = strategy_table;
				spotprice_col = 0;
			}

			int row = selected_t.getSelectedRow();
			if(row!=-1){
				String ids = (String) selected_t.getValueAt(row, 0);
				if(ids!=null){
					int id = Integer.parseInt(ids);
					float spotprice = Float.parseFloat((String) selected_t.getValueAt(row, spotprice_col));
					System.out.println("id of the derivative sold is "+id);
					for(Derivative d : portfolio.getOnhand()){
						if(d.getId()== id){
							//portfolio.getOnhand().remove(d);
							if(d instanceof Option)
								portfolio.excerciseOption((Option)d, spotprice);
							if(d instanceof Stock)
								portfolio.test_sell(d, spotprice);
							break;
						}
					}
					setOnhandTable();
					
				}

			}
		
		}
    	
    }

    private void addlisteners() {
		// TODO Auto-generated method stub
    	
    	but_cancelorder.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = orders_table.getSelectedRow();
				if(row!=-1){
					portfolio.removeOrderbyLocation(row);
					setOrderTable();
			    	setStrategyTable();
			    	setHistoryTable();
				}
			}
    	});
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
            		p.test_purchase(new Stock((float) 3.55, 20, "ABC"));
            		p.test_purchase(new Option((float) 1.50, 20, "ABC", "11/12/2012",(float) 3.40, "Call"));
            		p.test_purchase(new Option((float) 1.50, 20, "ABC", "11/12/2012",(float) 5.40, "Call"));
            		p.test_purchase(new Option((float) 1.50, 20, "ABC", "11/12/2012",(float) 5.40, "Put"));
            		p.makeOrder(new MarketOrder(new Stock((float)3.5, 10, "ABC"), "Short"));
            		new PortfolioView(p).setVisible(true);
            	}else{
                    new PortfolioView(new Portfolio (10000)).setVisible(true);
            	}
            }
        });
    }
        
	private Portfolio portfolio;
	
    private String order_title[] = {"ID","Symbol","Security","Order Type", "Long/Short", "Volume"};
	
    private String stock_title[] = {"ID","Symbol","Bought at","Volume", "Spot price", "Proft/Loss"};
    private String option_title[] = {"ID","Symbol","Type","Bought at","Volume", "Strike price", "Spot price", "Maturity", "Proft/Loss"};

    private String strategy_title[]={"Strat ID", "ID", "Type", "Symbol", "Volume"};
    private String history_title[]={"Action"};

    
    private int selected_stock;
    private int selected_option;
    private int selected_order;
    private LinkedList<Stock> slist;
    private LinkedList<Option> oplist;
    
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
    private javax.swing.JButton but_detail;
    private javax.swing.JButton but_excercise;
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
