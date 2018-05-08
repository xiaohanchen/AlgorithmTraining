package Draft;

import java.util.ArrayList;

public class List {


    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(){};
        ArrayList list2 = new ArrayList(){};

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(3);
        list2.add(4);

        list1.removeAll(list2);

        return;

    }


}
