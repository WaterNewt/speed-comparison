#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <sstream>
#include <iomanip>
#include <openssl/md5.h>
#include <chrono>

std::string string2md5(const std::string& input) {
    MD5_CTX context;
    MD5_Init(&context);
    MD5_Update(&context, input.c_str(), input.length());
    unsigned char digest[MD5_DIGEST_LENGTH];
    MD5_Final(digest, &context);

    std::stringstream ss;
    for (int i = 0; i < MD5_DIGEST_LENGTH; ++i) {
        ss << std::hex << std::setw(2) << std::setfill('0') << static_cast<int>(digest[i]);
    }
    return ss.str();
}

std::vector<std::string> file2vector(const std::string& fileName) {
    std::ifstream file(fileName);
    std::vector<std::string> lines;
    std::string line;
    while (std::getline(file, line)) {
        lines.push_back(line);
    }
    return lines;
}

int main() {
    std::string target = "23379f40a2d9beb40a732cd15acc3093";
    std::string wordlist = "top-3000000.txt";

    std::vector<std::string> passwords = file2vector(wordlist);

    auto start = std::chrono::high_resolution_clock::now(); // Start time

    for (const auto& pwd : passwords) {
        std::string hashed_pass = string2md5(pwd);
        if (hashed_pass == target) {
            auto end = std::chrono::high_resolution_clock::now(); // End time
            std::chrono::duration<double, std::milli> duration = end - start;
            
            std::cout << "Found the password." << std::endl;
            std::cout << "Password is: " << pwd << std::endl;
            std::cout << "Duration: " << duration.count() << " ms" << std::endl;
            return 0;
        }
    }

    std::cout << "Password not found." << std::endl;

    return 0;
}