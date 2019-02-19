package bioinformatic;

public class Complement {
    public static String getReverseComplement(String p) {
        StringBuilder sb = new StringBuilder();
        String b = "ACGT";

        for (int i = p.length() - 1; i >= 0; i--) {
            sb.append(b.charAt(0x3 - b.indexOf(p.charAt(i))));
        }

        return sb.toString();
    }
}
