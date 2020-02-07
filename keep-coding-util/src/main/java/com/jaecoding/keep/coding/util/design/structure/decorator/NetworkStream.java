package com.jaecoding.keep.coding.util.design.structure.decorator;

public class NetworkStream extends Stream {

    private Stream stream;

    /**
     * 组合优于继承  A包含一个父类属性,并且拥有父类方法（可重写）
     *
     * @param stream
     */
    public NetworkStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public int read(int number) {
        return 0;
    }

    @Override
    public void seek(int position) {

    }

    @Override
    public void write(byte data) {

    }
}
