package hlj.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @PackageName:hlj.table
 * @ClassName:AttributeZID
 * @Description:
 * @author:ss
 * @date:2021/11/3 14:53
 */
public class AttributeZID {

    private static AttributeZID ATTRIBUTEZID;
    private Map<String, Integer> attribute_zid;

    private AttributeZID() {
        attribute_zid = new HashMap<>();
    }

    public static AttributeZID getInstance(){

        if(ATTRIBUTEZID == null){
            ATTRIBUTEZID = new AttributeZID();
        }
        return ATTRIBUTEZID;
    }



    public int addData(String data){
        if(attribute_zid.containsKey(data)){
            return attribute_zid.get(data);
        }else {
            int id = Tools.getID(false);
            attribute_zid.put(data, id);
            return id;
        }


    }

    public void remove(int id){

        for (Map.Entry<String, Integer> entry : attribute_zid.entrySet()
        ) {

            if(entry.getValue() == id){
                attribute_zid.remove(entry.getKey());
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

    public void update(int id, String value){
        for (Map.Entry<String, Integer> entry : attribute_zid.entrySet()
        ) {

            if(entry.getValue() == id){
                attribute_zid.remove(entry.getKey());
                attribute_zid.put(value, id);
                break;
            }
        }
    }

    public String query(int id){
        for (Map.Entry<String, Integer> entry : attribute_zid.entrySet()
        ) {

            if(entry.getValue() == id){
                return entry.getKey();

            }
        }
        return null;
    }

    public Set<String> query(){
        return attribute_zid.keySet();
    }


    public Map<String, Integer> getAttribute_zid() {
        return attribute_zid;
    }


}
