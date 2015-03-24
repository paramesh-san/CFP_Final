
package com.p1;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "demo")
public class ListRequest {
	
	private List<Msg> listRequest = new ArrayList<Msg>();
    
	@XmlElement(name = "requesttable")
	public List<Msg> getListRequest(){
		return listRequest;	
    }
    
	
	public void setListRequest(List<Msg> listRequest)
	{
		this.listRequest = listRequest;	
	}
	
}
    
