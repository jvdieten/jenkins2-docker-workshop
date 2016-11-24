package com.example.employees.test.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by joost on 24/11/2016.
 */
public class ResultsTable {

    public static Target ITEM_COUNT = Target.the("table rows").located(By.xpath("//tbody//tr"));

}
