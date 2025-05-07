// Класс для представления очереди символов фиксированного размера.
class FixedQueue implements ICharQ {
    private char[] q; // массив, в котором хранится очередь
    private int putloc, getloc; // индексы для позиций помещения и извлечения

    // Конструктор пустой очереди заданного размера.
    public FixedQueue(int size) {
        q = new char[size]; // выделение памяти под очередь
        putloc = getloc = 0;
    }

    // Поместить символ в очередь.
    public void put(char ch) {
        if (putloc == q.length) {
            System.out.println(" - Очередь переполнена.");
            return;
        }
        q[putloc++] = ch;
    }

    // Извлечь символ из очереди.
    public char get() {
        if (getloc == putloc) {
            System.out.println(" - Очередь пуста.");
            return (char) 0;
        }
        return q[getloc++];
    }
}

// Кольцевая очередь.
class CircularQueue implements ICharQ {
    private char[] q; // массив, в котором хранится очередь
    private int putloc, getloc; // индексы для позиций помещения и извлечения

    // Конструктор пустой очереди заданного размера.
    public CircularQueue(int size) {
        q = new char[size + 1]; // выделение памяти под очередь
        putloc = getloc = 0;
    }

    // Поместить символ в очередь.
    public void put(char ch) {
        /*
         * Очередь переполнена, если либо putloc на единицу меньше getloc,
         * либо putloc указывает на конец массива, а getloc - на его начало
         */
        if (putloc + 1 == getloc | ((putloc == q.length - 1) & (getloc == 0))) {
            System.out.println(" - Очередь переполнена.");
            return;
        }
        q[putloc++] = ch;
        if (putloc == q.length)
            putloc = 0; // закольцевать
    }

    // Извлечь символ из очереди.
    public char get() {
        if (getloc == putloc) {
            System.out.println(" - Очередь пуста.");
            return (char) 0;
        }
        char ch = q[getloc++];
        if (getloc == q.length)
            getloc = 0; // закольцевать
        return ch;
    }
}

// Динамическая очередь.
class DynQueue implements ICharQ {
    private char[] q; // массив, в котором хранится очередь
    private int putloc, getloc; // индексы для позиций помещения и извлечения

    // Конструктор пустой очереди заданного размера.
    public DynQueue(int size) {
        q = new char[size]; // выделение памяти под очередь
        putloc = getloc = 0;
    }

    // Поместить символ в очередь.
    public void put(char ch) {
        if (putloc == q.length) {
            // Увеличить размер очереди.
            char[] t = new char[q.length * 2];
            // Скопировать элементы в новую очередь.
            for (int i = 0; i < q.length; i++)
                t[i] = q[i];
            q = t;
        }
        q[putloc++] = ch;
    }

    // Извлечь символ из очереди.
    public char get() {
        if (getloc == putloc) {
            System.out.println(" - Очередь пуста.");
            return (char) 0;
        }
        return q[getloc++];
    }
}

// Демонстрация использования интерфейса ICharQ.
class IQDemo {
    public static void main(String[] args) {
        FixedQueue q1 = new FixedQueue(10);
        DynQueue q2 = new DynQueue(5);
        CircularQueue q3 = new CircularQueue(10);

        ICharQ iQ; // Ссылка на интерфейс

        char ch;
        int i;

        iQ = q1;
        // Поместить ряд символов в очередь фиксированного размера.
        System.out.println("Помещение символов в FixedQueue:");
        for (i = 0; i < 10; i++)
            iQ.put((char) ('A' + i));

        // Отобразить содержимое очереди.
        System.out.print("Содержимое очереди фиксированного размера: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }
        System.out.println("\n");

        iQ = q2;
        // Поместить ряд символов в динамическую очередь.
        System.out.println("Помещение символов в DynQueue:");
        for (i = 0; i < 10; i++)
            iQ.put((char) ('Z' - i));

        // Отобразить содержимое очереди.
        System.out.print("Содержимое динамической очереди: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }
        System.out.println("\n");

        iQ = q3;
        // Поместить ряд символов в кольцевую очередь.
        System.out.println("Помещение символов в CircularQueue:");
        for (i = 0; i < 10; i++)
            iQ.put((char) ('A' + i));

        // Отобразить содержимое очереди.
        System.out.print("Содержимое кольцевой очереди: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }
        System.out.println();

        // Поместить дополнительные символы в кольцевую очередь.
        System.out.println("\nПомещение дополнительных символов в CircularQueue:");
        for (i = 10; i < 20; i++)
            iQ.put((char) ('A' + i));

        // Отобразить содержимое очереди.
        System.out.print("Содержимое кольцевой очереди: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }

        System.out.println("\n\nСохранение и использование элементов в кольцевой очереди.");
        // Сохранение и использование элементов в кольцевой очереди.
        for (i = 0; i < 20; i++) {
            iQ.put((char) ('A' + i));
            ch = iQ.get();
            System.out.print(ch);
        }
        System.out.println();
    }
}