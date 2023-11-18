package javaCamp.oop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // class yapısı için

//        CreditManager creditManager = new CreditManager();
//        creditManager.add();
//        creditManager.calculate();
//
//        MortgageManager mortgageManager = new MortgageManager();
//        mortgageManager.add();
//
//        Array örneği
//        CreditManager[] credits = new CreditManager[3];
//        credits[0] = new MortgageManager();
//        credits[1] = new VehicleManager();
//        credits[2] = new OfficerManager();
//
//        for (int i = 0; i < credits.length; i++) {
//            credits[i].calculate();
//        }

        // interface yapısı için

        // ArrayList örneği -> dizi'nin boyutlarını kendiniz vermiyorsunuz,
        // eleman eklendikçe kendisi güncelleniyor. Array'lere göre daha dinamik bir yapıda olduğu için bu daha kullanışlıdır.


        ArrayList<CreditManager> credits = new ArrayList<CreditManager>();
        credits.add(new MortgageManager());
        credits.add(new VehicleManager());
        credits.add(new OfficerManager());


        for (CreditManager credit : credits) {
            credit.calculate();
        }
    }
}
