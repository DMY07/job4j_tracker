package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                sum += s.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil p : pupils) {
            double sum = 0;
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            result.add(new Label(p.name(), sum / p.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> totalScores = new LinkedHashMap<>();
        Map<String, Integer> subjectCounts = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                totalScores.merge(s.name(), s.score(), Integer::sum);
                subjectCounts.merge(s.name(), 1, Integer::sum);
            }
        }
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : totalScores.entrySet()) {
            String subject = entry.getKey();
            double average = (double) entry.getValue() / subjectCounts.get(subject);
            result.add(new Label(subject, average));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil p : pupils) {
            double sum = 0;
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            result.add(new Label(p.name(), sum));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> totalScores = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                totalScores.merge(s.name(), s.score(), Integer::sum);
            }
        }
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : totalScores.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue()));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
