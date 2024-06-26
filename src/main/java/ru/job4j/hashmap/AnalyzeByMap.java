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
        Map<String, int[]> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int[] scores = subjectScores.getOrDefault(subject.name(), new int[2]);
                scores[0] += subject.score();
                scores[1] += 1;
                subjectScores.put(subject.name(), scores);
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, int[]> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            int[] scores = entry.getValue();
            double averageScore = scores[1] == 0 ? 0D : (double) scores[0] / scores[1];
            result.add(new Label(subjectName, averageScore));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label bestStudent = null;
        double highestScore = 0;
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            if (bestStudent == null || totalScore > highestScore) {
                highestScore = totalScore;
                bestStudent = new Label(pupil.name(), totalScore);
            }
        }
        return bestStudent;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectTotalScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectTotalScores.put(subject.name(), subjectTotalScores.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        Label bestSubject = null;
        int highestScore = 0;
        for (Map.Entry<String, Integer> entry : subjectTotalScores.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();
            if (bestSubject == null || totalScore > highestScore) {
                highestScore = totalScore;
                bestSubject = new Label(subjectName, totalScore);
            }
        }
        return bestSubject;
    }
}
