package hlj.table;

/**
 * @PackageName:hlj.table
 * @ClassName:Tools
 * @Description:
 * @author:ss
 * @date:2021/11/3 14:58
 */
public class Tools {

    private static int id_count = 0;
    private static int zid_count = 0;

    //b 为true 获取id 为false 获取zid
    public static int getID(boolean b){
        if(b){
            return id_count++;
        }else {
            return zid_count++;
        }

    }
}
