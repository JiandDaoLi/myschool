package com.school.util;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 字符串工具类
 */
public class StringUitl {
    private static char[] cha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 字符串获取重要信息
     * @param string
     * @return
     */
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
            return beString + news;
        }
        while (beString.length() > 20) {
            return  news;
        }
        while (news.length() > 20) {
            return  beString;
        }
        return news;
    }

    /**
     * 获取评论楼层
     * @param rank
     * @return
     */
    public static String getRank(int rank){
        String rankS = "";
        if (rank == 1) {
            rankS = "沙发";
        }else if (rank == 2) {
            rankS = "板凳";
        }else if ( rank > 3) {
            rankS = rank +"楼";
        }
       return rankS;


    }


}
