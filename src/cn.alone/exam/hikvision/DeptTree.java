package cn.alone.exam.hikvision;

import java.util.*;

/**
 * Created by RojerAlone on 2017-09-14.
 * 输入字符串，输出对应的部门树结构

 比如公司部门的数据对应关系如下，已按照部门层级排序：
 ID        名称          上级部门ID
 1         公司A          0
 2         人力资源部      1
 3         薪酬福利管理部  2
 4         招聘部          2
 列出部门的关系如下：
 公司A---人力资源部---薪酬福利管理部；公司A---人力资源部---招聘部

 1,A,0;2,B,1;3,C,1
 1,A,0; B,1,2;
 1,A,0;2,B,1;3,C,2;4,D,2
 2,A,0; 1,B,1;3,C,2

 A-B;A-C
 incorrect data
 A-B-C;A-B-D
 incorrect data
 */
public class DeptTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] depts = str.split(";");
            if (depts.length < 3) {
                System.out.println("incorrect data");
            } else {
                boolean incorrect = false;
                Map<Integer, Dept> map = new HashMap<>(depts.length + 1);
                map.put(0, new Dept(0, null, -1));
                for (String dept : depts) {
                    String[] tmp = dept.split(",");
                    if (tmp.length != 3) {
                        System.out.println("incorrect data");
                        incorrect = true;
                        break;
                    } else {
                        if (tmp[0].equals(tmp[2])) {
                            System.out.println("incorrect data");
                            incorrect = true;
                            break;
                        } else {
                            if (map.get(Integer.valueOf(tmp[2])) == null) {
                                System.out.println("incorrect data");
                                incorrect = true;
                                break;
                            } else {
                                Dept tmpDept = new Dept(Integer.valueOf(tmp[0]), tmp[1], Integer.valueOf(tmp[2]));
                                map.get(Integer.valueOf(tmp[2])).son.offer(tmpDept);
                                map.put(Integer.valueOf(tmp[0]), tmpDept);
                            }
                        }
                    }
                }
                if (incorrect) {
                    continue;
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (map.get(0).son.size() != 1) {
                        System.out.println("incorrect data");
                    } else {
                        Dept dept = map.get(0).son.peek();
                        boolean hasNext = false;
                        while (dept != null) {
                            if (dept.parent == 0) {
                                sb.append(dept.name);
                                hasNext = false; // 新一次循环，重置标识
                            } else {
                                sb.append("-").append(dept.name);
                            }
                            if (dept.son.size() > 1) {
                                hasNext = true;
                                dept = dept.son.remove();
                            } else if (dept.son.size() == 1) {
                                dept = dept.son.peek();
                            } else {
                                if (hasNext) {
                                    sb.append(";");
                                    hasNext = false;
                                    dept = map.get(0).son.peek();
                                } else {
                                    dept = null;
                                }
                            }
                        }
                        System.out.println(sb.toString());
                    }
                }
            }
        }
        sc.close();
    }

    static class Dept {
        public int id;
        public String name;
        public int parent;
        public Queue<Dept> son = new LinkedList<>();

        public Dept(int id, String name, int parent) {
            this.id = id;
            this.name = name;
            this.parent = parent;
        }

    }

}
