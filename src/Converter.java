public class Converter {

    int step;
    int distanse;
    int kkal;


    void distanse(int sumStep) { //Пройденная дистанция (в км);
        distanse = (step * 75) / 1000;
        System.out.println("Пройденная дистанция (в км):" + distanse);

        // Для подсчёта дистанции можно считать, что один шаг равен 75 см.

    }

    void kkal(int sumStep) { //Количество сожжённых килокалорий;
        // Для подсчёта количества сожжённых килокалорий можно считать, что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.
        kkal = (step * 50) / 1000;
        System.out.println("Количество сожжённых килокалорий:" + kkal);
    }
}