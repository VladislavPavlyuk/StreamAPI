package stream.models;

public class FoodItem {
    private final String title;
    private final String category;
    
    public FoodItem(String title, String category) {
        this.title = title;
        this.category = category;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getCategory() {
        return category;
    }
    
    @Override
    public String toString() {
        return title + " (" + category + ")";
    }
}

