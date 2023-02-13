package ru.netology.javaqa.javaqamvn.ru.netology.stats;

public class StatsService {

    //Сумму всех продаж//
    public long amount(long[] sales) {
        long total = 0;
        for (long sale : sales) {
            total += sale;
        }
        return total;
    }

    //Среднюю сумму продаж в месяц//
    public long average(long[] sales) {
        return amount(sales) / 12;
    }

    // Номер месяца, в котором был пик продаж, то есть осуществлены продажи на максимальную сумму//
    public int maxSales(long[] sales) {
        int maxMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[maxMonth] - продажи в месяце maxMonth
            // sale - продажи в рассматриваемом месяце
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return maxMonth + 1;
    }

    //Номер месяца, в котором был минимум продаж, то есть осуществлены продажи на минимальную сумму//
    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }

    //Количество месяцев, в которых продажи были ниже среднего//
    public int minMonth(long[] sales) {
        long average = average(sales);
        int counter = 0;
        for (long sale : sales) {
            if (sale < average) {
                counter++;
            }
        }
        return counter;
    }

    //Количество месяцев, в которых продажи были выше среднего//
    public int maxMonth(long[] sales) {
        long average = average(sales);
        int counter = 0;
        for (long sale : sales) {
            if (sale > average) {
                counter++;
            }
        }
        return counter;
    }
}
