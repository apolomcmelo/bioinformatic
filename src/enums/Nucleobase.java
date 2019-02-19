package enums;

public enum Nucleobase {
    ADENINE(0, "Adenine", "A"), CYTOSINE(1, "Cytosine", "C"), GUANINE(2, "Guanine", "G"), THYMINE(3, "Thymine", "T"), URACIL(4, "Uracil", "U");

    private int numberRepresentation;
    private String name;
    private String initials;

    private Nucleobase(int numberRepresentation, String name, String initials) {
        this.numberRepresentation = numberRepresentation;
        this.name = name;
        this.initials = initials;
    }

    public int getNumberRepresentation() {
        return numberRepresentation;
    }
    
    public String getName() {
        return name;
    }

    public String getInitials() {
        return initials;
    }

    public static Nucleobase getBaseComplement(Nucleobase nucleobase) {
        if (nucleobase.equals(ADENINE)) {
            return Nucleobase.THYMINE;
        }
        if (nucleobase.equals(THYMINE) || nucleobase.equals(URACIL)) {
            return Nucleobase.ADENINE;
        }
        if (nucleobase.equals(CYTOSINE)) {
            return Nucleobase.GUANINE;
        }
        if (nucleobase.equals(GUANINE)) {
            return Nucleobase.CYTOSINE;
        }

        return null;
    }

    public static Nucleobase getNucleobaseByName(String name) {
        for (Nucleobase nucleobase : Nucleobase.values()) {
            if (nucleobase.getName().equals(name)) {
                return nucleobase;
            }
        }

        return null;
    }

    public static Nucleobase getNucleobaseByInitials(String initials) {
        for (Nucleobase nucleobase : Nucleobase.values()) {
            if (nucleobase.getInitials().equals(initials)) {
                return nucleobase;
            }
        }

        return null;
    }
    
    public static Nucleobase getNucleobaseByNumberRepresentation(int numberRepresentation) {
        for (Nucleobase nucleobase : Nucleobase.values()) {
            if (nucleobase.getNumberRepresentation() == numberRepresentation) {
                return nucleobase;
            }
        }

        return null;
    }
}
