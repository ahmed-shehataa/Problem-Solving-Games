package javaPs;

import linkedList.MyLinkedList;
import linkedList.Node;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] iArray = {1, 2, 3, 9, 5, 6, 7, 8};
        int[] iArray2 = {1, 2, 3, 9, 5, 6, 5, 8};
        int[] iArray3 = {1, 2, 1, 1, 3, 4, 1, 2};
        int[] iArray4 = {0, 1, 2, 3, 4, 3, 2, 5};
        int[] numbers = {2, 4, 3, 5, 7, 8};
        int targetSum = 7;
        String words = " Hello ahmed hamdy";
        System.out.println(StringManipulation.reverseSentence(words));

        String name = "ahamhed";
        String value = "v12346";
        String Hello = "Hello, world";
        String car = "asdasd";
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        // strings & arrays
        getMissingNumber(iArray, 9);
        getDuplicatedNumber(iArray2);
        removeDuplicatedNumber(iArray3);
        getLargeAndSmallNumbers(iArray);
        reverseArray(iArray4);
        dupStringChars(name);
        dupStringCharsWithCount(name);
        firstNonRepeatedCharacter(name);
        ifStringDigits(value);
        ifStringVowelCounter(Hello);
        reverseString(Hello);
        palindromeString(car);
        pairsSumNumber(iArray4, 5);

        // TODO
        pairsSumNumber(numbers, targetSum);
        findPairsWithSum(numbers, targetSum);

        // Linked List
        MyLinkedList<Integer> myLinkedList = new MyLinkedList();
        myLinkedList.add(new Node<Integer>(12));
        myLinkedList.add(new Node(2));
        myLinkedList.add(new Node(3));
        myLinkedList.add(new Node(9));
        myLinkedList.add(new Node(8));
        findSizeLinkedList(myLinkedList);
        myLinkedList.print();
        //findThirdFromEndLinkedList(myLinkedList);


        // 2-D arrays
        printAllArrayItems();
        rotateArray();


    }

    private static void rotateArray() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);
        int n = matrix.length;
        // Transpose the matrix (swap rows and columns)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("\nRotated Matrix:");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void printAllArrayItems() {
        int[][] twoDArray = {
                {1, 2, 3},
                {5, 8, 3},
                {1, 2, 3},
                {1, 9, 3},
                {1, 2, 3}
        };
        int max = 0;

        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                if (twoDArray[i][j] > max) max = twoDArray[i][j];
                System.out.print(twoDArray[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("Maxis -> " + max);
    }


    private static void findThirdFromEndLinkedList(MyLinkedList myLinkedList) {
        if (myLinkedList.getSize() < 3) return;

        Node current = myLinkedList.getHead();
        Node requriedNode = null;
        while (current.getNext() != null) {

            if (current.getNext().getNext().getNext() == null) {
                requriedNode = current;
                break;
            }
            current = current.getNext();
        }
        System.out.println("findThirdFromEndLinkedList ->" + requriedNode.getValue());
    }

    private static void findSizeLinkedList(MyLinkedList linkedList) {
        System.out.println("findSizeLinkedList ->" + linkedList.getSize());

    }

    public static void findPairsWithSum(int[] numbers, int targetSum) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int number : numbers) {
            int complement = targetSum - number;

            // Check if the complement exists in the set
            if (seenNumbers.contains(complement)) {
                System.out.println("Pair: (" + number + ", " + complement + ")");
            }

            // Add the current number to the set
            seenNumbers.add(number);
        }
    }

    private static void pairsSumNumber(int[] numbers, int sum) {
        String array = Arrays.toString(numbers);
        System.out.println("pairsSumNumber ->" + array);

        Map<Integer, Integer> pairs = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == sum) {
                    pairs.put(numbers[i], numbers[j]);
                }
            }
        }

        pairs.forEach((integer, integer2) -> {

        });
        System.out.println("pairsSumNumber ->" + pairs);

    }

    private static void palindromeString(String value) {
        System.out.println("palindromeString ->" + value);

        boolean isPalindrome = true;
        char[] ch = value.toCharArray();

        for (int i = 0; i < ch.length / 2; i++) {
            if (ch[i] != ch[ch.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("palindromeString ->" + isPalindrome);
    }

    private static void reverseString(String value) {
        System.out.println("reverseString ->" + value);

        char[] ch = value.toCharArray();
        for (int i = 0; i < ch.length / 2; i++) {
            char swap = ch[i];
            ch[i] = ch[ch.length - 1 - i];
            ch[ch.length - 1 - i] = swap;
        }
        System.out.println("reverseString ->" + new String(ch));

    }

    private static void ifStringVowelCounter(String value) {
        System.out.println("ifStringDigits ->" + value);
        int vowels = 0;
        int nonVowels = 0;

        for (char ch : value.toCharArray()) {

            if (Character.isLetter(ch)) {
                switch (ch) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowels++;
                        break;
                    default:
                        nonVowels++;
                }
            }
        }
        System.out.println("ifStringDigits ->" + vowels + " :: " + nonVowels);

    }

    private static void ifStringDigits(String value) {
        boolean isDigit = true;
        for (char ch : value.toCharArray()) {
            if (!Character.isDigit(ch)) {
                isDigit = false;
                break;
            }
        }

        System.out.println("ifStringDigits ->" + value + " " + isDigit);

    }

    private static void firstNonRepeatedCharacter(String name) {
        System.out.println("The Before firstNonRepeatedCharacter ->" + name);
        Map<Character, Integer> dupChars = new HashMap<>();

        // Calculate character frequencies
        for (char c : name.toCharArray()) {
            dupChars.put(c, dupChars.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeated character
        for (char c : name.toCharArray()) {
            if (dupChars.get(c) == 1) {
                System.out.println("The After firstNonRepeatedCharacter ->" + c);
                break;
            }
        }

    }

    private static void dupStringCharsWithCount(String name) {
        System.out.println("The Before dupStringCharsWithCount ->" + name);
        char[] chars = name.toCharArray();
        Map<Character, Integer> dupChars = new HashMap<>();


        for (int i = 0; i < chars.length; i++) {
            if (dupChars.containsKey(chars[i])) break;

            for (int j = i + 1; j < chars.length; j++) {
                if (Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[j])) {
                    int oldCount = 0;
                    if (dupChars.containsKey(chars[i])) {
                        oldCount = dupChars.get(chars[i]);
                    }
                    dupChars.put(chars[i], oldCount + 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> item : dupChars.entrySet()) {
            System.out.println("The After dupStringCharsWithCount ->" + item.getKey() + item.getValue());
        }

    }

    private static void dupStringChars(String name) {
        System.out.println("The Before find dup ->" + name);
        char[] chars = name.toCharArray();
        Set<Character> dupChars = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {

            for (int j = i + 1; j < chars.length; j++) {
                if (Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[j])) {
                    dupChars.add(chars[i]);
                    break;
                }
            }
        }

        System.out.println("The After find dup ->" + dupChars.toString());

    }

    private static void reverseArray(int[] numbers) {
        String array = Arrays.toString(numbers);
        System.out.println("The Before reverse ->" + array);

        for (int i = 0; i < numbers.length / 2; i++) {
            int swap = numbers[i];
            int leftIterator = numbers.length - 1 - i;
            numbers[i] = numbers[leftIterator];
            numbers[leftIterator] = swap;
        }

        String array2 = Arrays.toString(numbers);
        System.out.println("The After reverse ->" + array2);
    }

    private static void getLargeAndSmallNumbers(int[] numbers) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            } else if (number < smallest) {
                smallest = number;
            }
        }
        String array2 = Arrays.toString(numbers);
        System.out.println("The large & small in -> " + array2 + " -> " + largest + " :: " + smallest);
    }

    private static void removeDuplicatedNumber(int[] numbers) {
        String array = Arrays.toString(numbers);
        System.out.println("The Before removing Duplicated number in ->" + array);

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    numbers[j] = 0;
                }
            }
        }
        String array2 = Arrays.toString(numbers);
        System.out.println("The After removing Duplicated number in ->" + array2);
    }

    private static void getDuplicatedNumber(int[] numbers) {
        Integer dupNumber = null;
        boolean isDup = false;

        for (int i = 0; i < numbers.length; i++) {
            if (isDup) break;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    dupNumber = numbers[j];
                    isDup = true;
                    break;
                }
            }
        }

        String array = Arrays.toString(numbers);
        if (dupNumber == null) {
            System.out.println("The Duplicated number in ->" + array + " Not found");

        } else {
            System.out.println("The Duplicated number in ->" + array + " is -> " + dupNumber);

        }
    }

    public static void getMissingNumber(int[] numbers, int totalCount) {
        //int expectedSum = totalCount * ((totalCount + 1) / 2);
        int expectedSum = 0;
        for (int i = 1; i <= totalCount; i++) {
            expectedSum += i;
        }
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        String array = Arrays.toString(numbers);
        System.out.println("The missing number in ->" + array + " is -> " + (expectedSum - actualSum));
    }
}