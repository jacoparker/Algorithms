class Node:
    def __init__(self, data='*', children=None):
        """
        Data defaults to asterisk, meaning we assume if no
        data is given then this is the last letter in a word
        """
        self.data = data
        if children is None:
            self.children = dict()
        else:
            self.children = children

    def is_leaf(self):
        return self.data == '*'

    def is_root(self):
        return self.data == None

    def insert(self, data):
        if self.is_leaf():
            raise LeafNodeInsertException
        if data in self.children:
            return self.children[data]
        node = Node(data=data)
        self.children[data] = node
        return node

        
class LeafNodeInsertException(Exception):
    def __init__(self, *args, **kwargs):
        super().__init__(self, *args, **kwargs)
