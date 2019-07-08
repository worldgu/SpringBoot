package com.zero.repository;

import com.zero.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：Zero
 * @date ：Created in 2019/7/8 10:51
 * @modified By：
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
