package hlj.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:hlj.table
 * @ClassName:DataRelation
 * @Description:
 * @author:ss
 * @date:2021/11/3 14:56
 */
public class DataRelation {

    private static DataRelation DATARELATION;
    private Map<Integer, List<Integer>> data_relaiton;

    private DataRelation() {
        data_relaiton = new HashMap<>();
    }

    public static DataRelation getInstance(){

        if(DATARELATION == null){
            DATARELATION = new DataRelation();

        }
        return DATARELATION;
    }

    public void addData(int id_main, int id){
        if(data_relaiton.containsKey(id_main)){
            data_relaiton.get(Integer.valueOf(id_main)).add(id);

        }else {

            data_relaiton.put(id_main, new ArrayList<Integer>(){{
                add(id);
            }});
        }

    }


    public void removeOneZid(int zid){
        data_relaiton.remove(Integer.valueOf(zid));
    }

    public void removeOneID(int zid, int id){
        List<Integer> idList = data_relaiton.get(Integer.valueOf(zid));
        idList.remove(Integer.valueOf(id));
    }

    public void removeOneID(int zid, List<Integer> idList){

        for (int id :idList
             ) {
            removeOneID(zid, idList);
        }
    }

    public List<Integer> query(int id){
        return data_relaiton.get(Integer.valueOf(id));
    }


    public Map<Integer, List<Integer>> getData_relaiton() {
        return data_relaiton;
    }
}
