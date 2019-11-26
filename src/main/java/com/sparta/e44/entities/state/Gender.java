package com.sparta.e44.entities.state;

public enum Gender {

    MALE,
    FEMALE,
    OTHER;


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


}
