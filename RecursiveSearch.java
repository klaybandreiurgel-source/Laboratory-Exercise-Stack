public class RecursiveSearch {

    // Recursive search method
    public static int recursiveSearch(int[] array, int target, int index) {

        // Display the current search step
        System.out.println("Searching at index: " + index);

        // Base case: target not found
        if (index >= array.length) {
            System.out.println("Target not found.");
            return -1;
        }

        // Check if the current element matches the target
        System.out.println("Checking value: " + array[index]);

        if (array[index] == target) {
            System.out.println("Target found at index: " + index);
            return index;
        }

        // Recursive call to check the next element
        return recursiveSearch(array, target, index + 1);
    }

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};
        int target = 40;

        System.out.println("=== RECURSIVE SEARCH TRACE ===");
        System.out.println("Array: 10, 20, 30, 40, 50");
        System.out.println("Target: " + target);
        System.out.println();

        int result = recursiveSearch(numbers, target, 0);

        System.out.println();

        if (result != -1) {
            System.out.println("Search successful!");
            System.out.println("Target " + target
                    + " is located at index " + result + ".");
        } else {
            System.out.println("Search unsuccessful!");
        }
    }
}