package com.p1;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Persistance {
public void main1(List<Msg> l,List<Double> l2,List<String> l3) throws JAXBException
{  
		ListRequest lp = ThrottledQueue.lp;
	
	lp.setListRequest(l);
	JAXBContext jc = JAXBContext.newInstance(ListRequest.class);
	Marshaller ms=jc.createMarshaller();
	ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
	ListRequest demo = (ListRequest) jaxbUnmarshaller.getUnmarshallerHandler();
	System.out.println(demo);
	ms.marshal(lp, System.out);


	
	
}
}
