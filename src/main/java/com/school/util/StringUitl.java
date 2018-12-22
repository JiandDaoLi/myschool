package com.school.util;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field:
 */
public class StringUitl {
    private static char[] cha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static String aString(String string) {
        int count = 0;
        int ent = 0;
        String beString = "";
        int beIndex = 0;
        char ar = '0';
        boolean boo = true;
        int b = 0;
        String cs = "";
        for (int i = 0; i < string.length(); i++) {
            if (!boo) {
                break;
            }
            String stringSub = string.substring(i, i + 1);
            for (char c : cha) {
                cs = String.valueOf(c);
                b = stringSub.indexOf(cs);
                while (b != -1) {
                    beIndex = string.indexOf(cs);
                    boo = false;
                    break;
                }
                if (!boo) {
                    break;
                }
            }
        }
        beString = string.substring(0, beIndex);
        Boolean bc = true;
        String newString = "";
        try {
            string.substring(beIndex, string.length());
        }catch (Exception e){
            return string;
        }


        for (int i = 0; i < newString.length(); i++) {
            if (ent == 4) {
                bc = false;
            }
            while (!bc) {
                break;
            }
            for (char c : cha) {
                if (ent == 3) {
                    break;
                }
                String sc = String.valueOf(c);
                int bbc = newString.indexOf(sc);
                while (ent < 3) {
                    while (bbc != -1) {
                        count = count + 1;
                        ent = 0;
                        bbc = -1;
                    }
                    break;
                }
                ent = ent + 1;
                if (ent == 3) {
                    break;
                }
            }
            ent = ent + 1;

        }
        String news = newString.substring(0, count);
        while ((beIndex + news).length() < 20) {
            news = beString + news;
            break;
        }
        while (news.length() > 20) {
            news = news;
            break;
        }
        while (news.length() > 20) {
            news = beString;
            break;
        }
        return news;
    }

}
