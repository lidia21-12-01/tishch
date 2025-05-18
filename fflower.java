// Верхний уровень иерархии — Суперкласс (Растение)
abstract class Plant {
    String name;
    String color;

    public Plant(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Абстрактный метод для роста
    abstract void grow();
}

// Средний уровень — Подкласс (Древесные растения)
abstract class WoodyPlant extends Plant {
    int height; // Высота растения

    public WoodyPlant(String name, String color, int height) {
        super(name, color);
        this.height = height;
    }
}

// Низший уровень — Подкласс (Дуб)
class Oak extends WoodyPlant {
    int age; // Возраст дуба

    public Oak(String name, String color, int height, int age) {
        super(name, color, height);
        this.age = age;
    }

    @Override
    void grow() {
        System.out.println("Дуб " + name + ", цвет: " + color + ", высота: " + height +
            " м, возраст: " + age + " лет — растет медленно.");
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Oak oak = new Oak("Лесной дуб", "Зеленый", 20, 50);
        oak.grow();
    }
}
