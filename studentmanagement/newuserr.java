/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author kashish
 */
       
   
            
        


public class newuserr extends JFrame implements ActionListener 
{
                  
    JPanel user ;

    Connection con ;
    
    JTextField nm;
    JPasswordField p;
     JPasswordField Cp;
     JButton can;
     JButton add;
          JButton bl;

     JTextField type ;
    public newuserr()
    {  
//Panel
        
      
      
    
         user = new JPanel();
         user.setLayout(null);
          user.setSize(400,350);
         user.setBackground(Color.ORANGE);
         user.setBounds(190,155,500,450);
        
//username
        
        JLabel name = new JLabel("UserName :");
         
         name.setBounds(70,50,100,50);
         
      user.add(name); 
      
         
          nm = new JTextField("");
         nm.setBounds(190,50,300,50);
                  nm.setBackground(new Color(210,180,140));

         user.add(nm);
      
//password
       JLabel pas = new JLabel("Password :");
         
         pas.setBounds(70,130,100,50);
         
      user.add(pas); 
            
       p= new JPasswordField("");
               p.setBounds(190,130,300,50);

                  p.setBackground(new Color(210,180,140));
                  user.add(p);
//cofirm pass    
     
   JLabel cp = new JLabel("Confirm Password :");
         
         cp.setBounds(70,200,200,50);
         
      user.add(cp); 
        
      Cp= new JPasswordField("");
       Cp.setBounds(190,200,300,50);
                  Cp.setBackground(new Color(210,180,140));
                  user.add(Cp);
//usertype
   JLabel ut = new JLabel("UserType :");
         
         ut.setBounds(70,270,100,50);
         
      user.add(ut); 
      
      type = new JTextField("Enter only one (admin/user)");
        type.setBounds(190,270,300,50);
                  type.setBackground(new Color(210,180,140));
                  user.add(type);
                  
  //button//                //add and cancel button
                  
                    add = new JButton("ADD");
         add.setBounds(40,360,100,40);
         user.add(add);
        
      add.addActionListener(this);
   
      
                   
             can = new JButton("CANCEL");
         can.setBounds(340,360,100,40);
         user.add(can);
        can.addActionListener(this);

         bl = new JButton("Back to Login");
        bl.setBounds(170,400,150,40);
        user.add(bl);
        bl.addActionListener(this);
//frame 
         add(user);
        setTitle("NEW USER");
         setSize(800,700);
         setLayout(null);
          setVisible(true);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
    }         

    /**
     *
     * @param ae
     */
    public void actionPerformed(ActionEvent ae)    
    {   
            if(ae.getSource()==bl){
           login l = new login();
           l.setVisible(true);
       } 
           if(ae.getSource() == can)
           {
                this.hide();         //for cancelling
            }
        if(nm.getText().length() == 0)
         {
    JOptionPane.showMessageDialog(this,"Please type the username");        
        }
       else if(p.getText().length() == 0)
        {
    JOptionPane.showMessageDialog(this,"Please type the Password");        
        } 
       else if(p.getText().equals(Cp.getText())==false)
        {
            JOptionPane.showMessageDialog(this,"Password not match");     
        }
       
       //Database//
       else 
       { 
           try
           {   
               
              String username= nm.getText();
                            String confirmpass= Cp.getText();
              String usertype= type.getText();

                                
                  Class.forName("com.mysql.jdbc.Driver");    //this is method which register the deriver//  
        
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","Demo12345");
       
              PreparedStatement st = con.prepareStatement("insert into user(username,password,utype)values(?,?,?) ");
                  st.setString(1, username);
                                   st.setString(2,confirmpass);
                  st.setString(3, usertype);

               st.executeUpdate();
                       JOptionPane.showMessageDialog(null,"User created");     
                nm.setText("");
                           Cp.setText("");
                type.setText("");
                p.setText("");
nm.requestFocus();
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
           
       }



    }
    
  
    
    public static void main(String a[]) {
        
        new newuserr();
        
    }
}
