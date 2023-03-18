package week3;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static double getOptimalValue(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];

        // Create an array of items with weight, value, and value per unit weight
        for (int i = 0; i < n; i++) {
            double valuePerUnitWeight = (double) values[i] / weights[i];
            items[i] = new Item(weights[i], values[i], valuePerUnitWeight);
        }

        // Sort the items in descending order of value per unit weight
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o2.valuePerUnitWeight, o1.valuePerUnitWeight);
            }
        });

        double totalValue = 0.0;
        int currentCapacity = capacity;

        // Iterate through the sorted items and add as much of each item as possible to the knapsack
        for (Item item : items) {
            int weight = Math.min(item.weight, currentCapacity);
            totalValue += weight * item.valuePerUnitWeight;
            currentCapacity -= weight;
            if (currentCapacity == 0) {
                break;
            }
        }

        return totalValue;
    }

    // An item with weight, value, and value per unit weight
    static class Item {
        int weight;
        int value;
        double valuePerUnitWeight;

        public Item(int weight, int value, double valuePerUnitWeight) {
            this.weight = weight;
            this.value = value;
            this.valuePerUnitWeight = valuePerUnitWeight;
        }
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(weights ,values, capacity));
    }
    
    public static void printArray(double [] doubleArray) {
    	for(double d : doubleArray) {
    		System.out.print(d + " ");
    	}
    	System.out.println();
    }
} 
