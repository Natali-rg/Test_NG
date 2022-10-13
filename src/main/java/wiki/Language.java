package wiki;

public enum Language {
    EN("en"),
    RU("ru"),
    ES("es"),
    DE("de");



    private String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
