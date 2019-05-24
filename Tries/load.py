import sys
from trie import Trie


def test(trie, file_name):
    string = "Is {} in the trie: {}"
    with open(file_name) as data:
        for line in data:
            result = trie.lookup(line)
            print(string.format(line, result))

def load(trie, file_name):
    """
    Load file into a trie. File is assumed to have a word per line
    """
    with open(file_name) as dictionary:
        for word in dictionary:
            trie.insert(word.strip())

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python load.py <file1> [<file2> ...]")
        exit(1)
    trie = Trie()
    for file_name in sys.argv[1:]:
        load(trie, file_name)
    # test(trie, sys.argv[1])
    trie.to_str()
