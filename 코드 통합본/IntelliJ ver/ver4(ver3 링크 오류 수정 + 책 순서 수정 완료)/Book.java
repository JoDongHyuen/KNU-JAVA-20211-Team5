import java.nio.file.Paths;
import java.util.Scanner;

public class Book {
    private String bookTitle;
    private String bookWriter;
    private String bookPublisher;
    private String bookContent;
    private String bookLink;

    private static Scanner input;

    public Book(String fileName)
    {
        try{
            input = new Scanner(Paths.get(fileName));
            bookTitle = input.nextLine();
            bookWriter = input.nextLine();
            bookPublisher = input.nextLine();
            bookContent = input.nextLine();
            bookLink = input.nextLine();
            input.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public String getBookTitle()
    {
        return bookTitle;
    }

    public String getBookWriter()
    {
        return bookWriter;
    }

    public String getBookPublisher()
    {
        return bookPublisher;
    }

    public String getBookContent()
    {
        return bookContent;
    }

    public String getBookLink()
    {
        return bookLink;
    }
}
