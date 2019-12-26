package com.nglb.students.util;

import java.util.Scanner;

public class  Utils {

    public static Scanner scanner = new Scanner(System.in);

    @Override
    protected void finalize() throws Throwable {
        scanner.close();
    }
}
