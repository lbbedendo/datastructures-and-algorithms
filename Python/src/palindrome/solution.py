from collections import deque


def is_palindrome(input_string):
    stack = deque()
    queue = deque()
    for c in input_string.lower():
        if c.isalpha():
            stack.append(c)
            queue.append(c)

    while stack:
        if stack.pop() != queue.popleft():
            return False

    return True


if __name__ == '__main__':
    print(is_palindrome("I did, did I ?"))
    print(is_palindrome("Racecar"))
    print(is_palindrome("Hello"))
    print(is_palindrome("Ana"))
    print(is_palindrome("Leonardo Barbieri Bedendo"))
    print(is_palindrome("Arara"))
    print(is_palindrome("Tenet"))
