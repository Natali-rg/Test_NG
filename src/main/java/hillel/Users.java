package hillel;

public enum Users {
    ALEX("Alex"),
    JON("Jon"),
    KATE("Kate"),
    MARY("Mary"),
    NICK("Nick");

    private String code;

    Users(String code) {
        this.code=code;
    }

    public String getCode() {
        return code;
    }
}
