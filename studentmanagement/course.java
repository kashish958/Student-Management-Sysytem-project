/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kashish
 */
public class course extends JFrame implements  ActionListener {
   
     JPanel pp;
        JLabel bn;
        JLabel yr;      
        JTextField btn; 
          JTextField y; 
        JButton add;
                JButton cc;
                Connection con;
    PreparedStatement pst;
ResultSet rs;
    
    public course()
    { 
        //panel//
        pp= new JPanel();
        pp.setBounds(70,100,500,500);
                 pp.setBackground(Color.ORANGE);
pp.setLayout(null);
                 
                 
        bn=new  JLabel("CourseName :");
         bn.setBounds(50,20,100,65);
  
         pp.add(bn); 
         
         yr = new JLabel("Duration(in years):");
         yr.setBounds(50,80,105,75);
                                   pp.add(yr);
        
                                   
                 btn = new JTextField("");
         btn.setBounds(150,20,300,50);
         btn.setBackground(new Color(210,180,140));
         pp.add(btn);                    
         
                            
                 y = new JTextField("");
         y.setBounds(150,80,300,50);
         y.setBackground(new Color(210,180,140));
         pp.add(y);                    
         
                                   
               add = new JButton("ADD");
           add.setBounds(100,320,130,80);
         pp.add(add); 
          add.addActionListener(this);
         
         cc = new JButton("CANCEL");
           cc.setBounds(300,320,130,80);
         pp.add(cc); 
        cc.addActionListener(this);
                                   
                                   
         add(pp);        
         setTitle("Course");
           setSize(700,700);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
  
    }
   
        @Override
       public void actionPerformed(ActionEvent ae)
    {   
          
        try{
        
            
            if(ae.getSource() == cc)
            {
                this.hide();
            }
            
         //checking not null values//
         if(btn.getText().isEmpty()||y.getText().isEmpty())
         {
                 JOptionPane.showMessageDialog(this,"Coursename 0r duration is blank");        

         } 
        
         else {
   
             //database//
        
              String coursename= btn.getText();
                            String duration= y.getText();
             Class.forName("com.mysql.jdbc.Driver");    //this is method which register the deriver//  
        
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","Demo12345");
                       pst = con.prepareStatement("insert into course(Coursename,Duration)values(?,?)");
 pst.setString(1,coursename);
              pst.setString(2,duration);
 pst.executeUpdate();
 
              JOptionPane.showMessageDialog(this,"course entry created...");
              btn.setText("");
                            y.setText("");
                            btn.requestFocus();

         }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

 
 
    public static void main(String a[]) {
        
       course c =new course();
        
    }
}
