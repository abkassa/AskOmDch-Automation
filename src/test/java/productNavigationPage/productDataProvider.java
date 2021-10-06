package productNavigationPage;

public class productDataProvider {
    // This class provides search data for our tests
// It returns 3 different objects, with 1 String attributes (search keyword)
    public static Object[] provideUserData() {
        return new Object[] {
                new Object[] {"Basic Blue Jeans"},
                new Object[] {"Anchor Bracelet"},    // Search for multiple items
                new Object[] {"Blue Shoes"}     // Search for multiple items
        };
    }
}
