public class PrintInfo {
    public void printBookDetails(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Year Published: " + book.getYearPublished());
        System.out.println("Price: $" + book.getPrice());
    }
}