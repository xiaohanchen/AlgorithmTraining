package MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Car{

}

class CarPark {
    int[][] space; //floor & space in each floor
    int[] carCount;
    final int capacity;
    Integer availableSpace;
    BlockingQueue<Car> parkQueue;   //enter one by one?

    public CarPark(int capacity) {
        this.capacity = capacity;
        this.availableSpace = capacity;
        this.parkQueue = new ArrayBlockingQueue<Car>(4);
    }


    void enter()  {
        //put into the queue if park is full
        try {
            if(!checkSpaceAvailable()){ //what if enter1 check here before enter2 do decrement?
                wait();
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        availableSpace --;
        notifyAll();
    }

    void exit()  {
        //take out of queue
        try {
            if(checkCarParkEmpty()){
                wait();
            }
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        availableSpace ++;
        notifyAll();
    }

    synchronized boolean checkSpaceAvailable(){
        return availableSpace > 0;
    }

    synchronized boolean checkCarParkEmpty(){
        return availableSpace == capacity;
    }



/*    synchronized void enter()  {
        //put into the queue if park is full
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    synchronized void exit()  {
        //take out of queue
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/


    public static void main(String[] args) throws InterruptedException {
        CarPark carPark = new CarPark(1);

        Thread enter1 = new Thread(() -> carPark.enter(), "enter-1");
        Thread enter2 = new Thread(() -> carPark.enter(),"enter-2");
        Thread exit1 = new Thread(() -> carPark.exit(), "exit-1");

        long startTime = System.currentTimeMillis();

        enter1.start();
        exit1.start();
        enter2.start();

        enter1.join();   //returns only t1 complete the execution
        exit1.join();
        enter2.join();

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        return;

    }


}
