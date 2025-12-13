import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("electronics", new ArrayList<>());
        map.put("grocery", new ArrayList<>());
        map.put("pharmacy", new ArrayList<>());
        map.put("restaurant", new ArrayList<>());

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;
            if (!map.containsKey(businessLine[i])) continue;
            if (code[i].length() == 0) continue;

            boolean valid = true;
            for (char c : code[i].toCharArray()) {
                if (!(Character.isLetterOrDigit(c) || c == '_')) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;

            map.get(businessLine[i]).add(code[i]);
        }

        List<String> res = new ArrayList<>();
        String[] order = {"electronics", "grocery", "pharmacy", "restaurant"};

        for (String b : order) {
            List<String> list = map.get(b);
            Collections.sort(list);
            res.addAll(list);
        }

        return res;
    }
}
