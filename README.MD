# Programming Language speed comparison.
I took 3 of the biggest programming languages and compared them in speed. I ran the same script, in all the different programming languages. This script was an MD5 hash bruteforcer. The wordlist that I used was a txt list consistingn of 3,000,000 of the most popular passwords. The results **will shock you**.

## Python
Python is a simple, beginner-friendly programmingn language, known for it's simplicity and readability. This is the language I'm most familiar with, it took about 5 minutes and 32 lines of code.
Running it is as simple as typing `python3 hashBruteforce.py` into your terminal.

## Java
Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. I knew the basics of this programming language. I took about 5-8 minutes and 58 lines of code.
To run it, type `java hashBruteforce.java` into your terminal

## C++
C++ is a cross-platform language that can be used to create high-performance applications. I do not know this programming language at all, so the code was made by ChatGPT. The script also consists of 58 lines of code.
Since C++ is a compiled programming language, running it is a little big more complicated. To run it, you first have to compile it. You can do that by typing `g++ hashBruteforce.cpp`, and then you can run it as a binary, by typing `./hashBruteforce` into your terminal.

## Speed
All of them were measured in w/s (words per second)
### 1. Python
Python was the fastest out of the three languages, at an average speed of 
**1812689w/s** 

### 2. Java
Java was the second fastest, at an average speed of
**1530612w/s**

### 3. C++
Surprisingly, C++ was the slowest programming language out of the three, at an average speed of
**557621w/s**