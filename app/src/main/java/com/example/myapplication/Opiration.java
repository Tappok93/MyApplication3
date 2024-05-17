package com.example.myapplication;

public class Opiration {
    int firstMin;
    int firSecond;
    int secondMinut;
    int secSecond;
    int resultMin;
    int resultSec;

    public Opiration(int firstMin, int secMin, int firstSecond, int secSecond) {
        this.firstMin = firstMin;
        this.firSecond = secMin;
        this.secondMinut = firstSecond;
        this.secSecond = secSecond;
        this.resultMin = resultMin;
        this.resultSec = resultSec;
    }

    public String sumResult() {
        if (firstMin >= 0 && secondMinut >= 0) {
            resultMin = firstMin + secondMinut;
            if (firSecond >= 0 && secSecond >= 0) {
                resultSec = firSecond + secSecond;
                if (resultSec >= 60) {
                    Double temp = (double) (resultSec / 60);

                    int countMin = temp.intValue();
                    resultMin = resultMin + countMin;

                    double countSec = resultSec - 60;
                    resultSec = (int) countSec;
                }
            } else {
                System.err.println("Ошибка ввода!!!");
            }
        } else {
            System.err.println("Ошибка ввода!!!");
        }
        String string = resultMin + " минут " + resultSec + " секунд";

        return string;
    }

    public String differenceOpearation() {

        if (firstMin >= 0 && secondMinut >= 0) {
            resultMin = firstMin - secondMinut;
            if (firSecond >= 0 && secSecond >= 0) {
                resultSec = firSecond - secSecond;
                if (resultSec >= 60) {
                    Double temp = (double) (resultSec / 60);

                    int countMin = temp.intValue();
                    resultMin = resultMin - countMin;

                    double countSec = resultSec - 60;
                    resultSec = (int) countSec;
                }
            } else {
                System.err.println("Ошибка ввода!!!");
            }
        } else {
            System.err.println("Ошибка ввода!!!");
        }

        String string = resultMin + " минут " + resultSec + " секунд";

        return string;
    }

}
