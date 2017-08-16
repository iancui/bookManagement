package com.iancui.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iancui.dto.AppointExecution;
import com.iancui.dto.Result;
import com.iancui.entity.Book;
import com.iancui.enums.AppointStateEnum;
import com.iancui.exeception.NoNumberException;
import com.iancui.exeception.RepeatAppointException;
import com.iancui.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

    private static final Log log = LogFactory.getLog(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> list = bookService.getList();
        model.addAttribute("list", list);
        // list.jsp + model = ModelAndView
        return "list";// WEB-INF/jsp/"list".jsp
    }

    @RequestMapping(value = "/{idBook}/detail", method = RequestMethod.GET)
    private String detail(@PathVariable("idBook") Long idBook, Model model) {
        if (idBook == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getById(idBook);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    //ajax json
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    private Result<AppointExecution> appoint(
        @PathVariable("bookId") Long bookId,
        @RequestParam("idStudent") Long idStudent) {
        if (idStudent == null || idStudent.equals("")) {
            return new Result<>(false, "学号不能为空");
        }
        //AppointExecution execution = bookService.appoint(bookId, studentId);//错误写法，不能统一返回，要处理异常（失败）情况
        AppointExecution execution = null;
        try {
            execution = bookService.appoint(bookId, idStudent);
        } catch (NoNumberException e1) {
            execution =
                new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2) {
            execution =
                new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution =
                new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(true, execution);
    }

}
