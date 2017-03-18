public class TestSingletonTest {
    private static TestSingletonTest ourInstance = new TestSingletonTest();

    public static TestSingletonTest getInstance() {
        return ourInstance;
    }

    private TestSingletonTest() {
    }
}
