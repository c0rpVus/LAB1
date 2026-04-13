package academy.school;


import java.util.*;
import java.util.stream.Collectors;

public class Group {
    private String name;
    private String room;
    private List<Trainee> trainees;

    // 1. Конструктор
    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
        this.trainees = new ArrayList<>();
    }

    // 2. getName
    public String getName() {
        return name;
    }

    // 3. setName
    public void setName(String name) throws TrainingException {
        if (name == null || name.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    // 4. getRoom
    public String getRoom() {
        return room;
    }

    // 5. setRoom
    public void setRoom(String room) throws TrainingException {
        if (room == null || room.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        if (trainee != null) {
            trainees.add(trainee);
        }
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int index) throws TrainingException {
        if (index < 0 || index >= trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for (Trainee trainee : trainees) {
            if (trainee.getFirstName().equals(firstName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for (Trainee trainee : trainees) {
            String traineeFullName = trainee.getFirstName() + " " + trainee.getLastName();
            if (traineeFullName.equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort((t1, t2) -> Integer.compare(t2.getRating(), t1.getRating()));
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        if (trainees.isEmpty()) {
            return;
        }
        int shift = positions % trainees.size();
        if (shift != 0) {
            Collections.rotate(trainees, -shift); // Отрицательное значение для сдвига влево
        }
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        int maxRating = trainees.stream()
                .mapToInt(Trainee::getRating)
                .max()
                .orElse(0);

        return trainees.stream()
                .filter(t -> t.getRating() == maxRating)
                .collect(Collectors.toList());
    }

    public boolean hasDuplicates() {
        Set<String> seen = new HashSet<>();
        for (Trainee trainee : trainees) {
            String key = trainee.getFirstName() + "|" +
                    trainee.getLastName() + "|" +
                    trainee.getRating();
            if (seen.contains(key)) {
                return true;
            }
            seen.add(key);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) && Objects.equals(room, group.room) && Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}