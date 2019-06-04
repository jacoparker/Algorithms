// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Jane Street.
//
// cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns
// the first and last element of that pair. For example, car(cons(3, 4))
// returns 3, and cdr(cons(3, 4)) returns 4.
// Given this implementation of cons:
// def cons(a, b):
//     def pair(f):
//         return f(a, b)
//     return pair
// Implement car and cdr.

import javafx.util.Pair;


class Problem5 {

    static int car(Pair<Integer, Integer> pair) {
        return pair.getKey();
    }

    static int cdr(Pair<Integer, Integer> pair) {
        return pair.getValue();
    }

    static Pair<Integer, Integer> cons(int a, int b) {
        return new Pair<Integer, Integer> (a, b);
    }

    public static void main(String []args) {
        // set up data
        Pair<Integer, Integer> pair1 = cons(1, 2);
        Pair<Integer, Integer> pair2 = cons(3, 4);
        Pair<Integer, Integer> pair3 = cons(5, 6);
        Pair<Integer, Integer> pair4 = cons(7, 8);

        // run some tests
        int result = car(pair1);
        assert result == 1: "Test 1: Expected 1, got " + result;
        result = cdr(pair1);
        assert result == 2: "Test 2: Expected 2, got " + result;
        result = car(pair2);
        assert result == 1: "Test 1: Expected 3, got " + result;
        result = cdr(pair2);
        assert result == 1: "Test 1: Expected 4, got " + result;
        result = car(pair3);
        assert result == 1: "Test 1: Expected 5, got " + result;
        result = cdr(pair3);
        assert result == 1: "Test 1: Expected 6, got " + result;
        result = car(pair4);
        assert result == 1: "Test 1: Expected 7, got " + result;
        result = cdr(pair4);
        assert result == 1: "Test 1: Expected 8, got " + result;
    }
}
