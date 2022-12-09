package com.company;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class platnosci {
    public static void cash(String[] args) {
    int sposPlatnosci;
    double reszta = 0;
    int a = 0;
    int b;
    double zaplata = 0;
    int zaplata1 = 0;
    ArrayList<Integer> banknoty = new ArrayList<Integer>();
    Scanner myObj = new Scanner(System.in);
    Random rnd = new Random();
    double am = rnd.nextInt(10000) / 100.0;
    double amount = Math.round(Math.random() * 100000) / 100.0; //0,984187687253;      879.82
    boolean doRepeat = false;
    do {
        System.out.print("Do zaplaty: " + am + " Wybierz sposob platnosci:\n1. Karta\n2. BLIK\n3. Gotowka\nWpisz liczbe odpowiadajaca Twojemu wyborowi: ");
        String input1 = myObj.nextLine();

        try {
            sposPlatnosci = Integer.parseInt(input1);//licba - OK; litery - EXCEPTION!!!!
        } catch (NumberFormatException e) {
            sposPlatnosci = 0;
        }


        if (sposPlatnosci == 1) {
            System.out.println("wybrales sposob platnosci: Karta");
            doRepeat = true;
        } else if (sposPlatnosci == 2) {
            System.out.println("wybrales sposob platnosci: Blik");
            doRepeat = true;
        } else if (sposPlatnosci == 3) {
            System.out.println("wybrales sposob platnosci: Gotowka");
            doRepeat = true;
        } else {
            System.out.println("wybierz sposob platnosci od 1 do 3: ");
            try {
                sposPlatnosci = Integer.parseInt(input1);//licba - OK; litery - EXCEPTION!!!!
            } catch (NumberFormatException e) {
                sposPlatnosci = 0;
            }
            doRepeat = false;
        }
        System.out.println("Wybrales: " + sposPlatnosci);
    } while (doRepeat == false);

    if (sposPlatnosci == 3) {
        System.out.println("kwota do zplaty wysosi: " + am);
        while(zaplata1 <= am) {
            while (a < 1) {
                System.out.println("Podawaj banknoty pojeynczo");
                System.out.println("Jesli podales wszystkie banknoty wpisz numer 0");
                b = Integer.parseInt(myObj.nextLine());
                if (b == 0) {
                    if(zaplata1 >= am){
                        a++;
                    }else{
                        System.out.println("Podano za malo banknotow !!!");
                    }

                } else if (b == 10 || b == 20 || b == 50 || b == 100 || b == 200 || b == 500) {
                    banknoty.add(b);
                    zaplata1 += b;
                    //System.out.println("Podawaj tylko istniejace banknoty :)");
                } else {
                    System.out.println("Podawaj tylko istniejace banknoty :)");
                    //banknoty.add(b);
                    //zaplata1 += b;
                }

            }
        }
        for (int i : banknoty) {
            zaplata+=i;
        }
        System.out.println("zaplaciles: " + zaplata1);
        System.out.println("koszt wynosil: " + am);
        double c = am;
        reszta = zaplata-c; 
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println("Reszta wynosi: " + df.format(reszta) );
    }
}
}

