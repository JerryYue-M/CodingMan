package com.coder.threads;

/**
 * Created by Administrator on 15-3-3.
 */
public class JavaDeamonThread {
    public static void main(String args[]){

        Thread t=new Thread(){
            int j=0;
            @Override
            public void run() {
                while(true){
                    j++;
                    System.out.println("the "+j+" times to println"+this.getName());
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t.setName("test deamon");
        t.setDaemon(true);
        t.start();
        TestRun();



    }
    public static void TestRun(){
        int i=0;
        while (i<20){
            i++;
            System.out.println("the "+i+" times to println");
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
