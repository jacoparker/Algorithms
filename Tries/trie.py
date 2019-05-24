from node import Node


class Trie:
    
    def __init__(self):
        self.root = Node(data=None)
        self.curr = self.root  # keep some state for faster traversal

    def get_root(self):
        return self.root

    def insert(self, string):
        curr = self.get_root()
        for c in string:
            curr = curr.insert(c)
        curr.insert('*')

    def lookup(self, string, start_from_root=True):
        if start_from_root:
            self.reset()
        for c in string:
            if c in self.curr.children:
                self.curr = self.curr.children[c]
            else:
                return False
        return '*' in self.curr.children

    def reset(self):
        self.curr = self.get_root()

    def to_str(self):
        """TODO add description"""
        def recurse_on_child(node, tmp_string):
            if tmp_string[-1] == '|':
                string = '{}____{}\n'.format(tmp_string, node.data)
            else:
                string = '{}|____{}\n'.format(tmp_string, node.data)
            for index, grandchild in enumerate(node.children):
                if index == len(node.children)-1:
                    if tmp_string[-1] == '|' or tmp_string[-4] == '|':
                        tmp_str = tmp_string + 4*' '                    
                    else:
                        tmp_str = tmp_string + 5*' ' 
                else:
                    tmp_str = tmp_string + 5*' ' + '|'
                string += recurse_on_child(node.children[grandchild], tmp_str)
            return string
        
        curr = self.get_root()
        print("*")
        result = ''
        for index, child in enumerate(curr.children):
            result += recurse_on_child(curr.children[child], '|')
        print(result)
