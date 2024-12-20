# Affine-Ciper

Affine Cipher is the substitution cipher, which has a fucntion called affine function,
Encryption: e(x) = (ax+b) mod 26
Decryption: d(y) = a^(-1)(y - b) mod 26

In order to make decryption possible, the function must be injective, which means for every y, if and only if gcd(a, 26) = 1, where gcd is the greatest common divisor. If e(x) = (ax+b) mod 26 is not an injective function, it is not valid encryption function nor decryption function.

Example(Encryption)

    Input: I LOVE YOU
    Key: a = 5, b = 8 ----> e(x) = 5x+8 mod 26

    Input: I(8) ---> 5*8 + 8 mod 26 = 16 mod 26
    Encrypted = W(22)

    Apply to other characters, then
    Result: W LAJC YAE

Example(Decryption)

    Input: W LAJC YAE
    Key: a = 5, b = 8 ----> e(x) = 5x+8 mod 26

    Since, inverse of 5 in mod 26 is 21,
    
    Input: W(22) ---> 21*8 - 8 mod 26 = 8 mod 26 
    Decrypted = I(8)

    Apply to other characters, then
    Result: I LOVE YOU