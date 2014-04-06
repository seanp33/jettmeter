package jettmeter.web.model;

import java.util.HashMap;
import java.util.Map;

public class Record {

    private String id;

    protected Map<String, Object> fields = new HashMap<String, Object>();

    public Record(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void set(String key, Object value){
        fields.put(key, value);
    };

    public Object get(String key){
        return fields.get(key);
    }

}
