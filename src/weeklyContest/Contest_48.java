package weeklyContest;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/9/3.
 */
public class Contest_48 {


    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        char[] tmp = String.valueOf(num).toCharArray();
        Arrays.sort(tmp);
        int len = tmp.length;
        for(int i = 0 ;i < len ; ++i){
            if(tmp[len - 1 - i ] == nums[i]){
                continue;
            }else{
                char c = nums[i];
                nums[i] = tmp[len -1 - i];
                for(int j = len - 1; j >=0 ; --j){
                    if(nums[j] == nums[i]){
                        nums[j] = c;
                        break;
                    }
                }
                break;
            }
        }
        return Integer.parseInt(new String(nums));

    }

    public static void main(String[] args) {
        Contest_48 contest_48 = new Contest_48();
        System.out.println(contest_48.maximumSwap(98368));
    }



    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        TreeNode res = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            if(res == null && head.val >=L && head.val <= R){
                res = head;
            }
            if(null != head.left){
                if(head.left.val < L && head.left.right != null){
                    TreeNode tmp = head.left.right;
                    while(tmp != null && tmp.val < L){
                        tmp = tmp.right;
                    }
                    head.left = tmp;
                    if(tmp != null){
                        queue.add(head.left);
                    }

                }else if(head.left.val >= L){
                    queue.add(head.left);
                }else{
                    head.left = null;
                }
            }
            if(null != head.right){
                if(head.right.val > R && head.right.left != null){
                    TreeNode tmp = head.right.left;
                    while(tmp != null && tmp.val > R){
                        tmp = tmp.left;
                    }
                    head.right = tmp;
                    if(null != tmp){
                        queue.add(head.right);
                    }
                }else if(head.right.val <= R){
                    queue.add(head.right);
                }else{
                    head.right = null;
                }
            }
        }
        return res;
    }


    private boolean needAddLeft(TreeNode node ,int num){
        while(node != null && node.val < num){
            node = node.right;
        }
        return node != null;
    }


    private boolean needAddRight(TreeNode node,int num){
        while(node != null && node.val > num){
            node = node.left;
        }
        return node != null;
    }




    public int findSecondMinimumValue(TreeNode root) {
        if(null == root.left && root.right == null){
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();
        Set<Integer> tmp = new HashSet<>();
        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            nums.add(head.val);
            tmp.add(head.val);
            if(head.left != null && head.right != null){
                queue.add(head.left);
                queue.add(head.right);
            }
        }
        if(tmp.size() < 2){
            return -1;
        }
        Collections.sort(nums);
        int num = nums.get(0);
        for(int i = 1 ; i < nums.size();++i){
            if(num != nums.get(i)){
                return nums.get(i);
            }
        }
        return -1;

    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
