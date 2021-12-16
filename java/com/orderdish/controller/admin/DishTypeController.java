package com.orderdish.controller.admin;

import com.orderdish.model.DishType;
import com.orderdish.result.PageTableRequest;
import com.orderdish.result.Results;
import com.orderdish.service.DishTypeService;
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
@RequestMapping("/dishType")
public class DishTypeController {

    @Autowired
    private DishTypeService dishTypeService;

    @GetMapping("/list")
    @ResponseBody
    public Results<DishType> list(PageTableRequest request){
        request.countOffset();
        return dishTypeService.list(request);
    }

    @GetMapping("/findDishTypeByFuzzyName")
    @ResponseBody
    public Results<DishType> findDishTypeByFuzzyDishTypeName(PageTableRequest request, String typeName){
        request.countOffset();
        return dishTypeService.findDishTypeByFuzzyName(request,typeName);
    }

    @GetMapping("/add")
    public String add(Model model){
        return "dishType/dishType-add";
    }
    @RequestMapping("/add")
    @ResponseBody
    public Results<DishType> add(@RequestBody DishType dishType){
        return dishTypeService.add(dishType);
    }

    @GetMapping("/edit/{dishTypeId}")
    public String edit(@PathVariable("dishTypeId")Integer dishTypeId,Model model){
        DishType dishType = dishTypeService.findDishTypeById(dishTypeId);
        model.addAttribute("dishType",dishType);
        return "dishType/dishType-edit";
    }
    @PostMapping("/upload")
    @ResponseBody
    public Results<DishType> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        DishType type = new DishType();
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
            type.setTypeImage(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Results.success(type);
    }
    @RequestMapping("/update")
    @ResponseBody
    public Results edit(@RequestBody DishType dishType){
        return dishTypeService.update(dishType);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public Results delete(@PathVariable("id") Integer id){
        return dishTypeService.delete(id);
    }
    @GetMapping("/getAll")
    @ResponseBody
    public Results getAll(){
        return Results.success(dishTypeService.getAll());
    }
}
