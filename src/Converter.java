public class Converter {
    void findDistance(int sumStep) { //Пройденная дистанция (в км);
        int distance = (sumStep * 75) / 1000;
        System.out.println("Пройденная дистанция (в км):" + distance);    // Для подсчёта дистанции можно считать, что один шаг равен 75 см.
    }

    void findKkal(int sumStep) { //Количество сожжённых килокалорий;
        // Для подсчёта количества сожжённых килокалорий можно считать, что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.
        int kkal = (sumStep * 50) / 1000;
        System.out.println("Количество сожжённых килокалорий:" + kkal);
    }
}