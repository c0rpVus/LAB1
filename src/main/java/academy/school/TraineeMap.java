package academy.school;

import java.util.*;

public class TraineeMap {
    private Map<Trainee, String> traineeInstituteMap;

    public TraineeMap() {
        this.traineeInstituteMap = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        if (traineeInstituteMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }

        // Если institute == null, сохраняем пустую строку
        String instituteValue = (institute == null) ? "" : institute;
        traineeInstituteMap.put(trainee, instituteValue);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        if (!traineeInstituteMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        // Если institute == null, сохраняем пустую строку
        String instituteValue = (institute == null) ? "" : institute;
        traineeInstituteMap.put(trainee, instituteValue);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        if (traineeInstituteMap.remove(trainee) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public int getTraineesCount() {
        return traineeInstituteMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        String institute = traineeInstituteMap.get(trainee);
        if (institute == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        return institute;
    }

    public Set<Trainee> getAllTrainees() {
        return new HashSet<>(traineeInstituteMap.keySet());
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(traineeInstituteMap.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        if (institute == null) {
            return false;
        }
        return traineeInstituteMap.containsValue(institute);
    }
}
