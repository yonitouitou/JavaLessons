public enum SingletonByEnum {

    INSTANCE("MyConnectionString");

    private String value;

    SingletonByEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
