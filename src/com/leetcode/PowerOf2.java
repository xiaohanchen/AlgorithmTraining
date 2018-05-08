package com.leetcode;

public class PowerOf2 {

    /*BIT OPERATION
    * >>1   means dive by 2
    * <<1   means multiply by 2*/

    public static void main(String[] args) {

        int a = 100;

        //bitwise of a number has only one '1'
        int count = 0;
        for(int i = 0; i < 32; i ++){
             if(((a>>i) & 1) == 1) {  //CHECKING IF THE LEFT MOST BIT (LSB) is 1    SUPER USEFULLLLLLLLLLLLLLLL
                count++;
             }
        }

        Main.print(count);

    }
}
