package CrackInterview;

import java.util.ArrayList;

public class ChatServer {

    ArrayList<User> userList;

    boolean checkIfOnline(long userId){

        return false;
    }

    void requestFriend(long userId){


    }

    void repondFriendRequest(long userId){


    }

}



class User{

    long id;
    String name;
    Status status;
    ArrayList<User> friendList;

    enum Status{
        Online, Offline, Idle
    }


}