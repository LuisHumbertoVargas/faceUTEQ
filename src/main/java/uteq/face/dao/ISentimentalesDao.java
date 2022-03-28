package uteq.face.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uteq.face.model.SentimentalesModel;

@Repository
public interface ISentimentalesDao extends JpaRepository<SentimentalesModel, Long>{
    
}

