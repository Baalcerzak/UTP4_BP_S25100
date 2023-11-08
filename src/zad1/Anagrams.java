/**
 *
 *  @author Balcerzak Piotr S25100
 *
 */

package zad1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Anagrams {

    List<String> words = new ArrayList<String>();

    List<List<String>> listaAn = new ArrayList<List<String>>();
    public Anagrams(String allWords) throws FileNotFoundException {
        Scanner s = new Scanner(new File(allWords));
        while (s.hasNext()){
            words.add(s.next());
        }
        s.close();
    }

    public List<List<String>> getSortedByAnQty() {

        for (String wzor :
                words) {
            ArrayList<String> an = new ArrayList<String>();
            char[] ch = wzor.toCharArray();
            Arrays.sort(ch);
            String temp2 = new String(ch);
            for (String slowo :
                    words) {
                char[] cha = slowo.toCharArray();
                Arrays.sort(cha);
                String temp = new String(cha);
                if (temp2.equals(temp)) {
                    an.add(slowo);
                }
            }
            boolean flag = false;
            for (List<String> lista:
                 listaAn) {
                if(lista.contains(wzor)){
                    flag = true;
                }
            }
            if(!flag){
                listaAn.add(an);
            }

        }
        int n = listaAn.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listaAn.get(j).size() < listaAn.get(j + 1).size()) {
                    List<String> temp = listaAn.get(j);
                    listaAn.set(j, listaAn.get(j + 1));
                    listaAn.set(j + 1, temp);
                }
            }
        }

        return listaAn;
    }

    public String getAnagramsFor(String word){
        if(!words.contains(word)) return word + ": null";

        char[] chars0 = word.toCharArray();
        Arrays.sort(chars0);
        String temp = new String(chars0);

        ArrayList<String> l1 = new ArrayList<>();
        for (String w:
                words) {
            char[] chars1 = w.toCharArray();
            Arrays.sort(chars1);
            String tempSlowo = new String(chars1);
            if (tempSlowo.equals(temp)){
                l1.add(w);
            }
        }
        l1.removeIf(w -> w.equals(word));
        return word + ": " + l1;
    }
}
