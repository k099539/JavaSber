package com.company;

public class Main {

    public static void main(String[] args) {
        String[] cars = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000",
                "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28",
                "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
        total_cost(cars);

    }

    private static void total_cost(String[] cars) {
        final double cost100 = 46.10;
        final double cost200 = 48.90;
        final double cost300 = 47.50;
        final double cost400 = 48.90;

        final double fuel100 = 12.5;
        final double fuel200 = 12;
        final double fuel300 = 11.5;
        final double fuel400 = 20;

        double oneKm100 = fuel100 * cost100 / 100;
        double oneKm200 = fuel200 * cost200 / 100;
        double oneKm300 = fuel300 * cost300 / 100;
        double oneKm400 = fuel400 * cost400 / 100;

        double sumFuel100 = 0;
        double sumFuel200 = 0;
        double sumFuel300 = 0;
        double sumFuel400 = 0;

        for (String str : cars) {
            String currentkm = str.substring(7).split("-")[0];

            switch (str.substring(1, 4)) {
                case "100": sumFuel100 += calc_cost(currentkm, oneKm100);
                    break;
                case "200": sumFuel200 += calc_cost(currentkm, oneKm200);
                    break;
                case "300": sumFuel300 += calc_cost(currentkm, oneKm300);
                    break;
                case "400": sumFuel400 += calc_cost(currentkm, oneKm400);
                    break;
                default:
            }
        }
        System.out.println("Общая стоимость расходов на ГСМ: " + (sumFuel100 + sumFuel200 + sumFuel300 + sumFuel400));
        System.out.println("Легковой авто: " + sumFuel100);
        System.out.println("Грузовой авто: " + sumFuel200);
        System.out.println("Пассажирский транспорт: " + sumFuel300);
        System.out.println("Тяжелая техника: " + sumFuel400);
    }

    public static double calc_cost(String onekm, double costonekm) {
        int a = Integer.parseInt(onekm);
        return costonekm * a;
    }
}

