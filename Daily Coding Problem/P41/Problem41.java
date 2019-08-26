// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Facebook.
//
// Given an unordered list of flights taken by someone, each represented as
// (origin, destination) pairs, and a starting airport, compute the person's
// itinerary. If no such itinerary exists, return null. If there are multiple
// possible itineraries, return the lexicographically smallest one. All flights
// must be used in the itinerary.
//
// For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'),
// ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should
// return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
//
// Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting
// airport 'COM', you should return null.
//
// Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')]
// and starting airport 'A', you should return the list
// ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a
// valid itinerary. However, the first one is lexicographically smaller.


import java.util.ArrayList;
import java.util.HashMap;

class Solution
{
    public static String[] itinerary(String[][] flights, String initial)
    {
        // hash map of airports to their possible destinations
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        // setup a data structure to more easily solve problem
        for (String[] flight: flights)
        {
            String start = flight[0], end = flight[1];
            if (map.containsKey(start))
            {
                map.get(start).add(end);
            }
            else
            {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(end);
                map.put(start, tmp);
            }
        }

        int i = 0;
        String[] itinerary = new String[flights.length + 1];
        
    }
}


public class Problem41
{
    public static void main(String[] args)
    {

    }
}
