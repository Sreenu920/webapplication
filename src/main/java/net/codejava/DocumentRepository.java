package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
@Query("SELECT new Document(d.id,d.name,d.empid) FROM Document d where d.empid=?1")
List<Document> findAllByEmpid(Long empid);
}