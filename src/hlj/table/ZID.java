package hlj.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:hlj.table
 * @ClassName:ZID
 * @Description:
 * @author:ss
 * @date:2021/11/3 14:55
 */
public class ZID {

    private static ZID ZIDD;
    private List<Integer> zid_List;

    private ZID() {
        zid_List = new ArrayList<>();
    }

    public static ZID getInstance(){
        if(ZIDD == null){
            ZIDD = new ZID();

        }
        return ZIDD;
    }

    public void addData(int zid){
        if(!zid_List.contains(Integer.valueOf(zid))){
            zid_List.add(zid);
        }

    }

    public void remove(int zid){
        zid_List.remove(Integer.valueOf(zid));
    }



    public void remove(List<Integer> zidList){

        for (int zid : zidList
        ) {
            remove(zid);
        }
    }


    public List<Integer> query(){
        return zid_List;
    }

    public List<Integer> getZid_List() {
        return zid_List;
    }
}
