package org.cevahir.spring;

import org.springframework.stereotype.Service;

@Service("klasikOrkesutra")
public class KlasikOrkestraServisiImpl implements OrkestraServisi {
	
	public void cal() {
		System.out.println("Klasik orkestra caliyor.");
	}

}
