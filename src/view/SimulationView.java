package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pei Wang
 */
public class SimulationView extends javax.swing.JFrame {

	
	private void printBuffer(){
		System.out.println("Print Buffer");

		for(int a = 0; a <displayBuffer.length; a++){
			for(int b = 0; b <displayBuffer[a].length; b++){
				for(int c = 0; c <displayBuffer[a][b].length; c++){
					System.out.print(displayBuffer[a][b][c]+",");
				}
				System.out.println("");
			}
		}
	}
	
	private void readtobuffer(String path, String type){
		try {
			if(br == null)
				br = new BufferedReader(new FileReader(path+type));
			int counter = 0;
	        //StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        
	        int cyc = 0; // used to count event entry
	        while (cyc != cyclelimit ) {
	            //sb.append(line);
	            //sb.append('\n');
	        	System.out.println("the line was "+line);
	        	String[] split = line.split(",");
	        	if(counter == 0){
	        		//entry number, date, time
	        		displayBuffer[cyc][counter]=split;
	        		
	        	}else{
	        		//price, A, B, C, Volume
	        		displayBuffer[cyc][counter]=split;
	        	}
	        	//System.out.println("while loop "+split.length);
	        	
	        	counter ++;
	        	if(counter ==rows){
	        		counter = 0;
	        		cyc++;
	        	}
	        	if(cyc == cyclelimit || readentry+cyc == totalentry) break; // break after reading x entries
	            line = br.readLine();
	        }
	        cyclelimit = cyc;
	        readentry+=cyc;
	        //String everything = sb.toString();
	        
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		printBuffer();
	}
	
	private void readfile(String folder, String type){
    	if(!folder.equals("null")){
		    path = "packages/"+folder+"/"+folder;

    		if(type.equals(".conf")){
    			try {
					BufferedReader br = new BufferedReader(new FileReader(path+type));
			        String line = br.readLine();
			        if(line !=null){
				        String[] splited = line.split(",");
				        totalentry = Integer.parseInt(splited[0]);// check the .conf file
				        totalfirm = Integer.parseInt(splited[1]);// for more info
				        cols = Integer.parseInt(splited[2]);
				        rows = totalfirm+1;
				        firms = new String[totalfirm];
				        displayBuffer = new String[cyclelimit][rows][index_title.length];
				        
				        for(int i = 0; i < totalfirm; i++){
				        	firms[i] = splited[i+3];
				        	System.out.println("firm[i] "+firms[i]);
				        }
				        
			        }

			        br.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    		}else if(type.equals(".csv")){
    			readtobuffer(path, type);
    		}

    	}
	}
	
    public SimulationView(String folder) {
        cyclelimit = 3;
    	readfile(folder,".conf");
    	readfile(folder,".csv");

        initComponents();
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
        but_index_chart = new javax.swing.JButton();
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
        news_TextArea = new javax.swing.JTextArea();
        lab_stock_detail = new javax.swing.JLabel();
        stockdetail_scroll = new javax.swing.JScrollPane();
        stock_detail_TextArea = new javax.swing.JTextArea();
        lab_trading_command = new javax.swing.JLabel();
        but_trade = new javax.swing.JButton();
        but_check_chart = new javax.swing.JButton();
        but_strategy = new javax.swing.JButton();
        but_my_portfolio = new javax.swing.JButton();
        lab_updating_rate = new javax.swing.JLabel();
        update_rate_TextField = new javax.swing.JTextField();
        but_minus = new javax.swing.JButton();
        but_plus = new javax.swing.JButton();
        but_pause = new javax.swing.JButton();
        but_auto = new javax.swing.JButton();
        but_next = new javax.swing.JButton();
        lab_current_time = new javax.swing.JLabel();
        current_time_TextField = new javax.swing.JTextField();
        current_date_TextField = new javax.swing.JTextField();

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

        but_index_chart.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_index_chart.setText("Index Chart");
        but_index_chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_index_chartActionPerformed(evt);
            }
        });
        but_index_chart.setBounds(310, 551, 143, 40);
        leftmultilayer.add(but_index_chart, javax.swing.JLayeredPane.DEFAULT_LAYER);

        but_check_detail.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_check_detail.setText("Check Detail");
        but_check_detail.setBounds(490, 551, 153, 40);
        leftmultilayer.add(but_check_detail, javax.swing.JLayeredPane.DEFAULT_LAYER);

