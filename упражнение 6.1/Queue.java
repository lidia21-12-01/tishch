/*
   Упражнение 6.1.
   Усовершенствованный класс очереди для символов,
   использующий private для инкапсуляции данных.
*/
class Queue {
    // эти члены теперь закрытые
    private char[] q; // Массив для хранения элементов очереди
    private int putloc, getloc; // Индексы для вставки и извлечения

    // Конструктор очереди заданного размера - делаем публичным
    public Queue(int size) {
        q = new char[size]; // выделить память под очередь
        putloc = getloc = 0;
    }

    // Поместить символ в очередь - делаем публичным
    public void put(char ch) {
        if (putloc == q.length) {
            System.out.println(" - Очередь переполнена.");
            return;
        }
        q[putloc++] = ch;
    }

    // Извлечь символ из очереди - делаем публичным
    public char get() {
        if (getloc == putloc) {
            System.out.println(" - Очередь пуста.");
            return (char) 0;
        }
        return q[getloc++];
    }
}