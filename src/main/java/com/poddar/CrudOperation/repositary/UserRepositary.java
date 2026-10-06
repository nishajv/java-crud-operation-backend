package com.poddar.CrudOperation.repositary;

import com.poddar.CrudOperation.model.UserRegs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositary extends JpaRepository<UserRegs, Long> {

}
