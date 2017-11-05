package butelka;

/**
 *
 * @author Mariu
 */
public class Butelka {
    
    private double ileLitrow;
    private double pojemnosc;
    
    Butelka(double ileLitrow, double pojemnosc)
    {
        this.ileLitrow = ileLitrow;
        this.pojemnosc = pojemnosc;
    }   
    
    double getIleLitrow()
    {
        return ileLitrow;
    }
    
    double getPojemnosc()
    {
        return pojemnosc;
    }
    
    void wlej(double ilosc)
    {
        this.ileLitrow += ilosc;
    }
    
    boolean wylej(double ilosc)
    {
        if(ilosc <= ileLitrow)
            this.ileLitrow -= ilosc;
        else
            return false;
        
        return true;
    }
    
    void przelej (double ilosc, Butelka gdzieWylac, Butelka gdziePrzelac)
    {
        if(gdziePrzelac.pojemnosc >= (ilosc + gdziePrzelac.ileLitrow))
        {
            gdziePrzelac.wlej(ilosc);
            gdzieWylac.wylej(ilosc);
        }
        else if(gdziePrzelac.pojemnosc == gdziePrzelac.ileLitrow)
        {
            System.out.println("Zbyt dużo płynu checsz przelać do butelki docelowej!!!"); 
        }
        else
        {
            gdzieWylac.wylej(ilosc - (gdziePrzelac.pojemnosc - gdziePrzelac.ileLitrow));
            gdziePrzelac.wlej(gdziePrzelac.pojemnosc - gdziePrzelac.ileLitrow);
        }  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Butelka[] butelka = new Butelka[3];
        
        butelka[0] = new Butelka(5,10); 
        butelka[1] = new Butelka(8,10); 
        butelka[2] = new Butelka(10,10);
        
        butelka[0].wlej(4);
        butelka[1].przelej(4, butelka[2], butelka[1]);
        
        System.out.println("Ilość płynu: " + butelka[0].getIleLitrow() + " L, pojemność: " + butelka[0].getPojemnosc() + " L");
        System.out.println("Ilość płynu: " + butelka[1].getIleLitrow() + " L, pojemność: " + butelka[1].getPojemnosc() + " L");
        System.out.println("Ilość płynu: " + butelka[2].getIleLitrow() + " L, pojemność: " + butelka[2].getPojemnosc() + " L");
    }
    
}