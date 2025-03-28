package abstracts;

import interfaces.IUserRepository;

public abstract class UserRepository<T extends User> extends Repository<T> implements IUserRepository<T> {
    @Override
    public T findByUsername(String username) {
        for (T user : entities) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        T user = findByUsername(username);
        if (user != null) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBalance(String username, double newBalance) {
        T user = findByUsername(username);
        if (user != null) {
            user.setBalance(newBalance);
            return true;
        }
        return false;
    }

    @Override
    public T verifyCredentials(String username, String password) {
        T user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public boolean add(T user) {
        if (findByUsername(user.getUsername()) != null) {
            return false; // User with the same username already exists
        }
        return super.add(user); // Call the parent class's add method
    }
}
