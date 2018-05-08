package CrackInterview;

import java.util.ArrayList;
import java.util.HashMap;

interface Store{
    void checkout();
    void order();
}

abstract class Book{
    String name;
    String author;
    double price;
    int stockCount;
    ArrayList<BookCategory> categories;

    //....
}

enum BookCategory{
    FICTION, MANGA  //....
}

public class OnlineBookStore implements Store{

    BookStock bookStock;
    ShopCart shopCart;
    BookSearcher bookSearcher;

    @Override
    public void checkout() {

    }

    @Override
    public void order() {

    }

    void checkBook(){

    }

}


class ShopCart{

}


class BookStock{
    HashMap<Book, Integer> bookStock;  //category -> Books
}


class BookSearcher{

}



