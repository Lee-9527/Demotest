package com.demo.controller;

import com.demo.entity.Machines;
import com.demo.entity.QueryVo;
import com.demo.entity.Site;
import com.demo.service.MachinesService;
import com.demo.service.SiteService;
import com.demo.util.Pages;
import com.demo.util.Paginate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/Manger")
public class MangerController {

    @Autowired
    private SiteService siteService;

    @Autowired
    private MachinesService machinesService;

    //站点维护
    @RequestMapping("/StationMaintain.action")
    public String StationMaintain(QueryVo queryVo,Model model) {

        List<Site> list = siteService.getAllSites();
        model.addAttribute("list",list);

        //分页查询数据
        Pages<Site> page = siteService.queryCustomerByQueryVo(queryVo);

        model.addAttribute("page", page);

       // System.out.println("page:+++" +page);

        return "/WEB-INF/jsp/StationMaintain.jsp";
    }

    //easyUI分页查询
    @RequestMapping("/list.action")
    @ResponseBody
    public Paginate<Site> pageList(int page, int rows, Model model) {

        System.out.println("controller++page:" +page);
        System.out.println("controller++rows:" +rows );

        //分页查询数据
        Paginate<Site> paginate = siteService.querySites(page,rows);

        //System.out.println("total:controller:+" +total );
        //System.out.println("list:+++" +paginate);
        return paginate;

    }


    //处理form表单
    @RequestMapping("/shebeipeizhi.action")
    public void shebeipeizhi(Machines machines) {

        System.out.print(machines);
        System.out.print(111);

        machinesService.updateMachines(machines);
        //return "";

    }

    //form表单回显
    @RequestMapping("/getMsg.action")
    @ResponseBody
    public Machines getMsg(int site_id) {
        System.out.print(site_id);

        Machines machines = machinesService.selectById(site_id);
        return machines;

    }
}
