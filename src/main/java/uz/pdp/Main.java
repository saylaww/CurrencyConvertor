package uz.pdp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uz.pdp.model.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TEST
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            URL url = new URL("http://www.cbu.uz/oz/arkhiv-kursov-valyut/json/");

            URLConnection urlConnection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            List<Currency> currencies = new ArrayList<Currency>(Arrays.asList(gson.fromJson(reader, Currency[].class)));

            Scanner scanner = new Scanner(System.in);
            boolean bool = true;
            while (bool){
                System.out.println("Valyuteni tanlang-");
                System.out.println("0 - Chiqish");
                System.out.println("1 - USD");
                System.out.println("2 - EUR");
                System.out.println("3 - RUB");

                int val = scanner.nextInt();
                switch (val){
                    case 0:{
                        bool = false;
                        break;
                    }
                    case 1:{
                        for (Currency currency : currencies) {
                            if (currency.getCcy().equals("USD")){
                                boolean b = true;
                                while (b){
                                    System.out.println("0 - Orqaga");
                                    System.out.println("1 - USD -> SUM");
                                    System.out.println("2 - SUM -> USD");

                                    int con = scanner.nextInt();
                                    switch (con){
                                        case 0:{
                                            b = false;
                                            break;
                                        }
                                        case 1:{
                                            System.out.println(currency.getCcy() + " ni miqdorini kiriting -");
                                            double cur = scanner.nextDouble();
                                            System.out.println(cur + " - " + currency.getCcy() + " : " +Double.parseDouble(currency.getRate()) * cur + " SUM bo'ladi");
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("SUM ni miqdorini kiriting - ");
                                            double cur = scanner.nextDouble();
                                            System.out.println(cur + " - SUM "  + " : " + cur / Double.parseDouble(currency.getRate())+ " USD bo'ladi");
                                            break;
                                        }
                                        default:{
                                            System.out.println("Xato kiritildi!!!");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case 2:{
                        for (Currency currency : currencies) {
                            if (currency.getCcy().equals("EUR")){
                                boolean b = true;
                                while (b){
                                    System.out.println("0 - Orqaga");
                                    System.out.println("1 - EUR -> SUM");
                                    System.out.println("2 - SUM -> EUR");

                                    int con = scanner.nextInt();
                                    switch (con){
                                        case 0:{
                                            b = false;
                                            break;
                                        }
                                        case 1:{
                                            System.out.println(currency.getCcy() + " ni miqdorini kiriting -");
                                            double cur = scanner.nextDouble();
                                            System.out.println(cur + " - " + currency.getCcy() + " : " +Double.parseDouble(currency.getRate()) * cur + " SUM bo'ladi");
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("SUM ni miqdorini kiriting - ");
                                            double cur = scanner.nextDouble();
                                            System.out.println(cur + " - SUM "  + " : " + cur / Double.parseDouble(currency.getRate())+ " EUR bo'ladi");
                                            break;
                                        }
                                        default:{
                                            System.out.println("Xato kiritildi!!!");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case 3:{
                        for (Currency currency : currencies) {
                            if (currency.getCcy().equals("RUB")){
                                boolean b = true;
                                while (b){
                                    System.out.println("0 - Orqaga");
                                    System.out.println("1 - RUB -> SUM");
                                    System.out.println("2 - SUM -> RUB");

                                    int con = scanner.nextInt();
                                    switch (con){
                                        case 0:{
                                            b = false;
                                            break;
                                        }
                                        case 1:{
                                            System.out.println(currency.getCcy() + " ni miqdorini kiriting -");
                                            double cur = scanner.nextDouble();
                                            System.out.println(cur + " - " + currency.getCcy() + " : " +Double.parseDouble(currency.getRate()) * cur + " SUM bo'ladi");
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("SUM ni miqdorini kiriting - ");
                                            double cur = scanner.nextDouble();
                                            System.out.println(cur + " - SUM "  + " : " + cur / Double.parseDouble(currency.getRate())+ " RUB bo'ladi");
                                            break;
                                        }
                                        default:{
                                            System.out.println("Xato kiritildi!!!");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    default:{
                        System.out.println("Xato kiritildi!!!");
                        break;
                    }
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
