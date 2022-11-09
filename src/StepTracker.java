public class StepTracker {
    int stepGoal = 10000; // Целевое количество шагов. При старте приложения устанавливается равным 10 000 в день.
    MonthData[] monthToData;
    int sumStep = 0;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    static class MonthData {
        int[] days = new int[30];
    }

    void stepInDay(int newStep, int stepDay, int stepMonth) {
        monthToData[stepMonth - 1].days[stepDay - 1] = newStep;
        System.out.println("Ввели новые данные:" + stepDay + "." + stepMonth + "." + newStep + "шагов");
    }
    void printAllStepsMonth(int stepMonth) {
        for (int i = 0; i <= monthToData[stepMonth-1].days.length; i++) {
            System.out.println("День " + (i+1) + ".  " + monthToData[stepMonth-1].days[i-1] + " шагов");
        }
    }
    int staticStep(int stepMonth) { // Общее количество шагов за месяц;


        for (int i = 0; i <= monthToData[stepMonth-1].days.length; i++) {
            sumStep = sumStep + monthToData[stepMonth - 1].days[i - 1];
        }
        System.out.println("Общее количество шагов за месяц:"+ sumStep);
        return sumStep;
    }
    void findMaxStaticStep(int stepMonth) { //Максимальное пройденное количество шагов в месяце;
        int maxStaticStep = 0;
        for (int i = 0; i <= monthToData[stepMonth-1].days.length; i++) {
            if (monthToData[stepMonth - 1].days[i - 1] > maxStaticStep) {
                maxStaticStep  = monthToData[stepMonth - 1].days[i - 1];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце:"+ maxStaticStep );
    }


    void averageStaticStep(int sumStep) {  //Среднее количество шагов;
        int averageStep = sumStep / 30;
        System.out.println("Среднее количество шагов:"+ averageStep );
    }

    void bestSeries (int stepMonth) {  //Лучшая серия: максимальное количество подряд идущих дней,
                                           // в течение которых количество шагов за день было равно или выше целевого.
        int series = 0;
        int best = 0;
        for ( int i = 0; i<monthToData[stepMonth-1].days.length; i++){
            if (monthToData[stepMonth-1].days[i] >= stepGoal ) {
                series++;
                if (series>best){
                    best++;
                }
            }else {
                series=0;
            }
        }System.out.println("Лучшая серия составила" + best);
    }
    int changeStapInDays (int newStepGoal) { //изменение цели на месяц
        stepGoal = newStepGoal;
        return newStepGoal;
    }

}







