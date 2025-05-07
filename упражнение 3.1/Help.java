/*
   Упражнение 3.1.
   Простая справочная система по управляющим операторам Java.
*/
class Help {
    public static void main(String[] args)
            throws java.io.IOException { // Необходимо для System.in.read()

        char choice;

        System.out.println("Справка по:");
        System.out.println("  1. if");
        System.out.println("  2. switch");
        System.out.print("Выберите вариант: ");

        choice = (char) System.in.read(); // Получить выбор пользователя

        System.out.println("\n"); // Добавить пустую строку для читаемости

        switch (choice) {
            case '1':
                System.out.println("Оператор if:\n");
                System.out.println("if(условие) оператор;");
                System.out.println("else оператор;");
                break;
            case '2':
                System.out.println("Традиционный оператор switch:\n");
                System.out.println("switch(выражение) {");
                System.out.println("  case константа:");
                System.out.println("    последовательность операторов");
                System.out.println("    break;");
                System.out.println("  // ...");
                System.out.println("}");
                break;
            default:
                System.out.print("Выбранный вариант не найден.");
        }
    }
}