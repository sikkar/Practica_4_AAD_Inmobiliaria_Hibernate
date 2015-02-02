/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izv.modelo;

import com.izv.hibernate.HibernateUtil;
import com.izv.hibernate.Inmueble;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author AngelakaMogu
 */
public class ModeloInmueble {
    
    public static List<Inmueble> get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Inmueble";
        Query q = session.createQuery(hql);
        List<Inmueble> inmuebles = q.list();
        session.getTransaction().commit();
        session.close();
        return inmuebles;
    }
    
    public static void delete(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Inmueble inm = (Inmueble) session.load(Inmueble.class,Integer.parseInt(id));
        session.delete(inm);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void insert(Inmueble inm){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(inm);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void update(Inmueble inm){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(inm);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static Inmueble get(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Inmueble inm = (Inmueble) session.get(Inmueble.class, Integer.parseInt(id));
        
        session.getTransaction().commit();
        session.close();
        
        return inm;
    }
    
}
