package problems.onstack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class SimplyfyUnixPaths {

    //Epi Accepted solution
    public static String shortestEquivalentPath(String path) {
        StringBuilder res = new StringBuilder();
        String[] tokens = path.split("/");
        Deque<String> dirNames = new LinkedList<>();
        if (path.startsWith("/")) dirNames.addFirst("/");
        for (String token : tokens) {
            if ("..".equals(token)){
                if (dirNames.isEmpty() || dirNames.peekFirst().equals("..")){
                    dirNames.addFirst(token);
                } else {
                    if (dirNames.peekFirst().equals("/")){
                        throw new IllegalStateException("trying to go up to root"+path);
                    }
                    dirNames.removeFirst();

                }
            } else if(!".".equals(token) && !token.isEmpty()) {
                dirNames.addFirst(token);
            }
        }

        if (!dirNames.isEmpty()){
            Iterator<String> it = dirNames.descendingIterator();
            String prev = it.next();
            res.append(prev);
            while (it.hasNext()){
                if(!prev.equals("/")){
                    res.append("/");
                }
                prev = it.next();
                res.append(prev);
            }
        }
        return res.toString();
    }

    //Leetcode accepted solution
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        String[] tokens = path.split("/");
        Deque<String> dirNames = new LinkedList<>();
        for (String token : tokens) {
            if ("..".equals(token)){
                if (!dirNames.isEmpty()){
                    dirNames.removeFirst();
                }
            } else if(!".".equals(token) && !token.isEmpty()) {
                dirNames.addFirst(token);
            }
        }

        res.append("/");
        while (!dirNames.isEmpty()){
            String prev = dirNames.removeLast();
            res.append(prev);
            if(!dirNames.isEmpty()){
                res.append("/");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestEquivalentPath("/abc/../c"));
        System.out.println(shortestEquivalentPath("/abc/../c"));
    }
}
