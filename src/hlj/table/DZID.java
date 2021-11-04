package hlj.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:hlj.table
 * @ClassName:Relation
 * @Description:
 * @author:ss
 * @date:2021/11/3 14:54
 */
public class DZID {

    private static DZID DZIDD;

    private Map<Integer, Integer> id_zid;

    private DZID() {
        id_zid = new HashMap<>();
    }

    public static DZID getInstance(){

        if(DZIDD == null){
            DZIDD = new DZID();
        }
        return DZIDD;
    }


    public void addData(int id, int zid){
        id_zid.put(id, zid);
    }

    public void remove(int id){

        for (Map.Entry<Integer, Integer> entry : id_zid.entrySet()
        ) {
            if(entry.getValue() == id){
                id_zid.remove(entry.getKey());
                break;
            }
        }
    }



    public void remove(List<Integer> idList){

        for (int id : idList
        ) {
            remove(id);
        }
    }


    //zid 查 id
    public List<Integer> query(int zid, boolean b){
        List<Integer> idList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : id_zid.entrySet()
        ) {

            if(entry.getValue() == zid){
                idList.add(entry.getKey());
            }
        }
        return idList;
    }

    //id 查zid
    public int query(int id){
        return id_zid.get(Integer.valueOf(id));
    }

    public Map<Integer, Integer> getId_zid() {
        return id_zid;
    }
}
