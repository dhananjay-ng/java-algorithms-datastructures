package problems.onstring;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonic {
    // The mapping from digit to corresponding characters .
    private static final String[] MAPPING
            = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    //recursion to generate all the mnemonics O(4^n)
    public static List<String> phoneMnemonic(String phoneNumber) {
        char[] partialMnemonic = new char [phoneNumber . length() ] ;
        List<String> mnemonics = new ArrayList <>() ;
        phoneMnemonicHelper (phoneNumber , 0, partialMnemonic , mnemonics);
        return mnemonics;

    }

    private static void phoneMnemonicHelper(String phoneNumber, int digit, char[] partialMnemonic, List<String> mnemonics) {
        if (digit == phoneNumber.length()){
            mnemonics.add(new String(partialMnemonic));
        }
        else {
            for (int i=0;i < MAPPING[phoneNumber.charAt(digit) - '0'].length(); i++){
                char c = MAPPING[phoneNumber.charAt(digit) - '0'].charAt(i);
                partialMnemonic[digit]=c;
                phoneMnemonicHelper(phoneNumber,digit+1,partialMnemonic,mnemonics);
            }
        }
    }

    public static List<String> phoneMnemonicBrute(String phoneNumber) {
        int nl = phoneNumber.length() - 1;
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; nl >= 0 && i < MAPPING[phoneNumber.charAt(0) - '0'].length(); i++) {
            for (int j = 0; nl >= 1 && j < MAPPING[phoneNumber.charAt(1) - '0'].length(); j++) {
                for (int k = 0; nl >= 2 && k < MAPPING[phoneNumber.charAt(2) - '0'].length(); k++) {
                    for (int l = 0; nl >= 3 && l < MAPPING[phoneNumber.charAt(3) - '0'].length(); l++) {
                        for (int m = 0; nl >= 4 && m < MAPPING[phoneNumber.charAt(4) - '0'].length(); m++) {
                            for (int n = 0; nl >= 5 && n < MAPPING[phoneNumber.charAt(5) - '0'].length(); n++) {
                                for (int p = 0; nl >= 6 && p < MAPPING[phoneNumber.charAt(6) - '0'].length(); p++) {
                                    for (int q = 0; nl >= 7 && q < MAPPING[phoneNumber.charAt(7) - '0'].length(); q++) {
                                        for (int r = 0; nl >= 8 && r < MAPPING[phoneNumber.charAt(8) - '0'].length(); r++) {
                                            for (int s = 0; nl >= 9 && s < MAPPING[phoneNumber.charAt(9) - '0'].length(); s++) {
                                                if (nl == 9) {
                                                    stringBuilder.append(MAPPING[phoneNumber.charAt(0) - '0'].charAt(i))
                                                            .append(MAPPING[phoneNumber.charAt(1) - '0'].charAt(j))
                                                            .append(MAPPING[phoneNumber.charAt(2) - '0'].charAt(k))
                                                            .append(MAPPING[phoneNumber.charAt(3) - '0'].charAt(l))
                                                            .append(MAPPING[phoneNumber.charAt(4) - '0'].charAt(m))
                                                            .append(MAPPING[phoneNumber.charAt(5) - '0'].charAt(n))
                                                            .append(MAPPING[phoneNumber.charAt(6) - '0'].charAt(p))
                                                            .append(MAPPING[phoneNumber.charAt(7) - '0'].charAt(q))
                                                            .append(MAPPING[phoneNumber.charAt(8) - '0'].charAt(r))
                                                            .append(MAPPING[phoneNumber.charAt(9) - '0'].charAt(s));
                                                    res.add(stringBuilder.toString());
                                                    stringBuilder = new StringBuilder();
                                                }
                                            }
                                        }
                                    }
                                    if (nl == 6) {
                                        stringBuilder.append(MAPPING[phoneNumber.charAt(0) - '0'].charAt(i))
                                                .append(MAPPING[phoneNumber.charAt(1) - '0'].charAt(j))
                                                .append(MAPPING[phoneNumber.charAt(2) - '0'].charAt(k))
                                                .append(MAPPING[phoneNumber.charAt(3) - '0'].charAt(l))
                                                .append(MAPPING[phoneNumber.charAt(4) - '0'].charAt(m))
                                                .append(MAPPING[phoneNumber.charAt(5) - '0'].charAt(n))
                                                .append(MAPPING[phoneNumber.charAt(6) - '0'].charAt(p));
                                        res.add(stringBuilder.toString());
                                        stringBuilder = new StringBuilder();
                                    }
                                }
                                if (nl == 5) {
                                    stringBuilder.append(MAPPING[phoneNumber.charAt(0) - '0'].charAt(i))
                                            .append(MAPPING[phoneNumber.charAt(1) - '0'].charAt(j))
                                            .append(MAPPING[phoneNumber.charAt(2) - '0'].charAt(k))
                                            .append(MAPPING[phoneNumber.charAt(3) - '0'].charAt(l))
                                            .append(MAPPING[phoneNumber.charAt(4) - '0'].charAt(m))
                                            .append(MAPPING[phoneNumber.charAt(5) - '0'].charAt(n));
                                    res.add(stringBuilder.toString());
                                    stringBuilder = new StringBuilder();

                                }
                            }
                            if (nl == 4) {
                                stringBuilder.append(MAPPING[phoneNumber.charAt(0) - '0'].charAt(i))
                                        .append(MAPPING[phoneNumber.charAt(1) - '0'].charAt(j))
                                        .append(MAPPING[phoneNumber.charAt(2) - '0'].charAt(k))
                                        .append(MAPPING[phoneNumber.charAt(3) - '0'].charAt(l))
                                        .append(MAPPING[phoneNumber.charAt(4) - '0'].charAt(m));
                                res.add(stringBuilder.toString());
                                stringBuilder = new StringBuilder();

                            }
                        }
                        if (nl == 3) {
                            stringBuilder.append(MAPPING[phoneNumber.charAt(0) - '0'].charAt(i))
                                    .append(MAPPING[phoneNumber.charAt(1) - '0'].charAt(j))
                                    .append(MAPPING[phoneNumber.charAt(2) - '0'].charAt(k))
                                    .append(MAPPING[phoneNumber.charAt(3) - '0'].charAt(l));
                            res.add(stringBuilder.toString());
                            stringBuilder = new StringBuilder();

                        }
                    }
                    if (nl == 2) {
                        stringBuilder.append(MAPPING[phoneNumber.charAt(0) - '0'].charAt(i))
                                .append(MAPPING[phoneNumber.charAt(1) - '0'].charAt(j))
                                .append(MAPPING[phoneNumber.charAt(2) - '0'].charAt(k));
                        res.add(stringBuilder.toString());
                        stringBuilder = new StringBuilder();

                    }
                }
                if (nl == 1) {
                    stringBuilder.append(MAPPING[phoneNumber.charAt(0) - '0'].charAt(i))
                            .append(MAPPING[phoneNumber.charAt(1) - '0'].charAt(j));
                    res.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();

                }
            }
            if (nl == 0) {
                stringBuilder.append(MAPPING[phoneNumber.charAt(0) - '0'].charAt(i));
                res.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();

            }
        }

        return res;
    }

    }
