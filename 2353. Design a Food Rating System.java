import java.util.*;
class FoodRatings {
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, TreeSet<String>> cuisineToFoods;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(
                (a, b) -> {
                    int r1 = foodToRating.get(a);
                    int r2 = foodToRating.get(b);
                    if (r1 != r2) return r2 - r1; 
                    return a.compareTo(b);       
                }
            ));

            cuisineToFoods.get(cuisine).add(food);
        }
    }
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> set = cuisineToFoods.get(cuisine);

        set.remove(food);              
        foodToRating.put(food, newRating);
        set.add(food);                 
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first();
    }
}
