import java.util.ArrayList;

public class Overlap_Graphs {
    public static void main(String[] args) {
        String fasta_input = ">Rosalind_0498\n" +
                "AAATAAA\n" +
                ">Rosalind_2391\n" +
                "AAATTTT\n" +
                ">Rosalind_2323\n" +
                "TTTTCCC\n" +
                ">Rosalind_0442\n" +
                "AAATCCC\n" +
                ">Rosalind_5013\n" +
                "GGGTGGG";

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
        for (String x : seq) {
            for (String y : seq) {
                if (!x.equals(y)) {
                    if (x.substring(0, 3).equals(y.substring(4))) {
                        System.out.println(head.get(seq.indexOf(y)) + " --> " + head.get(seq.indexOf(x)));

                    }

                }
            }
        }

    }
}
