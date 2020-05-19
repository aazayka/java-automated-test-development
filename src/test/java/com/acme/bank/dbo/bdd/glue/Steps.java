package com.acme.bank.dbo.bdd.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;

public class Steps {
    @Given("система доступна по АдресуСистемы {string}")
    public void системаДоступнаПоАдресуСистемы(String address) {
    }

    @Given("интернет-магазин доступен по АдресуТильды.")
    public void интернетМагазинДоступенПоАдресуТильды() {
    }

    @Допустим("^система управления бронированиями выдает отсутствие текущих гостей")
    public void системаУправленияБронированиямиВыдаетОтсутствиеТекущихГостей() {
    }
}
