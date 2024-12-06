package org.example.Model;

public class Electronics extends Product {
    private String company;
    private String storage;
    private String model;
    private String type;

    public Electronics(int productID, double price, int quantity) {
        super(productID, price, quantity);
    }

    public Electronics(int productID, double price, int quantity, String company, String storage, String model) {
        super(productID, price, quantity);
        this.company = company;
        this.storage = storage;
        this.model = model;
        this.type = "Electronics";
    }

    public String getCompany() {
        return company;
    }

    public String getStorage() {
        return storage;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getDetails() {
        return "Electronics: \n" +
                "Company: " + company + "\n" +
                "Storage: " + storage + "\n" +
                "Model: " + model + "\n" +
                "Price: $" + getPrice() + "\n" +
                "Quantity: " + getQuantity();
    }
}
