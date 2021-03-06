package co.com.plataforma1.controladores;

import co.com.plataforma1.modelo.Docentemateria;
import co.com.plataforma1.controladores.util.JsfUtil;
import co.com.plataforma1.controladores.util.JsfUtil.PersistAction;
import co.com.plataforma1.operaciones.DocentemateriaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("docentemateriaController")
@SessionScoped
public class DocentemateriaController implements Serializable {

    @EJB
    private co.com.plataforma1.operaciones.DocentemateriaFacade ejbFacade;
    private List<Docentemateria> items = null;
    private Docentemateria selected;

    public DocentemateriaController() {
    }

    
    
    public Docentemateria getSelected() {
        return selected;
    }

    public void setSelected(Docentemateria selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DocentemateriaFacade getFacade() {
        return ejbFacade;
    }

    public Docentemateria prepareCreate() {
        selected = new Docentemateria();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DocentemateriaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DocentemateriaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DocentemateriaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Docentemateria> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Docentemateria getDocentemateria(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Docentemateria> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Docentemateria> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Docentemateria.class)
    public static class DocentemateriaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DocentemateriaController controller = (DocentemateriaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "docentemateriaController");
            return controller.getDocentemateria(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Docentemateria) {
                Docentemateria o = (Docentemateria) object;
                return getStringKey(o.getIddocenteMateria());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Docentemateria.class.getName()});
                return null;
            }
        }

    }

}
