/**
 * 
 */
package com.iancui.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iancui.dao.AppointmentDao;
import com.iancui.dao.BookDao;
import com.iancui.dto.AppointExecution;
import com.iancui.entity.Appointment;
import com.iancui.entity.Book;
import com.iancui.enums.AppointStateEnum;
import com.iancui.exeception.AppointException;
import com.iancui.exeception.NoNumberException;
import com.iancui.exeception.RepeatAppointException;
import com.iancui.service.BookService;

/**
 * @author S.Murata
 * @version $Id$
 * @since JDK5.0
 */
@Service
public class BookServiceImpl implements BookService {

    private Log log = LogFactory.getLog(this.getClass());

    // 注入Service依赖
    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;

    /**
     * {@inheritDoc}
     * @see com.iancui.service.BookService#getById(long)
     */
    @Override
    public Book getById(long bookId) {

        return bookDao.queryById(bookId);

    }

    /**
     * {@inheritDoc}
     * @see com.iancui.service.BookService#getList()
     */
    @Override
    public List<Book> getList() {

        return bookDao.queryAll(0, 1000);

    }

    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    @Override
    @Transactional
    public AppointExecution appoint(long idBook, long idStudent) {

        try {
            // 减库存
            int update = bookDao.reduceNumber(idBook);
            if (update <= 0) {// 库存不足
                //return new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);//错误写法                
                throw new NoNumberException("no number");
            } else {
                // 执行预约操作
                int insert =
                    appointmentDao.insertAppointment(idBook, idStudent);
                //                if (insert > 0) {// 重复预约
                //return new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);//错误写法
                //                    throw new RepeatAppointException("repeat appoint");
                //                } else {// 预约成功
                Appointment appointment =
                    appointmentDao.queryByKeyWithBook(idBook, idStudent);
                return new AppointExecution(idBook, AppointStateEnum.SUCCESS,
                    appointment);
                //                }
            }
            // 要先于catch Exception异常前先catch住再抛出，不然自定义的异常也会被转换为AppointException，导致控制层无法具体识别是哪个异常
        } catch (NoNumberException e1) {
            throw e1;
        } catch (DuplicateKeyException e2) {
            throw new RepeatAppointException("repeat appoint");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            //return new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);//错误写法
            throw new AppointException("appoint inner error:" + e.getMessage());
        }

    }

}
