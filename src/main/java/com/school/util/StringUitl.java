package com.school.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 字符串工具类
 */
public class StringUitl {
    private static char[] cha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 字符串获取重要信息
     *
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
        } catch (Exception e) {
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
            return news;
        }
        while (news.length() > 20) {
            return beString;
        }
        return news;
    }

    /**
     * 获取评论楼层
     *
     * @param rank
     * @return
     */
    public static String getRank(int rank) {
        String rankS = "";
        if (rank == 1) {
            rankS = "沙发";
        } else if (rank == 2) {
            rankS = "板凳";
        } else if (rank > 3) {
            rankS = rank + "楼";
        }
        return rankS;


    }

    public static void main(String[] args) {

        System.out.println(stringFilter("是你呀还是我呀"));
    }

    /**
     * 敏感词汇验证
     * @param s
     * @return
     */
    public static boolean stringFilter(String s) {
        boolean b = false;
        String string1 = "";
        String string2 = "";
        String string3 = "";
        String[] srArray = {"草", "你", "妈", "爸", "尼", "狗", "日"};
        for (String s1 : srArray) {
            if (b) {
                break;
            }
            if (!b) {
                if (s.equals(s1)) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                for (String s2 : srArray) {
                    string2 = s1 + s2;
                    if (s.equals(string2)) {
                        b = true;
                        break;
                    }
                    if (!b) {
                        for (String s3 : srArray) {
                            string3 = s1 + s2 + s3;
                            if (s.equals(string3)) {
                                b = true;
                                break;
                            }
                        }
                    }
                }

            }
        }
        System.out.println(b);
        return b;
    }


    /**
     * 验证输入的是否是数字
     * @param s
     * @return
     */
    public  static  boolean validateInt(String s){
        String regex = "^[0-9]*$";
        return match(regex, s);
    }


    /**
     * 正则验证
     * @param regex
     * @param str
     * @return
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }



    /**
     * 生成.png字符串
     * @return
     */
    public static String createStringRandomName(){
        // 生成文件名
        String files = new SimpleDateFormat("yyyyMMddHHmmssSSS")
                .format(new Date())
                + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                + ".text";

        return files;
    }



    /**
     * 生成.png字符串
     * @return
     */
    public static String createStringRandomNamePNG(){
        // 生成文件名
        String files = new SimpleDateFormat("yyyyMMddHHmmssSSS")
                .format(new Date())
                + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                + ".png";

        return files;
    }



}