        simulation_front.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        simulation_front.setText("Simulation");
        simulation_front.setBounds(20, 0, 260, 57);
        leftmultilayer.add(simulation_front, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Object[][] obj = new Object[totalfirm][index_title.length];
        
        index_table.setModel(new javax.swing.table.DefaultTableModel(
            obj,index_title
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

        news_TextArea.setColumns(20);
        news_TextArea.setRows(5);
        news_scroll.setViewportView(news_TextArea);

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

        lab_updating_rate.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lab_updating_rate.setText("Updating Rate");

        update_rate_TextField.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        update_rate_TextField.setText("jTextField1");
        update_rate_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_rate_TextFieldActionPerformed(evt);
            }
        });

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
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(update_rate_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(but_minus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(but_plus)
                                .addGap(34, 34, 34)
                                .addComponent(but_pause)
                                .addGap(26, 26, 26)
                                .addComponent(but_auto)
                                .addGap(27, 27, 27)
                                .addComponent(but_next)
                                .addGap(33, 33, 33))
                            .addGroup(RightLayout.createSequentialGroup()
                                .addComponent(lab_updating_rate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lab_current_time)
                            .addComponent(current_date_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(current_time_TextField))
                        .addGap(19, 19, 19))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(lab_trading_command)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(but_trade, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but_strategy, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(but_check_chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(but_my_portfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109))))
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
                .addComponent(news_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lab_stock_detail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stockdetail_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lab_trading_command)
                .addGap(18, 18, 18)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_check_chart, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_trade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_my_portfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_strategy, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_updating_rate)
                    .addComponent(lab_current_time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(current_date_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(but_auto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(but_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_rate_TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(but_plus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(but_pause, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(but_minus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(current_time_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        getContentPane().add(Right, java.awt.BorderLayout.CENTER);

        addlisteners();
        
        pack();
    }// </editor-fold>                       

    private void addlisteners(){
    	but_next.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	            
				printBuffer();
				
				for(int b = 0; b <displayBuffer[cycle].length-1; b++){// length-1 because the first line has the time and date
					for(int c = 0; c <displayBuffer[cycle][b+1].length; c++){// b+1 because the first line has the time and date
						index_table.setValueAt(displayBuffer[cycle][b+1][c], b, c);
					}
					System.out.println("");
				}
				cycle++;
				if(cycle == cyclelimit){
					if(readentry==totalentry){
						//signal all entry has been displayed
						
						
					}
					//read in more contents
					bufferRunnable thread = new bufferRunnable();
					thread.run();
					
					cycle=0;
				}
			}
    		
    	});

    }
    public void add_index_chart_lis(ActionListener l){
    	but_index_chart.addActionListener(l);
    }
    
    public void add_check_detail_lis(ActionListener l){
    	but_check_detail.addActionListener(l);
    }
    
    public void add_save_lis(ActionListener l){
    	but_save.addActionListener(l);
    }
    
    public void add_back_lis(ActionListener l){
    	but_back.addActionListener(l);
    }
    
    public void add_trade_lis(ActionListener l){
    	but_trade.addActionListener(l);
    }
    
    public void add_check_chart_lis(ActionListener l){
    	but_check_chart.addActionListener(l);
    }
    
    public void add_strategy_lis(ActionListener l){
    	but_strategy.addActionListener(l);
    }
    
    public void add_my_portfolio_lis(ActionListener l){
    	but_my_portfolio.addActionListener(l);
    }
    
    public void add_minus_lis(ActionListener l){
    	but_minus.addActionListener(l);
    }
    
    public void add_plus_lis(ActionListener l){
    	but_plus.addActionListener(l);
    }
    
    public void add_pause_lis(ActionListener l){
    	but_pause.addActionListener(l);
    }
    
    public void add_auto_lis(ActionListener l){
    	but_auto.addActionListener(l);
    }
    
    public void add_next_lis(ActionListener l){
    	but_next.addActionListener(l);
    }
    /*
    public void add__lis(ActionListener l){
    	but_.addActionListener(l);
    }
    */
    
    
    private void but_pauseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void update_rate_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void but_saveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void but_backActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void but_index_chartActionPerformed(java.awt.event.ActionEvent evt) {                                                
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
    
    public class bufferRunnable implements Runnable {

        public void run() {
            System.out.println("Hello from a thread!");
            readtobuffer(path, ".csv");
        }

    }
    
    class SwindowsListener implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
    
    private String simulation;
    private BufferedReader br = null;
    private int totalentry = 0;
    private int totalfirm = 0;
    private String firms[];
    private int cols = 0;
    private int rows = 0;
    private String index_title[] = {"Symbol","Last","Net Change", "% Change", "Volumn"};
    private int readevery = 5;
    private int cycle = 0;// used to count entries, reset when reach cyclelimit
    private int cyclelimit;
    private String displayBuffer[][][];
    private String path;
    private int readentry = 0;
    
    // Variables declaration - do not modify                     
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JPanel Top;
    private javax.swing.JButton but_auto;
    private javax.swing.JButton but_back;
    private javax.swing.JButton but_check_chart;
    private javax.swing.JButton but_check_detail;
    private javax.swing.JButton but_index_chart;
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
    private javax.swing.JTable index_table;
    private javax.swing.JLabel lab_adage;
    private javax.swing.JLabel lab_background;
    private javax.swing.JLabel lab_current_time;
    private javax.swing.JLabel lab_latest_news;
    private javax.swing.JLabel lab_stock_detail;
    private javax.swing.JLabel lab_trading_command;
    private javax.swing.JLabel lab_updating_rate;
    private javax.swing.JLabel label_stock_index;
    private javax.swing.JLayeredPane leftmultilayer;
    private javax.swing.JTextArea news_TextArea;
    private javax.swing.JScrollPane news_scroll;
    private javax.swing.JLabel simulation_back;
    private javax.swing.JLabel simulation_front;
    private javax.swing.JTextArea stock_detail_TextArea;
    private javax.swing.JScrollPane stockdetail_scroll;
    private javax.swing.JLayeredPane top_background;
    private javax.swing.JTextField update_rate_TextField;
    // End of variables declaration                    
}
