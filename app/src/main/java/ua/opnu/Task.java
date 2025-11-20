package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String a = list.get(i);
            String b = list.get(i + 1);

            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) return true;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int val = queue.remove();
            queue.add(val);
            stack.push(val);
        }

        boolean isPal = true;

        for (int i = 0; i < size; i++) {
            int a = queue.remove();
            int b = stack.pop();
            if (a != b) isPal = false;
            queue.add(a);
        }

        return isPal;
    }

    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            if (v < 0) stack.push(v);
            queue.add(v);
        }

        while (!stack.isEmpty()) queue.add(stack.pop());

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            if (v >= 0) queue.add(v);
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            if (v % 2 == 0) stack.push(v);
            queue.add(v);
        }

        ArrayDeque<Integer> temp = new ArrayDeque<>();
        while (!stack.isEmpty()) temp.push(stack.pop());
        for (int v : temp) queue.add(v);

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            if (v % 2 != 0) queue.add(v);
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            max = Math.max(max, s.length());
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<>(list1);
        Set<Integer> common = new HashSet<>();
        for (int x : list2) {
            if (set.contains(x)) common.add(x);
        }
        return common.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> used = new HashSet<>();
        for (String v : map.values()) {
            if (!used.add(v)) return false;
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> res = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                res.put(key, map1.get(key));
            }
        }
        return res;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> res = new HashMap<>();
        for (int k : map.keySet()) {
            res.put(map.get(k), k);
        }
        return res;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) throw new IllegalArgumentException();

        Map<Integer, Integer> count = new HashMap<>();

        for (int v : map.values()) {
            count.put(v, count.getOrDefault(v, 0) + 1);
        }

        int bestValue = Integer.MAX_VALUE;
        int bestCount = Integer.MAX_VALUE;

        for (int v : count.keySet()) {
            int c = count.get(v);
            if (c < bestCount || (c == bestCount && v < bestValue)) {
                bestValue = v;
                bestCount = c;
            }
        }

        return bestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;

        for (int x : list) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            max = Math.max(max, f);
        }

        return max;
    }
}
