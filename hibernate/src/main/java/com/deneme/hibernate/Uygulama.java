package com.deneme.hibernate;

import org.hibernate.Session;
 
public class Uygulama 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();
        Stock stock = new Stock();
 
        stock.setStockCode("4715");
        stock.setStockName("GENM");
 
        session.save(stock);
        session.getTransaction().commit();
    }
}
