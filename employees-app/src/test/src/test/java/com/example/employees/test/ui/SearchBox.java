package com.example.employees.test.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBox {
    public static Target SEARCH_FIELD = Target.the("search field").located(By.id("employeeName"));
    public static Target SEARCH_BUTTON = Target.the("search button").located(By.className("btn.btn-info"));
}
