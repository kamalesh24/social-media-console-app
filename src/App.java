import java.util.*;

public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        
        UserList ul = new UserList();
        User currUser = null;
        int uid;

        while (loop) {
            System.out.print("1. Sign Up\n2. Sign In\n3. Make Requests\n4. Accept Requests\n5. Logout\n6. Exit\n");
            
            int n = sc.nextInt();

            switch(n){
                case 1:
                    // int id;
                    System.out.println("Enter name:");
                    String name = sc.next();

                    System.out.println("Enter DOB(DD/MM/YYYY):");
                    String dob = sc.next();

                    System.out.println("Enter age:");
                    int age = sc.nextInt();

                    System.out.println("Enter Location:");
                    String location = sc.next();

                    System.out.println("Enter Occupation:");
                    String occupation = sc.next();


                    currUser = new User(name, dob, age, location, occupation);
                    currUser.showDetails();
                    UserList.usersList.add(currUser);

                    System.out.println("List of Users:");
                    for(User i: UserList.usersList){
                        i.showDetails();
                    }
                    break;

                case 2:
                    System.out.println("Enter your id: ");
                    uid = sc.nextInt();
                    currUser = getUser(uid);
                    if(currUser == null){
                        System.out.println("UserID not valid! Enter correct user ID.");
                        break;
                    }
                    currUser.showDetails();
                    if(currUser.getRequests().size() > 0){
                        System.out.println("You have new friend request. Check them out!");
                    }
                    break;

                case 3:
                    if(currUser == null){
                        System.out.println("Please Sign in, and try again!");
                        break;
                    }
                    
                    ul.display(currUser);
                    sc.nextLine();
                    String[] temp = sc.nextLine().split(" ");

                    List<Integer> friends = new ArrayList<>();
                    for(String i: temp){
                        friends.add(Integer.parseInt(i));
                    }

                    currUser.request(friends);
                    currUser.showRequestList();

                    break;

                case 4:
                    if(currUser == null){
                        System.out.println("Please Sign in, and try again!");
                        break;
                    }
                    
                    currUser.showAcceptList();
                    sc.nextLine();
                    temp = sc.nextLine().split(" ");

                    List<Integer> fs = new ArrayList<>();
                    for(String i: temp){
                        fs.add(Integer.parseInt(i));
                    }

                    currUser.accept(fs);
                    currUser.showFriends();
                    
                    break;
                case 5:
                    currUser = null;
                    break;
                case 6:
                    loop = false;
                    break;

            }
        }
        sc.close();

    }

    public static User getUser(int id){
        for(User i: UserList.usersList){
            if(id == i.getId()){
                return i.getUser();
            }
        }
        return null;
    }
}
