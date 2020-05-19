package demo;

import org.junit.*;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
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
//        Assert.assertSame();
        Assert.assertEquals(0.3, .1 + .2, 0.000001);

        assertThat(sut.size())
                .isLessThan(0)
                .isNegative()
                .isEqualTo(1);
        //endregion
    }

    @Test(timeout = 5_000, expected = IllegalArgumentException.class)
    public void shouldBeingEmptyWhenCreated() {
        assertEquals(0, sut.size());
    }
}
