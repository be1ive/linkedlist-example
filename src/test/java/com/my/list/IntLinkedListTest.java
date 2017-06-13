package com.my.list;


import static com.my.list.IntLinkedList.newIntLinkedList;

/**
 * Created by nik.denisenko on 14/06/2017.
 */
public class IntLinkedListTest {

    public static void test_element_can_be_appended() {
        final IntLinkedList ll = newIntLinkedList().append(1).append(2).append(3);

        assert ll.size() == 3;

        int i = 0;
        for (int c : ll) {
            if (i == 0) assert c == 1;
            if (i == 1) assert c == 2;
            if (i == 2) assert c == 3;
            i++;
        }
        System.out.println("test_element_can_be_appended completed");
    }

    public static void test_tailed_element_can_be_removed() {
        final IntLinkedList ll = newIntLinkedList().append(1).append(2).append(3);

        ll.removeTail();

        assert ll.size() == 2;

        int i = 0;
        for (int c : ll) {
            if (i == 0) assert c == 1;
            if (i == 1) assert c == 2;
            i++;
        }
        System.out.println("test_greater_element_can_be_removed completed");
    }

    public static void test1_greater_element_can_be_removed () {
        final IntLinkedList ll =
                newIntLinkedList()
                        .append(5).append(4).append(3).append(2).append(1)
                        .append(1).append(3).append(2).append(4).append(5);

        ll.removeGreaterThan(2);

        assert ll.size() == 4;

        int i = 0;
        for (int c : ll) {
            if (i == 0) assert c == 2;
            if (i == 1) assert c == 1;
            if (i == 2) assert c == 1;
            if (i == 3) assert c == 2;
            i++;
        }
        System.out.println("test1_greater_element_can_be_removed completed");
    }

    public static void test2_greater_element_can_be_removed() {
        final IntLinkedList ll =
                newIntLinkedList()
                        .append(1).append(1).append(1).append(1).append(1)
                        .append(1).append(1).append(1).append(1).append(1);

        ll.removeGreaterThan(2);

        assert ll.size() == 10;

        System.out.println("test2_greater_element_can_be_removed completed");
    }

    public static void test3_greater_element_can_be_removed() {
        final IntLinkedList ll =
                newIntLinkedList()
                        .append(3).append(3).append(3).append(3).append(3)
                        .append(3).append(3).append(3).append(3).append(3);

        ll.removeGreaterThan(2);

        assert ll.size() == 0;

        System.out.println("test3_greater_element_can_be_removed completed");
    }

    public static void test4_greater_element_can_be_removed() {
        final IntLinkedList ll =
                newIntLinkedList()
                        .append(3).append(1).append(1).append(1).append(1)
                        .append(1).append(1).append(1).append(1).append(2);

        ll.removeGreaterThan(2);

        assert ll.size() == 9;

        int i = 0;
        for (int c : ll) {
            if (i == 0) assert c == 1;
            if (i == 8) assert c == 2;
            i++;
        }

        System.out.println("test4_greater_element_can_be_removed completed");
    }

    public static void test5_greater_element_can_be_removed() {
        final IntLinkedList ll =
                newIntLinkedList()
                        .append(1).append(1).append(1).append(1).append(1)
                        .append(1).append(1).append(1).append(2).append(3);

        ll.removeGreaterThan(2);

        assert ll.size() == 9;

        int i = 0;
        for (int c : ll) {
            if (i == 0) assert c == 1;
            if (i == 8) assert c == 2;
            i++;
        }

        System.out.println("test5_greater_element_can_be_removed completed");
    }

    public static void test6_greater_element_can_be_removed() {
        final IntLinkedList ll =
                newIntLinkedList()
                        .append(1).append(3).append(3).append(3).append(3)
                        .append(3).append(3).append(3).append(3).append(2);

        ll.removeGreaterThan(2);

        assert ll.size() == 2;

        int i = 0;
        for (int c : ll) {
            if (i == 0) assert c == 1;
            if (i == 1) assert c == 2;
            i++;
        }

        System.out.println("test6_greater_element_can_be_removed completed");
    }

    public static void main(String[] args) {
        test_element_can_be_appended();
        test_tailed_element_can_be_removed();
        test1_greater_element_can_be_removed();
        test2_greater_element_can_be_removed();
        test3_greater_element_can_be_removed();
        test4_greater_element_can_be_removed();
        test5_greater_element_can_be_removed();
        test6_greater_element_can_be_removed();
    }
}
