package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yongfeng on 16/9/14.
 */
public class EvaluateDivision_399 {

    public static  double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String,Double> map = new HashMap<>();
        Map<String,Set<String>> tmp = new HashMap<>();
        int size1 = equations.length;
        int size2 = values.length;
        if(size1 != size2){
            return null;
        }
        if(size1 == 0){
            return null;
        }

        int len = queries.length;
        if(len == 0){
            return null;
        }

        init(equations,map,tmp,values,size1);

        for(int i = 0 ;i < size1 ; ++i){
            cal(equations[i][0],equations[i][1],map,tmp,equations,1,size1);
            cal(equations[i][1], equations[i][0], map, tmp, equations, 1, size1);
        }

        return getRes(queries,map);

    }

    private static double[] getRes(String[][] queries,Map<String,Double> map){
        int  size = queries.length;
        double[] res = new double[size];
        for(int i = 0; i< size; ++i){
            String fenzi = queries[i][0];
            String fenmu = queries[i][1];
            Double d = map.get(fenzi + "/" + fenmu);
            if(d != null){
                res[i] = d;
            }else{
                d = map.get(fenmu + "/" + fenzi);
                if(d != null){
                    res[i] = 1/d;
                }else{
                    res[i] = -1;
                }
            }
            System.out.println(res[i]);

        }
        return res;
    }


    private static void init(String[][] equations,Map<String,Double> map,Map<String,Set<String>> tmp, double[] values,int size1){
        for(int i = 0; i< size1; ++i){
            map.put((equations[i][0] + "/" + equations[i][1]), values[i]);
            map.put((equations[i][1] + "/" + equations[i][0]), 1.0 / values[i]);

            Set<String> s1 = tmp.get(equations[i][1]);
            if(s1 == null){
                s1 = new HashSet<>();
            }
            s1.add(equations[i][0]);
            tmp.put(equations[i][1], s1);


            Set<String> s2 = tmp.get(equations[i][0]);
            if(s2 == null){
                s2 = new HashSet<>();
            }
            s2.add(equations[i][1]);
            tmp.put(equations[i][0], s2);

        }
    }



    private static void cal(String fz,String fm,Map<String,Double> map,Map<String,Set<String>> tmp,String[][] equations,int start, int end){
        String fenzi = fz;
        String fenmu = fm;
        Set<String> stringSet = tmp.get(fenmu);
        Set<String> tmpSet;
        for(int j = start + 1; j < end ; ++j){
            if(equations[j][0].equals(fenmu)){
                map.put(fenzi + "/" + equations[j][1], map.get(fenzi + "/" + fenmu) * map.get(equations[j][0] + "/" + equations[j][1]));
                tmpSet = tmp.get(fenzi);
                if(tmpSet == null){
                    tmpSet = new HashSet<>();
                }
                tmpSet.add(equations[j][1]);
                map.put(equations[j][1] + "/" + fenzi,1.0/(map.get(fenzi + "/" + fenmu)*map.get(equations[j][0] + "/" + equations[j][1])));
                tmpSet = tmp.get(equations[j][1]);
                if(tmpSet == null){
                    tmpSet = new HashSet<>();
                }
                tmpSet.add(fenzi);
            }
        }

        for(String s: stringSet){
            if(s.equals(fenmu)){
                continue;
            }
            if(map.containsKey(fenzi + "/" + s)){
                continue;
            }
            map.put(fenzi + "/" + s,map.get(fenzi + "/" + fenmu)*map.get(fenmu + "/" + s));
            tmpSet = tmp.get(fenzi);
            if(tmpSet == null){
                tmpSet = new HashSet<>();
            }
            tmpSet.add(s);
        }
    }



    public static void main(String[] args) {
        String[][] question ={{"a","b"},{"a","c"},{"a","d"},{"a","e"},{"a","f"},{"a","g"},{"a","h"},{"a","i"},{"a","j"},{"a","k"},{"a","l"},{"a","aa"},{"a","aaa"},{"a","aaaa"},{"a","aaaaa"},{"a","bb"},{"a","bbb"},{"a","ff"}};
        double[] value = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,1.0,1.0,1.0,1.0,1.0,3.0,5.0};
        String[][] qu={{"d","f"},{"e","g"},{"e","k"},{"h","a"},{"aaa","k"},{"aaa","i"},{"aa","e"},{"aaa","aa"},{"aaa","ff"},{"bbb","bb"},{"bb","h"},{"bb","i"},{"bb","k"},{"aaa","k"},{"k","l"},{"x","k"},{"l","ll"}};
        calcEquation(question,value,qu);
    }




}
