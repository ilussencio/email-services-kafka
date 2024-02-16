package br.com.srbit.msemail.repositories;

import br.com.srbit.msemail.models.EmailModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<EmailModel, String> {
}
