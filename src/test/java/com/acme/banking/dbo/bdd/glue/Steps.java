package com.acme.banking.dbo.bdd.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class Steps {
    @Given("система доступна по АдресуСистемы {string}")
    public void системаДоступнаПоАдресуСистемы(String address) {
    }

    @Given("интернет-магазин доступен по АдресуТильды.")
    public void интернетМагазинДоступенПоАдресуТильды() {
    }

    @Допустим("система управления бронированиями выдает отсутствие текущих гостей.")
    public void системаУправленияБронированиямиВыдаетОтсутствиеТекущихГостей() {
    }

    @Когда("администратор запрашивает список ссылок на магазин по {string}")
    public void администраторЗапрашиваетСписокСсылокНаМагазинПоАдресуСистемыShopLinks(String address) {
    }

    @Тогда("он получает пустой список ссылок.")
    public void онПолучаетПустойСписокСсылок() {
    }
}
