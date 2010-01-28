package org.cevahir.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("maystro")
public class MaystroServisiImpl implements MaystroServisi{

	@Autowired
	@Qualifier("klasikOrkesutra")
	private OrkestraServisi klasik;
	
	@Autowired
	@Qualifier("vurmaliOrkesutra")
	private OrkestraServisi vurmali;
	
	@Autowired
	@Qualifier("kayitci")
	private KayitServisi kayitServisi;

	
	public void setKlasik(OrkestraServisi klasik) {
		this.klasik = klasik;
	}

	public void setVurmali(OrkestraServisi vurmali) {
		this.vurmali = vurmali;
	}


	public void yonet() {
		System.out.println("Maystro orkestrayi yonetmeye basladi.");
		klasik.cal();
		vurmali.cal();
		System.out.println("Maystro orkestrayi yonetmeyi bitirdi.");
		kayitServisi.kaydet("Konser tamamlandi.");
	}
	
	
}
