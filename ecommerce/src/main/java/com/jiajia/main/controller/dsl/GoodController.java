package com.jiajia.main.controller.dsl;

import com.jiajia.main.dto.GoodDto;
import com.jiajia.main.model.QGoodInfoBean;
import com.jiajia.main.model.QGoodTypeBean;
import com.jiajia.main.model.GoodInfoBean;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/7/9
 * Time：15:24
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Controller
@RequestMapping("/good")
public class GoodController
{

    @Autowired
    private EntityManager entityManager;

    //查询工厂实体
    private JPAQueryFactory queryFactory;

    //实例化控制器完成后执行该方法实例化JPAQueryFactory
    @PostConstruct
    public void initFactory()
    {
        System.out.println("开始实例化JPAQueryFactory");
        queryFactory = new JPAQueryFactory(entityManager);
    }

    /**
     * url : http://localhost:8080/good/selectByType?typeId=1
     * ui  : thymeleaf
     * json: [{"id":2,"title":"2","price":2.0,"unit":"2","order":2,"typeId":1}
     */


    @RequestMapping(value = "/selectByType")
    public String selectByType
            (
                    @RequestParam(value = "typeId") Long typeId //类型编号
                    ,Model model
            )
    {
        //商品查询实体
        QGoodInfoBean _Q_good = QGoodInfoBean.goodInfoBean;
        //商品类型查询实体
        QGoodTypeBean _Q_good_type = QGoodTypeBean.goodTypeBean;

                List<GoodInfoBean> booklist  =  queryFactory
                        .select(_Q_good)
                        .from(_Q_good,_Q_good_type)
                        .where(
                                //为两个实体关联查询
                                _Q_good.typeId.eq(_Q_good_type.id)
                                        .and(
                                                //查询指定typeid的商品
                                                _Q_good_type.id.eq(typeId)
                                        )
                        )
                        .orderBy(_Q_good.order.desc())
                        .fetch();
        model.addAttribute("list", booklist);
                return "/booklist";

    }

    //http://localhost:8080/good/selectWithQueryDSL freemark
    @RequestMapping(value = "/selectWithQueryDSL")
    public String selectWithQueryDSL(Model model)
    {
        //商品基本信息
        QGoodInfoBean _Q_good = QGoodInfoBean.goodInfoBean;
        //商品类型
        QGoodTypeBean _Q_good_type = QGoodTypeBean.goodTypeBean;

        List<GoodDto> allbooklist = queryFactory
                .select(
                        Projections.bean(
                                GoodDto.class,//返回自定义实体的类型
                                _Q_good.id,
                                _Q_good.price,
                                _Q_good.title,
                                _Q_good.unit,
                                _Q_good_type.name.as("typeName"),//使用别名对应dto内的typeName
                                _Q_good_type.id.as("typeId")//使用别名对应dto内的typeId
                        )
                )
                .from(_Q_good,_Q_good_type)//构建两表笛卡尔集
                .where(_Q_good.typeId.eq(_Q_good_type.id))//关联两表
                .orderBy(_Q_good.order.desc())//倒序
                .fetch();
        model.addAttribute("allbooklist", allbooklist);
        return "/allbooklist";
    }

}
