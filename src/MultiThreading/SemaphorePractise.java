package MultiThreading;

import java.util.concurrent.Semaphore;

public class SemaphorePractise {


    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(1); //the one who gets the semaphore can execute the code
//        sem.release();
//        sem.release();
//        sem.release();
//        sem.acquire(3);
//        sem.acquire();
//        sem.acquire();


        MyThread mt1 = new MyThread(sem, "A");
        MyThread mt2 = new MyThread(sem, "B");

        // stating threads A and B
        mt1.start();
        mt2.start();

        // waiting for threads A and B
        mt1.join();
        mt2.join();

        // count will always remain 0 after
        // both threads will complete their execution
        System.out.println("count: " + Shared.count);


        return;


    }
}



class Shared
{
    static int count = 0;
}

class MyThread extends Thread
{
    Semaphore sem;
    String threadName;

    public MyThread(Semaphore sem, String threadName)
    {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        // run by thread A
        System.out.println("Starting " + threadName);
        try
        {
            // First, get a permit.
            System.out.println(threadName + " is waiting for a permit.");

            // acquiring the lock
            sem.acquire();

            System.out.println(threadName + " gets a permit.");

            // Now, accessing the shared resource.
            // other waiting threads will wait, until this
            // thread release the lock
            for(int i=0; i < 5; i++)
            {
                Shared.count++;
                System.out.println(threadName + ": " + Shared.count);

                // Now, allowing a context switch -- if possible.
                // for thread B to execute
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // Release the permit.
        System.out.println(threadName + " releases the permit.");
        sem.release();
    }
}