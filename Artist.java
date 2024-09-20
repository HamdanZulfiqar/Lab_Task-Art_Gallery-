/**
 * Represents an Artist in the digital art gallery management system.
 */
public class Artist {
    private String name;

    /**
     * Constructor to initialize the artist's name.
     * @param name the artist's full name
     */
    public Artist(String name) {
        this.name = name;
    }

    /**
     * Getter method to retrieve the artist's name.
     * @return the artist's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to display the artist's information in a user-friendly format.
     */
    public void displayInformation() {
        System.out.println("Artist Name: " + name);
    }
}
/**
 * Represents an Artwork in the digital art gallery management system.
 */
public class Artwork {
    private String title;
    private int year;
    private Artist artist;

    /**
     * Constructor to initialize the artwork's title, year, and artist.
     * @param title the title of the artwork
     * @param year the year the artwork was created
     * @param artist the artist who created the artwork
     */
    public Artwork(String title, int year, Artist artist) {
        this.title = title;
        this.year = year;
        this.artist = artist;
    }

    /**
     * Constructor to initialize the artwork's title and year, with a default "Unknown Artist".
     * @param title the title of the artwork
     * @param year the year the artwork was created
     */
    public Artwork(String title, int year) {
        this(title, year, new Artist("Unknown Artist"));
    }

    /**
     * Getter method to retrieve the artwork's title.
     * @return the artwork's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method to retrieve the artwork's year.
     * @return the artwork's year
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter method to retrieve the artwork's artist.
     * @return the artwork's artist
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Method to display the artwork's details in a user-friendly format.
     */
    public void displayInformation() {
        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Artist: " + artist.getName());
    }

    /**
     * Method to create a shallow copy of the artwork.
     * @return a new Artwork object that shares the same Artist object as the original
     */
    public Artwork shallowCopy() {
        return new Artwork(title, year, artist);
    }

    /**
     * Method to create a deep copy of the artwork.
     * @return a new Artwork object with a completely independent copy of the Artist object
     */
    public Artwork deepCopy() {
        return new Artwork(title, year, new Artist(artist.getName()));
    }
}
/**
 * Demonstrates the functionality of the Artist and Artwork classes.
 */
public class main {
    public static void main(String[] args) {
        // Create an Artist object
        Artist artist = new Artist("John Doe");

        // Create two Artwork objects
        Artwork artwork1 = new Artwork("Artwork 1", 2020, artist);
        Artwork artwork2 = new Artwork("Artwork 2", 2021);

        // Set the title and year of the second artwork using setter methods
        artwork2.setTitle("New Title");
        artwork2.setYear(2022);

        // Print the details of both artworks
        System.out.println("Artwork 1:");
        artwork1.displayInformation();
        System.out.println("Artwork 2:");
        artwork2.displayInformation();

        // Create a shallow copy and a deep copy of the first artwork
        Artwork shallowCopy = artwork1.shallowCopy();
        Artwork deepCopy = artwork1.deepCopy();

        // Print the details of the original artwork, the shallow copy, and the deep copy
        System.out.println("Original Artwork:");
        artwork1.displayInformation();
        System.out.println("Shallow Copy:");
        shallowCopy.displayInformation();
        System.out.println("Deep Copy:");
        deepCopy.displayInformation();

        // Change the artist's name in the original artwork
        artist.setName("Jane Doe");

        // Print the details of the original artwork, the shallow copy, and the deep copy again
        System.out.println("Original Artwork (after changing artist's name):");
        artwork1.displayInformation();
        System.out.println("Shallow Copy (after changing artist's name):");
        shallowCopy.displayInformation();
        System.out.println("Deep Copy (after changing artist's name):");
        deepCopy.displayInformation();
    }
}