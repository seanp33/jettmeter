package jettmeter.web.service.repository;

import jettmeter.web.model.Record;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.util.HashMap;
import java.util.Map;

@ManagedResource(objectName = "jettmeter.jmx:name=MemoryRepositoryService,type=MemoryRepositoryService", description = "The MemoryRepositoryService")
public class MemoryRepositoryService implements RepositoryService<String, Record, String> {

    private Map<String, Record> store = new HashMap<String, Record>();

    public Record read(String id) {
        return store.get(id);
    }

    public synchronized String write(final Record record) {
        store.put(record.getId(), record);
        return record.getId();
    }

    @ManagedAttribute(description = "The size of the store")
    public int getSize() {
        return store.size();
    }

    @ManagedOperation(description = "Clears the in-memory store")
    public synchronized void resetStore() {
        store.clear();
    }
}
