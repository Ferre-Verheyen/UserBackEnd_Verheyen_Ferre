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

    public User getUserWithEmail(String string) {
        User x = null;
        for (int i = 0; i < userRepository.size(); i++) {
            if (userRepository.get(i).getEmail() == string) {
                x = userRepository.get(i);
            }
        }
        return x;
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

}