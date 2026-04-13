package academy.school;

import java.util.*;

public class TraineeQueue {
    private Queue<Trainee> queue;

    public TraineeQueue() {
        this.queue = new LinkedList<>();
    }

    public void addTrainee(Trainee trainee) {
        if (trainee != null) {
            queue.add(trainee);
        }
    }

    public Trainee removeTrainee() throws TrainingException {
        if (queue.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
