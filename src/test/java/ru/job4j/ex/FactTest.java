package ru.job4j.ex;

//import junit.framework.TestCase;
import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void NLessThen0() {
        Fact.calc(-1);
    }
}
