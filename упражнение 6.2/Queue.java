/*
   Упражнение 6.2.
   Класс очереди для символов с перегруженными конструкторами.
*/
class Queue {
    // эти члены теперь закрытые
    private char[] q; // Массив для хранения элементов очереди
    private int putloc, getloc; // Индексы для вставки и извлечения

    // Конструктор пустой очереди заданного размера
    public Queue(int size) {
        q = new char[size]; // выделить память под очередь
        putloc = getloc = 0;
    }

    // Конструктор объекта Queue на основе объекта Queue.
    public Queue(Queue ob) {
        putloc = ob.putloc;
        getloc = ob.getloc;
        q = new char[ob.q.length];

        // Копировать элементы.
        for (int i = getloc; i < putloc; i++)
            q[i] = ob.q[i];
    }

    // Конструктор объекта Queue с начальными значениями.
    public Queue(char[] a) {
        putloc = 0;
        getloc = 0;
        q = new char[a.length];

        for (int i = 0; i < a.length; i++)
            put(a[i]);
    }

    // Поместить символ в очередь
    public void put(char ch) {
        if (putloc == q.length) {
            System.out.println(" - Очередь переполнена.");
            return;
        }
        q[putloc++] = ch;
    }

    // Извлечь символ из очереди
    public char get() {
        if (getloc == putloc) {
            System.out.println(" - Очередь пуста.");
            return (char) 0;
        }
        return q[getloc++];
    }
}