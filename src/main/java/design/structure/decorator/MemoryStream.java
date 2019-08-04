package design.structure.decorator;

/**
 * @author Jae
 * 扩展操作，必须传入一个流
 */
public class MemoryStream extends Stream {

    /**
     * 装饰者模式的关键在此
     */
    private Stream stream;

    public MemoryStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public int read(int number) {
        //TODO 额外的储存操作
        return stream.read(number);
    }

    @Override
    public void seek(int position) {
        //TODO 额外的储存操作
        stream.seek(position);
    }

    @Override
    public void write(byte data) {
        //额外的储存操作
        stream.write(data);
    }
}
