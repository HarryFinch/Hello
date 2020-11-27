package crud.handler;

import java.util.Map;

import crud.dao.DepartmentDao;
import crud.dao.EmployeeDao;
import crud.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id,
                            Map<String, Object> map) {
        if (id != null) {
            map.put("employee", employeeDao.get(id));
        }
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String update(Employee employee) {
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("employee", employeeDao.get(id));
        map.put("departments", departmentDao.getDepartments());
        return "input";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    /*
     * @Description : 数据校验
     *  通过getErrorCount()获取错误总条数，
     *  若错误总条数大于0，表示有错误产生，
     *  可通过getField()和getDefaultMessage()方法获取错误名称和错误信息
     *
     * @Param : Employee 自动映射生成 Employee 类对象
     * @Param : Errors 可以获取错误的相关信息
     * @Param : Map 在数据验证出错的情况下，其中的数据可以携带到页面中
     *
     * @return : input 产生错误的情况下，返回到输入信息的界面，重新输入信息
     * @return : "redirect:/emps" 为产生错误的情况下，重定向至显示所有员工的控制器，页面显示所有员工信息
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(@Valid Employee employee, Errors errors, Map<String, Object> map) {
        System.out.println("save:" + employee);
        if (errors.getErrorCount() > 0) {
            System.out.println("There is errors");
            for (FieldError error : errors.getFieldErrors()) {
                System.out.println(error.getField() + " : " + error.getDefaultMessage());
            }
            //若验证出错，则转向指定的页面
            map.put("departments", departmentDao.getDepartments());
            return "input";
        }
        employeeDao.save(employee);
        return "redirect:/emps";
    }

//    @RequestMapping(value = "/emp", method = RequestMethod.POST)
//    public String save(@Valid Employee employee, BindingResult bindingResult, Map<String,Object> map) {
//        System.out.println("save : " + employee);
//        if (bindingResult.getErrorCount() > 0) {
//            System.out.println("There are errors");
//
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                System.out.println(error.getField() + " : " + error.getDefaultMessage());
//            }
//            map.put("departments", departmentDao.getDepartments());
//            return "input";
//        }
//        employeeDao.save(employee);
//        return "redirect:/emps";
//    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        map.put("departments", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String, Object> map) {
        map.put("employees", employeeDao.getAll());
        return "list";
    }


//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		binder.setDisallowedFields("lastName");
//	}

}
