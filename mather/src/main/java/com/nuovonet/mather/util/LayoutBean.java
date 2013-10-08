package com.nuovonet.mather.util;

import javax.faces.bean.SessionScoped;
import javax.faces.event.NamedEvent;
import javax.inject.Named;

@NamedEvent 
@SessionScoped
public class LayoutBean
{
    private String theme = "glass-x";
    public String getTheme()
    {
        return theme;
    }
}
