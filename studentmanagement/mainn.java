/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author kashish
 */
public class mainn extends JFrame implements  ActionListener {   
    
       JButton course;
       JButton batch;
       JButton regi;
    
    public mainn()
         
            
    {    
        //BUTTONS//
        
               course = new JButton("COURSE");
          course.setBounds(40,60,100,40);
           add(course); 
      course.addActionListener(this);

        
                  batch = new JButton("BATCH");
          batch.setBounds(220,360,100,40);
           add(batch); 
        batch.addActionListener(this);

       
               regi = new JButton("REGISTRATION");
           regi.setBounds(400,560,130,40);
         add(regi); 
        regi.addActionListener(this);
               setSize(700,700);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);}
  
       @Override
           public void actionPerformed(ActionEvent ae)
    {   
          
        try{
        
            
            if(ae.getSource() == course)
            { course c =new course(); 
            
            c.setVisible(true); 
            }
             if(ae.getSource() == batch)
             { batchh c =new batchh(); 
            
            c.setVisible(true); 
            }
              if(ae.getSource() == regi)
            { 
                
             registration r = new registration();
             r.setVisible(true);
            }
            
            
        }
        catch(Exception e){ System.out.println(e);
            
        }
        }
    
    
     public static void main(String a[]) {
        mainn n = new mainn();
           
    }
}
