package ru.job4j.oop;

public class Profession {
    private String name, surname, education, birthday;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public Profession (String name, String surname, String education, String birthday){
        this.name = name;
        this.birthday = birthday;
        this.education = education;
        this.surname = surname;
    }


}