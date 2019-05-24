import sys

# find the number of ways to climb the steps
def count(num_steps):
    if num_steps <= 0:
        return 0
    return 1 + count(num_steps-1) + count(num_steps-2)


def count2(num_steps):
    def helper(index):
        if index <= 0:
            return 0
        if table[index] != None:
            return table[index]
        result = helper(index-1) + helper(index-2)
        table[index] = result
        return 1 + result
    table = [None for i in range(num_steps)]
    return helper(num_steps)


def count3(num_steps):
    table = [None for i in range(num_steps+1)]
    if num_steps == 0:
        return 0
    elif num_steps == 1:
        return 1
    table[0] = 0
    table[1] = 1
    for index, step in enumerate(table[2:], 2):
        table[index] = 1 + table[index-1] + table[index-2]
    return table[-1]


def count4(num_steps):
    pass


def main():
    if len(sys.argv) < 2:
        print("Usage: python find_ways.py <number of steps> [step_len1, step_len2, ...]")
        exit(1)
    steps = int(sys.argv[1])
    # print("count: {}".format(count(steps)))
    # print("count2: {}".format(count(steps)))
    print("count3: {}".format(count3(steps)))


if __name__ == "__main__":
    main()
