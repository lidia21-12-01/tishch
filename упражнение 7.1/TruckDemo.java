// Упражнение 7.1: Построение подкласса Vehicle для представления грузовиков.

// Базовый класс Vehicle (с private членами и методами доступа)
class Vehicle {
    private int passengers; // количество пассажиров
    private int fuelcap; // запас топлива в галлонах
    private int mpg; // расход топлива в милях на галлон

    // Конструктор класса Vehicle.
    Vehicle(int p, int f, int m) {
        passengers = p;
        fuelcap = f;
        mpg = m;
    }

    // Возвращает дальность поездки.
    int range() {
        return mpg * fuelcap;
    }

    // Рассчитывает объем топлива, необходимого для поездки на заданное расстояние.
    double fuelNeeded(int miles) {
        return (double) miles / mpg;
    }

    // Методы доступа к переменным экземпляра.
    int getPassengers() {
        return passengers;
    }

    void setPassengers(int p) {
        passengers = p;
    }

    int getFuelcap() {
        return fuelcap;
    }

    void setFuelcap(int f) {
        fuelcap = f;
    }

    int getMpg() {
        return mpg;
    }

    void setMpg(int m) {
        mpg = m;
    }
}

// Расширение класса Vehicle для создания класса Truck.
class Truck extends Vehicle {
    private int cargocap; // грузоподъемность в фунтах

    // Конструктор класса Truck.
    Truck(int p, int f, int m, int c) {
        // Инициализировать члены Vehicle с использованием конструктора Vehicle
        super(p, f, m);

        cargocap = c;
    }

    // Методы доступа для cargocap.
    int getCargo() {
        return cargocap;
    }

    void putCargo(int c) {
        cargocap = c;
    }
}

// Демонстрация использования класса Truck.
class TruckDemo {
    public static void main(String[] args) {

        // Сконструировать несколько объектов-грузовиков.
        Truck semi = new Truck(2, 200, 7, 44000);
        Truck pickup = new Truck(3, 28, 15, 2000);
        double gallons;
        int dist = 252;

        gallons = semi.fuelNeeded(dist);

        System.out.println("Полуприцеп может перевезти " + semi.getCargo() +
                " фунтов.");
        System.out.println("Для поездки на расстояние " + dist +
                " миль полуприцепу требуется " + gallons +
                " галлонов топлива.\n");

        gallons = pickup.fuelNeeded(dist);

        System.out.println("Пикап может перевезти " + pickup.getCargo() +
                " фунтов.");
        System.out.println("Для поездки на расстояние " + dist +
                " миль пикапу требуется " + gallons +
                " галлонов топлива.");
    }
}