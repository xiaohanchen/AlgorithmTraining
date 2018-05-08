package MultiThreading;

public class SynchronisedPractise {

    static class LittleCounter{
         int count;
         LittleCounter(){
             this.count = 0;
         }
         synchronized void increment(){
             count ++;
             System.out.println(getCount());   //reentrant monitor
         }

         synchronized int getCount(){
             return count;
         }

    }

    public static void main(String[] args) {

        LittleCounter counter = new LittleCounter();

        Runnable run1 = () ->{
            int i = 10;
            while(i > 0) {
                counter.increment();    //lock released after the execution of this call
                System.out.println(Thread.currentThread().getName() + counter.getCount());  //the count printed maybe a different value
                i--;
            }
        };


        Runnable run2 = () ->{
            int i = 10;
            while(i > 0) {
                System.out.print(Thread.currentThread().getName());  //ERROR: between println and increment, the thread might be suspended
                counter.increment();    //lock released after the execution of this call
                i--;
            }
        };

//        Thread thread1 = new Thread(run1); //thread executes the RUNNABLE api
        Thread thread1 = new Thread(run2, "T1 ");
        Thread thread2 = new Thread(run2, "T2 ");

        thread1.start();
        thread2.start();
    }





    static class ValuePair {

        private int a;
        private int b;

        public void copy(final ValuePair other) {
            synchronized (other){
                this.a = other.a;
                this.b = other.b;
            }
        }

        public synchronized void setValue(final int value) {
            this.a = value;
            this.b = value;
        }

        @Override
        public synchronized String toString() {
            return String.format("a: %d and b: %d", a, b);
        }

    }


}
