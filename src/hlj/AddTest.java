package hlj;

import java.util.Map;

/**
 * @PackageName:hlj
 * @ClassName:AddTest
 * @Description:
 * @author:ss
 * @date:2021/11/3 16:04
 */
public class AddTest {

    public static void main(String[] args) {

        Operate operate = new Operate();

        operate.addData("孙爽", "姓名");
        operate.addData("张三", "name");
        operate.addData("李四", "姓名");

        operate.addData("25", "年龄", "孙爽");
        operate.addData("13720335235", "电话", "孙爽");
        operate.addData("男", "性别", "孙爽");
        operate.addData("计算机", "专业", "孙爽");

        operate.addData("30", "年龄", "张三");
        operate.addData("100000000", "电话", "张三");
        operate.addData("男", "性别", "张三");
        operate.addData("经济", "专业", "张三");


        operate.addData("19", "年龄", "李四");
        operate.addData("22222222", "电话", "李四");
        operate.addData("女", "性别", "李四");
        operate.addData("生科", "专业", "李四");

        operate.printAllTable();


        System.err.println("-----------------");
        for (String str : operate.getMainAttributeList()
        ) {
            System.err.println(str);
            for (Map.Entry<String, String> a : operate.getEntity(str).entrySet()
                 ) {

                System.err.println(a.getKey() + " : " + a.getValue());

            };
            System.err.println("-----------------");
        }


    }
}
