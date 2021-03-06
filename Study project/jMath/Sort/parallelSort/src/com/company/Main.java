package com.company;

import java.util.Arrays;

public class Main {
    public static final int LISTSIZE = 20_000_000;
    public static final int SAMPLESIZE = 10;

    public static void main(String[] args) {
        RandomList randList = new RandomList(LISTSIZE);
        float[] list;
        float[] preSorted = randList.getList();
        Arrays.sort(preSorted);

        TestContext context;
        long duration;

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores + " cores available");


        // Quicksort
        System.out.println("Quicksort:");
        list = randList.getList();
        context = new TestContext(new Quicksort());
        duration = context.executeStrategy(SAMPLESIZE) / 10_000;
        System.out.println("\tTime: " + duration);
        System.out.println("");

        // QuicksortAction
        System.out.println("Parallel Quicksort:");
        list = randList.getList();
        QuicksortAction task = new QuicksortAction(list, 0, list.length - 1);
        context = new TestContext(task);
        duration = context.executeStrategy(SAMPLESIZE) / 10_000;
        System.out.println("\tTime: " + duration);
        System.out.println("");

        // Merge sort
        System.out.println("Merge sort:");
        list = randList.getList();
        float[] tmp = randList.getList();
        context = new TestContext(new MergeSort(list, tmp, 0, list.length - 1));
        duration = context.executeStrategy(SAMPLESIZE) / 10_000;
        System.out.println("\tTime: " + duration);
        System.out.println("");

        // MergeSortAction
        System.out.println("Parallel Merge sort:");
        list = randList.getList();
        float[] list2 = randList.getList();
        context = new TestContext(new MergeSortAction(list, list2, 0, list.length - 1));
        duration = context.executeStrategy(SAMPLESIZE) / 10_000;
        System.out.println("\tTime: " + duration);
        System.out.println("");
    }
}
