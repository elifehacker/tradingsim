    import java.awt.event.ActionEvent;

    import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

import com.michaelbaranov.microba.calendar.DatePicker;


    public class Frame extends JFrame{
        private JPanel panel1, panel2;
        private JButton but,but2; 
        DatePicker dp;
        public Frame()
        {
           createPanel();
           addPanel();
        }
        private void createPanel()
        {
            panel1 = new JPanel();
            but = new JButton("TestButton");
            but.addActionListener(new addButtonListener());
            but.setBounds(50, 90, 190, 30);//There are example values but remember about setting size
            panel2 = new JPanel();
            but2 = new JButton("TestButton2");
            but2.setBounds(50, 50, 90, 30);//There are example values but remember about setting size
            dp = new DatePicker();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            dp.setDateFormat(df);
            dp.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println(dp.getDate().getYear());
				}
            	
            });
        }
        private void addPanel()
        {
            panel1.add(but);
            panel1.add(dp);
            panel2.add(but2);
            add(panel1);
        }

        class addButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent ae) 
            {
                getContentPane().removeAll();
                getContentPane().add(panel2);//Adding to content pane, not to Frame
                repaint();
                printAll(getGraphics());//Extort print all content
            }
        }

        public static void main(String args[])
        {
            Frame frame = new Frame();
            frame.setTitle("Test Software");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,500);
            frame.setVisible(true);
        }

    }