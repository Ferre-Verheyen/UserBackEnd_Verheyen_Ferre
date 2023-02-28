package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private List<User> userRepository = new ArrayList<>();

    public UserService() {
    }

    public List<User> getAllUsers() {
        return userRepository;
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.stream().filter(user -> user.getAge() > age).toList();
    }

    public User getOldestUser() {
        User oldest = null;
        if (userRepository.size() > 0) {
            oldest = userRepository.get(0);
            for (User user : userRepository) {
                if (user.getAge() > oldest.getAge())
                    oldest = user;
            }
        }
        return oldest;
    }

    public User getUserWithName(String name) {
        return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
    }

    public boolean addUser(User user) {
        for (int i = 0; i < userRepository.size(); i++) {
            if (userRepository.get(i).getEmail() == user.getEmail()) {
                return false;
            }
        }
        return userRepository.add(user);
    }

    public User removeUser(String string) {
        User x = null;
        for (int i = 0; i < userRepository.size(); i++) {
            if (userRepository.get(i).getEmail() == string) {
                x = userRepository.get(i);
                userRepository.remove(i);
            }
        }
        return x;
    }

    public List<User> getUsersMembershipGivenYear(int year) {
        List<User> usersMembershipGivenYear = new ArrayList<>();
        for (User user : userRepository) {
            if (user.getMembershipYear(year) == year)
                usersMembershipGivenYear.add(user);
        }
        return usersMembershipGivenYear;
    }

    public List<User> getListOfUsersOfAgeBetween(int min, int max) {
        List<User> listOfUsersOfAgeBetween = new ArrayList<>();
        for (User user : userRepository) {
            if (user.getAge() > min && user.getAge() < max) {
                listOfUsersOfAgeBetween.add(user);
            }

        }
        return listOfUsersOfAgeBetween;
    }

    public List<User> getAdults() {
        List<User> adults = new ArrayList<>();
        for (User user : userRepository) {
            if (user.getAge() > 17) {
                adults.add(user);
            }
        }
        return adults;
    }

    public User getUserWithEmail(String string) {
        User userWithEmail = null;
        for (User user : userRepository) {
            if (user.getEmail().equals(string)) {
                userWithEmail = user;
            }
        }
        return userWithEmail;
    }

    public List<User> getListOfUsersWithEmailAndAge(String email, int age) {
        List<User> usersWithEmailAndAge = new ArrayList<>();
        for (User user : userRepository) {
            if (user.getEmail().equals(email) && user.getAge() == age) {
                usersWithEmailAndAge.add(user);
            }
        }
        return usersWithEmailAndAge;
    }

}