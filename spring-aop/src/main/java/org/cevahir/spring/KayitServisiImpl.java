package org.cevahir.spring;

import org.springframework.stereotype.Repository;

@Repository("kayitci")
public class KayitServisiImpl implements KayitServisi {

	public void kaydet(String satir) {
		// TODO Auto-generated method stub
		System.out.println("'" + satir + "' satiri kaydedildi.");
	}

}
