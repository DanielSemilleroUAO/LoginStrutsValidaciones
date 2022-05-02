/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author adseglocdom
 */
@Result(name = "success", location = "/WEB-INF/content/login.jsp")
public class LoginAction extends ActionSupport {

    @Action("login")
    @Override
    public String execute() {
        return SUCCESS;
    }

}
