package com.mycompany.onlineexam.repository;

import com.mycompany.onlineexam.domain.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {

    Master getMasterByUsernameAndPassword(String username, String password);

    void deleteMasterByMasterCode(String masterCode);

    Master getMasterByMasterCode(String masterCode);

    Master findMasterByUsername(String username);
}
