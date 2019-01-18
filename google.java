import java.util.*;

public class google {
    public static void main(String[] args) {
        String str = "[10.30am] <John> Hello  ";
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
        System.out.println(getWordCount(str));
        System.out.print(getWordCountForAUserName(list));
    }


    public static String getUserNameFromConversation(String logLine) {
        if (logLine.length() == 0) {
            return null;
        }
        int startIndex = -1;
        for (int i = 0; i < logLine.length(); i++) {
            if (logLine.charAt(i) == '<') {
                startIndex = i + 1;
            }
            if (logLine.charAt(i) == '>' && startIndex < i) {
                return logLine.substring(startIndex, i);
            }
        }
        return null;
    }

    public static int getWordCount(String logLine) {
        if (logLine.length() == 0) {
            return 0;
        }
        int startIndex = 0;
        int wordCount = 0;
        while (startIndex < logLine.length()) {
            if (logLine.charAt(startIndex) == '>') {
                break;
            } else {
                startIndex++;
            }
        }
        while (startIndex < logLine.length() - 1) {
            if (logLine.charAt(startIndex) == ' ' && logLine.charAt(startIndex + 1) != ' ') {
                wordCount++;
            }
            startIndex++;
        }
        return wordCount;
    }

    public static HashMap<String, Integer> getWordCountForAUserName(ArrayList<String> logLineList) {
        if (logLineList.size() == 0) {
            return null;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String logLine: logLineList){
            String userName = getUserNameFromConversation(logLine);
            if(map.containsKey(userName)){
                Integer value = map.get(userName);
                map.put(userName, value+getWordCount(logLine));
            } else {
                map.put(userName,getWordCount(logLine));
            }
        }
        return map;
    }
}
