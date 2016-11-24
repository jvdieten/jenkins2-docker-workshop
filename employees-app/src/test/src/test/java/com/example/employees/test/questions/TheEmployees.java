package com.example.employees.test.questions;

import net.serenitybdd.screenplay.Question;

public class TheEmployees {

    public static Question<Integer> count() {
        return new NumberOfEmployeesInResultTable();
    }
}
