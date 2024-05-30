
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> result = proceed(s);
        result.forEach(System.out::println);
    }

    static List<String> proceed(String s) {
        List<String> result = new ArrayList<>();
        LinkedList<String> tokens = new LinkedList<>();

        for (int i = 0; i < s.length(); ) {
            StringBuilder tokenBuilder = new StringBuilder();
            if (s.charAt(i) == '<') {
                while (s.charAt(i) != '>') {
                    tokenBuilder.append(s.charAt(i++));
                }
                tokenBuilder.append(s.charAt(i++));
            } else {
                while (s.charAt(i) != '<') {
                    tokenBuilder.append(s.charAt(i++));
                }
            }
            String token = tokenBuilder.toString();

            if (token.contains("/")) {
                String toFind = tokenBuilder.deleteCharAt(tokenBuilder.indexOf("/")).toString();
                Iterator<String> iterator = tokens.descendingIterator();
                StringBuilder resultItem = new StringBuilder();
                while (iterator.hasNext()) {
                    String item = iterator.next();
                    if (item.equals(toFind)) {
                        break;
                    }
                    resultItem.insert(0, item);
                }
                result.add(resultItem.toString());
            }

            tokens.add(token);
        }

        return result;
    }
}

/*

SOLUTION 1
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        parseHtml(content);
    }

    private static void parseHtml(String content) {
        Pattern pattern = Pattern.compile("<([A-Za-z][A-Za-z0-9]*)>(.*)</\\1>");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String subText = matcher.group(2);
            if (!subText.matches("[a-zA-Z0-9\\s]*")) {
                parseHtml(subText);
            }
            System.out.println(subText);
        }
    }
}

SOLUTION 2
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        char[] html = line.toCharArray();

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean flag = false;

        for (int i = 0; i < html.length; i++) {
            if (html[i] == '>' && !flag) {
                deque.addLast(i + 1);
            } else if (html[i] == '/') {
                flag = true;
                System.out.println(line.substring(deque.pollLast(), i - 1));
            } else if (html[i] == '>' && flag) {
                flag = false;
            }
        }
    }
}

SOLUTION 3
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printTagValue(scanner.nextLine());
    }

    public static void printTagValue(String html) {
        Pattern p = Pattern.compile("<([a-z\\d]+)>(.+)</\\1>");
        Matcher m = p.matcher(html);
        while (m.find()) {
            printTagValue(m.group(2));
            System.out.println(m.group(2));
        }
    }
}
"<([a-z\d]+)>" - matches a start tag. Tag names could contain one or more characters in the range a-z or digits.
"(.+)" - matches content between tags.
"</\\1>" - matches an end tag with the same name as the start tag. \1 matches the same text as most recently matched by the 1st capturing group.

SOLUTION 4
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                if (str.charAt(i + 1) != '/') {
                    stack.push(str.indexOf('>', i) + 1);
                } else {
                    int indexOpen = stack.pop();
                    System.out.println(str.substring(indexOpen, i));
                }
            }
        }
    }
}

SOLUTION 5
import java.util.*;
import java.util.regex.*;

class Main {
    public static void main(String[] args) {
        dfs(new Scanner(System.in).nextLine());
    }

    private static void dfs(String input) {
        Matcher m = Pattern.compile("<(\\w+)>(.+?)</\\1>").matcher(input);
        while (m.find()) {
            dfs(m.group(2));
            System.out.println(m.group(2));
        }
    }
}
 */