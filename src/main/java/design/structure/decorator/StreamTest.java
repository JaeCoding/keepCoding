package design.structure.decorator;

public class StreamTest {
    public static void main(String[] args) {
        Stream stream = new Stream();
        FileStream fileStream = new FileStream();
        MemoryStream memoryStream = new MemoryStream(fileStream);

        Stream stream1 = new MemoryStream(new FileStream());
    }
}
