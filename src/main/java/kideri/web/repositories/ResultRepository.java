package kideri.web.repositories;

import kideri.web.area.PointData;
import kideri.web.controller.AuthCheck;
import kideri.web.orm.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

    @Query("SELECT NEW kideri.web.area.PointData(point.x,point.y,rez.r,rez.inside,point.point_id) " +
            "FROM ResultActual act, ResultRs rez, Result point, User user" +
            " where " +
            "point.user = user " +
            "and user.login=?1 " +
            "and rez.point=point " +
            "and act.history_point=rez order by point.point_id asc ")
    List<PointData> GetAll(String login);


    @EnableWebMvc
    @Configuration
    class WebConfig implements WebMvcConfigurer {


        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new AuthCheck());

        }

    }
}
