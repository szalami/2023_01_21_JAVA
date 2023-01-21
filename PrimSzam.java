
package primszam;

public class PrimSzam {

    static boolean primE(int szam){
        int i = 2;              //a kettessel kezdjük a vizsgálatot, azért mert az 1 minden számban megvan
        while((szam%i != 0) && (i < Math.sqrt(szam))){  //addig vizsgálunk amíg nem találunk olyan számot ami az...
                                                          //...'i'-vel osztva nem ad maradékot, vagy el nem érjük a szám gyökét
                                                          // a '%' a maradékos osztás művelete...
                                                          //...pl.: 5%2 az egyet ad eredményül mert 5:2=2 maradék egy
            i++;                                          //növeljük az 'i'-t egyel
        }
        
        return !((szam%i) == 0);    //a '!' azt jelenti: megfordítjuk az értékét, azaz tagadjuk
                                    //ez ugyanazt csinálja mint a kommentel cucc rögtön lejjebb
//        if(szam%i == 0){
//            return false;
//        }else{
//            return true;
//        }
    }
    public static void main(String[] args) {  //itt indulunk szokás szerint
        
        int szam = 7;       //ezt a számot vizsgáljuk hogy prím-e?
        System.out.println("Az " + szam + " prím: " + primE(szam)); //kiírjuk és közben meghívjuk a vizsgáló függvényt
    }
    
}
