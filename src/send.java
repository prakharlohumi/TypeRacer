/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class send extends Thread {
    OutputStream os;
    DataOutputStream dos;
    Socket socket;
    JTextArea txt;
    JButton b;
    String name;
    int pressed;
    send(JButton b1,JTextArea txt1,Socket s1,String n1)
    {
        pressed=0;
        name=n1;
        socket=s1;
        b=b1;
        txt=txt1;
    }
    
    private class clickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b)
            {
                pressed=1;
            }
        }
    }
    @Override
    public void run()
    {
        try {
            os=socket.getOutputStream();
            dos=new DataOutputStream(os);
            System.out.println("1 name "+name);
            Scanner sc=new Scanner(System.in);
            dos.writeUTF(name);
            //txt.setText("Type Here");
            while(1==1)
            {
                //System.out.println(name);
               clickListener click=new clickListener();
               b.addActionListener(click);
               //System.out.println(temp);
               if(pressed==1)
               {
                    pressed=0;
                    String temp=txt.getText();
                    if(temp.length()==0)
                    {
                        continue;
                    }
                    txt.setText("");
                    dos.writeUTF(temp);
                }
               b.removeActionListener(click);
            }
        } catch (IOException ex) {
            Logger.getLogger(send.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
}
