/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class timer implements Runnable{
    int m,s;
    Thread t;
    javax.swing.JTextField time;
    timer(int m,int s,javax.swing.JTextField time)
    {
        this.m=m;
        this.s=s;
        this.time=time;
        t=new Thread(this,"timer");
        t.start();
    }
    public void run()
    {
        try{
            while(m!=0&&s!=0)
            {
                if(s==0)
                {
                    m--;
                    s=60;
                }
                if(s!=0)
                time.setText(m+":"+s);
                else
                time.setText(m+":00");
                s--;
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            System.out.println("Exception");}

    }
    
}
