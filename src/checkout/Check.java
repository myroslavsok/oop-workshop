package checkout;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Check {
    private List<Product> products = new ArrayList<>();
    private int points = 0;
    private int discount = 0;
    private LocalDate dateOfCheck = LocalDate.now();

    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : this.products) {
            totalCost += product.price;
        }
        return (this.discount > 0) ? totalCost - (totalCost * discount / 100) : totalCost;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalPoints() {
        return getTotalCost() + points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getCostByCategory(Category category) {
        return products.stream()
                .filter(p -> p.category == category)
                .mapToInt(p -> p.price)
                .reduce(0, (a, b) -> a + b);
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    LocalDate getDateOfCheck() {
        return this.dateOfCheck;
    }
}
