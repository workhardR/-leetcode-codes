import java.util.*;
class MovieRentingSystem {
    private static class Entry {
        int shop, movie, price;
        Entry(int s, int m, int p) {
            shop = s; movie = m; price = p;
        }
        public boolean equals(Object o) {
            if (!(o instanceof Entry)) return false;
            Entry e = (Entry) o;
            return this.shop == e.shop && this.movie == e.movie && this.price == e.price;
        }
        @Override
        public int hashCode() {
            return Objects.hash(shop, movie, price);
        }
    }

    private Map<String, Integer> priceMap;
    private Map<Integer, TreeSet<Entry>> available;
    private TreeSet<Entry> rented;
    
    private Comparator<Entry> compAvail = (a, b) -> {
        if (a.price != b.price) return a.price - b.price;
        return a.shop - b.shop;
    };
    
    private Comparator<Entry> compRented = (a, b) -> {
        if (a.price != b.price) return a.price - b.price;
        if (a.shop != b.shop) return a.shop - b.shop;
        return a.movie - b.movie;
    };

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();
        rented = new TreeSet<>(compRented);
        
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "#" + movie, price);
            available.computeIfAbsent(movie, k -> new TreeSet<>(compAvail))
                     .add(new Entry(shop, movie, price));
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        Iterator<Entry> it = available.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            res.add(it.next().shop);
            count++;
        }
        return res;
    }
    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        Entry e = new Entry(shop, movie, price);
        available.get(movie).remove(e);
        rented.add(e);
    }
    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        Entry e = new Entry(shop, movie, price);
        rented.remove(e);
        available.get(movie).add(e);
    }
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<Entry> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            Entry e = it.next();
            res.add(Arrays.asList(e.shop, e.movie));
            count++;
        }
        return res;
    }
}
