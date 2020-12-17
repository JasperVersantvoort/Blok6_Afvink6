import java.util.ArrayList;
import java.util.Collections;

public class Short_superstring {
    public static void main(String[] args) {
        String fasta_input = ">Rosalind_56\n" +
                "ATTAGACCTG\n" +
                ">Rosalind_57\n" +
                "CCTGCCGGAA\n" +
                ">Rosalind_58\n" +
                "AGACCTGCCG\n" +
                ">Rosalind_59\n" +
                "GCCGGAATAC";

        String[] comby = new String[10];
        ArrayList<String> head = new ArrayList<String>();
        ArrayList<String> seq = new ArrayList<String>();

        comby = fasta_input.split("\n");
        for (String s : comby) {
            if (s.charAt(0) == '>') {
                head.add(s);
            } else {
                seq.add(s);
            }
        }
        StringBuilder overlap = new StringBuilder();

        // bepaal start sequentie
        ArrayList<Integer> cijfer_overlap = new ArrayList<Integer>();
        for (String x : seq) {
            int j = 0;
            for (String y : seq) {
                if (!x.equals(y)) {
                    for (int i = 1; i < x.length(); i++) {
                        String y_sub = y.substring(y.length() - i);
                        if (x.substring(0, i).equals(y_sub) && i > j) {
                            j = i;

                        }
                    }
                }
            }
            cijfer_overlap.add(j);
        }
        overlap.append(seq.get(cijfer_overlap.indexOf(Collections.min(cijfer_overlap))));
        seq.remove(cijfer_overlap.indexOf(Collections.min(cijfer_overlap)));

        // bepaal welke van de sequenties in seq het beste aansluit, deze word toegevoegd totdat de seq af is.
        while (seq.size() != 0) {
            int m = 0;
            String sub = "";
            String heel = "";
            for (String x : seq) {
                for (int i = 1; i < x.length(); i++) {
                    if (overlap.substring(overlap.length() - i).equals(x.substring(0, i)) && i > m) {
                        m = i;
                        sub = x.substring(i);
                        heel = x;


                    }
                }
            }
            overlap.append(sub);
            seq.remove(heel);
        }
        System.out.println(overlap);
    }
}




