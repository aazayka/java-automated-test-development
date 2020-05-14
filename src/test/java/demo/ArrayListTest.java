package demo;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

/**
 * Test Case
 */
public class ArrayListTest { //SUT
    private ArrayList<Object> sut;

    public ArrayListTest() {
        System.out.println(">>>> CREATED!!!!!");
    }

    //    @BeforeClass, static!!!
    @Before //@After
    public void initSut() {
        sut = new ArrayList<>();
    }

    @Test
    public void shouldGetElementWhenAddNullElement() { //BDD
        //region Fixture | Arrange | Given
        Object dummyElement = null;
        assumeTrue(sut.size() == 0);
        //endregion

        //region Act | When
        sut.add(dummyElement);
        //endregion

        //region Assert | Then
        assertEquals("", dummyElement, sut.get(0));
        assertEquals(1, sut.size());
        //endregion
    }

    @Test
    public void shouldBeingEmptyWhenCreated() {
        assertEquals(0, sut.size());
    }
}
