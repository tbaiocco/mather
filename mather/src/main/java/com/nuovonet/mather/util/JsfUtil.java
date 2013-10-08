package com.nuovonet.mather.util;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;

public class JsfUtil {

	public static boolean isDummySelectItem(UIComponent component, String value) {
        for (UIComponent children : component.getChildren()) {
            if (children instanceof UISelectItem) {
                UISelectItem item = (UISelectItem) children;
                if (item.getItemValue() == null && item.getItemLabel().equals(value)) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
	
}
