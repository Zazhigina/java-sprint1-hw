public class StepTracker {
    int stepGoal = 10000; // Целевое количество шагов. При старте приложения устанавливается равным 10 000 в день.
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    static class MonthData { // объект массива дат
        int[] days = new int[30];

        public void addStepDay(int stepDay, int steps) {
            days[stepDay - 1] = steps;
        }

        public int getStepByDay(int stepDay) {
            return days[stepDay];
        }

        public int[] getDays() {
            return days;
        }
    }

    void enterStepInDay(int stepDay, int stepMonth, int steps) {
        monthToData[stepMonth - 1].addStepDay(stepDay, steps);
        System.out.println("Ввели новые данные:" + stepDay + "число, " + stepMonth + "месяц,  вы прошли " + steps + "шагов");
    }

    void printAllStepsMonth(int stepMonth) {
        System.out.println("Количество пройденных шагов по дням: ");
        for (int i = 0; i < monthToData[stepMonth - 1].getDays().length; i++) {
            System.out.println("День " + (i + 1) + ".  " + monthToData[stepMonth - 1].getStepByDay(i) + " шагов");
        }
    }

    int findAllStepInMonth(int stepMonth) { // Общее количество шагов за месяц;
        int sumStep = 0;

        for (int i = 0; i < monthToData[stepMonth - 1].getDays().length; i++) {
            sumStep = sumStep + monthToData[stepMonth - 1].getStepByDay(i);
        }
        return sumStep;
    }

    int findMaxStaticStep(int stepMonth) { //Максимальное пройденное количество шагов в месяце;
        int maxStaticStep = 0;
        for (int i = 0; i < monthToData[stepMonth - 1].getDays().length; i++) {
            if (monthToData[stepMonth - 1].getStepByDay(i) > maxStaticStep) {
                maxStaticStep = monthToData[stepMonth - 1].getStepByDay(i);
            }
        }
        return maxStaticStep;
    }


    int averageStaticStep(int sumStep) {  //Среднее количество шагов;
        sumStep /= 30;
        return sumStep;
    }

    int findBestSeries(int stepMonth) {  //Лучшая серия: максимальное количество подряд идущих дней,
        // в течение которых количество шагов за день было равно или выше целевого.
        int series = 0;
        int best = 0;
        for (int i = 0; i < monthToData[stepMonth - 1].getDays().length; i++) {
            if (monthToData[stepMonth - 1].getStepByDay(i) >= stepGoal) {
                series = series + 1;
                if (series > best) {
                    best = best + 1;
                }

            } else {
                return best ;
            }

        }
        return best;
    }

    int changeStepsInDays(int newStepGoal) { //изменение цели на месяц
        stepGoal = newStepGoal;
        return stepGoal;
    }

}







