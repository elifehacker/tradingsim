package view;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.DataReader;
import model.Newsqueue;
import model.Portfolio;
import model.SessionController;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pei Wang
 */
public class SimulationView extends javax.swing.JFrame {

	public DataReader getDr() {
		return dr;
	}

	public void setDr(DataReader dr) {
		this.dr = dr;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public void setTableContent(String s, int x, int y){
		index_table.setValueAt(s, x, y);
	}
	
	public Portfolio getPortfolio(){
		return portfolio;
	}

	
	private void removechartdata(String pack){
		File chartdata = new File("packages/"+pack);
		
		chartdata.delete();
	}
	
	public String[] getFirms(){
		return dr.getFirms();
	}
	
    public SimulationView(String folder) {
    	
        dr = new DataReader(folder, 10000);
        this.folder = folder;
        initComponents();
    	
        addlisteners();
    	removechartdata(folder);
    	
        //create DataReader to handle the rest

        dr.updateTable();
		current_date_TextField.setText(dr.getDate());
		
		update_rate_TextField.setText("Rate");
		current_time_TextField.setText("Time");
		//current_date_TextField.setText("Date");
		status_TextField.setText("Manual");
		
		portfolio = new Portfolio(dr.getStartingCash());
        
        news_table.setModel(new javax.swing.table.DefaultTableModel(Newsqueue.toBoard(),news_title));

		
        this.addWindowListener(new SwindowsListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */                        
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

         Top = new javax.swing.JPanel();
         top_background = new javax.swing.JLayeredPane();
         lab_adage = new javax.swing.JLabel();
         lab_background = new javax.swing.JLabel();
         Left = new javax.swing.JPanel();
         leftmultilayer = new javax.swing.JLayeredPane();
         label_stock_index = new javax.swing.JLabel();
         but_check_detail = new javax.swing.JButton();
         simulation_front = new javax.swing.JLabel();
         index_scroll = new javax.swing.JScrollPane();
         index_table = new javax.swing.JTable();
         simulation_back = new javax.swing.JLabel();
         Right = new javax.swing.JPanel();
         but_back = new javax.swing.JButton();
         but_save = new javax.swing.JButton();
         lab_latest_news = new javax.swing.JLabel();
         news_scroll = new javax.swing.JScrollPane();
         news_table = new javax.swing.JTable();
         lab_stock_detail = new javax.swing.JLabel();
         stockdetail_scroll = new javax.swing.JScrollPane();
         stock_detail_TextArea = new javax.swing.JTextArea();
         lab_trading_command = new javax.swing.JLabel();
         but_trade = new javax.swing.JButton();
         but_check_chart = new javax.swing.JButton();
         but_strategy = new javax.swing.JButton();
         but_my_portfolio = new javax.swing.JButton();
         lab_progression_step = new javax.swing.JLabel();
         update_rate_TextField = new javax.swing.JTextField();
         but_minus = new javax.swing.JButton();
         but_plus = new javax.swing.JButton();
         but_pause = new javax.swing.JButton();
         but_auto = new javax.swing.JButton();
         but_next = new javax.swing.JButton();
         lab_current_time = new javax.swing.JLabel();
         current_time_TextField = new javax.swing.JTextField();
         current_date_TextField = new javax.swing.JTextField();
         status_TextField = new javax.swing.JTextField();
         progression_step_TextField = new javax.swing.JTextField();
         lab_progression_type = new javax.swing.JLabel();
         lab_auto_pro_rate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        Top.setOpaque(false);

        lab_adage.setFont(new java.awt.Font("Consolas", 1, 32)); // NOI18N
        lab_adage.setForeground(new java.awt.Color(255, 255, 255));
        lab_adage.setText("ADAGE TRADING SIMULATOR");
        lab_adage.setBounds(20, 20, 480, 40);
        top_background.add(lab_adage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lab_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/topbar.png"))); // NOI18N
        lab_background.setBounds(0, 0, 1360, 80);
        top_background.add(lab_background, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top_background, javax.swing.GroupLayout.DEFAULT_SIZE, 1373, Short.MAX_VALUE)
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addComponent(top_background, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Top, java.awt.BorderLayout.PAGE_START);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(660, 608));

        label_stock_index.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        label_stock_index.setText("Stock Index");
        label_stock_index.setBounds(20, 50, 110, 22);
        leftmultilayer.add(label_stock_index, javax.swing.JLayeredPane.DEFAULT_LAYER);

        but_check_detail.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_check_detail.setText("Check Detail");

        but_check_detail.setBounds(490, 551, 153, 40);
        leftmultilayer.add(but_check_detail, javax.swing.JLayeredPane.DEFAULT_LAYER);

        simulation_front.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        simulation_front.setText("Simulation");
        simulation_front.setBounds(20, 0, 260, 57);
        leftmultilayer.add(simulation_front, javax.swing.JLayeredPane.DEFAULT_LAYER);

        index_table.setModel(new javax.swing.table.DefaultTableModel(
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
        index_scroll.setViewportView(index_table);

        index_scroll.setBounds(20, 70, 630, 470);
        leftmultilayer.add(index_scroll, javax.swing.JLayeredPane.DEFAULT_LAYER);

        simulation_back.setFont(new java.awt.Font("Consolas", 1, 85)); // NOI18N
        simulation_back.setForeground(new java.awt.Color(214, 214, 214));
        simulation_back.setText("Simulation");
        simulation_back.setBounds(10, 10, 530, 120);
        leftmultilayer.add(simulation_back, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addComponent(leftmultilayer, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addContainerGap())
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftmultilayer, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );

        getContentPane().add(Left, java.awt.BorderLayout.WEST);

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(660, 400));

        but_back.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_back.setLabel("Back");
        but_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_backActionPerformed(evt);
            }
        });

        but_save.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_save.setText("Save");
        but_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_saveActionPerformed(evt);
            }
        });

        lab_latest_news.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lab_latest_news.setText("Latest News");

        news_table.setModel(new javax.swing.table.DefaultTableModel(
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
        news_scroll.setViewportView(news_table);

        lab_stock_detail.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lab_stock_detail.setText("Stock Detail");

        stock_detail_TextArea.setColumns(20);
        stock_detail_TextArea.setRows(5);
        stockdetail_scroll.setViewportView(stock_detail_TextArea);

        lab_trading_command.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lab_trading_command.setText("Trading Command");

        but_trade.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_trade.setText("Trade");

        but_check_chart.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_check_chart.setText("Check Chart");

        but_strategy.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_strategy.setText("Strategy");

        but_my_portfolio.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_my_portfolio.setText("My Portfolio");

        lab_progression_step.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lab_progression_step.setText("Progression Step");

        update_rate_TextField.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        update_rate_TextField.setText("jTextField1");

        but_minus.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_minus.setText("-");

        but_plus.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_plus.setText("+");

        but_pause.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_pause.setText("||");
        but_pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_pauseActionPerformed(evt);
            }
        });

        but_auto.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_auto.setText("Auto");

        but_next.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_next.setText(">>");

        lab_current_time.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lab_current_time.setText("Current Time");

        current_time_TextField.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        current_time_TextField.setText("jTextField2");

        current_date_TextField.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        current_date_TextField.setText("jTextField2");

        status_TextField.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        status_TextField.setText("jTextField1");

        progression_step_TextField.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        progression_step_TextField.setText("1 day");

        lab_progression_type.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lab_progression_type.setText("Progression Type");

        lab_auto_pro_rate.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lab_auto_pro_rate.setText("Auto Progression Rate");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(news_scroll)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(but_save, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(but_back, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(stockdetail_scroll, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lab_latest_news)
                                    .addComponent(lab_stock_detail))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addComponent(lab_progression_step)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(progression_step_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RightLayout.createSequentialGroup()
                                .addComponent(lab_progression_type)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(status_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RightLayout.createSequentialGroup()
                                .addComponent(lab_auto_pro_rate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(RightLayout.createSequentialGroup()
                                        .addComponent(but_minus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(but_plus))
                                    .addComponent(update_rate_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lab_current_time)
                                .addComponent(current_date_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                .addComponent(current_time_TextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                                .addComponent(but_pause)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(but_auto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(but_next)))
                        .addGap(19, 19, 19))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lab_trading_command)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addComponent(but_check_chart, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but_trade, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but_strategy, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but_my_portfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(17, Short.MAX_VALUE))))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_back, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_save, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lab_latest_news)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(news_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_stock_detail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stockdetail_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lab_trading_command)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_check_chart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_trade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_strategy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_my_portfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(progression_step_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_progression_step)
                    .addComponent(lab_current_time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lab_progression_type))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update_rate_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lab_auto_pro_rate)))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(current_date_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(current_time_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(but_minus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(but_plus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(but_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(but_next, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(but_auto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(Right, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>  
 
  
     public void loadme(String date){
    	 while(!dr.getDate().equals(date)){
    		 goNext();
    	 }
     }
     
	private void goNext() {
		// TODO Auto-generated method stub
		//printBuffer();
		dr.updateTable();
        news_table.setModel(new javax.swing.table.DefaultTableModel(Newsqueue.toBoard(),news_title));
		portfolio.checkOrders(dr.get_table());
		portfolio.checkOptions();
		newtablecontent = true;
		current_date_TextField.setText(dr.getDate());
	}

    
    public void setNewTableFlag(boolean b){
    	 newtablecontent = b;
    }
    public boolean getNewTableFlag(){
    	return newtablecontent;
    }
    private void addlisteners(){
    	but_next.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				goNext();
			}
    	});
    	
    	but_my_portfolio.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PortfolioView(portfolio).setVisible(true);
			}
    	});
    	

    	but_strategy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TradeStrategyView(portfolio, getFirms()).setVisible(true);
			}
    	});
    	
    	but_trade.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TradeView(portfolio, getFirms()).setVisible(true);
			}
    	});    	
    	
    	
    	index_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				int row = index_table.getSelectedRow();
				if(row !=-1){
					
					StringBuffer sb = new StringBuffer();
					String[] content = dr.getFileContent(row);
					String[] title = dr.getFileTitle();
					selected = dr.getFirms()[row];
					for(int i =0; i < title.length; i++){
						//System.out.print(title[i]+": ");
						//System.out.println(content[i]+"  ");
						sb.append(title[i]+": "+content[i]+"  ");
						if(i == title.length/4 ||i == title.length/2||i == title.length*3/4) sb.append("\n");
					}
					stock_detail_TextArea.setText(sb.toString());					
				}

			}  		
    	});
    	
    	but_check_chart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!selected.isEmpty()){

					try {
						StringBuffer sb = new StringBuffer();
						BufferedReader br = new BufferedReader(new FileReader("chartdata/header.txt"));
						String line = null; 
						while((line =br.readLine())!=null){
						   sb.append(line).append("\n");
						 }
						
						sb.append("<title>"+selected+"</title>\n"+
								"<short>"+selected+"</short>\n"+
								"<description></description>\n");
						
						sb.append("<file_name>"+selected+".csv");

						br = new BufferedReader(new FileReader("chartdata/footer.txt"));
						while((line =br.readLine())!=null){
							   sb.append(line).append("\n");
						 }
						
						FileWriter fw= new FileWriter("chartdata/amstock_settings.xml");
						//System.out.println(sb.toString());
						fw.write(sb.toString());
						fw.close();
						File graph = new File("chartdata/index.html");
						open(graph);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
    	});
    	
    	but_check_detail.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selected.isEmpty()){
					try {
						URI url = new URI("www.reuters.com/finance/stocks/overview?symbol="+selected);
						java.awt.Desktop.getDesktop().browse(url);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
    		
    	});

    	
    }
	public static void open(File document) throws IOException {
	    Desktop dt = Desktop.getDesktop();
	    dt.open(document);
	}
	
	public static Float get_price(String ticker){
		for(int i = 0; i < index_table.getRowCount();i++){
			if(index_table.getValueAt(i,0).equals(ticker)){
				return  Float.parseFloat((String) index_table.getValueAt(i,price_index));	
			}
		}
		return null;
	}
	
	public static void setDisplay(String[][] table){
		displayingtable = table;
        index_table.setModel(new javax.swing.table.DefaultTableModel(displayingtable,index_title));
	}

	public void setManual(){
		manual = true;
    	update_rate_TextField.setText("Paused");
    	status_TextField.setText("Manual");
	}
	
    private void but_pauseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	setManual();
    } 
    private void but_autoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	manual = false;
    	if(AT == null){
    		AT = new AutoThread();
        	AT.start();
    	}
    	update_rate_TextField.setText(""+rate/1000+" sec");
    	status_TextField.setText("Auto");
    	
    }  
    
    private class AutoThread extends Thread {

        public void run() {
        	
            while(true)
            {
            	while(manual){
            		Thread.yield();
            	}
   
            	goNext();
				try {
					Thread.sleep(rate);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

        }
        /*
        public static void main(String args[]) {
            (new AutoThread()).start();
        }*/

    }
    private void but_plusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	rate+=1000;
    	update_rate_TextField.setText(""+rate/1000+" sec");
    }  
    private void but_minusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	if(rate > 2000) rate-=1000;
    	update_rate_TextField.setText(""+rate/1000+" sec");

    }                                                    

    private void but_saveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:

    	SessionController sc = new SessionController();
    	sc.save(folder, portfolio, dr.getDate());

    }                                        

    private void but_backActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        new PackageSelection().setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(SimulationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulationView("test").setVisible(true);
            }
        });
    }
   
    
    class SwindowsListener implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			dr.deleteMe();

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
    public static int get_index_title_index(String s){
    	for(int i = 0 ; i < index_title.length; i++){
    		if(index_title[i].equals(s)) return i;
    	}
		return 0;    	
    }
 
    public static String[] get_index_title(){

		return index_title;
    	
    }

    private String news_title[] = {"News Headlines"};
    private static String index_title[] = {"Symbol","Last","Net Change", "% Change", "Volumn"};
    private static int price_index =1; //where "Last" colume is
    private DataReader dr;
    private String folder;
    private Portfolio portfolio; 
    
    private String selected = "";
    
    public static String[][] displayingtable; 
    public boolean newtablecontent = false;
    
    private volatile boolean manual = true;
    private AutoThread AT = null;
    
    private int rate= 4000;
 // Variables declaration - do not modify                     
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JPanel Top;
    private javax.swing.JButton but_auto;
    private javax.swing.JButton but_back;
    private javax.swing.JButton but_check_chart;
    private javax.swing.JButton but_check_detail;
    private javax.swing.JButton but_minus;
    private javax.swing.JButton but_my_portfolio;
    private javax.swing.JButton but_next;
    private javax.swing.JButton but_pause;
    private javax.swing.JButton but_plus;
    private javax.swing.JButton but_save;
    private javax.swing.JButton but_strategy;
    private javax.swing.JButton but_trade;
    private javax.swing.JTextField current_date_TextField;
    private javax.swing.JTextField current_time_TextField;
    private javax.swing.JScrollPane index_scroll;
    private static javax.swing.JTable index_table;
    private javax.swing.JLabel lab_adage;
    private javax.swing.JLabel lab_auto_pro_rate;
    private javax.swing.JLabel lab_background;
    private javax.swing.JLabel lab_current_time;
    private javax.swing.JLabel lab_latest_news;
    private javax.swing.JLabel lab_progression_step;
    private javax.swing.JLabel lab_progression_type;
    private javax.swing.JLabel lab_stock_detail;
    private javax.swing.JLabel lab_trading_command;
    private javax.swing.JLabel label_stock_index;
    private javax.swing.JLayeredPane leftmultilayer;
    private javax.swing.JTable news_table;
    private javax.swing.JScrollPane news_scroll;
    private javax.swing.JTextField progression_step_TextField;
    private javax.swing.JLabel simulation_back;
    private javax.swing.JLabel simulation_front;
    private javax.swing.JTextField status_TextField;
    private javax.swing.JTextArea stock_detail_TextArea;
    private javax.swing.JScrollPane stockdetail_scroll;
    private javax.swing.JLayeredPane top_background;
    private javax.swing.JTextField update_rate_TextField;
    // End of variables declaration                                     
}
