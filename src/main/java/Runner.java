import db.DBBook;
import db.DBWriter;
import models.Book;
import models.Writer;

public class Runner {
    public static void main(String[] args) {
        Book book = new Book("Everything is Illuminated", 120);
        Book book1 = new Book("Nineteen Eighty Four", 160);
        Writer writer = new Writer("Jonathan", "Safran Foer");
        Writer writer2 = new Writer("George", "Orwell");
        DBBook.save(book);
        DBBook.save(book1);
        book.setNumberOfPages(30);
        DBBook.update(book);
        DBBook.delete(book1);

        DBWriter.save(writer);
        DBWriter.save(writer2);
        System.out.println(DBWriter.findById(1));

    }
}
