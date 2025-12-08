package stream.models;

import java.util.Objects;

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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodCategory that = (FoodCategory) o;
        return Objects.equals(title, that.title) && Objects.equals(category, that.category);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(title, category);
    }
}

