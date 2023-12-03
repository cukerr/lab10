import java.util.*;

class CalendarDate implements Comparable<CalendarDate> {
    private int year;
    private int month;
    private int day;

    public CalendarDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return String.format("%04d/%02d/%02d", year, month, day);
    }

    @Override
    public int compareTo(CalendarDate otherDate) {
        if (this.year != otherDate.year) {
            return Integer.compare(this.year, otherDate.year);
        } else if (this.month != otherDate.month) {
            return Integer.compare(this.month, otherDate.month);
        } else {
            return Integer.compare(this.day, otherDate.day);
        }
    }

    public static void main(String[] args) {
        // Создание объектов CalendarDate
        CalendarDate date1 = new CalendarDate(2023, 11, 29);
        CalendarDate date2 = new CalendarDate(2023, 10, 15);
        CalendarDate date3 = new CalendarDate(2022, 5, 10);

        // Добавление их в список
        List<CalendarDate> datesList = new ArrayList<>();
        datesList.add(date1);
        datesList.add(date2);
        datesList.add(date3);

        // Сортировка списка по возрастанию
        Collections.sort(datesList);

        // Вывод содержимого списка в консоль с помощью цикла foreach
        for (CalendarDate date : datesList) {
            System.out.println(date);
        }

        // Сортировка списка по убыванию
        datesList.sort(Collections.reverseOrder());

        // Вывод содержимого списка в консоль с помощью цикла foreach
        for (CalendarDate date : datesList) {
            System.out.println(date);
        }
    }

}
