package interfaces;

import abstracts.User;

public interface IUserRepository<T extends User> extends IRepository<T> {
    T findByUsername(String username);
    boolean updatePassword(String username, String newPassword);
    boolean updateBalance(String username, double newBalance);
    T verifyCredentials(String username, String password);
}
