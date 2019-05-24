import sys


def backtrack(table, items):
    included_items = []
    num_items = len(table)
    cap = len(table[0]) - 1
    print(cap)
    result = table[0][cap]
    print(result)
    for i, item in enumerate(items, 1):
        row = table[i]
        if row[cap - item['weight']] == result - item['value']:
            cap -= item['weight']
            result -= item['value']
            included_items.append(item['name'])
    return included_items

def knapsack(items, cap):
    """find optimal value achieved with given capacity constraint"""
    def rec(index, cap):
        if index == len(items):
            return 0
        item = items[index]
        if item["weight"] > cap:
            max_val = rec(index+1, cap)
            if table[index][cap] < max_val:
                table[index][cap] = max_val
        else:
            max_val = max([
                rec(index + 1, cap - item["weight"]) + item["value"],
                rec(index + 1, cap)
            ])   
            if table[index][cap] < max_val:
                table[index][cap] = max_val
        return max_val
    table = [[0 for num in range(cap+1)] for item in items]
    table.append([0 for num in range(cap+1)])
    val = rec(0, cap)
    width = 5
    for row in table:
        row_str = ''
        for elem in row:
            row_str += str(str(elem)+',').rjust(width)
        print(row_str)
    included_items = backtrack(table, items)
    print('\n - '.join(['Items to include:'] + included_items))
    return val

def parse_items(filename):
    """
    Expects file to be organized with an item per line,
    with the first number being the weight of items and the
    second number its value (0-1 knapsack problem)
    """
    item_list = []
    with open(filename) as items:
        for item in items:
            name, weight, value = item.split()
            curr_item = {
                'name': name,
                'weight': int(weight),
                'value': int(value)
                }
            item_list.append(curr_item)
    return item_list


if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python knapsack.py <items> <capacity>")
        exit(1)
    items = parse_items(sys.argv[1])
    print("\n".join([str(item) for item in items]))
    cap = int(sys.argv[2])
    print(knapsack(items, cap))
