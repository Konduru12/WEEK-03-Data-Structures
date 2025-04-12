import java.util.*;
class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;
    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}
class SocialMediaManager {
    private UserNode head;
    public void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        newNode.next = head;
        head = newNode;
    }
    private UserNode findUser(int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == userId)
                return current;
            current = current.next;
        }
        return null;
    }
    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 == null || user2 == null || userId1 == userId2) {
            System.out.println("Invalid user IDs.");
            return;
        }
        if (!user1.friendIds.contains(userId2))
            user1.friendIds.add(userId2);
        if (!user2.friendIds.contains(userId1))
            user2.friendIds.add(userId1);

        System.out.println("Friend connection added.");
    }
    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("Invalid user IDs.");
            return;
        }
        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("Friend connection removed.");
    }
    public void displayFriends(int userId) {
        UserNode user = findUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        for (int fid : user.friendIds) {
            UserNode friend = findUser(fid);
            if (friend != null)
                System.out.println("- " + friend.name + " (ID: " + fid + ")");
        }
    }
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("User(s) not found.");
            return;
        }
        System.out.println("Mutual friends:");
        for (int id : user1.friendIds) {
            if (user2.friendIds.contains(id)) {
                UserNode friend = findUser(id);
                if (friend != null)
                    System.out.println("- " + friend.name + " (ID: " + id + ")");
            }
        }
    }
    public void searchUser(String query) {
        UserNode current = head;
        boolean found = false;
        try {
            int id = Integer.parseInt(query);
            current = findUser(id);
            if (current != null) {
                System.out.println("User found: " + current.name + ", Age: " + current.age);
                return;
            }
        } catch (NumberFormatException ignored) {
            while (current != null) {
                if (current.name.equalsIgnoreCase(query)) {
                    System.out.println("User found: ID " + current.userId + ", Age: " + current.age);
                    found = true;
                }
                current = current.next;
            }
        }
        if (!found)
            System.out.println("User not found.");
    }
    public void countAllFriends() {
        UserNode current = head;
        while (current != null) {
            System.out.println(current.name + " (ID: " + current.userId + ") has " + current.friendIds.size() + " friend(s).");
            current = current.next;
        }
    }
}
public class SocialMediaFriendConnections{
    public static void main(String[] args) {
        SocialMediaManager sm = new SocialMediaManager();
        sm.addUser(1, "Abhi", 25);
        sm.addUser(2, "Chintu", 22);
        sm.addUser(3, "Hema", 24);
        sm.addUser(4, "Teja", 23);
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(3, 4);
        sm.displayFriends(1);
        sm.findMutualFriends(1, 2);
        sm.searchUser("Hema");
        sm.searchUser("3");
        sm.countAllFriends();
        sm.removeFriend(1, 2);
        sm.displayFriends(1);
    }
}
