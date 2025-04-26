package com.hms.HMSApplication.utility;

import java.security.SecureRandom;
import java.util.Random;

import static com.hms.HMSApplication.utility.Constants.*;

public class PasswordUtility {

    static Random random = new SecureRandom();

    public static String getPassword() {

        char[] password = new char[PASS_LEN];

        //get the requirements out of the way
        password[0] = LOWERCASE[random.nextInt(LOWERCASE.length)];
        password[1] = UPPERCASE[random.nextInt(UPPERCASE.length)];
        password[2] = NUMBERS[random.nextInt(NUMBERS.length)];
        password[3] = SYMBOLS[random.nextInt(SYMBOLS.length)];

        //populate rest of the password with random chars
        for (int i = 4; i < PASS_LEN; i++) {
            password[i] = ALL_CHARS[random.nextInt(ALL_CHARS.length)];
        }

        //shuffle it up
        for (int i = 0; i < password.length; i++) {
            int randomPosition = random.nextInt(password.length);
            char temp = password[i];
            password[i] = password[randomPosition];
            password[randomPosition] = temp;
        }

        return new String(password);
    }
}
