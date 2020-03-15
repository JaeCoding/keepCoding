package com.jaecoding.keep.coding.util.design.structure.decorator;

/**
 * @author Jae
 * 基础操作 可以直接用
 */
public class FileStream extends Stream {


    @Override
    public int read(int number) {
        return 10;
    }

    @Override
    public void seek(int position) {

    }

    @Override
    public void write(byte data) {

    }
}
