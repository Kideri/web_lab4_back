package kideri.web.services;

import kideri.web.area.PointData;
import kideri.web.orm.Result;
import kideri.web.orm.ResultActual;
import kideri.web.orm.ResultRs;
import kideri.web.orm.User;
import kideri.web.repositories.ResultActualRepository;
import kideri.web.repositories.ResultRepository;
import kideri.web.repositories.ResultRsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PointsDataService {

    @Transactional
    public ResultRs AddNewResult(float x, float y, float r,User curUser){


        Result newResult=new Result(x,y,curUser);
        resultRepository.save(newResult);

        ResultRs newResultRs = new ResultRs(newResult,r,new Date());
        resultRsRepository.save(newResultRs);

        ResultActual newResultActual = new ResultActual(newResultRs);
        resultActualRepository.save(newResultActual);
        return newResultRs;

    }


    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ResultRsRepository resultRsRepository;

    @Autowired
    private ResultActualRepository resultActualRepository;


    @Transactional
    public List<PointData> GetAll(String login) {
        return resultRepository.GetAll(login);
    }


    @Modifying
    public boolean deleteActualPoint(int point_id) {

        resultActualRepository.deleteActualPoint(point_id);

       return true;
    }

    @Modifying
    public boolean reDrawActualPoint(int point_id,float radius) {

        Optional<Result> point= resultRepository.findById( point_id);

        if(!point.isPresent())return false;

        ResultRs newResultRs = new ResultRs(point.get(),radius,new Date());
        resultRsRepository.save(newResultRs);

        resultActualRepository.changeActualPoint(newResultRs,point_id);

       return  true;
    }
}
