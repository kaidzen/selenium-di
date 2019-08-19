package DriverManager;

public enum DriverType {
    CHROME("CHROME"),
    FIREFOX("FIREFOX"),
    IE("IE"),
    SAFARI("SAFARI");

    private final String name;

    DriverType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
