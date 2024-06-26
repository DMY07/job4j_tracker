package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAsc() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        Comparator<Job> comparator = new JobAscByPriority();
        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameDesc() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameDescAndPriorityAsc() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameDescAndPriorityDesc() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isLessThan(0);
    }
}
