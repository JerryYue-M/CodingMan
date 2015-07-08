package com.coder.Generics.animals;

/**
 * Created by Administrator on 14-12-28.
 */
public interface AmimalInfo<T> {
    void setAnimal(T t);
    T getAnimal();
    void PrintlnAnimal();
}
