package design.behavior.responsibility;

public class SpellCheckerProcessing<T> extends ProcessingObject<String> {

    @Override
    public String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
