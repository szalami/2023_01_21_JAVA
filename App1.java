// a program futása a main függvénnyel indul nem itt.

package app1;

public class App1 {

    static void tombKiIr(int[] tomb) {  // (VI.) 
        tombKiIr(tomb, tomb.length);     // átadjuk a másik 'tombKiIr' függvénynek a tömbünket és annak a hosszát
    }                                           //ezt azért csinljuk, mert így meg lehet hívni a tömböt anélkül is hogy megadnánk azt...
                                                //..hogy bizonyos számú elemet írjon ki
                                                //ha így hívjuk meg hogy 'tombKiIr(tomb)' akkor megnézi hogy milyen hosszú a tömb..
                                                //...és továbbadja a tombbel együtt a (VII.) -es függvénynek
                                                //...ha úgy hívjuk meg hogy pl.: 'tombKiIr(tomb, hossz)' akkor alapbó a (VII.)-est...
                                                //...hívja, mert látja hogy egy tömböt és egy számot vár a függvény
    
    static void tombKiIr(int[][] tomb) {    // (V.) ez a többdimenziós tömb kiíratója
        for (int i = 0; i < tomb.length; i++) { //végigmegyünk a tömb elemein és mivel a tomb.length a többdimenziós tömböknél...
            tombKiIr(tomb[i]);                  //...csak egy sor hosszát jelenti ezért a ciklus a sorokon megy végig...
        }                                       //...amik ugye már csak egydimenziósak, így a sima tömbKiIr azokat meg tudja jeleníteni
        
    }
    //a többdimenziós tömböknél pl.: int[a][b] az 'a' jelű jelenti a sorokat, a 'b' jelű pedig azt hogy hány sorunk van
    //így kell elképzelni:pl.: int[5][3]         1  2  3  4  5
    //                                           6  7  8  9 10
    //                                          11 12 13 14 15
    //
    //ha hivatkozni akarok mondjuk a fentinél a '9'-es számra akkor így: int[2][4] azaz a második sor negyedik eleme
    
    static void tombKiIr(int[] tomb, int elemSzam) {  // (VII.) megkapja a tömbjét és hogy abból hány elemet kell kiírni 
        for (int i = 0; i < elemSzam; i++) {          //végigmegyünk a tömb elemein...
            System.out.print(tomb[i] + "; ");         //...és kiírjuk egyesével
        }
        System.out.println("");
    }
                                                                // ha void van az eljárásban az azt jelenti hogy nem küld vissza...
                                                                //..adatot, csak elvégez egy/több műveletet
    static void tombInit(int[] tomb, int also, int felso) {     // (I.) az eljárás megkapja a tömböt amit fel kell tölteni és a két értékhatárt...
                                                                //...amit a main-ban maegadtunk
        for (int i = 0; i < tomb.length; i++) {       //végigmegyünk a tömb elemein...
            tomb[i] = (int) Math.round(Math.random() * (felso - also)) + also;  //...és feltöltjük a két érték közötti véletlenszámokkal
        }                                                       
    }
    
    static void tombInit(int[][] tomb, int ertek) {  //megkapja a tömböt és azt hogy milyen értéket kapjon, itt minden elem ugyanazt...
                                                     //...az értéket kapja meg, de lehetne akár véletlenszám is mint az előzőnél
        for (int i = 0; i < tomb.length; i++) {      //végigmegyünk a tömb sorain
            for (int j = 0; j < tomb[i].length; j++) {//azon belül a sorok elemein
                tomb[i][j] = ertek;                 //és feltöltjük a megadott értékkel
            }           //ezt úgy hívják hogy egymásba ágyazott ciklus
                        //a külső ciklus /az 'i'-s/ csak akkor növeli az értékét ha a belső 'j' már lefutott
                        //ilyen értékei lesznek monjuk egy 3x3 tömbnél: (i=0, j=0); (i=0, j=1); (i=0,  j=2); (i=1, j=0); (i=1, j=1);
                        //(i=1, j=2); (i=2, j=0) ...
        }
    }
                                            //azért static int mert a függvény visszatérési értéke egész szám
    static int minKivalaszt(int[] tomb) {   // (II.) ez is megkapja  a kedvenc feltöltött tömbünket
        int lkh = 0;                        // létrehozunk egy változót amiben a tömbnek azt az indexét tároljuk amelyik...
                                            //...legkisebb számot tárolja
        for (int i = 1; i < tomb.length; i++) { //végigmegyünk a tömb elemein
            if (tomb[i] < tomb[lkh]) {      // ha találunk benne olyan számot ami kisebb, akkor az indexét átrakjuk a változóbA
                lkh = i;
            }
        }
        return lkh;                         //visszaküldjük a változót
    }

