class Artist{
    private String name;

    public Artist(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void display(){
        System.out.println("Artist Name: " + this.name);
    }
}
class Artwork{
    private String title;
    private Artist artist;

    public Artwork(String title, Artist artist){
        this.title = title;
        this.artist = artist;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public Artist getArtist(){
        return this.artist;
    }
    public void displayInformation(){
        System.out.println("Title: " + this.title);
        System.out.println("Artist: " + artist.getName());
    }
    public Artwork shallowCopy() {
        return new Artwork(title, artist);
    }
    public Artwork deepCopy() {
        return new Artwork(title, new Artist(artist.getName()));
    }
}

public class ArtGallery {
    public static void main(String[] args) {
         // Create an Artist object
         Artist artist = new Artist("Harry");

         // Create two Artwork objects
         Artwork artwork1 = new Artwork("DoddleCraft", artist);
         Artwork artwork2 = new Artwork("Artwork 2", artist);

        artwork2.setTitle("Felacia");

        // Print the details of both artworks
        System.out.println("Artwork 1:");
        artwork1.displayInformation();

        System.out.println();

        System.out.println("Artwork 2:");
        artwork2.displayInformation();

        // Create a shallow copy and a deep copy of the first artwork
        Artwork shallowCopy = artwork1.shallowCopy();
        Artwork deepCopy = artwork1.deepCopy();

        System.out.println();

        // Print the details of the original artwork, the shallow copy, and the deep copy
        System.out.println("Original Artwork:");
        artwork1.displayInformation();

        System.out.println();

        System.out.println("Shallow Copy:");
        shallowCopy.displayInformation();

        System.out.println();

        System.out.println("Deep Copy:");
        deepCopy.displayInformation();

        // Change the artist's name in the original artwork
        artist.setName("John");

        System.out.println();

        // Print the details of the original artwork, the shallow copy, and the deep copy again
        System.out.println("Original Artwork (after changing artist's name):");
        artwork1.displayInformation();

        System.out.println();

        System.out.println("Shallow Copy (after changing artist's name):");
        shallowCopy.displayInformation();

        System.out.println();

        System.out.println("Deep Copy (after changing artist's name):");
        deepCopy.displayInformation();
    }
}