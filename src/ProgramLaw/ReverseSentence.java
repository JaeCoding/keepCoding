package ProgramLaw;


/**
 * change "I am a student." to "student. a am I"
 */
public class ReverseSentence {

    public static StringBuffer reverseSentence(String s) {
        if(s == null || s.length() == 0) return null;
        StringBuffer sb = new StringBuffer();
        //记录一下单词起始位置
        for (int i = s.length() - 1, j = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, j + 1));
                sb.append(" ");
                j = i;
            }
            if (i == 0) {
                sb.append(s.substring(i, j + 1));
            }
        }
        return sb;
    }


    public static void main(String[] args) {
        String s = "billId is null.";
        s = String.valueOf(reverseSentence(s));
        System.out.println(s + "");
    }
}
