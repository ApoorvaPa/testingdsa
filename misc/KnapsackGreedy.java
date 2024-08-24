import java.util.*;

class Item implements Comparable<Item> {
    int weight;
    int value;
    Double cost;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.cost = (double)value / (double)weight;
    }

    @Override
    public int compareTo(Item other) {
        return this.cost.compareTo(other.cost);
    }
}

public class KnapsackGreedy {
    public static int greedyKnapsack01(int W, Item[] items) {
        Arrays.sort(items, Collections.reverseOrder());
        int currentWeight = 0;
        int finalValue = 0;

        for (Item item : items) {
            // Check if adding the current item doesn't exceed the capacity
            if (currentWeight + item.weight <= W) {
                currentWeight += item.weight; // Add item's weight to the current weight
                finalValue += item.value; // Add item's value to the total value
            }
        }
        return finalValue;
    }

    public static void main(String[] args) {
        int W = 50; // Weight capacity of knapsack
        Item[] items = {new Item(10, 60), new Item(20, 100), new Item(30, 120)};

        int maxValue = greedyKnapsack01(W, items);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
