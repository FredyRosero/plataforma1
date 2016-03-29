package co.com.plataforma1.controladores;

import co.com.plataforma1.modelo.Simpruebassaber;
import co.com.plataforma1.controladores.util.JsfUtil;
import co.com.plataforma1.controladores.util.JsfUtil.PersistAction;
import co.com.plataforma1.operaciones.SimpruebassaberFacade;

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

@Named("simpruebassaberController")
@SessionScoped
public class SimpruebassaberController implements Serializable {

    @EJB
    private co.com.plataforma1.operaciones.SimpruebassaberFacade ejbFacade;
    private List<Simpruebassaber> items = null;
    private Simpruebassaber selected;

    public SimpruebassaberController() {
    }

    public Simpruebassaber getSelected() {
        return selected;
    }

    public void setSelected(Simpruebassaber selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SimpruebassaberFacade getFacade() {
        return ejbFacade;
    }

    public Simpruebassaber prepareCreate() {
        selected = new Simpruebassaber();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SimpruebassaberCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SimpruebassaberUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SimpruebassaberDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Simpruebassaber> getItems() {
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

    public Simpruebassaber getSimpruebassaber(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Simpruebassaber> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Simpruebassaber> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Simpruebassaber.class)
    public static class SimpruebassaberControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SimpruebassaberController controller = (SimpruebassaberController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "simpruebassaberController");
            return controller.getSimpruebassaber(getKey(value));
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
            if (object instanceof Simpruebassaber) {
                Simpruebassaber o = (Simpruebassaber) object;
                return getStringKey(o.getIdSimPruSab());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Simpruebassaber.class.getName()});
                return null;
            }
        }

    }

}
