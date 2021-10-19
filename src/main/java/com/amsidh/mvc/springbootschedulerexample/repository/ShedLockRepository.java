package com.amsidh.mvc.springbootschedulerexample.repository;

import com.amsidh.mvc.springbootschedulerexample.entities.ShedLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShedLockRepository extends JpaRepository<ShedLock, String> {
}
