public enum TypeTask {
    P("Личная"),
    W("Рабочая");
    private final String type;

    TypeTask(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
