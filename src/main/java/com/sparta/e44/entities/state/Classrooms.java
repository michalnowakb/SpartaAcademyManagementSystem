package com.sparta.e44.entities.state;

public enum Classrooms {

    Innovation("Innovation"),
    Flexibility("Flexibility"),
    Empathy("Empathy"),
    Drive("Drive"),
    Diversity("Diversity"),
    Collaboration("Collaboration"),
    Turing("Turing");


    private String value;
    Classrooms(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Classrooms getClassroom(String classroom){
        switch (classroom){
            case "Innovation":
                return Classrooms.Innovation;
            case "Flexibility":
                return Classrooms.Flexibility;
            case "Empathy":
                return Classrooms.Empathy;
            case "Drive":
                return Classrooms.Drive;
            case "Diversity":
                return Classrooms.Diversity;
            case "Collaboration":
                return Classrooms.Collaboration;
            case "Turing":
                return Classrooms.Turing;
        }
        return Classrooms.Turing;
    }
}
