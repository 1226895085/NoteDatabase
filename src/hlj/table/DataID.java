package hlj.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:hlj.table
 * @ClassName:IDData
 * @Description:
 * @author:ss
 * @date:2021/11/3 14:51
 */
public class DataID {


    private static DataID DATAID;
    private Map<Integer, String> data_id;

    public DataID() {
        data_id = new HashMap<>();
    }

    public static DataID getInstance(){
        if(DATAID == null){

            DATAID = new DataID();
        }
        return DATAID;
    }

    public int addData(String data){

        int id = Tools.getID(true);
        data_id.put(id, data);
        return id;
    }

    public void remove(int id){

        data_id.remove(Integer.valueOf(id));

    }



    public void remove(List<Integer> idList){

        for (int id : idList
             ) {
            remove(id);
        }
    }

    public void update(int id, String value){
        data_id.put(id, value);

    }

    public String query(int id){

        return data_id.get(Integer.valueOf(id));
    }

    public List<Integer> query(String data){
        List<Integer> idList = new ArrayList<>();
        for (Map.Entry<Integer, String> a :data_id.entrySet()
             ) {

            if(a.getValue().equals(data)){
                idList.add(a.getKey());
            }
        }
        return idList;
    }

    public Map<Integer, String> getData_id() {
        return data_id;
    }
}
