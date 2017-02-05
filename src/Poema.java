/**
 * Created by kszorin on 05.02.2017.
 */
public class Poema {
    private String text[]={"В (1)","лесу (2)", "родилась (3)", "ёлочка (4)", "В (5)", "лесу (6)", "она (7)", "росла (8)",
            "Зимой (9)", "и (10)", "летом (11)", "стройная (12)", "Зелёная (13)", "была (14)"};
    private int i;

    public Poema() {
        i=0;
    }
    public String getNext() {
        if (i<text.length) {
            return text[i++];
        }
        return null;
    }
}
