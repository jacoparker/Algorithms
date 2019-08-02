class solution:
    def __init__(self):
        pass

    def match(regex, word):
        table = [[False for l1 in word] for l2 in regex]
        for i, l1 in enumerate(regex):
            for j, l2 in enumerate(word[i:], i):
                if l1 in ('.', l2):
                    if i > 0 and j > 0:
                        table[i][j] = table[i-1][j-1]
                    else:
                        table[i][j] = True
                elif l1 == '*':
                    # assume that there is a letter before this
                    if regex[i-1] in (l2, '.'):
                        if j > 0:
                            table[i][j] = table[i-1][j-1] or table[i][j-1]
                        elif j == 0:
                            table[i][j] = True
        print(".\n".join([', '.join([str(val) for val in row]) for row in table]))
        return table[len(regex)-1][len(word)-1]

    def helper(index, regex, word):
        pass

    def match_rec(regex, word):
        return helper(0, regex, word)

if __name__ == "__main__":
    # test 1    
    regex = '.*at'
    word = 'chat'
    print("{} matches {}:".format(word, regex))
    print(solution.match(regex, word))

    # test 2
    regex = 'ra.'
    word = 'ray'
    print("{} matches {}:".format(word, regex))
    print(solution.match(regex, word))

    # test 3
    regex = 'ray'
    word = 'raymond'
    print("{} matches {}:".format(word, regex))
    print(solution.match(regex, word))

    # test 4
    regex = '.*at'
    word = 'chats'
    print("{} matches {}:".format(word, regex))
    print(solution.match(regex, word))

    # test 5
    regex = 'ch.*'
    print("{} matches {}:".format(word, regex))
    print(solution.match(regex, word))

    # test 6
    regex = 'ach.*'
    print("{} matches {}:".format(word, regex))
    print(solution.match(regex, word))

    # test 7 *** test failing ***
    regex = 'c.at.*'
    print("{} matches {}:".format(word, regex))
    print(solution.match(regex, word))
