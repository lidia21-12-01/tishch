class Transport {
    private double weight;     // масса
    private double maxSpeed;   // максимальная скорость
    private String name;       // имя/модель

    Transport() {
        weight = 0.0;
        maxSpeed = 0.0;
        name = "Без имени";
    }

    Transport(double w, double s, String n) {
        weight = w;
        maxSpeed = s;
        name = n;
    }

    double getWeight() { return weight; }
    double getMaxSpeed() { return maxSpeed; }
    String getName() { return name; }

    void showInfo() {
        System.out.println("Транспорт: " + name +
                ", масса: " + weight + " кг" +
                ", макс. скорость: " + maxSpeed + " км/ч");
    }

    // Метод, передвижения
    void move() {
        System.out.println(name + " передвигается каким-либо способом.");
    }
}

// Подкласс - Автомобиль
class Car extends Transport {
    private int doors;          // количество дверей
    private String engineType;  // тип двигателя

    Car() {
        super();
        doors = 0;
        engineType = "Неизвестно";
    }

    Car(double w, double s, String n, int d, String eng) {
        super(w, s, n);
        doors = d;
        engineType = eng;
    }

    // Переопределение метода move()
    @Override
    void move() {
        System.out.println(getName() + " едет по дороге.");
    }

    void showCar() {
        showInfo();
        System.out.println("Дверей: " + doors + ", двигатель: " + engineType);
    }
}

// Подкласс - Электромобиль
class ElectricCar extends Car {
    private double battery;  // ёмкость батареи

    ElectricCar() {
        super();
        battery = 0.0;
    }

    ElectricCar(double w, double s, String n, int d, String eng, double bat) {
        super(w, s, n, d, eng);
        battery = bat;
    }

    @Override
    void move() {
        System.out.println(getName() + " бесшумно едет на электротяге.");
    }

    void showElectricCar() {
        showCar();
        System.out.println("Ёмкость батареи: " + battery + " кВт·ч");
    }
}

// Самый низкий уровень: такси (подобие "коровы" в запросе)
class Taxi extends Car {
    private String taxiCompany;   // название таксопарка
    private boolean isOnDuty;     // работает ли сейчас

    Taxi() {
        super();
        taxiCompany = "Неизвестно";
        isOnDuty = false;
    }

    Taxi(double w, double s, String n, int d, String eng, String company, boolean duty) {
        super(w, s, n, d, eng);
        taxiCompany = company;
        isOnDuty = duty;
    }

    // Дополнительные методы, характерные для такси
    void pickUpPassenger() {
        if (isOnDuty) {
            System.out.println(getName() + " (" + taxiCompany + "): принимает пассажира.");
        } else {
            System.out.println(getName() + " (" + taxiCompany + "): вне смены.");
        }
    }

    void switchDuty() {
        isOnDuty = !isOnDuty;
        System.out.println(getName() + ": статус работы изменён на " + (isOnDuty ? "на линии" : "вне линии"));
    }

    // Переопределение move() если нужно уникальное поведение
    @Override
    void move() {
        System.out.println(getName() + " везёт клиента по городу.");
    }

    void showTaxi() {
        showCar();
        System.out.println("Таксопарк: " + taxiCompany + ", на линии: " + (isOnDuty ? "да" : "нет"));
    }
}

// Демонстрация
class DispatchDemo {
    public static void main(String[] args) {
        Transport t = new Transport(1000, 90, "Грузовик");
        Car c = new Car(1500, 220, "Легковой", 4, "ДВС");
        ElectricCar e = new ElectricCar(1800, 240, "Tesla Model S", 4, "Электро", 100);
        Taxi taxi = new Taxi(1600, 180, "Hyundai Solaris", 4, "Бензиновый", "Яндекс.Такси", true);

        // Ссылки на базовый класс:
        Transport ref;

        ref = t; ref.move();
        ref = c; ref.move();
        ref = e; ref.move();
        ref = taxi; ref.move();

        System.out.println();
        c.showCar();
        System.out.println();
        e.showElectricCar();
        System.out.println();
        taxi.showTaxi();
        taxi.pickUpPassenger();
        taxi.switchDuty();
        taxi.pickUpPassenger();
    }
}
