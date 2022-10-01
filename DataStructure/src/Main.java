import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int deger;
	        System.out.println("1.  Array");
	        System.out.println("2.  DynamicArray");
	        System.out.println("3.  Linkedlist");
	        System.out.println("4.  StackArray");
	        System.out.println("5.  QueueArray");
	        System.out.println("6.  BinarySearch");
	        System.out.println("7.  InterpolationSearch");
	        System.out.println("8.  LinearSearch");
	        System.out.println("9.  BubbleSort");
	        System.out.println("10. HeapSort");
	        System.out.println("11. QuickSort");
	        System.out.println("12. MergeSort");
	        System.out.println("13. HashTable");
	        System.out.println("14. Binary Tree");
	        System.out.println("15. Quit");
	        System.out.println("Enter Your Choice : ");
	        deger = sc.nextInt();
	        switch (deger) {
	        case 1:
	            new MyArray();
	            break;
	        case 2:
	            MyDynamicArray x = new MyDynamicArray();
	            x.put(2);
	            x.put(3);
	            x.put(4);
	            for (int i = 0; i < x.getSize(); i++) {
	                System.out.println("Element: " + x.get(i));
	            }
	            break;
	        case 3:
	            MyLinkedList mylist = new MyLinkedList(new Node<String>("Foo", null));
	            mylist.add(new Node<String>("Bar", null));
	            mylist.add(new Node<String>("Baz", null));
	            mylist.display();
	            break;
	        case 4:
	            MyStackArray st = new MyStackArray<String>(3);
	            st.push("Foo");
	            st.push("Bar");
	            st.push("Baz");
	            System.out.println("Top element: " + st.get(st.top));
	            st.pop();
	            System.out.println("After pop: ");
	            System.out.println("Top element: " + st.get(st.top));
	            break;
	        case 5:
	            MyQueueArray qu = new MyQueueArray<String>(3);
	            qu.enqueue("Foo");
	            qu.enqueue("Bar");
	            qu.enqueue("Baz");
	            System.out.println("First element: " + qu.getFirst());
	            System.out.println("After dequeue: ");
	            qu.dequeue();
	            System.out.println("First element: " + qu.getFirst());
	            break;
	        case 6:
	            new MyBinarySearch();
	            break;
	        case 7:
	            new MyInterpolationSearch();
	            break;
	        case 8:
	            new MyLinearSearch();
	            break;
	        case 9:
	            new MyBubbleSort();
	            break;
	        case 10:
	            MyHeapSort heap_obj = new MyHeapSort();
	            int[] heap_arr = { 1, 50, 30, 10, 60, 80 };
	            System.out.println("Before Sorting: ");
	            for (int el : heap_arr) {
	                System.out.print(el + "\t");
	            }
	            System.out.println("\nAfter Sorting: ");
	            heap_obj.presort(heap_arr);
	            for (int el : heap_arr) {
	                System.out.print(el + "\t");
	            }
	            break;
	        case 11:
	            MyQuickSort quick_obj = new MyQuickSort();
	            int[] quick_arr = { 1, 50, 30, 10, 60, 80 };
	            System.out.println("Before sorting");
	            for (int i = 0; i < quick_arr.length; i++)
	                System.out.print(quick_arr[i] + "\t");

	            quick_obj.quickSort(quick_arr, 0, quick_arr.length - 1);
	            System.out.println("\nAfter sorting");
	            for (int i = 0; i < quick_arr.length; i++)
	                System.out.print(quick_arr[i] + "\t");
	            break;
	        case 12:
	            MyMergeSort merge_obj = new MyMergeSort();
	            int[] merge_arr = { 1, 50, 30, 10, 60, 80 };
	            System.out.println("Before sorting");
	            for (int i = 0; i < merge_arr.length; i++)
	                System.out.print(merge_arr[i] + "\t");

	            merge_obj.prepareForSort(merge_arr);

	            System.out.println("\nAfter sorting");
	            for (int i = 0; i < merge_arr.length; i++)
	                System.out.print(merge_arr[i] + "\t");
	            break;
	        case 13:
	            hashTableArray<String> hash = new hashTableArray<String>(10);
	            hash.put(10, "Alaa");
	            hash.put(11, "Ali");
	            hash.put(5, "Hameed");
	            System.out.println(hash.Get(10));
	            break;
	        case 14:
	            nodeTree root = new nodeTree(7, null, null);
	            MyBinaryTree bt = new MyBinaryTree(root);
	            for (int i = 1; i < 10; i++) {
	                nodeTree newNode = new nodeTree(i, null, null);
	                bt.addNode(newNode, bt.root);
	            }
	            bt.search(5, bt.root);
	            break;
	        case 15:
	            System.exit(1);
	            break;
	        }
	    }
	}

	class MyArray {
	    MyArray() {
	        String[] list = new String[3];
	        list[0] = "foo";
	        list[1] = "bar";
	        list[2] = "baz";
	        System.out.println("The elements in the array are: ");
	        for (int i = 0; i < list.length; i++) {
	            System.out.println(list[i]);
	        }
	    }
	}

	class MyDynamicArray {
	    int[] data;
	    int size;

	    MyDynamicArray() {
	        size = 0;
	        data = new int[size];
	    }

	    public int getSize() {
	        return data.length;
	    }

	    public int get(int index) {
	        return data[index];
	    }

	    public void put(int element) {
	        ensureCapacity(size + 1);
	        data[size - 1] = element;
	    }

	    public void ensureCapacity(int minCapacity) {
	        int oldCapacity = data.length;
	        if (minCapacity > oldCapacity) {
	            data = Arrays.copyOf(data, minCapacity);
	            size = minCapacity;
	        }
	    }
	}

	class Node<T> {
	    T value;
	    Node next;

	    Node(T value, Node next) {
	        this.value = value;
	        this.next = next;
	    }
	}

	class MyLinkedList {
	    Node head;

	    MyLinkedList(Node head) {
	        this.head = head;
	    }

	    public void add(Node newNode) {
	        newNode.next = head;
	        head = newNode;
	    }

	    public void delete() {
	        head = head.next;
	    }

	    public void display() {
	        Node n = head;
	        while (n != null) {
	            System.out.println(n.value);
	            n = n.next;
	        }
	    }
	}

	class MyStackArray<T> {
	    int size;
	    Object[] arrayStack;
	    int top;

	    MyStackArray(int size) {
	        this.size = size;
	        arrayStack = new Object[this.size];
	        top = -1;
	    }

	    public void push(Object newEl) {
	        if (isFull()) {
	            System.out.println("Stack is full!");
	            return;
	        }
	        top = top + 1;
	        arrayStack[top] = newEl;
	    }

	    public T pop() {
	        if (isEmpty()) {
	            System.out.println("Stack is empty!");
	            return null;
	        }
	        T item = (T) arrayStack[top];
	        top = top - 1;
	        return item;
	    }

	    public T get(int index) {
	        return (T) arrayStack[index];
	    }

	    public boolean isFull() {
	        return top == size - 1;
	    }

	    public boolean isEmpty() {
	        return top == 1;
	    }
	}

	class MyQueueArray<T> {
	    Object[] arrayQueue;
	    int rear, front, size;

	    MyQueueArray(int size) {
	        this.size = size;
	        arrayQueue = new Object[this.size];
	        front = -1;
	        rear = -1;
	    }

	    Boolean isFull() {
	        return rear == size - 1;
	    }

	    Boolean isEmpty() {
	        return front == -1;
	    }

	    void enqueue(Object newEl) {
	        if (isFull()) {
	            return;
	        }
	        rear = rear + 1;
	        arrayQueue[rear] = newEl;
	        front = 0;
	    }

	    T dequeue() {
	        if (isEmpty()) {
	            return null;
	        }
	        T obj = (T) arrayQueue[front];
	        front = front + 1;
	        return obj;
	    }

	    public T getFirst() {
	        return (T) arrayQueue[front];
	    }
	}

	class MyBinarySearch {
	    MyBinarySearch() {
	        int size = 1000000;
	        int[] numbers = new int[size];
	        for (int i = 0; i < size; i++)
	            numbers[i] = i + 1;
	        // binary search
	        int searchNumber = 9999;// number we look
	        int low = 0;
	        int high = numbers.length - 1;
	        int mid = 0;
	        int numberTry = 0;
	        Boolean isFound = false;
	        while (!isFound) {
	            if (low > high) {
	                System.out.println("number not found");
	                break;
	            }
	            mid = low + ((high - low) / 2);
	            numberTry++;
	            if (numbers[mid] == searchNumber) {
	                System.out.println("number is found");
	                System.out.println("find after number of try:" + numberTry);
	                break;
	            }
	            if (numbers[mid] < searchNumber) {
	                low = mid + 1;
	            }
	            if (numbers[mid] > searchNumber) {
	                high = mid - 1;
	            }
	        }
	    }
	}

	class MyInterpolationSearch {
	    MyInterpolationSearch() {
	        int size = 1000000;
	        int[] numbers = new int[size];
	        for (int i = 0; i < size; i++)
	            numbers[i] = i + 1;
	        // binary search
	        int searchNumber = 9999;// number we look
	        int low = 0;
	        int high = numbers.length - 1;
	        int mid = 0;
	        int numberTry = 0;
	        Boolean isFound = false;
	        while (!isFound) {
	            if (low > high) {
	                System.out.println("number not found");
	                break;
	            }
	            mid = low + ((high - low) / (numbers[high] - numbers[low])) * (searchNumber - numbers[low]);
	            numberTry++;
	            if (numbers[mid] == searchNumber) {
	                System.out.println("number is found");
	                System.out.println("find after number of try:" + numberTry);
	                break;
	            }
	            if (numbers[mid] < searchNumber) {
	                low = mid + 1;
	            }
	            if (numbers[mid] > searchNumber) {
	                high = mid - 1;
	            }
	        }
	    }
	}

	class MyLinearSearch {
	    MyLinearSearch() {
	        int size = 1000000;
	        int[] numbers = new int[size];
	        for (int i = 0; i < size; i++)
	            numbers[i] = i + 1;
	        // linear search
	        int numberTry = 0;
	        int searchNumber = 9999;
	        for (int i = 0; i < size; i++) {
	            numberTry++;
	            if (numbers[i] == searchNumber) {
	                System.out.println("number is found");
	                System.out.println("find after number of try:" + numberTry);
	                break;
	            }
	        }
	    }
	}

	class MyBubbleSort {
	    static void bubbleSorting(int[] arr) {
	        int n = arr.length;
	        int temp = 0;
	        for (int i = 0; i < n; i++) {
	            for (int j = 1; j < (n - i); j++) {
	                if (arr[j - 1] > arr[j]) {
	                    temp = arr[j - 1];
	                    arr[j - 1] = arr[j];
	                    arr[j] = temp;
	                }
	            }
	        }
	    }

	    MyBubbleSort() {
	        int[] arr = { 1, 50, 30, 10, 60, 80 };
	        System.out.println("before sorting");
	        for (int i = 0; i < arr.length; i++)
	            System.out.println(arr[i] + "\t");
	        bubbleSorting(arr);
	        System.out.println("\nafter sorting");
	        for (int i = 0; i < arr.length; i++)
	            System.out.println(arr[i] + "\t");
	    }
	}

	class MyHeapSort {
	    private int total;

	    public void heapify(int[] arr, int parentIndex) {
	        int leftNodeIndex = parentIndex;
	        int rightNodeIndex = parentIndex + 1;
	        int newIndex = parentIndex;
	        if (leftNodeIndex < total && arr[leftNodeIndex] > arr[parentIndex])
	            newIndex = leftNodeIndex;

	        if (rightNodeIndex < total && arr[rightNodeIndex] < arr[parentIndex])
	            newIndex = rightNodeIndex;

	        if (newIndex != parentIndex) {
	            swap(arr, parentIndex, newIndex);
	            heapify(arr, newIndex);
	        }
	    }

	    public void swap(int[] arr, int a, int b) {
	        int temp = arr[a];
	        arr[a] = arr[b];
	        arr[b] = temp;
	    }

	    public void presort(int[] arr) {
	        total = arr.length - 1;
	        for (int i = total / 2; i >= 0; i--)
	            heapify(arr, i);
	        for (int i = total; i >= 0; i--) {
	            swap(arr, 0, i);
	            total--;
	            heapify(arr, 0);
	        }
	    }

	}

	class MyQuickSort {
	    public void quickSort(int[] arr, int low, int high) {
	        if (low >= high)
	            return;
	        int middle = low + (high - low) / 2;
	        int pivot = arr[middle];
	        int i = low;
	        int j = high;

	        while (i <= j) {
	            while (arr[i] < pivot) {
	                i++;
	            }
	            while (arr[j] > pivot) {
	                j--;
	            }

	            if (i <= j) {
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	                i++;
	                j--;
	            }
	        }

	        if (low < j)
	            quickSort(arr, low, j);

	        if (high > i)
	            quickSort(arr, i, high);
	    }
	}

	class MyMergeSort {
	    int[] array;
	    int[] tempArray; // divided arrays

	    void prepareForSort(int[] arr) { // receiving arrays

	        // Prepare for sort
	        this.array = arr;
	        this.tempArray = new int[arr.length];
	        doMergeSort(0, arr.length - 1);

	    }

	    // Divide to small problem
	    void doMergeSort(int lowerIndex, int higherIndex) {

	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            doMergeSort(lowerIndex, middle); // ex: (1-5)
	            doMergeSort(middle + 1, higherIndex); // ex: (6-10)
	            mergePart(lowerIndex, middle, higherIndex);

	        }
	    }

	    // Merge small problems and sort
	    void mergePart(int lowerIndex, int middle, int higherIndex) {
	        for (int i = lowerIndex; i <= higherIndex; i++)
	            tempArray[i] = array[i];
	        int i = lowerIndex;
	        int j = middle + 1;
	        int k = lowerIndex;
	        while (i <= middle && j <= higherIndex) {
	            if (tempArray[i] <= tempArray[j]) {
	                array[k] = tempArray[i];
	                i++;
	            } else {
	                array[k] = tempArray[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= middle) {
	            array[k] = tempArray[i];
	            k++;
	            i++;
	        }
	    }
	}

	class entry<T> {
	    int key;
	    T value;
	    entry next;

	    public entry(int key, T value) {
	        this.key = key;
	        this.value = value;
	        next = null;
	    }

	    public entry() {
	        next = null;
	    }

	    public int getKey() {
	        return key;
	    }

	    public T getValue() {
	        return value;
	    }
	}

	class hashTableArray<T> {
	    entry[] arrayHash;
	    int size;

	    public hashTableArray(int size) {
	        this.size = size;
	        arrayHash = new entry[this.size];
	        for (int i = 0; i < arrayHash.length; i++)
	            arrayHash[i] = new entry<T>();
	    }

	    int GetHash(int key) {
	        return key % size;
	    }

	    public void put(int key, T value) {
	        int index = GetHash(key);
	        entry arrayValue = arrayHash[index];
	        entry newItem = new entry<T>(key, value);
	        newItem.next = arrayValue.next;
	        arrayValue.next = newItem;
	    }

	    public T Get(int key) {
	        T value = null;
	        int index = GetHash(key);
	        entry arrayValue = arrayHash[index];

	        while (arrayValue != null) {
	            if (arrayValue.getKey() == key) {
	                value = (T) arrayValue.getValue();
	                break;
	            }
	            arrayValue = arrayValue.next;
	        }
	        return value;
	    }
	}

	class nodeTree {

	    int value;
	    nodeTree left;
	    nodeTree right;

	    public nodeTree(int value, nodeTree left, nodeTree right) {
	        this.value = value;
	        this.left = left;
	        this.right = right;

	    }

	}

	class MyBinaryTree {
	    nodeTree root;

	    public MyBinaryTree(nodeTree root) {
	        this.root = root;
	    }

	    public void addNode(nodeTree newNode, nodeTree rootExplore) {

	        if (rootExplore == null)
	            return;

	        if (newNode.value > rootExplore.value) {
	            if (rootExplore.right == null)
	                rootExplore.right = newNode;
	            else
	                addNode(newNode, rootExplore.right);
	        }

	        if (newNode.value < rootExplore.value) {
	            if (rootExplore.left == null)
	                rootExplore.left = newNode;
	            else
	                addNode(newNode, rootExplore.left);

	        }
	    }

	    //// Search

	    public void search(int value, nodeTree rootExplore) {
	        if (rootExplore == null) {
	            System.out.println("Value cannot be found");
	            return;
	        }
	        if (rootExplore.value == value) {
	            System.out.println("Value is found");
	            return;
	        }

	        if (value > rootExplore.value) {
	            search(value, rootExplore.right);
	        }

	        if (value < rootExplore.value) {
	            search(value, rootExplore.left);
	        }
	    }

	}


