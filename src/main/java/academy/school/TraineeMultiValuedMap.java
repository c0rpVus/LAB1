package academy.school;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import java.util.Collection;

public class TraineeMultiValuedMap {
    private MultiValuedMap<Integer, Trainee> multiValuedMap;

    public TraineeMultiValuedMap() {
        this.multiValuedMap = new HashSetValuedHashMap<>();
    }

    public boolean addTrainee(Trainee trainee) {
        if (trainee == null) {
            return false;
        }
        int rating = trainee.getRating();
        return multiValuedMap.put(rating, trainee);
    }

    public boolean removeTrainee(Trainee trainee) {
        if (trainee == null) {
            return false;
        }
        int rating = trainee.getRating();
        return multiValuedMap.removeMapping(rating, trainee);
    }

    public Collection<Trainee> getTraineesByRating(int rating) {
        if (rating < 1 || rating > 5) {
            return java.util.Collections.emptyList();
        }
        return multiValuedMap.get(rating);
    }

    public boolean hasAnyBodyRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        Collection<Trainee> trainees = multiValuedMap.get(rating);
        return trainees != null && !trainees.isEmpty();
    }

    public int getTraineesCount() {
        return multiValuedMap.size();
    }


    // Возвращает все оценки, которые есть в Map
    public Collection<Integer> getAllRatings() {
        return multiValuedMap.keySet();
    }

    // Возвращает Map с группировкой по оценкам
    public MultiValuedMap<Integer, Trainee> getMultiValuedMap() {
        return multiValuedMap;
    }

    // Очищает все данные
    public void clear() {
        multiValuedMap.clear();
    }

    // Проверяет, пуста ли карта
    public boolean isEmpty() {
        return multiValuedMap.isEmpty();
    }
}