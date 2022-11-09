import java.util.Scanner;

public class Main {
       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);


           while (true) {

               display();
               int command = scanner.nextInt();
               isExit(command);
               if (command == 0) {
                   break;
               }
           }
       }
    public static void display() {

        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }

    public static void isExit(int command) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter ();

        if (command == 1) {

            System.out.println("Сколько шагов прошли?");
            int newStep = scanner.nextInt();
            System.out.println("В какой месяц ?");
            int stepMonth = scanner.nextInt();
            System.out.println("В какой день ?");
            int stepDay = scanner.nextInt();

            stepTracker.stepInDay (newStep,stepDay,stepMonth);


        } else if (command == 2) {
            System.out.println("Какой месяц?");
            int stepMonth = scanner.nextInt();
            stepTracker.printAllStepsMonth(stepMonth);
            stepTracker.staticStep (stepMonth);
            stepTracker.findMaxStaticStep(stepMonth);
            stepTracker.averageStaticStep (stepTracker.staticStep (stepMonth));
            converter.distanse(stepTracker.staticStep (stepMonth));
            converter.kkal(stepTracker.staticStep (stepMonth));
            stepTracker.bestSeries(stepMonth);



        } else if (command == 3) {
            System.out.println("Какой месяц?");
            int newStepGoal = scanner.nextInt();
            System.out.println("Новая цель - " + stepTracker.changeStapInDays(newStepGoal)+ "шагов");
        } else if (command == 0) {
            System.out.println("Программа завершена");
        } else {
            System.out.println("Такой команды нету,введите снова.");
        }

    }
}
   /* public static void run() {
        while (true) {
            display();

            int command = scanner.nextInt();

            boolean result = isExit(command);

            if (result) {
                return;
            }
        }
    }

    public static void display() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }

    private boolean isExit(Integer command) {
        switch (command) {
            case 0:
                return true;
            case 1:
               tepDay + "." + stepM + "." + step + "шагов");
                ; System.out.println("Сколько шагов добавить?");
                int step = scanner.nextInt();
                System.out.println("В какой месяц ?");
                int stepM = scanner.nextInt();
                System.out.println("В какой день ?");
                int stepDay = scanner.nextInt();
                System.out.println("Вы прошли" + s
                break;
            case 2:
                System.out.println("Вы прошли в " + "шагов.");
                break;
            case 3:
                System.out.println("Новая цель - " + "шагов");
                break;
            default:
                System.out.println("Такой команды нету,введите снова.");
                break;
        }

        return false;
  }
*/
/*
        if (command == 1) {
            System.out.println("Сколько шагов добавить?");
            int step = scanner.nextInt();
            System.out.println("В какой месяц ?");
            int stepM = scanner.nextInt();
            System.out.println("В какой день ?");
            int stepDay = scanner.nextInt();
            System.out.println("Вы прошли" + stepDay + "." + stepM + "." + step + "шагов");

        } else if (commond == 2) {
            System.out.println("Вы прошли в " + "шагов.");

        } else if (commond == 3) {
            System.out.println("Новая цель - " + "шагов");
        } else if (commond == 0) {
            return true;

        } else {
            System.out.println("Такой команды нету,введите снова.");
        }

        return false;
      }
*/
