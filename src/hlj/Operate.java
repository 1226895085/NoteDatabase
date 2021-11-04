package hlj;

import hlj.table.*;

import java.util.*;

/**
 * @PackageName:hlj
 * @ClassName:Operate
 * @Description:
 * @author:ss
 * @date:2021/11/3 15:28
 */
public class Operate {

    //zid
    private ZID zid_table = ZID.getInstance();

    //id-zid
    private DZID dzid_table = DZID.getInstance();
    //data-id
    private DataID dataID_table = DataID.getInstance();

    private DataRelation dataRelation_table = DataRelation.getInstance();

    //注记  zid
    private AttributeZID attributeZID_table = AttributeZID.getInstance();


    //添加普通数据
    public void addData(String value, String note, String mainAttribute){
        //1,数据放入data ID表，返回 id
        //2,注记放入属性-zid表，返回zid
        //3,获取识别注记的zid
        //4，id zid 放入表
        //5，数据关系表中加入id

        int id = dataID_table.addData(value);
        int zid = attributeZID_table.addData(note);

        int mainAttributeID = dataID_table.query(mainAttribute).get(0);
        //int mainAttributeZID = dzid_table.query(mainAttributeID);

        dzid_table.addData(id, zid);
        dataRelation_table.addData(mainAttributeID,id);

    }

    //添加识别注记
    public void addData(String value, String note){
        //1,数据放入data ID表，返回 id
        //2,注记放入属性-zid表，返回zid
        //3,获取识别注记的zid
        //4，id zid 放入表
        //5，数据关系表中加入id
        int id = dataID_table.addData(value);
        int zid = attributeZID_table.addData(note);
        dzid_table.addData(id, zid);
        dataRelation_table.addData(id,id);
        zid_table.addData(zid);

    }

    //识别注记列表
    public List<String>  getMainAttributeList(){

        List<Integer> allMainAttributeZID = zid_table.query();
        List<Integer> allMainAttributeID = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i :allMainAttributeZID
             ) {
            for ( int j : dzid_table.query(i, true)
                 ) {
                allMainAttributeID.add(j);
            }
        }

        for (int n : allMainAttributeID
             ) {
            result.add(dataID_table.query(n));

        }
        return result;
    }


    public Map<String, String> getEntity(String value){

        Map<String, String> entity = new HashMap<>();

        int id = dataID_table.query(value).get(0);
        //int zid = dzid_table.query(id);

        if(dataRelation_table.getData_relaiton().containsKey(Integer.valueOf(id))){
            List<Integer> idList = dataRelation_table.query(id);

            for (int i : idList
                 ) {
                entity.put(attributeZID_table.query(dzid_table.query(i)), dataID_table.query(i));
            }
        }

        return entity;
    }












    public void printAllTable(){

        System.err.println("------dataID_table------");
        for(Map.Entry<Integer , String> one_data_id : dataID_table.getData_id().entrySet()){
            System.err.println(one_data_id.getKey() + "  :  " + one_data_id.getValue());
        }

        System.err.println("------attributeZID_table------");
        for(Map.Entry<String , Integer> one_attribute_zid : attributeZID_table.getAttribute_zid().entrySet()){
            System.err.println(one_attribute_zid.getKey() + "  :  " + one_attribute_zid.getValue());
        }

        System.err.println("------dzid_table------");
        for(Map.Entry<Integer , Integer> one_id_zid : dzid_table.getId_zid().entrySet()){
            System.err.println(one_id_zid.getKey() + "  :  " + one_id_zid.getValue());
        }

        System.err.println("------zid_table------");
        for(int zid : zid_table.getZid_List()){
            System.err.println(zid);
        }

        System.err.println("------dataRelation_table------");
        for(Map.Entry<Integer , List<Integer>> one_id_zid : dataRelation_table.getData_relaiton().entrySet()){
            String str = one_id_zid.getKey() + " : ";
            for (int id : one_id_zid.getValue()
                 ) {
                str += id + ",";
            }
            System.err.println(str);
        }



    }


}
