package ru.stormsar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);

        // Ввод даты с консоли и преобразование в формат Date
        System.out.print("Введите дату в формате dd.MM.yyyy: ");
        String inputDateStr = scanner.nextLine();
        Date date = sdf.parse(inputDateStr);

        // Увеличение даты на 45 дней
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 45);
        System.out.println("Дата после добавления 45 дней: " + sdf.format(cal.getTime()));

        // Сдвиг даты на начало года
        cal.set(Calendar.DAY_OF_YEAR, 1);
        System.out.println("Дата после сдвига на начало года: " + sdf.format(cal.getTime()));

        // Увеличение даты на 10 рабочих дней
        int workingDays = 0;
        while (workingDays < 10) {
            cal.add(Calendar.DATE, 1);
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workingDays++;
            }
        }
        System.out.println("Дата после добавления 10 рабочих дней: " + sdf.format(cal.getTime()));

        // Ввод второй даты с консоли
        System.out.print("Введите вторую дату в формате dd.MM.yyyy: ");
        String inputSecondDateStr = scanner.nextLine();
        Date secondDate = sdf.parse(inputSecondDateStr);

        // Подсчет количества рабочих дней между двумя датами
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(date);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(secondDate);

        int workDaysBetween = 0;
        while (startCal.before(endCal)) {
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workDaysBetween++;
            }
            startCal.add(Calendar.DATE, 1);
        }

        System.out.println("Количество рабочих дней между датами: " + workDaysBetween);
    }
}
