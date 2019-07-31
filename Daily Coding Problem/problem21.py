# Good morning! Here's your coding interview problem for today.
# This problem was asked by Snapchat.
# Given an array of time intervals (start, end) for classroom lectures
# (possibly overlapping), find the minimum number of rooms required.
# For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

def sched(intervals):
    # sort on the start time
    intervals = sorted(intervals, key=lambda x: x[0])
    num_rooms = 1  # keep track of current number of rooms
    min_rooms = 1  # keep track of min number of rooms needed so far
    prev = intervals[0]
    for time_slot in intervals[1:]:
        if time_slot[0] < prev[1]:
            num_rooms += 1
            if time_slot[1] <

def main():
    intervals = [(30, 75), (0, 50), (60, 150)]
    result = sched(intervals)
    print('Result: ' + str(result))


if __name__ == '__main__':
    main()
