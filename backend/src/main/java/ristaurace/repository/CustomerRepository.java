// Tomáš Vopat - vopattom

package ristaurace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ristaurace.model.CustomerModel;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    List<CustomerModel> findByLastName(String lastName);
}
