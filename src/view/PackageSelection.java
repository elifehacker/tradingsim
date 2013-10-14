package view;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Newsqueue;
import model.SessionController;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pei Wang
 */
public class PackageSelection extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form NewJFrame
     */
    public PackageSelection() {

        String[] ps = null;
        try {
			ps = packageScan("packages\\");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        numOfpackage = ps.length;
        
        initComponents();

        //String all = "";
        int i = 0;
        for(String s: ps){
            select_table.setValueAt(s, i, 0);
            i++;
        	//all += s+" ";
        }
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
    	  
    	  /*
    	  File[] listOfFiles = folder.listFiles(); 
    	  ArrayList<String> ps = new ArrayList<String>();
    	  for (int i = 0; i < listOfFiles.length; i++) 
    	  {
    	 
    	   if (listOfFiles[i].isFile()) 
    	   {
    		   file = listOfFiles[i].getName();
    		   
    	       if (file.endsWith(".csv") || file.endsWith(".CSV")){

    	          System.out.println(file);
    	        }
    	     }
    	  }*/
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
        desc_ScrollPanel = new javax.swing.JScrollPane();
        desc_textarea = new javax.swing.JTextArea();
        simulation_front = new javax.swing.JLabel();
        simulation_back = new javax.swing.JLabel();
        picture_panel = new javax.swing.JPanel();
        lab_picture = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        lab_select = new javax.swing.JLabel();
        but_start = new javax.swing.JButton();
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

        desc_textarea.setColumns(20);
        desc_textarea.setRows(5);
        desc_textarea.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        desc_ScrollPanel.setViewportView(desc_textarea);

        desc_ScrollPanel.setBounds(20, 390, 630, 200);
        leftmultilayer.add(desc_ScrollPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        simulation_front.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        simulation_front.setText("Simulation");
        simulation_front.setBounds(20, 0, 260, 57);
        leftmultilayer.add(simulation_front, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout picture_panelLayout = new javax.swing.GroupLayout(picture_panel);
        picture_panel.setLayout(picture_panelLayout);
        picture_panelLayout.setHorizontalGroup(
            picture_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picture_panelLayout.createSequentialGroup()
                .addGap(0, 300, Short.MAX_VALUE)
                .addComponent(lab_picture)
                .addContainerGap(331, Short.MAX_VALUE))
        );
        picture_panelLayout.setVerticalGroup(
            picture_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picture_panelLayout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(lab_picture)
                .addGap(149, 149, 149))
        );

        picture_panel.setBounds(20, 50, 630, 320);
        leftmultilayer.add(picture_panel, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        lab_select.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lab_select.setText("Please select a simulation configuration");

        but_start.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_start.setText("Start");

        but_load.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_load.setText("Load");

        but_back.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        but_back.setText("Back");

        select_table.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        Object obj[][] = new Object[numOfpackage][1];
        select_table.setModel(new javax.swing.table.DefaultTableModel(
            obj,
            new String [] {
                "Packages"
            }
        ));
        select_table.setEnabled(true);
        select_table.setRowHeight(22);
        select_scroll.setViewportView(select_table);

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(but_load, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(but_start, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_load, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(but_start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(but_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        
        but_load.addActionListener(this);
        but_start.addActionListener(this);
        but_back.addActionListener(this);
        select_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				int row = select_table.getSelectedRow();
				folder = (String) select_table.getValueAt(row, 0);
				if(!folder.equals("null")){
					desc_textarea.setText("Table! "+folder);

					    BufferedReader br;
					    String path = "packages/"+folder+"/"+folder;
						try {
					        lab_picture.setIcon(new javax.swing.ImageIcon(path+".png"));

							br = new BufferedReader(new FileReader(path+".txt"));
					        StringBuilder sb = new StringBuilder();
					        String line = br.readLine();

					        while (line != null) {
					            sb.append(line);
					            sb.append('\n');
					            line = br.readLine();
					        }
					        String everything = sb.toString();
					        desc_textarea.setText(everything);

					        br.close();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				}

			}
        });
        
        getContentPane().add(Right, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == but_load){
			if(!folder.equals("")){

				JFileChooser fc = new JFileChooser("packages/"+folder+"/saves");
		        int returnVal = fc.showSaveDialog(fc);
		        if (returnVal != JFileChooser.APPROVE_OPTION) {
		        	return;
		        }
				//File file = new File("packages/"+folder+"/save.csv");
		        File file = fc.getSelectedFile();
				
				SessionController sc = new SessionController();
				SimulationView sv = new SimulationView(folder);
				sc.load(sv, file);
				sv.setVisible(true);
				this.dispose();
			}
			
		}else if (e.getSource() == but_start){
			System.out.println("start!");
			if(!folder.equals("")){
				//this.setVisible(false);
				new SimulationView(folder).setVisible(true);
				this.dispose();
			}

		}else if (e.getSource() == but_back){
			System.out.println("back!");
            new HomeView().setVisible(true);
            this.dispose();
		}
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
            java.util.logging.Logger.getLogger(PackageSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PackageSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PackageSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PackageSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PackageSelection().setVisible(true);
            }
        });
    }
    
    private String folder ="";
    private int numOfpackage = 0;
    // Variables declaration - do not modify   
    
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JPanel Top;
    private javax.swing.JButton but_back;
    private javax.swing.JButton but_load;
    private javax.swing.JButton but_start;
    private javax.swing.JScrollPane desc_ScrollPanel;
    private javax.swing.JTextArea desc_textarea;
    private javax.swing.JLabel lab_adage;
    private javax.swing.JLabel lab_background;
    private javax.swing.JLabel lab_picture;
    private javax.swing.JLabel lab_select;
    private javax.swing.JLayeredPane leftmultilayer;
    private javax.swing.JPanel picture_panel;
    private javax.swing.JScrollPane select_scroll;
    private javax.swing.JTable select_table;
    private javax.swing.JLabel simulation_back;
    private javax.swing.JLabel simulation_front;
    private javax.swing.JLayeredPane top_background;
    // End of variables declaration                   

}
