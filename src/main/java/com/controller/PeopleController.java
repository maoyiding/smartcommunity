package com.controller;

import com.domain.Banner;
import com.domain.City;
import com.domain.Community;
import com.domain.People;
import com.mapper.PeopleMapper;
import com.service.BannerService;
import com.service.CityService;
import com.service.CommunityService;
import com.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maoyiding on 6/29/17.
 */
@Controller
@RequestMapping

public class PeopleController {

    public People people;

    @Autowired
    PeopleService peopleService;

    @Autowired
    CityService cityService;

    @Autowired
    CommunityService communityService;

    @Autowired
    BannerService bannerService;

    @GetMapping
    public String toUserIndex(Model model){
        List<Banner> banner = bannerService.getAll();


        model.addAttribute("banner",banner);

        return "index";
    }

    @GetMapping("/user")
    public String toSignIn(){

        return "signin";
    }

    @PostMapping("/doLogin")
    public String signIn(People people,HttpServletRequest request){
        People u = peopleService.selectPeopleByPhone(people);
        if(u != null) {
            if (u.getPassword().equals(people.getPassword())) {
                HttpSession session =  request.getSession();
                session.setAttribute("people",u);
//                return "redirect:/index";
                return "redirect:/";
            }
        }
            return "signin";
    }

    //跳转到注册页面
    @GetMapping("/register")
    public String toAddPeople(){
        return "signup";
    }

    @PostMapping("/doRegister")
    public String insertPeople(People people,HttpServletRequest request){
        List<People> u =  peopleService.selectPeople();
        String phone = request.getParameter("phone");
        if(phone == ""){
            return "signup";
        }

        //循环遍历出所有内容，判断是否手机号重复
        for(People peo : u ){
            if(phone.equals(peo.getPhone())){
                return "signup";
            }
        }

        peopleService.addCustomer(people);
        return "signin";

    }


    @GetMapping("/user/forget")
    public String toForget(){
        return "forgetpwd";
    }


    @PostMapping("/updatePwd")
    public String updatePwd(People people,HttpServletRequest request){
        List<People> u =  peopleService.selectPeople();
        String phone = request.getParameter("phone");
        if( phone == "") {
            return "forgetpwd";
        }
        //
        for(People peo : u ){
            if( !phone.equals(peo.getPhone())){
                return "forgetpwd";
            }
        }

        peopleService.updataPeoplePasswordByPhone(people);
        return "signin";

    }


    @PostMapping("/address")
    public String toAddress(People people, Model model, HttpServletRequest request){
        String orderWrold="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        String[] firstWords=orderWrold.split(",");
        List words=new ArrayList();
        List cities=new ArrayList();
        for (int i=0;i<firstWords.length;i++) {

            List<City> cityList = cityService.getAllCity(firstWords[i]);

            if (cityList.size()>0){

                words.add(firstWords[i]);

//                List communitis=new ArrayList();
                for (City city : cityList){

                    city.setCommunity(communityService.getAllCommunityByCityId(city.getCityId()));

                    cities.add(city);
                }
            }
        }
        model.addAttribute("words",words);
        model.addAttribute("cities",cities);
//
//        model.addAttribute("people",people);
//        model.addAttribute("validation",request.getParameter("validation"));
//        model.addAttribute("password2",request.getParameter("password2"));

        //获取实体类中有的字段
        request.getSession().setAttribute("people",people);

        //People实体类没有属性，单独取值
        request.getSession().setAttribute("validation",request.getParameter("validation"));
        request.getSession().setAttribute("password2",request.getParameter("password2"));


//        HttpSession session=request.getSession();
//        session.setAttribute("phone_back",phone);
//        session.setAttribute("name_back",name);
//        session.setAttribute("address_back",address);
//        session.setAttribute("passwrod_back",password);
//        session.setAttribute("validation_back",validation);
        return "/selectcity";
    }

    @PostMapping("/finishSelect")
    public String finishSelect(String selectCityName,String selectCommunity,HttpServletRequest request,  RedirectAttributes attr){
            //把值重新赋值给注册页面，单独复制
            People people =  (People)request.getSession().getAttribute("people");
            attr.addFlashAttribute("phone",people.getPhone());
            attr.addFlashAttribute("autonym",people.getAutonym());
            attr.addFlashAttribute("address",people.getPassword());
            attr.addFlashAttribute("password",people.getPhone());
            attr.addFlashAttribute("validation",request.getSession().getAttribute("validation"));
            attr.addFlashAttribute("password2",request.getSession().getAttribute("password2"));
            attr.addFlashAttribute("cityCommunity",selectCityName+"-"+selectCommunity);

            return "redirect:/register";

    }

    @GetMapping("/toStore")
    public String toStore(){
        return "/store";
    }

}
