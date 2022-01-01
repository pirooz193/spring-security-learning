package com.mycompany.onlineexam.service;

import com.mycompany.onlineexam.domain.Admin;
import com.mycompany.onlineexam.domain.Course;
import com.mycompany.onlineexam.domain.Master;
import com.mycompany.onlineexam.service.dto.MasterDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface MasterService {
    Master checkMasterLogin(String username, String password);

    Master createMaster(MasterDTO masterDto);

    void deleteMaster(String masterCode);

    Master updateMasterInfo(MasterDTO masterDto);

    Master getMasterByMasterCode(String masterCode);

    Master getMasterByUsername(String username);
}
