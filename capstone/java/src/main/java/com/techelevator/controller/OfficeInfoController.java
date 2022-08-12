package com.techelevator.controller;

import com.techelevator.dao.OfficeInfoDao;
import com.techelevator.dao.ReviewDao;
import com.techelevator.model.OfficeInfo;
import com.techelevator.model.Reviews;
import org.apache.coyote.RequestGroupInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OfficeInfoController {

    private OfficeInfoDao officeInfoDao;
    private ReviewDao reviewDao;

    public OfficeInfoController(OfficeInfoDao officeInfoDao, ReviewDao reviewDao){this.officeInfoDao = officeInfoDao; this.reviewDao = reviewDao;}

    @RequestMapping(value="/offices", method = RequestMethod.GET)
    public List<OfficeInfo> findAllOffices(){
        return officeInfoDao.getAllOffices();
    }

    @RequestMapping(value="/offices/{id}", method= RequestMethod.GET)
    public OfficeInfo findOfficeById(@PathVariable int id){
        return officeInfoDao.getOfficeById(id);
    }

    @RequestMapping(value="/offices/{id}/ratings", method = RequestMethod.GET)
    public List<Reviews> getReviewsForOffice(@PathVariable int id){
        return reviewDao.getByOfficeID(id);
    }

    @RequestMapping(value="doctors/offices/{id}", method = RequestMethod.GET)
    public List<OfficeInfo> findOfficeByDoctorId(@PathVariable int id){
        return officeInfoDao.getAllOfficesByDoctors(id);
    }

    @RequestMapping(value="offices", method = RequestMethod.PUT)
    public void updateOffice(@RequestBody OfficeInfo officeInfo){
        officeInfoDao.updateOffice(officeInfo);
    }
}
