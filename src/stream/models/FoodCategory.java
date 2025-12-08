package stream.models;

public class FoodCategory {
    private final String title;
    private final String category;
    
    public FoodCategory(String title, String category) {
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

