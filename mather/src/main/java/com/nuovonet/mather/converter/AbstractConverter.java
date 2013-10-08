package com.nuovonet.mather.converter;

import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.gov.frameworkdemoiselle.template.JPACrud;

import com.nuovonet.mather.domain.util.AbstractEntity;
import com.nuovonet.mather.util.JsfUtil;
 
/*
 * NAO ESTA FUNCIONANDO AINDA...
 */

//@Named
//@FacesConverter(value = "abstractConverter")
public class AbstractConverter<T, PK extends Serializable> implements Converter {
 
	private JPACrud<T, PK> baseService;  
    private Class<T> entityClass;  
      
    public AbstractConverter(){}  
      
    public AbstractConverter(JPACrud<T, PK> baseService, Class<T> entityClass){  
        this.baseService = baseService;  
        this.entityClass = entityClass;  
    }  
    
    java.lang.Long getKey(String value) {
        java.lang.Long key;
        key = Long.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Long value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }
    
	@Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
		if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getBaseService().load((PK) getKey(value));
    }
 
	public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof AbstractEntity) {
        	AbstractEntity o = (AbstractEntity) object;
            return getStringKey(o.getId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AbstractEntity.class.getName()});
            return null;
        }
    }
 
    private void addAttribute(UIComponent component, AbstractEntity o) {
        this.getAttributesFrom(component).put(o.getId().toString(), o);
    }
 
    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

	public JPACrud<T, PK> getBaseService() {
		return baseService;
	}

	public void setBaseService(JPACrud<T, PK> baseService) {
		this.baseService = baseService;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
 
}