    static int tombOsszeAd(int[] tomb) {    // (III.) ez is static int mert egész számmal tér vissza
        int sum = 0;                        // adunk egy kezdőértéket annak a változónak amit majd visszaküldünk
        for (int i = 0; i < tomb.length; i++) { //végigmegyünk a tömb elemein
            sum += tomb[i];                 // a ciklus minden fordulójában hozzáadjuk az 'i' indexű tömbelem értékét
        }
        return sum;                         //visszatérünk az eredménnyel
    }

    static int keres(int[] tomb, int num) { // (IV.) megkapja a függvény a tömböt meg a keresendő számot
        int hely = -1;                      // alapból -1-re állítjuk a visszatérési értéket, ha ez megy vissza az azt jelenti...
                                            //...hogy nincs a tömbben a keresett érték
        for (int i = 0; i < 10; i++) {      //végigmegyünk a tömb elemein
            if (tomb[i] == num) {           //ha az 'i' indexű elem egyenlő a keresett számmal akkor...
                hely = i;                   //...átadjuk az értéket a 'hely' változónak és...
                break;                      //...kilépünk a ciklusból, mert fölösleges tovább keresni ha már van
            }
        }
        return hely;                        //visszatérünk az eredménnyel
    }

    static void buborek(int[] tomb) {       //ez a sorbarendező eljárás, ezt nem csináltuk
        int len = tomb.length;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (tomb[j] > tomb[j + 1]) {
                    int temp = tomb[j];
                    tomb[j] = tomb[j + 1];
                    tomb[j + 1] = temp;
                }
            }
        }
        System.out.println("");
        System.out.println("Sorban: ");
        tombKiIr(tomb);
    }
/--------------------------------------innen indul a program futása---------------------------------------
// zárójelbe római számokkal jelöltem az eljárásokat és az őket meghívó parancsot
    
    public static void main(String[] args) {
        /*
        int[] tomb = new int[10];       
 
        tombKiIr(tomb);
        tombKiIr(tomb, 5);
         */
        int[] szamok = new int[20];     // 1. létrehozunk egy egész számokból (int[]) álló tömböt 20 elemmel
        //tombKiIr(szamok);

        int also = 1, felso = 20;       //2. megadjuk hogy melyik két szám között legyenek majd a véletlenszámok
        tombInit(szamok, also, felso);  //3. átadjuk ezeket a tombInit függvénynek (eljárásnak)
        System.out.println("A számaink " + also + " és " + felso + " között: ");
        tombKiIr(szamok);           // 4. a véletlenszámokkal feltöltött tömböt átadjuk annak az eljárásnak (VI.)amelyik kiírja a konzolra
        buborek(szamok);            // ez nem kell, ezt csak magamnak csináltam - amúgy ez rendezi sorba a számokat- buborék sorbarandezésnek...
                                        //...nevezzük ezt a fajta sorbarendezést ezért ez a neve.

        System.out.println("Legkisebb: " + szamok[minKivalaszt(szamok)]);   // a legkisebb szám kiírásához meghívjuk a hozzá... 
                                                                                //...tartozó függvényt (II.)
        System.out.println("Tömb elemeinek összege: " + tombOsszeAd(szamok)); // (III.) meghívjuk az összeadó függvényt

        int keresett = 5;               // (IV.) meghatározunk egy számot amit megnézünk hogy van-e a tömbünkben
        System.out.println("A keresett szám=" + keresett + " tömbbeli indexe: " + keres(szamok, keresett));//meghívjuk
        System.out.println("");

        int[] t = {1, 5, 6, 123, 4};    //egy tömböt így is létrehozhatunk

        int[][] td = {      //ez egy többdimenziós tömb 3 sora és 3 oszlopa van
            {1, 2, 3},
            {4, 5, 6}
        };
        //System.out.println(td.length);
        
        tombKiIr(td);   // (V.) meghívjuk a többdimenziós tömbre létrehozott függvényt, ugyan ugyanaz a neve mint az egydimenziós...
                            //...kiírató függvénynek, de tudja hogy melyiket kell meghívni az átadott értékből...
                            //... itt int[][] típusú az átadott érték, a simánál meg int[]
        int[][] probaTomb = new int[10][15];
        tombInit(probaTomb, 8); // kétdimenziós tömb feltöltő eljárás meghívása (VIII.)
        tombKiIr(probaTomb);    //kiíratjuk a kétdimenziós tömbünket
    }
}
