class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        int partSize = length / k;
        int extraNodes = length % k;
        ListNode[] result = new ListNode[k];
        current = head;
        for (int i = 0; i < k && current != null; i++) {
            result[i] = current;
            int partLength = partSize + (i < extraNodes ? 1 : 0); 
            for (int j = 0; j < partLength - 1; j++) {
                current = current.next;
            }
            ListNode temp = current.next; 
            current.next = null; 
            current = temp;
        }

        return result;
    }
}
