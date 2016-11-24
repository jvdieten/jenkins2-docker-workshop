package com.example.employees.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import com.example.employees.test.ui.EmployeeSearchPage;

public class OpenTheApplication implements Task {

    EmployeeSearchPage employeeSearchPage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(employeeSearchPage)
        );
    }
}
