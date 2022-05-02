/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author adseglocdom
 */
@Results({
    @Result(name = "success", location = "/WEB-INF/content/bienvenido.jsp"),
    @Result(name = "input", location = "/WEB-INF/content/login.jsp")
})
public class ValidarUsuarioAction extends ActionSupport {

    Logger log = LogManager.getLogger(LoginAction.class);

    private String usuario;
    private String password;

    @Action("validarUsuario")
    @Override
    public String execute() throws Exception {
        if ("admin".equals(this.usuario)) {
            addActionMessage(getText("usuario.valido"));
            return SUCCESS;
        }
        return INPUT;
    }

    @Override
    public void validate() {
        if (usuario == null || "".equals(usuario.trim())) {
            addFieldError("usuario", getText("val.usuario"));
        } else if (!usuarioValido()) {
            addActionError(getText("usuario.invalido"));
        }
        
        if (password == null || "".equals(password.trim())) {
            addFieldError("password", getText("val.password"));
        } else if (password.length() < 3) {
            addFieldError("password", getText("val.password.min.lenght"));
        }
        
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private boolean usuarioValido() {
        return "admin".equals(usuario);
    }

}
