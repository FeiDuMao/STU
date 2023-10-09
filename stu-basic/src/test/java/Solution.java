import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {


    @Test
    public void solve() {


        List<Node> nodes = List.of(new Node("A", "-1"),

                new Node("A-1", "A"), new Node("A-2", "A"), new Node("A-3", "A"),

                new Node("A-2-1", "A-2"), new Node("A-2-2", "A-2"), new Node("A-2-3", "A-2"), new Node("A-2-4", "A-2"));


        Map<String, List<Node>> pid2Node = nodes.stream().collect(Collectors.groupingBy(Node::getPid));

        List<Node> root = pid2Node.get("-1");

        root.forEach(it -> print(pid2Node, it));


    }


    private void print(Map<String, List<Node>> pid2Node, Node node) {
        List<Node> nodes = pid2Node.get(node.getId());

        if (nodes != null && !nodes.isEmpty()) {
            nodes.forEach(it -> print(pid2Node, it));
        }
        System.out.println(node.getId());

    }


    @Test
    public void main1() {

        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 3, 5};

        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {

            if (binarySearch(b, a[i])) {
                System.out.println(i);
            }

        }

    }


    private static boolean binarySearch(int[] a, int target) {


        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int index = (start + end) / 2;

            int tmp = a[index];

            if (tmp > target) {
                end = index;
            } else if (tmp < target) {
                start = index + 1;
            } else {
                return true;
            }

        }

        return false;
    }


    @Test
    public void test2() {

        int[] arr = {1, 2, 3, 4, 5};
        List.of(1, 2, 3, 4, 5, 6, 7).forEach(it -> System.out.println(binarySearch(arr, it)));

    }

}
