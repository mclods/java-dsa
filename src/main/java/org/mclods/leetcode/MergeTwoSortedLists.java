package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode insertToList(ListNode head, int val) {
        ListNode currentNode = head;
        ListNode newNode = new ListNode(val);

        if(head == null) {
            head = newNode;
        } else {
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }

        return head;
    }

    private void printList(ListNode head) {
        ListNode currentNode = head;

        if(head != null) {
            while(currentNode.next != null) {
                System.out.println(currentNode.val);
                currentNode = currentNode.next;
            }
        }
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = null;

        if(list1 == null && list2 == null) {
            return null;
        } else if(list1 == null) {
            return list2;
        } else if(list2 == null) {
            return list1;
        } else{
            ListNode list1CurrentNode = list1, list2CurrentNode = list2, mergedListCurrentNode;

            // Assign head node of mergedList first then start parsing
            if(list1CurrentNode.val < list2CurrentNode.val) {
                mergedList = mergedListCurrentNode = list1CurrentNode;
                list1CurrentNode = list1CurrentNode.next;
            } else {
                mergedList = mergedListCurrentNode = list2CurrentNode;
                list2CurrentNode = list2CurrentNode.next;
            }

            while(list1CurrentNode != null && list2CurrentNode != null) {
                if(list1CurrentNode.val < list2CurrentNode.val) {
                    mergedListCurrentNode.next = list1CurrentNode;
                    list1CurrentNode = list1CurrentNode.next;
                } else {
                    mergedListCurrentNode.next = list2CurrentNode;
                    list2CurrentNode = list2CurrentNode.next;
                }
                mergedListCurrentNode = mergedListCurrentNode.next;
            }

            if(list1CurrentNode == null) {
                mergedListCurrentNode.next = list2CurrentNode;
            } else {
                mergedListCurrentNode.next = list1CurrentNode;
            }

            return mergedList;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputList1 = br.readLine().split(" ");
        String[] inputList2 = br.readLine().split(" ");

        MergeTwoSortedLists merge = new MergeTwoSortedLists();
        ListNode list1 = null, list2 = null, mergedList;
        for(String i : inputList1) {
            list1 = merge.insertToList(list1, Integer.parseInt(i));
        }

        for(String i : inputList2) {
            list2 = merge.insertToList(list2, Integer.parseInt(i));
        }

        mergedList = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        merge.printList(mergedList);
    }
}
