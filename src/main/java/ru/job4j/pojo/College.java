package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Dima");
        student.setGroup("А-01");
        student.setReceipt("01-01-2001");
        System.out.println(student.getName() + " из группы " + student.getGroup() + " поступил " + student.getReceipt());
    }
}
