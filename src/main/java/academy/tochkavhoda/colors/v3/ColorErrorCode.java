package academy.tochkavhoda.colors.v3;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("Такой цвет не добавлен"),
    NULL_COLOR("Передан NULL");

    final String errorString;

    ColorErrorCode(String errorString){
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }

}