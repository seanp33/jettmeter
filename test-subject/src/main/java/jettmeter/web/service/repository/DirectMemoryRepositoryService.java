package jettmeter.web.service.repository;

import jettmeter.web.model.Record;
import org.apache.directmemory.DirectMemory;
import org.apache.directmemory.cache.CacheService;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "jettmeter.jmx:name=DirectMemoryRepositoryService,type=DirectMemoryRepositoryService", description = "The MemoryRepositoryService")
public class DirectMemoryRepositoryService implements RepositoryService<String, Record, String>{

    private CacheService<Object, Object> cacheService = new DirectMemory<Object, Object>()
        .setNumberOfBuffers(10)
        .setSize(1000)
        .setInitialCapacity(100000)
        .setConcurrencyLevel(100)
        .newCacheService();

    public Record read(String query) {
        return null;
    }

    // TODO: understand direct mem's threading model
    public synchronized String write(Record record) {
        cacheService.put(record.getId(), record);
        return record.getId();
    }

    @ManagedAttribute(description = "The size of the store")
        public int getSize() {
            return cacheService.getMap().size();
        }

        @ManagedOperation(description = "Clears the in-memory store")
        public synchronized void resetStore() {
            cacheService.clear();
        }

}
