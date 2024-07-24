package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(pupil -> {
                    double average = pupil.subjects().stream()
                            .mapToInt(Subject::score)
                            .average()
                            .orElse(0);
                    return new Tuple(pupil.name(), average);
                })
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score)
                ))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects().stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(new Tuple("no student", 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::score)
                ))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(new Tuple("No subjects", 0));
    }
}