package com.coder.Generics.main;

/**
 * Created by Administrator on 14-12-28.
 */
public class GenTest1<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    public static void main(String[] args){
        GenTest1<String> gen=new GenTest1<String>();
        gen.setT("sfsfs");
        System.out.println(gen.getT());


    }
}
