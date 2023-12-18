import hashlib
import time

def string2md5(input):
    return hashlib.md5(input.encode()).hexdigest()

def file2list(filename):
    with open(filename, 'r') as file:
        return file.read().splitlines()

def main():
    start = time.time()
    target = "23379f40a2d9beb40a732cd15acc3093"
    wordlist = "top-3000000.txt"

    try:
        passwords = file2list(wordlist)
    except FileNotFoundError as e:
        print(e)
        return

    for pwd in passwords:
        hashed_pass = string2md5(pwd)
        if hashed_pass == target:
            print("Found the password.")
            print(f"Password is: {pwd}")
            duration = time.time() - start
            print(f"Duration: {int(duration*1000)} ms")
            return

if __name__ == "__main__":
    main()