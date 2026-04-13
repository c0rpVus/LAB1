package academy.school;

public enum TrainingErrorCode {
    // Trainee errors
    TRAINEE_WRONG_FIRSTNAME("Некорректное имя учащегося"),
    TRAINEE_WRONG_LASTNAME("Некорректная фамилия учащегося"),
    TRAINEE_WRONG_RATING("Некорректная оценка учащегося (должна быть от 1 до 5)"),
    TRAINEE_NOT_FOUND("Учащийся не найден"),

    // Group errors
    GROUP_WRONG_NAME("Некорректное имя группы"),
    GROUP_WRONG_ROOM("Некорректное название аудитории"),
    GROUP_NOT_FOUND("Группа не найдена"),

    // School errors
    SCHOOL_WRONG_NAME("Некорректное название курса"),

    // Duplicate errors
    DUPLICATE_GROUP_NAME("Группа с таким названием уже существует"),
    DUPLICATE_TRAINEE("Такой студент уже существует в Map"),

    // Queue errors
    EMPTY_TRAINEE_QUEUE("Очередь студентов пуста"),

    // TrainingErrorCode:
    DUPLICATE_PASSPORT("Студент с таким номером паспорта уже существует"),
    PASSPORT_NOT_FOUND("Паспорт не найден");

    private final String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}