package com.crm.miniCRM.model.persistence;


import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.PersonAddress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonAddressRepository extends CrudRepository<PersonAddress, PersonAddressID> {

    Optional<PersonAddress> findById(PersonAddressID personAddressID);

}