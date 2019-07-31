# Good morning! Here's your coding interview problem for today.
# This problem was asked by Google.
# The area of a circle is defined as pi r squared
# Estimate pi to 3 decimal places using a Monte Carlo method.
# Hint: The basic equation of a circle is x2 + y2 = r2.

import random
import math

NUM_TRIALS = 10000000

def main():
    num_in_range = 0.0
    # generate random numbers between -1 and 1
    for i in range(NUM_TRIALS):
        x = random.random()*2.0 - 1.0
        y = random.random()*2.0 - 1.0
        if math.sqrt(x**2.0 + y**2.0) < 1.0:
            num_in_range += 1.0
    pi = num_in_range / float(NUM_TRIALS) * 4
    print("%.3f" % pi)


if __name__ == '__main__':
    main()  # doesn't give a great estimate buuuuut oh well
