package todomvc.features.addtodo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

// https://github.com/serenity-bdd/screenplay-pattern-todomvc/blob/master/src/test/java/net/serenitybdd/demos/todos/screenplay/features/record_todos/AddNewTodos.java
@RunWith(SerenityRunner.class)
public class AddItemsStory {
    Actor justin = Actor.named("Justin");

    @Managed
    public WebDriver hisBrowser;

    @Before
    public void justinCanBrowseTheWeb() {
        justin.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void should_be_able_to_add_an_item_to_the_todo_list() {

        givenThat(justin).wasAbleTo(StartWith.anEmptyTodoList());

        when(justin).attemptsTo(AddATodoItem.called("Feed the cat"));

        then(justin).should(seeThat(TheTodoItems.displayed(), hasItem("Feed the cat")));
    }
}
