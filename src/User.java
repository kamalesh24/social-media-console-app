import java.util.*;


public class User {
    public static int idProvider = 0;
    private int id;
    private String name;
    private String dob;
    private int age;
    private String location;
    private String occupation;

    public static List<User> friendList = new ArrayList<>();
    public static List<User> requestList = new ArrayList<>();
    public static List<User> acceptList = new ArrayList<>();

    public User(String name, String dob, int age, String loc, String occupation){
        this.id = ++idProvider;
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.location = loc;
        this.occupation = occupation;
    }

    public void accept(List<Integer> friends){
        for(int f: friends){
            for(User u: UserList.usersList){
                if(f == u.getId()){
                    friendList.add(u);
                    acceptList.remove(u);
                    u.setRequestList(this);
                }
            }
        }
    }

    public void request(List<Integer> friends){
        for(int f: friends){
            for(User u: UserList.usersList){
                if(f == u.getId()){
                    requestList.add(u);
                    u.setAcceptList(this);
                }
            }
        }
    }

    // setters
    public void setRequestList(User frnd){
        requestList.remove(frnd);
    }
    public void setAcceptList(User req){
        acceptList.add(req);
    }

    // displayers
    public void showFriends(){
        for(User i: friendList){
            i.showDetails();
        }
    }
    public void showRequestList(){
        for(User i: requestList){
            i.showDetails();
        }
    }

    public void showAcceptList(){
        for(User i: acceptList){
            i.showDetails();
        }
    }
    public void showDetails(){
        System.out.println("id: " + id + "\nName: "+ name + "\nAge: " + age + "\nDOB: " + dob + 
                            "\nLocation: " + location + "\nOccupation: "+ occupation);
        System.out.println("--------------------");
    }

    // getters
    public User getUser(){
        return this;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getLocation(){
        return location;
    }
    public String getOccupation(){
        return occupation;
    }
    public List<User> getFriends(){
        return friendList;
    }
    public List<User> getRequests(){
        return requestList;
    }
}
