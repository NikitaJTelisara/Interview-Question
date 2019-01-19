import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Pattern;

public class google {
    public static void main(String[] args) {
        String str = "[10.30am] <John>";
        String str1 = "[10.30am] <niki> Hello Hellp  ";
        String str3 = "[10.30am] <John> Hello Hellp  ";
        String str4 = "[10.30am] <nik> How are u ";
        String str5 = "[10.30am] <niki> How are u ";
        ArrayList<String> list = new ArrayList<String>();
        list.add(str);
        list.add(str1);
        list.add(str3);
        list.add(str4);
        list.add(str5);
        System.out.println(getUserNameFromConversation(str));
        System.out.println(getWordCount(str1));
        System.out.print(getWordCountForAUserName(list));
    }


    public static String getUserNameFromConversation(String logLine) {
        if (logLine.length() == 0) {
            return null;
        }
        //   use regex to find < and >
        Pattern p1 = Pattern.compile("<");
        Matcher m1 = p1.matcher(logLine);
        Pattern p2 = Pattern.compile(">");
        Matcher m2 = p2.matcher(logLine);
        if (m1.find() && m2.find() && m1.start() < m2.start()) {
            return logLine.substring(m1.start() + 1, m2.start());  // substringmethod(takes from start to begin -1
        }
        return null;
    }

    public static int getWordCount(String logLine) {
        if (logLine.length() == 0) {
            return 0;
        }
        String converstion_start = new String();
        int wordCount = 0;
        Pattern p1 = Pattern.compile(">");
        Matcher m1 = p1.matcher(logLine);
        if (m1.find()) {
            if (m1.start() == logLine.length() - 1) {
                System.out.println("No Conversation");
                return 0;
            }
            converstion_start = logLine.substring(m1.start() + 1);
        } else {
            System.out.println("No Conversation");
            return 0;
        }
        p1 = Pattern.compile("[\\s]+[^\\s]");

        m1 = p1.matcher(converstion_start);
        while (m1.find()) {
            wordCount++;
        }
        return wordCount;
    }

    public static HashMap<String, Integer> getWordCountForAUserName(ArrayList<String> logLineList) {
        if (logLineList.size() == 0) {
            return null;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String logLine : logLineList) {
            String userName = getUserNameFromConversation(logLine);
            if (map.containsKey(userName)) {
                Integer value = map.get(userName);
                map.put(userName, value + getWordCount(logLine));
            } else {
                map.put(userName, getWordCount(logLine));
            }
        }
        return map;
    }
}
