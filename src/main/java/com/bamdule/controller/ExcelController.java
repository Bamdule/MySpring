/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bamdule.controller;

import com.bamdule.service.GuestBookService;
import com.bamdule.util.ExcelUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MW
 */
@Controller()
@RequestMapping(value = "/excel")
public class ExcelController {

    @Autowired
    private GuestBookService guestBookService;

    @ResponseBody
    @RequestMapping(value = "/guestBooks", method = RequestMethod.GET)
    public void excelDownload(HttpServletResponse response) {
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=test.xlsx");

        ExcelUtil excelUtil = new ExcelUtil();
        Workbook wb = excelUtil.create(guestBookService.list());

        try {
            wb.write(response.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ExcelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
