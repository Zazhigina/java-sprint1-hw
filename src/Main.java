import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {

            printMenu();
            int command = scanner.nextInt();
            selectAction(scanner, command, stepTracker);
            if (command == 0) {
                System.out.println("Программа завершена");
                break;
            }
        }
    }


    public static void printMenu() {

        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }

    public static void selectAction(Scanner scanner, int command, StepTracker stepTracker) {
        Converter converter = new Converter();
        if (command == 1) {

            System.out.println("Сколько шагов прошли?");
            int newStep;
            newStep = scanner.nextInt();
            while (newStep <= -1) {
                System.out.println("Число не может быть отрицательным.Введите еще раз");
                newStep = scanner.nextInt();
            }
            System.out.println("Выберите месяц: " +
                    "1-Январь,  " +
                    "2-Февраль, " +
                    "3-Март, " +
                    "4-Апрель, " +
                    "5-Май, " +
                    "6-Июнь, " +
                    "7-Июль, " +
                    "8-Август, " +
                    "9-Сентябрь, " +
                    "10-Октябрь, " +
                    "11-Ноябрь, " +
                    "12-Декабрь");
            int stepMonth = scanner.nextInt();
            while (stepMonth <= 0 || stepMonth >= 13) {
                System.out.println("Введите число от 1 до 12");
                stepMonth = scanner.nextInt();
            }
            System.out.println("В какой день ?");
            int stepDay = scanner.nextInt();
            while (stepDay <= 0 || stepDay >= 31) {
                System.out.println("Введите число от 1 до 30");
                stepDay = scanner.nextInt();
            }
            stepTracker.enterStepInDay(stepDay, stepMonth, newStep);


        } else if (command == 2) {
            System.out.println("Какой месяц?");
            int stepMonth = scanner.nextInt();
            while (stepMonth <= 0 || stepMonth >= 13) {
                System.out.println("Введите число от 1 до 12");
                stepMonth = scanner.nextInt();
            }
            stepTracker.printAllStepsMonth(stepMonth);
            System.out.println("Общее количество шагов за месяц:" + stepTracker.findAllStepInMonth(stepMonth));
            System.out.println("Максимальное пройденное количество шагов в месяце:" + stepTracker.findMaxStaticStep(stepMonth));
            System.out.println("Среднее количество шагов:" + stepTracker.averageStaticStep(stepTracker.findAllStepInMonth(stepMonth)));
            System.out.println("Пройденная дистанция (в км):" + converter.findDistance(stepTracker.findAllStepInMonth(stepMonth)));
            System.out.println("Количество сожжённых килокалорий:" + converter.findKkal(stepTracker.findAllStepInMonth(stepMonth)));
            System.out.println("Лучшая серия составила: " + stepTracker.findBestSeries(stepMonth));


        } else if (command == 3) {
            System.out.println("Какая новая цель на день?");
            int newStepGoal = scanner.nextInt();
            while (newStepGoal <= -1) {
                System.out.println("Введите неотрицательное число.");
                newStepGoal = scanner.nextInt();
            }
            System.out.println("Новая цель - " + stepTracker.changeStepsInDays(newStepGoal) + " шагов");

        } else {
            System.out.println("Такой команды нету,введите снова.");
        }

    }
}
