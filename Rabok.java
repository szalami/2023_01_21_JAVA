
package rabok;


public class Rabok {

    static void forditZar(boolean[] nyitva, int n){ //megkapta a tömböt és a cellák számát
        for (int i = 1; i <= n; i++) {      //ez is egymásba ágyazott ciklus, végigmegyünk a cellákon
            for (int j = 0; j < n; j = j + i) { //az ajtókat nyitogatjuk vagy zárjuk először egyesével, azután kettesével...ezerig
                nyitva[j] = !nyitva[j]; //ha nyitva akkor bezárjuk, ha csukva akkor nyitjuk
                                        // a !nyitva azt elenti hogy tagadjuk, azaz ha 'true' volt 'false' lesz és fordítva
            }
        }
    }
    
    static void kiIr(boolean[] tomb, int n){    //megkapta a tömböt és a cellák számát
        for (int i = 0; i < n; i++) {
            if(tomb[i] == true){                // ha a cella nyitva azaz 'true'
                System.out.print(i + ", ");     // akkor kiírjuk hogy mi az tömb indexe azaz a 'cella ajtaja'
            }
        }
    }
    
    static void negyzetSzamok(int szam){
        int i = 1;
        while(i * i < 1000){
            System.out.print((i * i) + ", ");
            i++;
        }
    }
    
    public static void main(String[] args) {    //mindig itt indul a program
        
        int cellakSzama = 1000;                 //a cellák száma ezer
        boolean[] nyitva = new boolean[cellakSzama];    //boolean tömböt(true-false) hozunk létre, annyi elemmel amennyi a cellák száma
        forditZar(nyitva, cellakSzama); //meghívjuk a zárfordítót, ami megkapja a tömböt és a cellák számát
        
        System.out.println("Nyitva levő cellák:");
        kiIr(nyitva, cellakSzama);  //ez kiírja a nyitott cellák számát
        System.out.println("");
        negyzetSzamok(1000);        
    }
    
}
