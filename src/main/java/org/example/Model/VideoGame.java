package org.example.Model;

public class VideoGame extends Product {
    private String platform;
    private String genre;
    private String name;

    public VideoGame(int productID, double price, int quantity) {
        super(productID, price, quantity);
    }

    public VideoGame(int productID, double price, int quantity, String platform, String genre, String name) {
        super(productID, price, quantity);
        this.platform = platform;
        this.genre = genre;
        this.name = name;
        this.type = "Video Game";
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return "\nVideo Game: \n" +
                "Product ID: " + productID + "\n" +
                "Name: " + name + "\n" +
                "Platform: " + platform + "\n" +
                "Genre: " + genre + "\n" +
                "Price: $" + getPrice() + "\n" +
                "Quantity: " + getQuantity();
    }
}
