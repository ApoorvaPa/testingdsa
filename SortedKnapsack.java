import java.util.Scanner;
public class SortedKnapsack {

    static class Item {
        int weight;
        int value;
        double ratio;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }

    public static void selectionSortItemsByRatio(Item[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < items.length; j++) {
                if (items[j].ratio > items[maxIndex].ratio) {
                    maxIndex = j;
                }
            }
            Item temp = items[maxIndex];
            items[maxIndex] = items[i];
            items[i] = temp;
        }
    }

    public static int greedyKnapsack01(int W, Item[] items) {
        selectionSortItemsByRatio(items);
        int currentWeight = 0, finalValue = 0;
        for (Item item : items) {
            if (currentWeight + item.weight <= W) {
                currentWeight += item.weight;
                finalValue += item.value;
            }
        }
        return finalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the weight capacity of the knapsack: ");
        int W = sc.nextInt();
        
        System.out.println("Enter number of items");
      
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight and value respectively for item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            int value = sc.nextInt();
            items[i] = new Item(weight, value);
        }

        

        int maxValue = greedyKnapsack01(W, items);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
