/*
   Упражнение 1.2
   Эта программа отображает таблицу преобразований галлонов в литры.
   Назовите этот файл GalToLitTable.java.
*/
class GalToLitTable {
    public static void main(String[] args) {
        double gallons, liters;
        int counter;

        counter = 0; // Инициализируем счетчик строк нулем
        for (gallons = 1.0; gallons <= 100.0; gallons++) {
            liters = gallons * 3.7854; // преобразуем в литры
            System.out.println(gallons + " галлонов соответствует " +
                    liters + " литрам.");

            counter++; // Увеличиваем счетчик строк
            // Каждые 10 строк выводим пустую строку
            if (counter == 10) {
                System.out.println(); // Вывод пустой строки
                counter = 0; // Сбрасываем счетчик строк
            }
        }
    }
}