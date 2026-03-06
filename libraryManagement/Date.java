import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Date {
    public int differenceDate(String date_kucuk,String date_buyuk){
        ArrayList<String> list_date_kucuk=new ArrayList<>(Arrays.asList(date_kucuk.split("/")));
        ArrayList<String> list_date_buyuk=new ArrayList<>(Arrays.asList(date_buyuk.split("/")));
        int kucuk_gun=Integer.parseInt(list_date_kucuk.get(0));
        int kucuk_ay=Integer.parseInt(list_date_kucuk.get(1));
        int buyuk_gun=Integer.parseInt(list_date_buyuk.get(0));
        int buyuk_ay=Integer.parseInt(list_date_buyuk.get(1));

        int gunler_farki= buyuk_gun-kucuk_gun;
        int aylar_farki=buyuk_ay-kucuk_ay;
        return aylar_farki*30+gunler_farki;
    }
}