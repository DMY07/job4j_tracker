package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0;
        int totalSubjects = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubjects++;
            }
        }
        return totalSubjects == 0 ? 0D : (double) totalScore / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            int totalSubjects = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            double averageScore = totalSubjects == 0 ? 0D : (double) totalScore / totalSubjects;
            result.add(new Label(pupil.name(), averageScore));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectTotalScores = new LinkedHashMap<>();
        Map<String, Integer> subjectCounts = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectTotalScores.merge(subject.name(), subject.score(), Integer::sum);
                subjectCounts.merge(subject.name(), 1, Integer::sum);
            }
        }
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectTotalScores.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();
            int count = subjectCounts.get(subjectName);
            double averageScore = count == 0 ? 0D : (double) totalScore / count;
            result.add(new Label(subjectName, averageScore));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> studentScores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            studentScores.add(new Label(pupil.name(), totalScore));
        }
        return studentScores.stream().max(Label::compareTo).orElse(null);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectTotalScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectTotalScores.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        return subjectTotalScores.entrySet().stream()
                .map(entry -> new Label(entry.getKey(), entry.getValue()))
                .max(Label::compareTo)
                .orElse(null);
    }
}
