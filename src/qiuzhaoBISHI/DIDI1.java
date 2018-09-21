package qiuzhaoBISHI;

import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 * 题目描述：
英文单词拼写的时候可能会出现拼写错误的情况(typo)。下面的题目，我们尝试实现拼写纠错推荐的功能。

字串编辑距离是衡量字串间相似度的常见手段。

①字串编辑距离：是指利用字符操作，把字符串A转换成字符串B所需要的最少操作数。

②字串操作包括：删除字符(removal)、插入字符(insertion)、修改字符(substitution)。

③使用以下规则对推荐纠错选项进行相似度排序。得分越高，认为相似度越低

只涉及到26个英文字符、不区分大小写。

删除(removal)  3分

插入(insertion) 3分

修改(substitution) ：

(q w e r t a s d f g z x c v ) （y u i o p h j k l b n m）

以上两个分组内的字符修改1分，两个分组间字符修改 2分。

输入
·每行一个输入。空格分割参数。 ·第一个参数是目标单词(可能存在typo) ·后面若干空格分割参数(个数不定)是字典单词，作为候选纠错项(也可能和第一个参数重复)。

输出
·按照上面的纠错规则字串相似度最小编辑距离进行排序，给出3个(如有)对应的纠错候选。 ·如得分相同，则按照输入顺序进行排序。


样例输入
slep slap sleep step shoe shop snap slep
样例输出
slep slap step
 **/
public class DIDI1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
    }
}
