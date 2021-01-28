package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void WhenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllItems() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новые заявки */
        Item[] items = {
                new Item(0, "item 1"),
                new Item(1, "item 2")
        };
        tracker.add(items[0]);
        tracker.add(items[1]);

        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        // assertArrayEquals(tracker.findAll(), items);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Output Items ===" + System.lineSeparator() +
                        items[0].toString() + System.lineSeparator() +
                        items[1].toString() + System.lineSeparator() +
                        "Data output is completed!" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }


    @Test
    public void whenFindByIdItemTrue() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новые заявки */
        Item[] items = {
                new Item("item 1"),
                new Item("item 2")
        };
        tracker.add(items[0]);
        tracker.add(items[1]);
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", Integer.toString(items[0].getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        //assertThat(tracker.findById(items[0].getId()), is(items[0]));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find Item by Id ===" + System.lineSeparator() +
                        items[0].toString() + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdItemFalse() {
        Tracker tracker = new Tracker();

        Item[] items = {
                new Item("item 1"),
                new Item("item 2")
        };
        tracker.add(items[0]);
        tracker.add(items[1]);
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "3", "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        //assertThat(tracker.findById(3), is(nullValue()));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find Item by Id ===" + System.lineSeparator() +
                        "Item not found!" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));

    }

    @Test
    public void whenFindByNameItemTrue() {
        Tracker tracker = new Tracker();

        Item[] items = {
                new Item("item 1"),
                new Item("item 2")
        };
        tracker.add(items[0]);
        tracker.add(items[1]);
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "item 2", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        //assertThat(tracker.findByName("item 2")[0], is(items[1]));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find Item by Name ===" + System.lineSeparator() +
                        items[1].toString() + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameItemFalse() {
        Tracker tracker = new Tracker();

        Item[] items = {
                new Item("item 1"),
                new Item("item 2")
        };
        tracker.add(items[0]);
        tracker.add(items[1]);
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "item 3", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        //assertThat(tracker.findByName("item 3").length, is(0));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find Item by Name ===" + System.lineSeparator() +
                        "Item not found!" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        //StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

}