package com.sparta.e44.entities.state;

public enum Grade {
    A_PLUS,
    A,
    A_MINUS,
    B_PLUS,
    B,
    B_MINUS,
    C_PLUS,
    C,
    C_MINUS,
    NOT_APPLICABLE;
    public static Grade getGrade(String g) {
        switch (g) {
            case "A+":
                return Grade.A_PLUS;
            case "A":
                return Grade.A;
            case "A-":
                return Grade.A_MINUS;
            case "B+":
                return Grade.B_PLUS;
            case "B":
                return Grade.B;
            case "B-":
                return Grade.B_MINUS;
            case "C+":
                return Grade.C_PLUS;
            case "C":
                return Grade.C;
            case "C-":
                return Grade.C_MINUS;
        }
        return Grade.NOT_APPLICABLE;

    }
}
