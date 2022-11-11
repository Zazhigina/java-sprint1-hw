import java.util.Scanner;

public class Main {
       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);


           while (true) {

               printMenu();
               int command = scanner.nextInt();
               choiceAction(scanner, command);
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

    public static void choiceAction(Scanner scanner, int command) {
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter ();
        int newStep;
        if (command == 1) {

            System.out.println("Сколько шагов прошли?");
            newStep = scanner.nextInt();
            while (newStep<0 ){
                System.out.println("Число не может быть отрицательным.Введите еще раз");
                newStep = scanner.nextInt();
            }
            System.out.println("В какой месяц ?");
            int stepMonth = scanner.nextInt();
            while (stepMonth < 0 || stepMonth > 12){
                System.out.println("Введите с 1-12 число");
                stepMonth = scanner.nextInt();
            }
            System.out.println("В какой день ?");
            int stepDay = scanner.nextInt();
            while (stepDay<0 || stepDay > 30){
                System.out.println("Введите число с 1-30");
                stepDay = scanner.nextInt();
            }
            stepTracker.enterStepInDay (stepDay, stepMonth);


        } else if (command == 2) {
            System.out.println("Какой месяц?");
            int stepMonth = scanner.nextInt();
            stepTracker.printAllStepsMonth(stepMonth);
            System.out.println("Общее количество шагов за месяц:"+ stepTracker.staticStep (stepMonth));
            stepTracker.findMaxStaticStep(stepMonth);
            stepTracker.averageStaticStep (stepTracker.staticStep (stepMonth));
            converter.findDistance(stepTracker.staticStep (stepMonth));
            converter.findKkal(stepTracker.staticStep (stepMonth));
            stepTracker.bestSeries(stepMonth);



        } else if (command == 3) {
            System.out.println("Какой месяц?");
            int newStepGoal = scanner.nextInt();
            System.out.println("Новая цель - " + stepTracker.changeStapInDays(newStepGoal)+ "шагов");
        }  else {
            System.out.println("Такой команды нету,введите снова.");
        }

    }
}