/*
    Упражнение 5.2.
    Класс очереди для символов.
*/
class Queue {
    private char[] q; // Массив для хранения элементов очереди
    private int putloc, getloc; // Индексы для вставки и извлечения
                                // элементов очереди

    // Конструктор очереди заданного размера
    Queue(int size) {
        q = new char[size]; // выделить память под очередь
        putloc = getloc = 0;
    }

    // Поместить символ в очередь
    void put(char ch) {
        if (putloc == q.length) {
            System.out.println(" - Очередь переполнена.");
            return;
        }
        q[putloc++] = ch;
    }

    // Извлечь символ из очереди
    char get() {
        if (getloc == putloc) {
            System.out.println(" - Очередь пуста.");
            return (char) 0; // Возвращаем нулевой символ при пустой очереди
        }
        return q[getloc++];
    }
}