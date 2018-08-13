import models.Book;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BookTest {


    Book book;
    @Before
    public void before() {
        book = new Book("Everything is Illuminated", 120);
    }

    @Test
    public void hasTitle() {
        assertEquals("Everything is Illuminated", book.getTitle());
    }

    @Test
    public void hasNumberOfPages() {
        assertEquals(120, book.getNumberOfPages());
    }

}
