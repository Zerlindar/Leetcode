package weeklyContest;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

/**
 * Created by sunyongfeng on 2017/11/5.
 */
public class Contest_57 {


    public static void main(String[] args) {
        Contest_57 contest_57 = new Contest_57();
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        List<String> tmp1 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> tmp2 = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> tmp3 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> tmp4 = Arrays.asList("Mary", "mary@mail.com");
        List<List<String>> accoutns = new ArrayList<>();
        accoutns.add(tmp1);
        accoutns.add(tmp2);
        accoutns.add(tmp3);
        accoutns.add(tmp4);
//        System.out.println(contest_57.accountsMerge(accoutns));


        String[] sources = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
        System.out.println(contest_57.removeComments(sources));
    }


    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        int len = source.length;
        for(int i = 0 ; i < len ; ++i){
            String line = source[i];
            if(line.contains("//") || line.contains("/*")){
                if(line.contains("/*") && line.contains("*/")){
                    int idx1 = line.indexOf("/*");
                    int idx2 = line.indexOf("*/");
                    String tmp = line.substring(0,idx1) + line.substring(idx2 + 2,line.length());
                    if(tmp.length() > 0){
                        res.add(tmp);
                    }

                }else if(line.contains("/*") && line.contains("//")){
                    int idx1 = line.indexOf("/*");
                    int idx2 = line.indexOf("//");
                    if(idx2 < idx1){
                        int  idx = line.indexOf("//");
                        String tmp = line.substring(0,idx);
                        if(tmp.length() > 0){
                            res.add(tmp);
                        }
                    }else{
                        int idx = line.indexOf("/*");
                        String tmp = line.substring(0,idx);
                        if(tmp.length() > 0){
                            res.add(tmp);
                        }
                        int j = i + 1;
                        while (j < len && !source[j].contains("*/")){
                            ++j;
                        }
                        idx = source[j].indexOf("*/");
                        tmp = source[j].substring(idx + 2,source[j].length());
                        if(tmp.length() > 0){
                            res.add(tmp);
                        }
                    }
                }else if(line.contains("/*")){
                    int idx = line.indexOf("/*");
                    String tmp = line.substring(0,idx);
                    ++i;
                    while (i < len && !source[i].contains("*/")){
                        ++i;
                    }
                    idx = source[i].indexOf("*/");
                    tmp = tmp + source[i].substring(idx + 2,source[i].length());
                    if(tmp.length() > 0){
                        res.add(tmp);
                    }
                }else{
                    int  idx = line.indexOf("//");
                    String tmp = line.substring(0,idx);
                    if(tmp.length() > 0){
                        res.add(tmp);
                    }
                }
            }
           else{
                res.add(line);
            }
        }
        return res;
    }



    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        Map<Integer,Set<String>> tmp = new HashMap<>();
        Map<Integer,String> tmp2 = new HashMap<>();
        int[] used = new int[len];
        for(int i = 0 ; i < len ; ++i){
            Set<String> set = new HashSet<>();
            tmp2.put(i,accounts.get(i).get(0));
            for(int j = 1 ; j < accounts.get(i).size() ; ++j){
                set.add(accounts.get(i).get(j));
            }
            tmp.put(i,set);
        }
        Set<String> contianer = new HashSet<>();

        for(int i = 0 ;i < len ; ++i){
            for(int j = i + 1; j < len ; ++j){
                contianer.clear();
                contianer.addAll(tmp.get(i));
                contianer.retainAll(tmp.get(j));
                if(contianer.size() > 0){
                    tmp.get(j).addAll(tmp.get(i));
                    used[i] = 1;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();

        for(int i = 0 ;i < len ; ++i){
            if(used[i] == 0){
                List<String> list = new ArrayList<>(tmp.get(i));
                Collections.sort(list);
                list.add(0,tmp2.get(i));
                res.add(list);
            }

        }
        return res;

    }



    public String longestWord(String[] words) {
        int len = words.length;
        if(len == 0){
            return "";
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                }else{
                    return o2.compareTo(o1);
                }

            }
        });

        Set<String> tmp = new HashSet<>();
        for(String word : words){
            tmp.add(word);
        }

        for(int i = len - 1; i >=0 ; --i){
            if(helper(words[i],tmp)){
                return words[i];
            }
        }
        return "";

    }

    private boolean helper(String word ,Set<String> words){
        int stop = word.length() - 1;
        while(stop > 0){
            if(words.contains(word.substring(0,stop))){
                --stop;
            }else{
                return false;
            }
        }
        return true;
    }



}
