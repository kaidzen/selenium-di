package manager;

import java.lang.reflect.InvocationTargetException;

public final class DriverManagerFactory {

    private DriverManagerFactory() {
    }

    public static <T extends DriverManager> T getManager(final Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return type.getConstructor().newInstance();
    }


}
