/*
   Упражнение 5.3.
   Класс, который отображает двоичное представление значения.
*/
class ShowBits {
    int numbits; // Количество отображаемых битов

    ShowBits(int n) {
        numbits = n;
    }

    void show(long val) {
        long mask = 1;

        // Сдвинуть 1 влево на нужную позицию
        mask <<= numbits - 1;

        int spacer = 0;
        for (; mask != 0; mask >>>= 1) { // Используем беззнаковый сдвиг
            if ((val & mask) != 0)
                System.out.print("1");
            else
                System.out.print("0");
            spacer++;
            if ((spacer % 8) == 0) {
                System.out.print(" ");
                spacer = 0;
            }
        }
        System.out.println();
    }
}