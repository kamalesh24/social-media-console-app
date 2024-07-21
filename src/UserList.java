import java.util.*;

public class UserList {
    public static List<User> usersList = new ArrayList<>();

    public void display(User u){
        for(User i: usersList){
            if(u.getId() == i.getId() || u.getFriends().contains(i)) continue;
            else if(u.getAge() == i.getAge()){
                i.showDetails();
            }
            else if(u.getLocation().equals(i.getLocation())){
                i.showDetails();
            }
            else if(u.getOccupation().equals(i.getOccupation())){
                i.showDetails();
            }
        }
    }
}
