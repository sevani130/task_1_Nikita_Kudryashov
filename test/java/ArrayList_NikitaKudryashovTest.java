package org.intensive.task1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayList_NikitaKudryashovTest {

    private ArrayList_NikitaKudryashov<Integer> arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new ArrayList_NikitaKudryashov<>();
    }

    @Test
    void size() {
        assertEquals(0, arrayList.size());
        arrayList.add(5);
        assertEquals(1, arrayList.size());
    }

    @Test
    void add() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        assertEquals(10, arrayList.get(0));
        assertEquals(20, arrayList.get(1));
        assertEquals(30, arrayList.get(2));
    }

    @Test
    void add_WithNegativeIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(-1, 100));
    }

    @Test
    void add_WithIndexGreaterThanSizeThrowsException() {
        arrayList.add(0, 100);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(2, 200));
    }

    @Test
    void addAtIndex() {
        arrayList.add(0, 100);
        arrayList.add(0, 200);
        arrayList.add(1, 300);
        assertEquals(200, arrayList.get(0));
        assertEquals(300, arrayList.get(1));
        assertEquals(100, arrayList.get(2));
    }

    @Test
    void get() {
        arrayList.add(50);
        assertEquals(50, arrayList.get(0));
    }

    @Test
    void get_WithNegativeIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1));
    }

    @Test
    void get_WithIndexEqualToSizeThrowsException() {
        arrayList.add(100);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(1));
    }

    @Test
    void set() {
        arrayList.add(5);
        arrayList.set(0, 10);
        assertEquals(10, arrayList.get(0));
    }

    @Test
    void set_WithNegativeIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(-1, 100));
    }

    @Test
    void set_WithIndexEqualToSizeThrowsException() {
        arrayList.add(100);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(1, 200));
    }

    @Test
    void remove() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        assertEquals(2, arrayList.remove(1));
        assertEquals(2, arrayList.size());
        assertEquals(3, arrayList.get(1));
    }

    @Test
    void remove_WithNegativeIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(-1));
    }

    @Test
    void remove_WithIndexEqualToSizeThrowsException() {
        arrayList.add(100);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(1));
    }

    @Test
    void clear() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @Test
    void quickSort() {
        arrayList.add(30);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.quickSort(Comparator.naturalOrder());
        assertEquals(10, arrayList.get(0));
        assertEquals(20, arrayList.get(1));
        assertEquals(30, arrayList.get(2));
    }

    @Test
    void isSorted() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        assertTrue(arrayList.isSorted());
    }

    @Test
    void split() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.split(2);
        assertEquals(2, arrayList.size());
    }

    @Test
    void split_WithNegativeSizeThrowsException() {
        arrayList.add(100);
        assertThrows(IllegalArgumentException.class, () -> arrayList.split(-1));
    }

    @Test
    void split_WithSizeGreaterThanListSizeThrowsException() {
        arrayList.add(100);
        assertThrows(IllegalArgumentException.class, () -> arrayList.split(2));
    }
}