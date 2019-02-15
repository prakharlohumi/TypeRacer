/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.*;
import java.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
public class recieve extends Thread {
    InputStream is;
    DataInputStream dis;
    JTextArea chat;
    Socket socket;
    recieve(Socket socket1,JTextArea a1)
    {
        socket=socket1;
        chat=a1;
    }
    @Override
    public void run()
    {
        try {
            is=socket.getInputStream();
            dis=new DataInputStream(is);
            System.out.println("2 nameasd ");
            String name=dis.readUTF();
            System.out.println("2 name "+name);
            chat.setText("Connected to: "+name);
            while(1==1)
            {
                String s=dis.readUTF();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                Date date = new Date();
                chat.setText(chat.getText()+"\n"+formatter.format(date)+" : "+name+" :: "+s);
                //System.out.println(formatter.format(date)+" :: "+s);
            }
        } catch (IOException ex) {
            Logger.getLogger(recieve.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
