package org.example.Model;

public class Electronics extends Product {
    private String company;
    private String storage;
    private String model;

    public Electronics(int productID, double price, int quantity, String company, String storage, String model) {
        super(productID, price, quantity);
        this.model = model;
        this.company = company;
        this.storage = storage;
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
        return "Electronic: " + "\n" + "Company: " + company + "\n" + "Storage: " + storage + "\n" + "Model: " + model + "\n" + "Price: " + getPrice() + "\n" + "Quantity: " + getQuantity();
    }
}
