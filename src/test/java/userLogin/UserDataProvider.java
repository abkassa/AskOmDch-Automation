package userLogin;

// This class provides the data for our tests, I am trying to separate the data provider
// It returns 3 different objects, with 2 String attributes (in our case, the 2 attributes are the username and the password)
public class UserDataProvider {
    public static Object[] provideUserData() {
        return new Object[] {
                new Object[] {"abk1", "Pass@abk"},
                new Object[] {"abk2", "Pass@abk"},    // if there is different types of users
                new Object[] {"abk3", "Pass@abk"}     // if there is different types of users
        };
    }
}
