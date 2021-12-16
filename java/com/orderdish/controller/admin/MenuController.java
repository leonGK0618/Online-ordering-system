package com.orderdish.controller.admin;

import com.orderdish.dto.MenuDto;
import com.orderdish.model.Menu;
import com.orderdish.result.PageTableRequest;
import com.orderdish.result.Results;
import com.orderdish.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService MenuService;

    @GetMapping("/list")
    @ResponseBody
    public Results<MenuDto> list(PageTableRequest request){
        request.countOffset();
        return MenuService.list(request);
    }

    @GetMapping("/findMenuByFuzzyName")
    @ResponseBody
    public Results<MenuDto> findMenuByFuzzyMenuName(PageTableRequest request, String dishName,Integer typeId){
        request.countOffset();
        return MenuService.findMenuByFuzzyName(request,dishName,typeId);
    }

    @GetMapping("/add")
    public String add(Model model){
        return "menu/menu-add";
    }
    @RequestMapping("/add")
    @ResponseBody
    public Results<Menu> add(@RequestBody Menu menu){
        return MenuService.add(menu);
    }

    @GetMapping("/edit/{dishId}")
    public String edit(@PathVariable("dishId")Integer dishId,Model model){
        Menu menu = MenuService.findMenuById(dishId);
        model.addAttribute("menu",menu);
        return "menu/menu-edit";
    }
    @PostMapping("/upload")
    @ResponseBody
    public Results<Menu> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        Menu menu = new Menu();
        String fileName;
        try {
            fileName = file.getOriginalFilename();
            fileName = System.currentTimeMillis()+fileName;
            String FilePath = ResourceUtils.getURL("classpath:").getPath() + "static/image";
            File targetfile=new File(FilePath,fileName);
            if(!targetfile.getParentFile().exists()){
                targetfile.mkdirs();
            }
            file.transferTo(targetfile);
            menu.setDishImage(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Results.success(menu);
    }
    @RequestMapping("/update")
    @ResponseBody
    public Results edit(@RequestBody Menu menu){
        return MenuService.update(menu);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public Results delete(@PathVariable("id") Integer id){
        return MenuService.delete(id);
    }
}
