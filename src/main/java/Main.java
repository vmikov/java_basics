import hw_21.*;

import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.printf("Main started in thread %d%n%n", Thread.currentThread().getId());

        CounterCollaborator[] collaborators = new CounterCollaborator[] {new ThreadInherited(), new RunnableImplemented(), new CallableImplemented()};
        CollaborationManager.setCollaborators(collaborators);

        Thread thread1 = (ThreadInherited)collaborators[0];
        Thread thread2 = new Thread((RunnableImplemented)collaborators[1]);
        Thread thread3 = new Thread(new FutureTask<>((CallableImplemented)collaborators[2]));

        thread1.start();
        thread2.start();
        thread3.start();

        //(2772,2782,2787), (2787,2802,2804), (2827,2836,2838)
        // дапазоны значений переменной допролнительного класса после завершения дочерних потоков по итогам трех запусков
        // при отсутствии синхронизации в методе дополнительного класса:
        // по потокам - (2772-2838), финальное - (2787-2838)

        //(2967,2995,3000), (2989,2992,3000), (2988,2994,3000)
        // дапазон значений переменной допролнительного класса после завершения дочерних потоков по итогам трех запусков
        // c синхронизацией в методе дополнительного класса:
        // по потокам - (2967-3000), финальное - (3000-3000)

        thread1.join();
        thread2.join();
        thread3.join();

        //(2749,2766,2767), (2788,2831,2833), (2799,2824,2835)
        // дапазоны значений переменной допролнительного класса после завершения дочерних потоков по итогам трех запусков
        // при отсутствии синхронизации в методе дополнительного класса c ожиданием в родительском потоке завершения дочерних:
        // по потокам - (2749-2835), финальное - (2767-2835)

        //(2978,2984,3000), (2988,2999,3000), (2989,2999,3000)
        // дапазон значений переменной допролнительного класса после завершения дочерних потоков по итогам трех запусков
        // c синхронизацией в методе дополнительного класса c ожиданием в родительском потоке завершения дочерних:
        // по потокам - (2978-3000), финальное - (3000-3000)

        System.out.printf("%nMain is done%n");

        //Для образования deadlock-а нужно как минимум в двух из классов ThreadInherited, RunnableImplemented и CallableImplemented
        //раскомментировать вызов метода displayCollaboration() и включить синхронизацию метода в дополнительном классе Counter;
    }
}
