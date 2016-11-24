package com.example.employees.test.questions;

import com.example.employees.test.ui.ResultsTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.TheSize;

@Subject("the displayed employees")
public class NumberOfEmployeesInResultTable implements Question<Integer>{

    @Override
    public Integer answeredBy(Actor actor) {
        return TheSize.of(ResultsTable.ITEM_COUNT)
                .viewedBy(actor)
                .resolveAll().size();
    }

}