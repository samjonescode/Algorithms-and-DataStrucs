def multiply(x, y):
    applyNegSign = True
    if (x < 0 and y < 0) or (x > 0 and y > 0):
        applyNegSign = False
    i = 1
    product = 0
    while i <= abs(y):
        product += abs(x)
        i += 1
    if applyNegSign:
        product *= -1
    return product


assert multiply(3, 5) == 15
assert multiply(-2, -3) == 6
assert multiply(-2, 2) == -4
assert multiply(2, -2) == -4


def subtract(x, y):
    y *= -1
    return x + y


assert subtract(5, 7) == -2
assert subtract(5, -7) == 12
assert subtract(-5, 7) == -12
assert subtract(-5, -7) == 2


def divide(x, y):
    applyNegSign = True
    if (y < 0 and x < 0) or (y > 0 and x > 0):
        applyNegSign = False

    counter = 0

    absX = abs(x)
    while absX > 0:
        absX = subtract(absX, abs(y))
        counter += 1
    if applyNegSign:
        counter *= -1
    return counter


assert divide(63, 7) == 9
assert divide(63, -7) == -9
assert divide(-63, -7) == 9
assert divide(-63, 7) == -9

