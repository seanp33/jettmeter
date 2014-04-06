package jettmeter.web.service.repository;

public interface RepositoryService<Q, R, ID> {

    R read(Q query);

    ID write(R record);
}
