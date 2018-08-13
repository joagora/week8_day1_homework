import models.Writer;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class WriterTest {

    Writer writer;
    @Before
    public void before() {
        writer = new Writer("Jonathan", "Safran Foer");
    }

    @Test
    public void hasFirstName() {
        assertEquals("Jonathan", writer.getFirstName());
    }
}
