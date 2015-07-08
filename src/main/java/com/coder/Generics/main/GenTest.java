package com.coder.Generics.main;

/**
 * Created by Administrator on 14-12-28.
 */
public class GenTest {

    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args){
        GenTest ge= new GenTest();
        ge.setObj("abc");
        String str=(String) ge.getObj();
        System.out.println(str);

    }
}
