package academy.school;

public class TrainingException extends Exception {
    private final TrainingErrorCode errorCode;

    public TrainingException(TrainingErrorCode errorCode) {
        super(errorCode.getErrorString());
        this.errorCode = errorCode;
    }

    public TrainingException(TrainingErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public TrainingException(TrainingErrorCode errorCode, Throwable cause) {
        super(errorCode.getErrorString(), cause);
        this.errorCode = errorCode;
    }

    public TrainingException(TrainingErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "TrainingException{" +
                "errorCode=" + errorCode +
                ", message=" + getMessage() +
                '}';
    }
}