import com.codeborne.selenide.Condition;
import org.junit.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CardCounter {

    @Test
    public void countCards(){
        open("https://qa-mesto.praktikum-services.ru/");
        // Блок авторизации
        $(byId("email")).setValue("merkuryev@mail.ru");
        $(byId("password")).setValue("ynossony");
        $(byClassName("auth-form__button")).click();
        // Подсчитай количество карточек, соответствующих местоположению "Байкал"
        $(byClassName("card__image")).shouldBe(Condition.visible);
        //$(byTagName("header__logout").shouldBe(clickable));

        Integer cardsQuantity = $$(byText("Москва")).size();

        System.out.println(cardsQuantity);

    }

    @Test
    public void task1() {
        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("merkuryev@mail.ru");
        $(byId("password")).setValue("ynossony");
        $(byClassName("auth-form__button")).click();
        $(byClassName("card__image")).shouldBe(visible);
        //$(byClassName("profile__image")).click();
        $(byCssSelector(".profile__image")).click();

        // в поле ссылки на изображение введи ссылку
        $(byId("owner-avatar")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png");

        // сохрани новое изображение
        $(byXpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }
    @Test
    /*
    Напиши автотест, который добавит новую карточку, а потом её удалит. Используй поиск по классу.
Создай автотест, который нажмёт на кнопку добавления нового контента. Откроется новое окно. Введи «Москва» в поле «Название». Вставь в поле для ссылки ссылку на изображение https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg. Используй поиск по атрибуту name.
Сохрани контент. Примени поиск по XPath. После корневого элемента ищи элемент form и его атрибут name. Найди кнопку сохранения через поиск по типу элемента и тексту.
Новую карточку нужно удалить, чтобы привести тестовый стенд в изначальное состояние. Найди кнопку удаления карточки. Используй поиск по XPath — относительный путь до элемента и значению его атрибута class. Кликни по ней.
     */
    public void task2() {
        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("merkuryev@mail.ru");
        $(byId("password")).setValue("ynossony");
        $(byClassName("auth-form__button")).click();
        $(byClassName("card__image")).shouldBe(visible);
        // кликни по кнопке добавления нового контента
        $(byClassName("profile__add-button")).click();
        // в поле названия введи «Москва»
        $(byName("name")).setValue("Москва");
        // в поле ссылки на изображение введи ссылку
        $(byName("link")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg");
        // сохрани контент
        $(byXpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        // удали добавленную карточку, кликнув по кнопке удаления
        $(byXpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();
    }
    @Test
    /*
    Нужно поменять описание и имя.
Напиши автотест, который нажмёт кнопку редактирования профиля. Используй поиск по классу.
Откроется отдельное окно. В поле «Имя» введи «Аристарх Сократович» а в поле «Занятие» — «Автор автотестов». Это можно сделать через поиск по атрибуту id.
Сохрани изменения. Примени поиск по XPath: после корневого элемента ищи элемент form и его атрибут name. Найди кнопку сохранения через поиск по типу элемента и тексту.
     */
    public void test3() {
        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("merkuryev@mail.ru");
        $(byId("password")).setValue("ynossony");
        $(byClassName("auth-form__button")).click();
        $(byClassName("card__image")).shouldBe(visible);

        // кликни по кнопке редактирования профиля
        $(byClassName("profile__edit-button")).click();
        //введи «Аристарх Сократович» в поле «Имя»
        $(byId("owner-name")).setValue("Аристарх Сократович");
        // введи «Автор автотестов» в поле «Занятие»
        $(byId("owner-description")).setValue("Автор автотестов");
        // сохрани изменения
        $(byXpath(".//form[@name='edit']/button[text()='Сохранить']")).click();
    }

}