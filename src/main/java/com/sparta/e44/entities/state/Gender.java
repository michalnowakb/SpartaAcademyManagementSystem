package com.sparta.e44.entities.state;

public enum Gender {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String value;
    Gender(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Gender getGender(char g){
        switch(g){
            case 'M':
                return Gender.MALE;
            case 'F':
                return Gender.FEMALE;
            case 'O':
                return Gender.OTHER;
        }
        return Gender.OTHER;
    }
    public Gender[] valuesWithoutCurrent(Gender gender){
        Gender[] genderList = values();
        Gender[] filteredGenderList = new Gender[values().length-1];
        int filteredIndex = 0;
        for(int i=0;i<values().length;i++){
            if(!genderList[i].equals(gender)) filteredGenderList[filteredIndex++] = genderList[i];
        }
        return filteredGenderList;
    }


}
