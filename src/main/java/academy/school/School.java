package academy.school;

import java.util.*;

public class School {
    private String name;
    private int year;
    private Set<Group> groups;

    public School(String name, int year) throws TrainingException {
        setName(name);
        setYear(year);
        this.groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) throws TrainingException {
        if (group == null) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }

        // Проверяем, есть ли группа с таким же именем
        for (Group existingGroup : groups) {
            if (existingGroup.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }

        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        if (!groups.remove(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public void removeGroup(String name) throws TrainingException {
        if (name == null || name.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }

        Group groupToRemove = null;
        for (Group group : groups) {
            if (group.getName().equals(name)) {
                groupToRemove = group;
                break;
            }
        }

        if (groupToRemove == null) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }

        groups.remove(groupToRemove);
    }

    public boolean containsGroup(Group group) {
        if (group == null) {
            return false;
        }
        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year && Objects.equals(name, school.name) && Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, groups);
    }
}