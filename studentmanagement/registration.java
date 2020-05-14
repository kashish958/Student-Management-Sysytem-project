/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author kashish
 */
public class registration extends JFrame implements ActionListener 
{
                  
    JPanel user ;
ResultSet rs;
    Connection con ;
    JButton ss;
    JButton can;
    JTextField nm;
    JTextField p;
     JLabel rr;
               JTextField type ;

                            JTextField ac ;

               JTextField ag ;

JTextField rc ;

         PreparedStatement pst; //for insert
                  PreparedStatement pst1;//for course
         PreparedStatement pst2;//for batch


JComboBox tc;
JComboBox bc;

public registration()
    
    {  
  
        
          Font f = new Font("Serif", Font.BOLD, 30);                             
         
                                    
   //Panel
             user = new JPanel();
         user.setLayout(null);
          user.setSize(400,350);
         user.setBackground(Color.ORANGE);
         user.setBounds(190,155,500,450);
         
         
        rr = new JLabel("REGISRATION");
         rr.setBounds(330,5,400,50);
         rr.setFont(f);
user.add(rr);
//username
        
        JLabel name = new JLabel("Firstname :");
         
         name.setBounds(70,50,100,50);
         
      user.add(name); 
      
         
          nm = new JTextField("");
         nm.setBounds(190,50,300,50);
                  nm.setBackground(new Color(210,180,140));

         user.add(nm);
      
//lastname
       JLabel ln = new JLabel("Lastname :");
         
         ln.setBounds(70,130,100,50);
         
      user.add(ln); 
            
       p= new JTextField("");
               p.setBounds(190,130,300,50);

                  p.setBackground(new Color(210,180,140));
                  user.add(p);
    
    //gender
     JLabel g = new JLabel("Gender :");
       g.setBounds(70,200,200,50);
         
      user.add(g); 
        
      ag= new JTextField("");
       ag.setBounds(190,200,300,50);
                  ag.setBackground(new Color(210,180,140));
                  user.add(ag);
     



     // course
      JLabel cc = new JLabel("Course :");
              
 
         cc.setBounds(70,270,100,50);
         
      user.add(cc); 
      
      tc = new JComboBox();
        tc.setBounds(190,270,300,50);
                  tc.setBackground(new Color(210,180,140));
                  user.add(tc);
                  
      user.add(tc);
  

      
      
      
//batch
 
 JLabel b = new JLabel("Batch :");
                  user.add(b);

     b.setBounds(70,340,100,50);
      bc = new JComboBox();
        bc.setBounds(190,340,300,50);
                  bc.setBackground(new Color(210,180,140));
                  user.add(bc);
     
    //telephone
     JLabel te = new JLabel("Telephone no. :");
                    user.add(te);
   te.setBounds(70,410,100,50);
      rc = new JTextField("");
        rc.setBounds(190,410,300,50);
                  rc.setBackground(new Color(210,180,140));
                  user.add(rc);
     
    
    
    //address
        JLabel ad = new JLabel("Address :");
                    user.add(ad);
  ad.setBounds(70,480,100,50);
      ac = new JTextField("");
        ac.setBounds(190,480,300,50);
                  ac.setBackground(new Color(210,180,140));
                  user.add(ac);
     
                    //button
                                            
               ss = new JButton("SAVE");
           ss.setBounds(100,580,130,80);
         user.add(ss); 
          ss.addActionListener(this);
         
         can = new JButton("CANCEL");
           can.setBounds(300,580,130,80);
         user.add(can); 
        can.addActionListener(this);
                                   
 add(user);
                    setTitle("Registration page");
         setSize(800,730);
         setVisible(true);
         setLayout(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
       
course();       
batch();
    }
  
               //courses
               public void course(){
        try {
            Class.forName("com.mysql.jdbc.Driver");    //this is method which register the deriver//  
                     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","Demo12345");
                     pst1 = con.prepareStatement("select * from course");
                     rs= pst1.executeQuery(); 
                      
                    tc.removeAllItems();
                    while(rs.next()){
                        tc.addItem(rs.getString("Coursename"));
                    }
      
        } catch (Exception ex) {
            System.out.print(ex);
        }
        
        
               }
               
               //batch
                     public void batch(){
        try {
            Class.forName("com.mysql.jdbc.Driver");    //this is method which register the deriver//  
                     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","Demo12345");
                     pst2 = con.prepareStatement("select * from batch");
                     rs= pst2.executeQuery(); 
                      
                    bc.removeAllItems();
                    while(rs.next()){
                        bc.addItem(rs.getString("batchname"));
                    }
      
        } catch (Exception ex) {
            System.out.print(ex);
        }
        
        
               }
   @Override
    public void actionPerformed(ActionEvent ae) {
try
{    if(ae.getSource()==can){
    this.hide();}    
      
    

 String fn= nm.getText();
  String ln= p.getText();
 String gen=ag.getText();
 
 String tele= rc.getText();
 String ad= ac.getText();

 String course =tc.getSelectedItem().toString();
  String batch =bc.getSelectedItem().toString();

 
        Class.forName("com.mysql.jdbc.Driver");    //this is method which register the deriver//  
        
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","Demo12345");
                     pst = con.prepareStatement("insert into registration(firstname,lastname,gender,course,batch,telephone,address)values(?,?,?,?,?,?,?)");
 pst.setString(1,fn);
              pst.setString(2,ln);
                            pst.setString(3,gen);
              pst.setString(4,course);
              pst.setString(5,batch);
                            pst.setString(6,tele);
                                          pst.setString(7,ad);



 pst.executeUpdate(); 


 JOptionPane.showMessageDialog(this,"Registration  created...");
              nm.setText("");
                 p.setText("");
                 ag.setText("");
                 rc.setText("");
                 ac.setText("");
                 tc.setSelectedIndex(-1);
                     bc.setSelectedIndex(-1);

                             nm.requestFocus();


}
catch(Exception e)
{
    System.out.println(e);
}   
    }

  
  


               public static void main(String a[])
    {
        
        registration r = new registration();
       
            
        }

   
    
}