package view;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.SessionController;

/**
 *
 * @author Pei Wang
 */
public class PerformanceView extends javax.swing.JFrame {
    /**
     * Creates new form NewJFrame
     */
    public PerformanceView() {

        String[] ps = null;
        try {
			ps = packageScan("packages\\");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        initComponents();
        String[][] pss =  new String[ps.length][1] ;
        int i = 0;
        for(String s: ps){
            pss[i][0]= s;
            i++;
        }
        
        select_table.setModel(new javax.swing.table.DefaultTableModel(
        		pss,new String [] {
                    "Packages"
                }
            ));
        select_table.setEnabled(true);
        select_table.setRowHeight(22);
        
    }

    public String[] packageScan(String path) throws IOException {

    	  String file;
    	  File folder = new File(path);
    	  
    	  String[] directories = folder.list(new FilenameFilter() {
    		  @Override
    		  public boolean accept(File dir, String name) {
    		    return new File(dir, name).isDirectory();
    		  }
    		});
    	  
		return directories;
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
        simulation_front = new javax.swing.JLabel();
        leaderboard_pane = new javax.swing.JScrollPane();
        leaderboard_table = new javax.swing.JTable();
        simulation_back = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        lab_select = new javax.swing.JLabel();
        but_load = new javax.swing.JButton();
        but_back = new javax.swing.JButton();
        select_scroll = new javax.swing.JScrollPane();
        select_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        Top.setOpaque(false);

        lab_adage.setFont(new java.awt.Font("Consolas", 1, 32)); // NOI18N
        lab_adage.setForeground(new java.awt.Color(255, 255, 255));
        lab_adage.setText("ADAGE TRADING SIMULATOR");
        lab_adage.setBounds(20, 20, 480, 40);
        top_background.add(lab_adage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lab_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_material/topbar.png"))); // NOI18N
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

        simulation_front.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        simulation_front.setText("Performance");
        simulation_front.setBounds(20, 0, 320, 57);
        leftmultilayer.add(simulation_front, javax.swing.JLayeredPane.DEFAULT_LAYER);

        leaderboard_table.setModel(new javax.swing.table.DefaultTableModel(
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
        leaderboard_pane.setViewportView(leaderboard_table);

        leaderboard_pane.setBounds(20, 50, 630, 510);
        leftmultilayer.add(leaderboard_pane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        simulation_back.setFont(new java.awt.Font("Consolas", 1, 85)); // NOI18N
        simulation_back.setForeground(new java.awt.Color(214, 214, 214));
        simulation_back.setText("Performance");
        simulation_back.setBounds(10, 10, 550, 120);
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

        lab_select.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lab_select.setText("Please select a simulation configuration");

        but_load.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_load.setText("Review");
        but_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_loadActionPerformed(evt);
            }
        });

        but_back.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_back.setText("Back");
        but_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	but_backActionPerformed(evt);
            }
        });
        select_table.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        select_table.setModel(new javax.swing.table.DefaultTableModel(
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
        select_scroll.setViewportView(select_table);

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(but_load, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(but_back, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(lab_select, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(select_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lab_select)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(select_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_back, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(but_load, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(Right, java.awt.BorderLayout.CENTER);
        select_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				int row = select_table.getSelectedRow();
				folder = (String) select_table.getValueAt(row, 0);

			}
        });
        pack();
    }// </editor-fold>                        

    private void but_loadActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
		if(!folder.equals("")){

			JFileChooser fc = new JFileChooser("packages/"+folder+"/saves");
	        int returnVal = fc.showSaveDialog(fc);
	        if (returnVal != JFileChooser.APPROVE_OPTION) {
	        	return;
	        }
			//File file = new File("packages/"+folder+"/save.csv");
	        File file = fc.getSelectedFile();
			
			SessionController sc = new SessionController();
			ReviewMode sv = new ReviewMode(folder);
			sc.load(sv, file);
			sv.setVisible(true);
			this.dispose();
		}
    }                                        

	private void but_backActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
        new HomeView().setVisible(true);
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
            java.util.logging.Logger.getLogger(PerformanceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerformanceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerformanceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerformanceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerformanceView().setVisible(true);
            }
        });
    }
    
    private String folder ="";
    // Variables declaration - do not modify                     
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JPanel Top;
    private javax.swing.JButton but_back;
    private javax.swing.JButton but_load;
    private javax.swing.JScrollPane leaderboard_pane;
    private javax.swing.JTable leaderboard_table;
    private javax.swing.JLabel lab_adage;
    private javax.swing.JLabel lab_background;
    private javax.swing.JLabel lab_select;
    private javax.swing.JLayeredPane leftmultilayer;
    private javax.swing.JScrollPane select_scroll;
    private javax.swing.JTable select_table;
    private javax.swing.JLabel simulation_back;
    private javax.swing.JLabel simulation_front;
    private javax.swing.JLayeredPane top_background;
    // End of variables declaration                   
}