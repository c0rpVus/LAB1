package academy.school;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeBidiMap {
    private Map<String, Trainee> passportToTrainee;
    private Map<Trainee, String> traineeToPassport;

    public TraineeBidiMap() {
        this.passportToTrainee = new HashMap<>();
        this.traineeToPassport = new HashMap<>();
    }

    public void addTrainee(Trainee trainee, String passport) throws TrainingException {
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        if (passport == null || passport.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }

        if (traineeToPassport.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        if (passportToTrainee.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }

        passportToTrainee.put(passport, trainee);
        traineeToPassport.put(trainee, passport);
    }

    public void replaceTraineePassport(Trainee trainee, String passport) throws TrainingException {
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        if (passport == null || passport.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }

        // Проверяем, существует ли trainee в карте
        if (!traineeToPassport.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        String oldPassport = traineeToPassport.get(trainee);

        // Проверяем, не занят ли новый паспорт (даже если это тот же студент)
        // Согласно тесту, даже замена на свой же паспорт должна вызывать исключение
        if (passportToTrainee.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }

        // Удаляем старую запись
        passportToTrainee.remove(oldPassport);

        // Добавляем новую
        passportToTrainee.put(passport, trainee);
        traineeToPassport.put(trainee, passport);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        if (!traineeToPassport.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        String passport = traineeToPassport.remove(trainee);
        passportToTrainee.remove(passport);
    }

    public void removeTraineeByPassport(String passport) throws TrainingException {
        if (passport == null || passport.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }

        if (!passportToTrainee.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }

        Trainee trainee = passportToTrainee.remove(passport);
        traineeToPassport.remove(trainee);
    }

    public Trainee getTraineeByPassport(String passport) throws TrainingException {
        if (passport == null || passport.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }

        Trainee trainee = passportToTrainee.get(passport);
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }

        return trainee;
    }

    public String getPassportByTrainee(Trainee trainee) throws TrainingException {
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        String passport = traineeToPassport.get(trainee);
        if (passport == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        return passport;
    }

    public Set<Trainee> getAllTrainees() {
        return new HashSet<>(traineeToPassport.keySet());
    }

    public Set<String> getAllPassports() {
        return new HashSet<>(passportToTrainee.keySet());
    }

    public boolean hasAnybodyPassport(String passport) {
        if (passport == null) {
            return false;
        }
        return passportToTrainee.containsKey(passport);
    }

    public int getTraineesCount() {
        return passportToTrainee.size();
    }
}