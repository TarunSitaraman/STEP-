class Stack:
    def __init__(self):
        self.stack = []

    def push(self, item):
        self.stack.append(item)  # Add item to the top

    def pop(self):
        if self.is_empty():
            return "Stack is empty"
        return self.stack.pop()  # Remove and return the top item

    def peek(self):
        if self.is_empty():
            return "Stack is empty"
        return self.stack[-1]  # Return the top item without removing it

    def is_empty(self):
        return len(self.stack) == 0  # Check if stack has no elements

    def size(self):
        return len(self.stack)  # Optional: get current stack size

# Demonstration
s = Stack()
s.push(10)
s.push(20)
s.push(30)
print("Top element:", s.peek())  # 30
print("Stack size:", s.size())    # 3
print("Popped element:", s.pop()) # 30
print("Is stack empty?", s.is_empty()) # False
print("Popped element:", s.pop()) # 20
print("Popped element:", s.pop()) # 10
print("Is stack empty?", s.is_empty()) # True
