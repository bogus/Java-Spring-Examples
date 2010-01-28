package org.cevahir.spring;

import org.springframework.stereotype.Service;

@Service("vurmaliOrkesutra")
public class VurmaliOrkestraServisiImpl implements OrkestraServisi {
	
	public void cal() {
		System.out.println("Vurmali orkestra caliyor.");
	}

}
