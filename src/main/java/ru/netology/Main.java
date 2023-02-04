package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;

        while (true){

            System.out.println();
            System.out.println("Выберите операцию и введите ее номер:");
            System.out.println("1. Добавить новый доход: текущий суммарный доход равен " + earnings);
            System.out.println("2. Добавить новый расход: текущий суммарный расход равен " + spendings);
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();

            if ("end".equals(input)){
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {

                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String moneyStr = scanner.nextLine();
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;

                    case 2:
                        System.out.println("Введите сумму расхода:");
                        moneyStr = scanner.nextLine();
                        money = Integer.parseInt(moneyStr);
                        spendings += money;
                        break;

                    case 3:
                        if (taxEarningsMinunsSpendings(earnings, spendings) > taxEarnings(earnings)){
                            System.out.println();
                            System.out.println("Мы советуем вам УСН доходы");
                            System.out.println("Ваш налог составит: " + taxEarnings(earnings));
                            System.out.println("Налог на другой системе: " + taxEarningsMinunsSpendings(earnings, spendings));
                            System.out.println("Экономия: " + (taxEarningsMinunsSpendings(earnings, spendings) - taxEarnings(earnings)));
                        } else if (taxEarningsMinunsSpendings(earnings, spendings) < taxEarnings(earnings)) {
                            System.out.println();
                            System.out.println("Мы советуем вам УСН доходы минус расходы");
                            System.out.println("Ваш налог составит: " + taxEarningsMinunsSpendings(earnings, spendings));
                            System.out.println("Налог на другой системе: " + taxEarnings(earnings));
                            System.out.println("Экономия: " + (taxEarnings(earnings) - taxEarningsMinunsSpendings(earnings, spendings)));
                        } else if (taxEarningsMinunsSpendings(earnings, spendings) == taxEarnings(earnings)) {
                            System.out.println();
                            System.out.println("Обе УСН дают одинаковый налог");
                            System.out.println("Налог по любой из УСН составит: " + taxEarnings(earnings));
                        }
                        break;
                    default:
                        System.out.println("Такой операции нет");
                }
            }
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinunsSpendings (int earnings, int spendings){
        int tax = (earnings - spendings) * 15 / 100;
        if (tax > 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings (int earnings){
        int taxEarnings = earnings * 6 / 100;
        if (taxEarnings > 0) {
            return taxEarnings;
        } else {
            return 0;
        }
    }

}